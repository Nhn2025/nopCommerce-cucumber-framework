package commons;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import commons.models.User;

import java.io.InputStream;
import java.util.Map;

public class TestDataReader {

    private static Map<String, User> data;

    static {
        try {
            ObjectMapper mapper = new ObjectMapper();

            String path = ConfigReader.getTestDataFile();

            InputStream input =
                    TestDataReader.class
                            .getClassLoader()
                            .getResourceAsStream(path);

            if (input == null) {
                throw new RuntimeException("users.json not found");
            }

            data = mapper.readValue(
                    input,
                    new TypeReference<Map<String, User>>() {}
            );

        } catch (Exception e) {
            throw new RuntimeException("Cannot read test data: " + e.getMessage());
        }
    }

    public static User getUser(String userType) {
        return data.get(userType);
    }
}
