package cloud.coffeesystems.big;

import java.util.Scanner;

public class StickRechner {
    public static void main(String[] args) {
        while (true) {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Geben Sie die Größe des USB-Sticks in GB ein:");
            int stickSize = scanner.nextInt();
            System.out.println("Geben sie die lesegeschwindigkeit des USB-Sticks in MB/s ein:");
            int stickSpeed = scanner.nextInt();
            double time = stickSize * 1024 / stickSpeed;
            System.out.println("Der Stick braucht " + time + " Sekunden um " + stickSize + " GB zu beschreiben.");
        }
    }
}