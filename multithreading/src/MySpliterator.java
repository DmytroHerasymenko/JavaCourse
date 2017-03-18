import java.util.Spliterator;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

/**
 * Created by dima on 18.03.17.
 */
class MyArray implements Spliterator<Integer> {
    Integer[] array;
    int firstPosition;
    int lastPosition;

    private MyArray(){}

    public MyArray(int n){
        array = new Integer[n];
        firstPosition = 0;
        lastPosition = array.length-1;
    }

    public void set(int pos, int element){
        array[pos] = element;
    }

    @Override
    public boolean tryAdvance(java.util.function.Consumer<? super Integer> action) {
        if(firstPosition <= lastPosition){
            action.accept(array[firstPosition]);
            firstPosition++;
            return true;
        }
        return false;
    }

    @Override
    public Spliterator<Integer> trySplit() {
        int mid = (lastPosition - firstPosition) / 2;
        if(mid <= 1) return null;
        MyArray newArray = new MyArray();
        newArray.array = this.array;
        newArray.firstPosition = firstPosition + mid + 1;
        newArray.lastPosition = lastPosition;
        lastPosition = firstPosition + mid;
        return newArray;
    }

    @Override
    public long estimateSize() {
        return lastPosition-firstPosition;
    }

    @Override
    public int characteristics() {
        return Spliterator.SIZED | SUBSIZED;
    }

    public Stream<Integer> stream(){
        firstPosition = 0;
        lastPosition = array.length-1;
        return StreamSupport.stream(this, false);
    }

    public Stream<Integer> parallelStream(){
        firstPosition = 0;
        lastPosition = array.length-1;
        return StreamSupport.stream(this, true);
    }
}

public class MySpliterator {
    public static void main(String[] args) {
        MyArray myArray = new MyArray(6);
        myArray.set(0, 10);
        myArray.set(1, 20);
        myArray.set(2, 30);
        myArray.set(3, 40);
        myArray.set(4, 50);
        myArray.set(5, 60);
        myArray.stream().map(element -> element*2).forEach(System.out::println);

        myArray.parallelStream().map(element -> element*2).forEach(System.out::println);
    }
}
