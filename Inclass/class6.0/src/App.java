public class App {
    public static void main(String[] args) {
        int[] data = { 5, 3, 7, 1, 9, 2, 6, 4, 8 };

        SortedList l1 = new SortedList(data);
        l1.setStrategy(new UnsortedFindMinMaxStrategy());

        System.out.println(l1.findMax());
        System.out.println(l1.findMin());

        l1.setStrategy(new SortedFindMinMaxStrategy());

        System.out.println(l1.findMax());
        System.out.println(l1.findMin());


    }
}
