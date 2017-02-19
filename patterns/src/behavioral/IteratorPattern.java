package behavioral;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created by dima on 19.02.17.
 */
class MyCollection implements Iterable<String>{
    List<String> list = new ArrayList<>();

    class MyIterator implements Iterator<String> {
        int current = -1;
        @Override
        public boolean hasNext() {
            return current < list.size()-1;
        }

        @Override
        public String next() {
            current++;
            return list.get(current);
        }
    }
    public void add (String s){
        list.add(s);
    }

    @Override
    public Iterator<String> iterator() {
        return new MyIterator();
    }
}

public class IteratorPattern {
    public static void main(String[] args) {
        MyCollection myCollection = new MyCollection();
        myCollection.add("10");
        myCollection.add("20");
        myCollection.add("30");
        for(String s : myCollection){
            System.out.println(s);
        }
    }
}
