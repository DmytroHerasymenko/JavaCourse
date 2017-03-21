import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by dima on 21.03.17.
 */
public class MyRegExp {
    public static void main(String[] args) {
    /*String s = "helloaaafffaaaarerbbbqwerbbbbzxcabpoiuyaaa";
        String[] array = s.split("[ab]+");
        for(String s1 : array) System.out.println(s1);*/

        String text = "asd@asd.asb.asd, asdsdf 1rr@gmail.com, sdfsdfsdflk titig@ffg.com sdfsdfsdf, " +
                "sfsdf@dfsfd.dff.com dfsfd.";
        Pattern pattern = Pattern.compile("(^|\\s)([a-zA-Z][\\w]*@(\\w+\\.)+[\\w]{1,3})");
        Matcher matcher = pattern.matcher(text);
        while (matcher.find()) {
            System.out.println(matcher.group(2));
        }
    }
}
