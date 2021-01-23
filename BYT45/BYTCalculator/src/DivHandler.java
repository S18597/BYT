public class DivHandler implements Handler{

    public Handler nextHandler;

    @Override
    public void setNextHandler(Handler handler) {
        this.nextHandler = handler;
    }

    @Override
    public void solve(Request req) {
        if (req.getOperation().equals("Division:")) {
            double res = req.getx() / req.gety();
            System.out.println("Result: " + res);
        } else if(req.getOperation().equals("Addition:") || req.getOperation().equals("Subtraction:") || req.getOperation().equals("Multiplication:")) {
            nextHandler.solve(req);
        } else {
            System.out.println("Result: Error");
        }
    }

}