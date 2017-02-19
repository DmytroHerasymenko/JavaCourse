package structural;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by dima on 19.02.17.
 */
class MyCharacter{
    private char b;

    public MyCharacter(char b) {
        this.b = b;
    }

    public char getB() {
        return b;
    }

    public void setB(char b) {
        this.b = b;
    }
}

class WordFactory{
    private static WordFactory instance = new WordFactory();
    public static WordFactory getInstance(){return instance;}

    public List<MyCharacter> getWord(String word){

        List<MyCharacter> myCharacters = new ArrayList<>();
        for(char ch : word.toCharArray()){
            MyCharacter symbol = null;
            for(MyCharacter mc : myCharacters){
                if(mc.getB() == ch){
                    symbol = mc;
                    break;
                }
            }
            if(symbol == null){
                myCharacters.add(new MyCharacter(ch));
            } else {
                myCharacters.add(symbol);
            }
        }
        return myCharacters;
    }
}

public class FlyWeight {
}
