import java.io.*;

public class Task
{
    public static void main(String[] ar)
    {
        Task t = new Task();
        Database d = t.readCSV("./resources/iris-data.xls");
    }

    public Database readCSV(String filename)
    {
        String contents = "";
        try (InputStream in = new FileInputStream(filename))
        {
            // create an array with number of bytes available
            byte[] buffer = new byte[in.available()];
            int lengthRead = in.read(buffer);
            while (lengthRead != -1)
            {
                contents += new String(buffer);
                lengthRead = in.read(buffer);
            }
            in.close();
        } catch (IOException e) {e.printStackTrace();
            System.exit(-1);
        }
        return new Database(contents);
    }
}
