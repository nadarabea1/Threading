package projectos;

import java.util.Arrays;

public class maxThread implements Runnable{
    private int max;    

    private final int[] array;
    public maxThread(int[] array) {
        this.array = array;
    }
  

    @Override
    public void run() {

        max = array[0];
        for (int i = 0; i < array.length; i++) {
            if (max <= array[i]) {
                max = array[i];
            }
        }
    }
    public int returnmax(){
        return max;        
    }
    

}