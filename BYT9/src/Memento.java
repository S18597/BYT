import java.io.*;
import java.net.URL;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Memento {

    public static final String file = "webpages.txt";
    public static final SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("yyyy-MM-dd");

    public void fillFile(Monitor monitor){
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(new File(file)))) {
            writer.write(monitor.serialize());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public Monitor restore() throws ParseException {
        Monitor monitor = new Monitor();
        String URL;
        Date lastModified;
        String string;
        try (Scanner reader = new Scanner(new FileReader("webpages.txt"))){
            string = reader.nextLine();
            while (string != null){
                URL = reader.nextLine();
                System.out.println(URL);
                URL url = new URL(URL);
                monitor.registerObserver(new Observer(url.toString()));
                lastModified = DATE_FORMAT.parse(reader.nextLine());
                System.out.println(lastModified);
                if(!reader.hasNext()){
                    break;
                }

            }
        } catch (IOException e){

        }
        return monitor;
    }
}
