import java.io.IOException;
import java.util.Date;
import java.util.HashMap;

public class Monitor {

    public static final HashMap<Observer, Date> observers = new HashMap<>();

    public static void registerObserver(Observer observer){
        if(!observers.containsKey(observer.getURL())){
            observers.put(observer, observer.getLastModified());
            System.out.println("Registered: " + observer.getURL() + "Modified: " + observer.getLastModified());
        } else {
            observers.replace(observer, observer.getLastModified());
            System.out.println("Registered: " + observer.getURL());
        }
    }

    public static void checkURL() throws IOException {
        for (Observer observer : observers.keySet()){
            System.out.println(("Checking " + observer.getURL()));
            Date currentModfied = observers.get(observer);
            observer.refresh();
            if(!observer.getLastModified().after(currentModfied)){
                observer.setLastModified(currentModfied);
                System.out.println(observer.getURL() + " was not modified.");
            } else {
                System.out.println(observer.getURL() + " was modified. The new date is: " + observer.getLastModified());
            }

        }
    }

    public static void monitor() throws IOException{
        int count = 2;
        while (count >= 0){
            checkURL();
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e){
                e.printStackTrace();
            }
            count--;
        }
    }

    public String serialize(){
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("\n");
        for(Observer observer : observers.keySet()){
            stringBuilder.append(observer.serialize());
            stringBuilder.append("\n");
        }
        return stringBuilder.toString();
    }

    public static HashMap<Observer, Date> getObservers(){
        return observers;
    }

    @Override
    public boolean equals(Object object){
        if(this == object)return true;
        if (!(object instanceof Monitor)) return false;
        Monitor myData = (Monitor) object;
        if(!myData.getObservers().keySet().equals(observers.keySet())) return false;
        return true;
    }
}
