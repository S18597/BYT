import java.time.LocalDateTime;
import java.util.concurrent.atomic.AtomicInteger;

public class Computer {

    public int id;
    LocalDateTime lastUsed;
    public final AtomicInteger counter = new AtomicInteger(0);

    public Computer(){
        id = counter.incrementAndGet();
        lastUsed = null;
    }

    public int getId(){
        return id;
    }

    public void setLastUsed(LocalDateTime lastUsed){
        this.lastUsed = lastUsed;
    }

}
