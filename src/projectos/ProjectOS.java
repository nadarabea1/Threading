
package projectos;

import java.util.*;

public class ProjectOS {

    public static void sort(int[] array) {
        Arrays.parallelSort(array);
    }

    public static int[] asign(int size) {
        int[] array = new int[size];
        for (int i = 0; i < size; i++) {
            Random r = new Random();
            int random = r.nextInt();
            array[i] = random;
        }
        return array;
    }

    public static ArrayList<Integer> maxArray() throws InterruptedException {
        int size = 9000000;
        int[] array = asign(size);
        ArrayList<Integer> maxArray = new ArrayList<Integer>();
        int old_i = 0;
        for (int i = 5000; i < size; i = i + 5000) {
            int[] arr = Arrays.copyOfRange(array, old_i, i);
            maxThread maxthread = new maxThread(arr);
            Thread thread = new Thread(maxthread);
            thread.start();
            thread.join();
            int max = maxthread.returnmax();
            maxArray.add(max);

            old_i = i;
        }
        return maxArray;

    }

    public static ArrayList<Integer> minArray() throws InterruptedException {
        int size = 9000000;
        int[] array = asign(size);
        ArrayList<Integer> minArray = new ArrayList<Integer>();
        int old_i = 0;
        for (int i = 5000; i <= size; i = i + 5000) {
            int[] arr = Arrays.copyOfRange(array, old_i, i);
            minThread minthread = new minThread(arr);
            Thread thread = new Thread(minthread);
            thread.start();
            thread.join();
            int min = minthread.returnmin();
            minArray.add(min);

            old_i = i;
        }

        return minArray;

    }

    public static void main(String[] args) throws InterruptedException {
        int size = 9000000;
        int[] array = asign(size);
        Arrays.sort(array);
        
        long maxstart = System.nanoTime();
        maxArray();
        long maxend = System.nanoTime();
        long executionmaxTime = maxend - maxstart;
        System.out.println("execution Time of Maximum in Millisecond = " + executionmaxTime / 1000000000 + " sec");
        
        long minstart = System.nanoTime();
        minArray();
        long minend = System.nanoTime();
        long executionminiTime = minend - minstart;
        System.out.println("execution Time of Minimum in Millisecond = " + executionminiTime / 1000000000 + " sec");
        
        
        
        
        System.out.println("Maximum: " + Collections.max(maxArray()));
        System.out.println("Minimum: " + Collections.min(minArray()));

    }
}
