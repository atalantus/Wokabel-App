
package com.wokabel.app.wokabel.services.XmlUtilities;

import android.content.Context;

import com.wokabel.app.wokabel.models.Subgroup;
import com.wokabel.app.wokabel.models.Supergroup;
import com.wokabel.app.wokabel.models.Vocable;
import com.wokabel.app.wokabel.services.room.DatabaseAdapter;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;

import javax.xml.parsers.*;

// TODO: schoener machen
public class XmlReader {

    private DatabaseAdapter dbAdapter;
    private File xml;
    private Document document;

    public XmlReader(File xml) {
        this.xml = xml;
        try {
            DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();
            Document document = documentBuilder.parse(xml);

            document.getDocumentElement().normalize();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static File createFileFromAsset(String filename, Context context) {
        File f = new File(context.getCacheDir() + "/" + filename);

        if (!f.exists()) try {

            InputStream is = context.getAssets().open(filename);
            int size = is.available();
            byte[] buffer = new byte[size];
            is.read(buffer);
            is.close();


            FileOutputStream fos = new FileOutputStream(f);
            fos.write(buffer);
            fos.close();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        return f;
    }

    public void writeXmlToDB() {
        try {
            //List of all Supergroups/Subjects
            NodeList SupergroupList = document.getElementsByTagName("subject");
            for (int i = 0; i < SupergroupList.getLength(); i++) {

                Node Supergroup = SupergroupList.item(i);
                String Supergroupid;

                //If the Node is a Element, process further
                if (Supergroup.getNodeType() == Node.ELEMENT_NODE) {
                    Element supElement = (Element) Supergroup;
                    Supergroupid = dbAdapter.insertSupergroup(new Supergroup(supElement.getAttribute("questionType"), supElement.getAttribute("icon"))).getId();

                    //If the Supergroup has any Subgroups
                    if (Supergroup.hasChildNodes()) {

                        //List of all Subgroups/units
                        NodeList SubgroupList = Supergroup.getChildNodes();
                        for (int j = 0; j < SubgroupList.getLength(); j++) {

                            Node Subgroup = SubgroupList.item(j);
                            String Subgroupid;
                            if (Supergroup.getNodeType() == Node.ELEMENT_NODE) {
                                Element subElement = (Element) Subgroup;
                                Subgroupid = dbAdapter.insertSubgroup(new Subgroup(subElement.getAttribute("name"), Supergroupid)).getId();

                                //If the Subgroup has any Vocables
                                if (Subgroup.hasChildNodes()) {

                                    //List of all Vocables
                                    NodeList VocableList = Subgroup.getChildNodes();
                                    for (int k = 0; k < VocableList.getLength(); k++) {

                                        Node Vocable = VocableList.item(k);
                                        Element vocElement = (Element) Vocable;
                                        dbAdapter.insertVocable(new Vocable(
                                                vocElement.getAttribute("key"),
                                                vocElement.getAttribute("value"),
                                                vocElement.getAttribute("hint"), Subgroupid));

                                    }
                                }
                            }
                        }
                    }
                }

            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}