public class Client {
    public static void main(String[] args) {

        Handler handler1 = new AddHandler();
        Handler handler2 = new SubHandler();
        Handler handler3 = new DivHandler();
        Handler handler4 = new MulHandler();

        handler1.setNextHandler(handler2);
        handler2.setNextHandler(handler3);
        handler3.setNextHandler(handler4);

        Request req1 = new Request("Addition:", 2,1);
        Request req2 = new Request("Subtraction:", 2,1);
        Request req3 = new Request("Division:", 2,1);
        Request req4 = new Request("Multiplication:", 2,1);

        handler1.solve(req1);
        handler1.solve(req2);
        handler1.solve(req3);
        handler1.solve(req4);

    }
}