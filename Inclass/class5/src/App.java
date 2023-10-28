public class App {
    public static void testInterface(PythonListOfInt x) throws Exception {
        System.out.println(x.findMax());

        System.out.println(x.findMin());
        System.out.println(x.findSum());
        System.out.println(x.contains(6));
        x.append(6);
        System.out.println(x.contains(6));
        System.out.println(x);
    }

    public static void main(String[] args) throws Exception {
        int[] k = {};
        PythonListOfInt y =new SimpleList(k);
        try{
            System.out.println(y.findMax());
        }
        catch(Exception e){
            System.out.println(e);
        }
        int[] d = {1,2,3,4,5};
        PythonListOfInt x = new SimpleList(d);
            testInterface(x);

    }
}
