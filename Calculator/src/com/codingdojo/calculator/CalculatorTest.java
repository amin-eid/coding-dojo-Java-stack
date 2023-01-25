package com.codingdojo.calculator;

public class CalculatorTest {

	public static void main(String[] args) {
		Calculator Calc1 = new Calculator(10.5,"+",5.2);
		Calculator Calc2 = new Calculator(20.2,"-",8.2);
		Calc1.performOperation();
		Calc1.getResults();
		Calc1.setOperandOne(15.0);
		Calc1.performOperation();
		Calc1.getResults();
		Calc2.performOperation();
		Calc2.getResults();
	}
}