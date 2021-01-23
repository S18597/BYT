import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Lab {

    private static List<Computer> free = new ArrayList<>();
    private static List<Computer> occupied = new ArrayList<>();

    public Computer create(){
        return new Computer();
    }

    public Computer logOut(){
        if(free.isEmpty()){
            free.add(create());
        }
        Computer comp = free.iterator().next();
        free.remove(comp);
        occupied.add(comp);
        return comp;
    }

    public void logIn(Computer comp){
        occupied.remove(comp);
        comp.setLastUsed(LocalDateTime.now());
        free.add(comp);
    }

}
