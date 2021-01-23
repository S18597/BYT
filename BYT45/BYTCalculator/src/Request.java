public class Request {

    public String operation;
    public double x;
    public double y;

    public Request(String operation, double firstNumber, double secondNumber ) {
        this.operation = operation;
        x = firstNumber;
        y = secondNumber;
    }

    public double getx() {
        return x;
    }

    public double gety() {
        return y;
    }

    public String getOperation() {
        return operation;
    }

}
