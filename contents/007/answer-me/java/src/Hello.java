
import static java.util.Objects.isNull;

import java.util.ArrayList;
import java.util.List;
import org.apache.commons.lang3.builder.ToStringBuilder;

public class Hello {
    public static void main(String args[]) {
        List<String> list = new ArrayList<>();
        if (isNull(list)) {
            throw new RuntimeException();
        }
        System.out.println("hello");
    }
}