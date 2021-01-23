public class CColleague3 extends Colleagues {

    public  CColleague3(Mediators mediators){
        super(mediators);
    }

    @Override
    public void recieve(String message){
        System.out.println("CColleague3. Recieved:" + message);
    }

}