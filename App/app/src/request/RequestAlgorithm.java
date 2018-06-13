import java.util.Random;
import java.util.HashMap;

public class RequestAlgorithm{

    HashMap<Integer,Vocable> randomsorted;
    Vocable currentVoc;
    int index;
    public RequestAlgorithm(HashMap<Integer,Vocable> input){
        ;
        Random rand = new Random();
        randomsorted = new HashMap<Integer,Vocable>();
        HashMap<Integer,Vocable> a = input;
        currentVoc = null;
        index = input.size();
        int max = 0;
        max = input.size();

        for(int i = 0; i < max  ; i++){
            if(input.get(i).getLevel() > 1){
                for(int l = 0; l < input.get(i).getLevel()-1; l++){
                    a.put(index,input.get(i));

                    index++;
                }
            }
        }

        while (a.size() > 0 || a == null){
            int randnum = rand.nextInt(a.size());
            randomsorted.put(index,a.get(randnum));
            index++;
            for(int i = randnum; i < a.size() ;i++){
                a.put(i,a.get(i+1));
            }
            a.remove(a.size()-1);

        }

    }
    public Vocable getNewVocable(){
        currentVoc = randomsorted.get(0);
        for(int i = 0; i < randomsorted.size()-1 ;i++){
            randomsorted.put(i,randomsorted.get(i+1));
        }
        randomsorted.remove(randomsorted.size()-1);
        index--;
        return currentVoc;
    }

    public void handleAnswer(boolean answer){
        if(answer == false) {
            randomsorted.put(index,currentVoc);
            index++;
        }
    }
}