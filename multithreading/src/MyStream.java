import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Created by dima on 17.03.17.
 */
public class MyStream {
    public static void main(String[] args) {
        List<Integer> list = new LinkedList<>();
        list.add(10);
        list.add(20);
        list.add(30);
        Integer res = list.stream()
                .map(element -> element*2)
                .reduce(0, (a,b) -> a+b);
        System.out.println(res);

        Stream<Integer> stream = list.stream()
                .map(element -> element*2);

        List<Integer> list1 = list.stream()
                .map(element -> element*2)
                .collect(Collectors.toList());

    }
}
