import java.util.NoSuchElementException;

public class SimpleList implements PythonListOfInt{
    private int[] array;
    public SimpleList(int[] a){
        array =a;
    }
    public int findMax() throws Exception{
        if (array.length == 0){
            throw new NoSuchElementException("No data  available");
        }
        int max = Integer.MIN_VALUE;
        for(int a : array) {
            if (a > max) max = a;
        }
        return max;
    }
    public int findMin(){
        int min = Integer.MAX_VALUE;
        for(int i:array) {
            if (i < min) min = i;
        }
        return min;
    }

    public int findSum(){
        int sum = 0 ;
        for(int i : array){
            sum += i;
        }
        return sum;
    }


    public boolean contains(int v){
        for(int i : array){
            if(i==v) return true;
        }
        return false;
    }

    public void append(int x){
        int[] b = new int[array.length+1];
        for(int i=0; i< array.length;i++){
            b[i] = array[i];
        }
        b[array.length] = x;
        array = b;
    }

    public String toString(){
        String out = "[";
        for(int i:array){
            out += i + ", ";
        }
        return out.substring(0,array.length*3-1) + "]";
    }

}