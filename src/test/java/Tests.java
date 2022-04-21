import java.io.*;
import java.util.ArrayList;
import java.util.List;
import static org.junit.Assert.*;
import org.junit.Test;

public class Tests
{
    Main main = new Main();

    @Test
    public void firstTaskTest()
    {
        try(OutputStream out = new FileOutputStream("data.txt");
            InputStream in = new FileInputStream("data.txt"))
        {
            int[] arr = {1, 2, 3, 4};
            main.writeByteStream(out, arr);
            assertArrayEquals(arr, main.readByteStream(in));

        }
        catch (IOException ex){
            System.out.println(ex.getMessage());
        }
    }

    @Test
    public void secondTaskTest(){
        try(Writer writer = new FileWriter("data.txt");
            Reader reader = new FileReader("data.txt")){
            int [] arr = {1, 2, 3, 4, 5};
            main.writeCharsStream(writer, arr);
            assertArrayEquals(arr, main.readCharsStream(reader));
        }
        catch (IOException ex){
            System.out.println(ex.getMessage());
        }
    }
    @Test
    public void thirdTastTest() throws IOException
    {
        long pos = 2 * Integer.BYTES;
        RandomAccessFile raf = new RandomAccessFile("C:\\Users\\XeonE5430\\Documents", "rw");
        raf.writeInt(5);
        raf.writeInt(6);
        raf.writeInt(7);
        int[] exp = {7};
        assertArrayEquals(main.readRandomAccessFile(raf, pos), exp);
        raf.close();
    }

    @Test
    public void fourthTestTest() throws IOException
    {
        File dir = new File("C:\\JavaProgs\\Work");
        File file1 = new File(dir, "data.txt");
        File file2 = new File(dir, "test1.txt");
        List<File> fileRes = main.filesCatalog("txt", dir);

        List<String> res = new ArrayList<>();
        for(File temp : fileRes){
            res.add(temp.getName());
        }

        List<String> actRes = new ArrayList<>();
        actRes.add("data.txt");
        actRes.add("test1.txt");

        assertEquals(actRes, res);
    }

    @Test
    public void sixthTaskTest() throws Exception{
        List<Flat> flats = new ArrayList<>();
        List<Person> personFlat2 = new ArrayList<>();
        List<Person> personFlat3 = new ArrayList<>();
        personFlat2.add(new Person("Олег", "Власов", "Юрьевич", 13, 2, 2002));
        personFlat2.add(new Person("Сергей", "Власов", "Денисович", 17, 8, 1980));

        personFlat3.add(new Person("Евгений", "Жданов", "Павловна", 25, 3, 1990));
        personFlat3.add(new Person("София", "Жданова", "Петровна", 19, 1, 2003));
        personFlat3.add(new Person("Елизавета", "Жданова", "Павловна", 7, 9, 1981));

        flats.add(new Flat(5, 23, personFlat2));
        flats.add(new Flat(11, 80, personFlat3));


        House house = new House("31", "ул. Мира 32", new Person
                ("Сергей", "Власов", "Денисович", 17, 8, 1980), flats);

        HouseSerializeAndDeserialize.houseSerialize(house, new File("data.txt"));
        assertEquals(house, HouseSerializeAndDeserialize.houseDeserialize(new File("data.txt")));
    }

    @Test
    public void eightTaskTest() throws Exception{
        List<Flat> flats = new ArrayList<>();
        List<Person> personFlat2 = new ArrayList<>();
        List<Person> personFlat3 = new ArrayList<>();
        personFlat2.add(new Person("Олег", "Власов", "Юрьевич", 13, 2, 2002));
        personFlat2.add(new Person("Сергей", "Власов", "Денисович", 17, 8, 1980));

        personFlat3.add(new Person("Евгений", "Жданов", "Павловна", 25, 3, 1990));
        personFlat3.add(new Person("София", "Жданова", "Петровна", 19, 1, 2003));
        personFlat3.add(new Person("Елизавета", "Жданова", "Павловна", 7, 9, 1981));


        flats.add(new Flat(5, 23, personFlat2));
        flats.add(new Flat(11, 80, personFlat3));

        House house = new House("31", "ул. Мира 32", new Person
                ("Сергей", "Власов", "Денисович", 17, 8, 1980), flats);

        assertEquals(house, HouseJackson.ObjectReturnFromJson(HouseJackson.ObjectJson(house)));
    }
}
