public class Expression {

	private char op;

	private Expression left;

	private Expression right;

	private int constant;

	public Expression(int constant) {
		this.op = 'c';
		this.constant = constant;
	}

	public Expression(char op, Expression left, Expression right) {
		this.op = op;
		this.left = left;
		this.right = right;
	}

	public int evaluate() {
		switch (op) {
		case 'c':
			return constant;
		case '+':
			return add();
		case '-':
			return subtract();
		case '*':
			return multiply();
		case '/':
			return divide();
		default:
			throw new IllegalStateException();
		}
	}

	protected int add() {
		return left.evaluate() + right.evaluate();
	}

	protected int subtract() {
		return left.evaluate() - right.evaluate();
	}

	protected int multiply() {
		return left.evaluate() * right.evaluate();
	}

	protected int divide() {
		return left.evaluate() / right.evaluate();
	}
}
