

import model.User;

import java.io.IOException;

public class Main {

    public static void main(String... args) throws IOException {
        Converter.toJSON(new User(1, "Alex", "+38000000001", "level"));
        User user = Converter.toJavaObject();
        System.out.println(user);
    }

}
