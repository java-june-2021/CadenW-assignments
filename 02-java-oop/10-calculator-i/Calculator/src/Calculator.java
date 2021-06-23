
public class Calculator {
	private double operandOne;
	private String operation;
	private double operandTwo;
	private double result = 0;
	
//	Constructor 
	
	public Calculator(double operandOne, String operation, double operandTwo) {
		this.operandOne = operandOne;
		this.operation = operation;
		this.operandTwo = operandTwo;
		
	}
//	Methods
	public double performOperation() {
		if(this.operation == "+") {
			setResult(this.operandOne + this.operandTwo);
		}else if(this.operation == "-") {
			setResult(this.operandOne - this.operandTwo);
		}
		return result;
	}
	public void getResults() {
		System.out.println(getOperandOne() + getOperation() + getOperandTwo() + "=" + getResult());
	}
	public double getOperandOne() {
		return operandOne;
	}
	public void setOperandOne(double operandOne) {
		this.operandOne = operandOne;
	}
	public String getOperation() {
		return operation;
	}
	public void setOperation(String operation) {
		this.operation = operation;
	}
	public double getOperandTwo() {
		return operandTwo;
	}
	public void setOperandTwo(double operandTwo) {
		this.operandTwo = operandTwo;
	}
	public double getResult() {
		return result;
	}
	public void setResult(double result) {
		this.result = result;
	}
	
}
