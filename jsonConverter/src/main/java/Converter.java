import com.fasterxml.jackson.databind.ObjectMapper;
import model.User;

import java.io.File;
import java.io.IOException;

public class Converter {

    private static final String baseFile = "user.json";


    public static void toJSON(User user) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.writeValue(new File(baseFile), user);
        System.out.printf("json was created");

    }

    public static User toJavaObject() throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.readValue(new File(baseFile), User.class);

    }

}
