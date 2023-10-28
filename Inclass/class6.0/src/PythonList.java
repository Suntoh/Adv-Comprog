public abstract class PythonList {
    protected FindMinMaxStrategy strategy;
    protected int[] array;

    public PythonList(int[] array) {
        setArray(array);
    }
    public void setStrategy(FindMinMaxStrategy strategy) {
        this.strategy = strategy;
    }

    public void setArray(int[] a) {
        array = new int[a.length];
        for (int i = 0; i < a.length; i++) {
            array[i] = a[i];
        }
    }

    public int findMin() {
        return strategy.findMin(array);
    }

    public int findMax() {
        return strategy.findMax(array);
    }

    public void append(int value) {
        array=strategy.append(value, array);
    }

    public boolean contains(int value) {
        for(int i = 0; i < array.length; i++) {
            if(array[i] == value) return true;
        }
        return false;
    }
}

class SortedList extends PythonList {
    public SortedList(int[] array) {
        // Set the strategy to use the sorted algorithm
        super(array);
    }
}

class UnsortedList extends PythonList{
    public UnsortedList(int[] array){
        super(array);
    }
}

