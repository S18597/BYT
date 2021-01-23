public class CColleague1 extends Colleagues {

    public  CColleague1(Mediators mediators){
        super(mediators);
    }

    @Override
    public void recieve(String message){
        System.out.println("CColleague1. Recieved:" + message);
    }

}
