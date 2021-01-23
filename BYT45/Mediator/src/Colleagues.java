public abstract class Colleagues {

    public Mediators mediators;

    public Colleagues(Mediators mediators){
        this.mediators = mediators;
    }

    public abstract void recieve(String message);

    public void send(String message){
        mediators.send(this, message);
    }
}

