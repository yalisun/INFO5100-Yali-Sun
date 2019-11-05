package assignment7.Q4;

import java.time.Duration;
import java.time.Instant;
import java.util.Random;

public class SumValue {

    /*generate array of random numbers*/
    private static void generateRandomArray(int[] arr){
        Random random = new Random();
        for (int i = 0; i < arr.length; i++) {
            arr[i] = random.nextInt(1000);
        }
    }

    public static class SumTread extends Thread {
        private int[] arr;
        private int start;
        private int end;
        private long sum;

        public SumTread(int[] arr, int start, int end) {
            this.arr = arr;
            this.start = start;
            this.end = end;
            this.sum = 0L;
        }

        public long getSum() {
            return sum;
        }

        public void run() {
            for (int i = start; i < end; i++) {
                sum += arr[i];
            }
        }
    }

    /*get sum of an array using 4 threads*/
    private static long sumUsingFourThreads(int[] arr) throws Exception {
        Instant start = Instant.now();

        int quarter = arr.length / 4;
        SumTread sum1 = new SumTread(arr, 0, quarter);
        SumTread sum2 = new SumTread(arr, quarter, quarter * 2);
        SumTread sum3 = new SumTread(arr, quarter * 2, quarter * 3);
        SumTread sum4 = new SumTread(arr, quarter * 3, arr.length);

        sum1.start();
        sum2.start();
        sum3.start();
        sum4.start();
        sum1.join();
        sum2.join();
        sum3.join();
        sum4.join();
        long sum = sum1.getSum() + sum2.getSum() + sum3.getSum() + sum4.getSum();

        Instant end = Instant.now();
        Duration timeElapsed = Duration.between(start, end);
        System.out.println("Sum using four threads takes time: "+ timeElapsed.toMillis() + " milliseconds");
        return sum;
    }

    private static long sumWithoutThread(int[] arr) {
        Instant start = Instant.now();

        long sumArr = 0;
        for (int num : arr) {
            sumArr += num;
        }

        Instant end = Instant.now();
        Duration timeElapsed = Duration.between(start, end);
        System.out.println("Sum without thread takes time: " + timeElapsed.toMillis() + " milliseconds");
        return sumArr;
    }

    public static void main(String[] args) throws Exception {
        int[] arr = new int[4000000];
        generateRandomArray(arr);
        long sum1 = sumUsingFourThreads(arr);
        System.out.println("Sum using 4 threads: " + sum1);
        long sum2 = sumWithoutThread(arr);
        System.out.println("Sum without thread: " + sum2);
    }
}
