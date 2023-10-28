import java.util.NoSuchElementException;

public interface FindMinMaxStrategy {
    int findMin(int[] array);
    int findMax(int[] array);
    void sortArray(int[] array);
    int[] append(int value, int[] array);
}


