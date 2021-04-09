package hust.soict.dsai.garbage;

public class GarbageCreator {

    public static void main(String[] args) {
        String[] lionRoar = new String[50000];
        lionRoar[0] = "A lion roars ";
        int i = 1;
        while (i < 50000) {
            lionRoar[i] = lionRoar[i - 1] + "GRRAAAUUUU ";
            System.out.println(lionRoar[i]);

            i += 1;
        }
    }
}
