import java.util.ArrayList;

public class PrimeCalculator {

    static boolean isPrime(int x){
        boolean returner = true;
        for (int i=2;i<=Math.sqrt(x);i++){
            if (x % i == 0) {
                returner = false;
                break;
            }
        }
        return returner;
    }
    public static ArrayList<Integer> findPrimes(int start, int end){
        long startTime = System.currentTimeMillis();
        ArrayList<Integer> allPrimes = new ArrayList<>();
        for (int i=start;i<=end;i++){
            if(isPrime(i)){
                allPrimes.add(i);
            }
        }
        long endTime = System.currentTimeMillis();
        return allPrimes;

    }


}
