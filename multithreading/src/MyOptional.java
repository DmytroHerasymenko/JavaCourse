import java.util.Optional;

/**
 * Created by dima on 18.03.17.
 */
public class MyOptional {
    public static void main(String[] args) {
        String s = new String("hello");
        Optional<String> element = Optional.ofNullable(s);
        element.orElseThrow(RuntimeException::new);
        element.ifPresent(System.out::println);
    }
}
