package models;

public class PrimeNumberThread extends Thread{

    public int initialRange;
    public int finishRange;
    public int primeCount;

    public PrimeNumberThread(int initialRange, int finishRange){
        this.finishRange = finishRange;
        this.initialRange = initialRange;
        primeCount = 0;
    }

    public int getPrimeStack() {
        return primeCount;
    }

    @Override
    public void run() {
        primeNumberStacker();
    }

    public void primeNumberStacker() {
        for (int i = initialRange; i < finishRange; i++) {
            if (isPrime(i)) {
            	primeCount++;
            }
        }
    }

    private boolean isPrime(int n) {
        if (n % 2 == 0) return false;
        for (int i = 3; i * i <= n; i += 2) {
            if (n % i == 0) {
                return false;
            }    
        }
        return true;
    }
}
