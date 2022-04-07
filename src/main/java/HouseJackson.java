import java.io.*;
import org.codehaus.jackson.map.ObjectMapper;

public class HouseJackson
{
    public static House ObjectReturnFromJson(String stringJson) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        return mapper.readValue(stringJson, House.class);
    }

    public static String ObjectJson(House house) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        return mapper.writerWithDefaultPrettyPrinter().writeValueAsString(house);
    }
}