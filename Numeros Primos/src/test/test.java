package test;

import models.CalculatorPrimeNumber;

public class test {

    public static void main(String[] args) {
    	int range = 500000;
        CalculatorPrimeNumber calculatorPrimeNumber = new CalculatorPrimeNumber(range);
        System.out.println("Hay "+calculatorPrimeNumber.getPrimeCount()+" n�meros primos del 1 al "+range);
    }
}
