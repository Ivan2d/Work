import java.io.*;

public class HouseSerializeAndDeserialize
{
    public static void houseSerialize(House house, File fileName) {
        try (ObjectOutput out = new ObjectOutputStream(new FileOutputStream(fileName))) {
            out.writeObject(house);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static House houseDeserialize(File fileName) {
        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(fileName))) {
            return (House) in.readObject();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }
}