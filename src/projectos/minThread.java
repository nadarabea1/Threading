package projectos;

import java.util.Arrays;

public class minThread implements Runnable{
    public volatile int min;

    private int[] array;
    public minThread(int[] array) {
        this.array = array;
    }

    public void run() {
        min = array[0];
        for (int i = 0; i < array.length; i++) {
            if (min >= array[i]) {
                min = array[i];
            }
        }
        
        
    }
    public int returnmin(){
        return min;        
    }

}
