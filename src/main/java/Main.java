import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public void writeByteStream(OutputStream out, int [] arr){
        try(DataOutputStream outputStream = new DataOutputStream(out)){
            for(int temp : arr){
                outputStream.writeInt(temp);
            }
        }
        catch (IOException ex){
            System.out.println(ex.getMessage());
        }
    }

    public int[] readByteStream(InputStream in){
        try(DataInputStream dataInputStream = new DataInputStream(in)){
            int[] arr = new int[in.available() / 4];
            for(int i = 0; i < arr.length; i++){
                arr[i] = dataInputStream.readInt();
            }
            return arr;
        }
        catch (IOException ex){
            System.out.println(ex.getMessage());
            return null;
        }
    }

    public void writeCharsStream(Writer out, int[] arr){
        try(BufferedWriter writer = new BufferedWriter(out)){
            for(int temp : arr){
                writer.write(String.valueOf(temp));
                writer.write(' ');
            }
        }
        catch (IOException ex){
            System.out.println(ex.getMessage());
        }
    }

    public int[] readCharsStream(Reader in){
        try(BufferedReader reader = new BufferedReader(in)){
            String[] numbers = reader.readLine().split(" ");
            int[] res = new int[numbers.length];
            for(int i = 0; i < res.length; i++){
                res[i] = Integer.parseInt(numbers[i]);
            }
            return res;
        }
        catch (IOException ex){
            System.out.println(ex.getMessage());
            return null;
        }
    }

    public String readRandomAccessFile(File fileName, int position){
        try(RandomAccessFile raf = new RandomAccessFile(fileName, "r")){
            raf.seek(position);
            return raf.readLine();
        }
        catch (IOException ex){
            System.out.println(ex.getMessage());
        }
        return null;
    }

    public List<File> filesCatalog(String expansion, File directory) throws IOException
    {
        List<File> res = new ArrayList<>();
        File[] listFiles = directory.listFiles(File::isFile);

        if(listFiles == null){
            throw new IOException("Empty catalog");
        }
        for(File temp : listFiles){
            if(temp.getName().endsWith(expansion)){
                res.add(temp);
            }
        }
        return res;
    }
}
