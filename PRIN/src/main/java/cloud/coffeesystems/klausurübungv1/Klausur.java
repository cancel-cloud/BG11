package cloud.coffeesystems.klausurübungv1;

public class Klausur {
    public static void main(String[] args) {

        String name = "USB-Stick";
        //print name in reverse
        for (int i = name.length() - 1; i >= 0; i--) {
            System.out.print(name.charAt(i));
        }

        String name2 = "USB-Stick22";

        if (name == name2) {
            System.out.println("name == name2");
        } else {
            System.out.println("name != name2");
        }
    }


}
