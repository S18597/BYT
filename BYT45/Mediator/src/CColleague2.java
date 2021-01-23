public class CColleague2 extends Colleagues {

    public  CColleague2(Mediators mediators){
        super(mediators);
    }

    @Override
    public void recieve(String message){
        System.out.println("CColleague2. Recieved:" + message);
    }

}