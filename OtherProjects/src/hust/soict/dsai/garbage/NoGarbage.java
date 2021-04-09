package hust.soict.dsai.garbage;

public class NoGarbage {

    public static void main(String[] args) {
        String a = "A lion roars ";
        String b = "GRRAAAUUUU ";
        int i = 2;
        while (i < 50000) {
            String c = a + b.repeat(i);
            System.out.println(c);

            System.gc();

            i += 1;
        }
    }
}
