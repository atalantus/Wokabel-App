import java.util.Random;
import java.util.ArrayList;

public class RequestAlgorithm{

    ArrayList<Vocable> randomsorted;
    Vocable currentVoc;
    int index;
    public RequestAlgorithm(ArrayList<Vocable> input){
        ;
        Random rand = new Random();
        randomsorted = new ArrayList<Vocable>();
        ArrayList<Vocable> a = new ArrayList<Vocable>();
        currentVoc = null;
        for(int i = 0; i < input.size(); i++){
            for(int l = 5; l > input.get(i).getLevel()-1; l--){
                a.add(input.get(i));
            }
        }

        while (a.size() > 0){
            int randnum = rand.nextInt(a.size());
            randomsorted.add(a.get(randnum));
            a.remove(randnum);
        }

    }
    public Vocable getNewVocable(){
        currentVoc = randomsorted.get(0);
        randomsorted.remove(0);
        return currentVoc;
    }

    public void handleAnswer(boolean answer){
        if(answer == false) {
            randomsorted.add(currentVoc);
        }

    }
}