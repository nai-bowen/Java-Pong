public class Main {
    //tells the java file to bring up a new window
    public static void main(String[] args) {
        Graphic graphic = new Graphic();
        //thread= the window that is opened
        Thread t1= new Thread(graphic);
        t1.start();
    }
}