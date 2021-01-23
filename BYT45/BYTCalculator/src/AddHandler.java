public class AddHandler implements Handler{
    
    public Handler nextHandler;

    @Override
    public void setNextHandler(Handler handler) {
        this.nextHandler = handler;
    }

    @Override
    public void solve(Request req) {
        if (req.getOperation().equals("Addition:")) {
            double res = req.getx() + req.gety();
            System.out.println("Result: " + res);
        } else if(req.getOperation().equals("Subtraction:") || req.getOperation().equals("Divison:") || req.getOperation().equals("Multiplication:")) {
            nextHandler.solve(req);
        } else {
            System.out.println("Result: Error");
        }
    }
    
}
