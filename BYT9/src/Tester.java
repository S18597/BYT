import org.junit.jupiter.api.Test;
import org.testng.Assert;
import java.io.IOException;
import java.text.ParseException;

public class Tester {
    
    private static Observer obs1 = null;
    private static Observer obs2 = null;

    static {
        try {
            obs1 = new Observer("https://www.aljazeera.com");
            obs2 = new Observer("https://www.wsj.com");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private final Monitor monitor = new Monitor();
    private final Memento memento = new Memento();

    @Test
    public void monitorTest() throws IOException, ParseException {

        monitor.registerObserver(obs1);
        monitor.registerObserver(obs2);

        monitor.monitor();

        memento.fillFile(monitor);
        Monitor m = memento.restore();
        Assert.assertEquals(monitor, m);

    }
}