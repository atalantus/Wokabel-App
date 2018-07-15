package com.wokabel.app.wokabel.services.XmlUtil;

import com.wokabel.app.wokabel.models.Subgroup;
import com.wokabel.app.wokabel.models.Supergroup;
import com.wokabel.app.wokabel.models.Vocable;
import com.wokabel.app.wokabel.services.room.DatabaseAdapter;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import java.io.File;

import javax.xml.parsers.*;

public class Xmlimport {

    DatabaseAdapter dbAdapter;
    File xml;
    Document document;

    Xmlimport(File xml) {
        this.xml = xml;
        try {
            DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();
            Document document = documentBuilder.parse(xml);

            document.getDocumentElement().normalize();

        }
        catch (Exception e){
            e.printStackTrace();
        }
    }

    public void writeXmltoDB(){
        try {
            //List of all Supergroups/Subjects
            NodeList SupergroupList = document.getElementsByTagName("subject");
            for(int i = 0; i < SupergroupList.getLength(); i++){

                Node Supergroup = SupergroupList.item(i);
                String Supergroupid;

                //If the Node is a Element, process further
                if(Supergroup.getNodeType() == Node.ELEMENT_NODE){
                    Element supElement = (Element) Supergroup;
                    Supergroupid = dbAdapter.insertSupergroup(new Supergroup(supElement.getAttribute("questionType"),supElement.getAttribute("icon"))).getId();

                    //If the Supergroup has any Subgroups
                    if(Supergroup.hasChildNodes()){

                        //List of all Subgroups/units
                        NodeList SubgroupList = Supergroup.getChildNodes();
                        for(int j = 0; j < SubgroupList.getLength(); j++){

                            Node Subgroup = SubgroupList.item(j);
                            String Subgroupid;
                            if(Supergroup.getNodeType() == Node.ELEMENT_NODE) {
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

        }
        catch (Exception e){
            e.printStackTrace();
        }
    }
}
