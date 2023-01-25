package com.codingdojo.calculator;

public class Calculator {
	
	private Double operandOne = 0.0;
	private Double operandTwo = 0.0;
	private Double total = 0.0;
	private String operation = "";
	

	public Calculator(Double operandOne, String operation, Double operandTwo) {
		this.operandOne = operandOne;
		this.operation = operation;
		this.operandTwo = operandTwo;
	}
		

	public Double getOperandOne() {
		return operandOne;
	}
	public Double getOperandTwo() {
		return operandTwo;
	}
	public Double getTotal() {
		return total;
	}
	public String getOperation() {
		return operation;
	}
	

	public void setOperandOne(Double operandOne) {
		this.operandOne = operandOne;
	}
	public void setOperandTwo(Double operandTwo) {
		this.operandTwo = operandTwo;
	}
	public void setTotal(Double total) {
		this.total = total;
	}
	public void setOperation(String operation) {
		this.operation = operation;
	}
	

	public void performOperation() {
		if(getOperation().equals("+")) {
			Double total = getOperandOne() + getOperandTwo();
			setTotal(total);
		}
		else if(getOperation().equals("-")) {
			Double total = getOperandOne() - getOperandTwo();
			setTotal(total);
		}
	}
	public void getResults() {
		System.out.println(getTotal());
	}	
}