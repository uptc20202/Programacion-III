package test;

import model.CalculatorPrimeNumber;

public class test {

    public static void main(String[] args) {
    	int range = 500000;
        CalculatorPrimeNumber calculatorPrimeNumber = new CalculatorPrimeNumber(range);
        System.out.println("Hay "+calculatorPrimeNumber.getPrimeCount()+" números primos del 1 al "+range);
    }
}
