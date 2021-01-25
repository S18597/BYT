import java.io.IOException;
import java.net.URL;
import java.net.URLConnection;
import java.util.Date;

import static com.sun.webkit.network.URLs.newURL;

public class Observer {
    public Date lastModified;
    public final String URL;

    public Observer(String URL) throws IOException{
        this.URL = URL;
        URL address = newURL(URL);
        URLConnection connect = address.openConnection();
        long longtime = connect.getLastModified();
        Date modifiedDate = new Date(longtime);
        this.lastModified = modifiedDate;
    }

    public void refresh() throws IOException{
        URL address = newURL(URL);
        URLConnection connect = address.openConnection();
        long longtime = connect.getLastModified();
        Date modifiedDate = new Date(longtime);
        this.lastModified = modifiedDate;
    }

    public Date getLastModified(){
        return lastModified;
    }

    public void setLastModified(Date lastModified) {
        this.lastModified = lastModified;
    }

    public String getURL(){
        return URL;
    }

    @Override
    public String toString(){
        return "URL: " + URL + ". Last modified on: " + lastModified;
    }

    public String serialize(){
        return URL + " " + lastModified;
    }
}
