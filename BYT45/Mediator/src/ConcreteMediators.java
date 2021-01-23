import java.util.ArrayList;
import java.util.List;

public class ConcreteMediators implements Mediators {

    private List<Colleagues> colleaguesList;

    public ConcreteMediators(){
        colleaguesList = new ArrayList<>();
    }

    @Override
    public void send(Colleagues colleagues, String message){
        for(Colleagues colleague : colleaguesList){
            if(colleague != colleagues){
                colleague.recieve(message);
            }
        }
    }

    public void addColleagueToList(Colleagues colleagues){
        colleaguesList.add(colleagues);
    }
}
