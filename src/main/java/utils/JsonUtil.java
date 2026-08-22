package utils;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;

public class JsonUtil {

    private static final ObjectMapper OBJECT_MAPPER =
            new ObjectMapper();

    private JsonUtil() {
    }

    public static <T> T read(String path,
                             Class<T> clazz) {
        try {
            return OBJECT_MAPPER.readValue(
                    new File(path),
                    clazz);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
