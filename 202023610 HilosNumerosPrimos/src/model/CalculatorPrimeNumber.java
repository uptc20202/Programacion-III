package model;

import java.util.ArrayList;

public class CalculatorPrimeNumber{

    private int primeCount;
    private ArrayList<PrimeNumberThread> threads;

    public CalculatorPrimeNumber(int range) {
        threads = new ArrayList<>();
        startThreads(range);
    }

    private void startThreads(int range){
        int initial = 0;
        int finish = range/3;
        for (int i = 0; i < 3; i++) {
            PrimeNumberThread hilo = new PrimeNumberThread(initial,finish);
            hilo.start();
            threads.add(hilo);
            initial = finish;
            finish += range/3;
        }
        countFinal();
    }
    
    private void countFinal() {
    	for (PrimeNumberThread thread:threads) {
            try {
                thread.join();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            primeCount += thread.getPrimeStack();
        }
    }

    public int getPrimeCount(){
        return primeCount;
    }

}
