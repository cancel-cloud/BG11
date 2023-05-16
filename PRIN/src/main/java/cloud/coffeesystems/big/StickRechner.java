package cloud.coffeesystems.big;

import java.util.Scanner;

public class StickRechner {
    private String name = "USB-Stick";
    private int size = 0;
    private double speed = 0.0;

    public void Stick(String name, int size, double speed) {
        this.name = name;
        this.size = size;
        this.speed = speed;
    }

    public String getName() {
        return name;
    }

    public int getSize() {
        return size;
    }

    public double getSpeed() {
        return speed;
    }

    public static void main(String[] args) {
        System.out.println("USB-Stick-Rechner");
        System.out.println("Geben Sie die Größe des USB-Sticks in GB ein:");
        Scanner scanner = new Scanner(System.in);
        int stickSize = scanner.nextInt();
        System.out.println("Geben sie die lesegeschwindigkeit des USB-Sticks in MB/s ein:");
        double stickSpeed = scanner.nextDouble();
        double calsec = stickSize * 1024 / stickSpeed;
        Stick stick = new Stick("USB-Stick", stickSize, stickSpeed);

        while (true) {
            System.out.println("Was möchten sie tun?");
            System.out.println("1. Zeit berechnen, für den Stick komplett zu beschreiben");
            System.out.println("2. Zeit berechnen, wie lange eine X GB Datei benötigt, um auf den Stick geschrieben zu werden.");
            System.out.println("3. Beenden");

            int input = scanner.nextInt();
            switch (input) {
                case 1 -> writeFullStick(stick);
                case 2 -> writeXGBtoStick(stick);
                case 3 -> System.exit(0);
                default -> System.out.println("Falsche Eingabe");
            }
        }
    }

    public static void writeFullStick(Stick stick) {
        double calsec = stick.getSize() * 1024 / stick.getSpeed();
        double calmin = calsec / 60;
        double calhour = calmin / 60;
        String calday = String.format("%.2f", (calhour / 24));

        System.out.println(new StringBuilder()
                .append("Der Stick braucht:\n")
                .append(calday)
                .append(" Tage\n")
                .append(calhour)
                .append(" Stunden\n")
                .append(calmin)
                .append(" Minuten\n")
                .append(calsec)
                .append(" Sekunden\num ")
                .append(stick.getSize())
                .append(" GB zu schreiben")
                .toString());
        System.out.println("---------------------------------");
    }

    public static void writeXGBtoStick(Stick stick) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Geben Sie die Größe der Datei in GB ein:");
        int x = scanner.nextInt();
        double calsec = x * 1024 / stick.getSpeed();
        double calmin = calsec / 60;
        double calhour = calmin / 60;
        String calday = String.format("%.2f", (calhour / 24));

        System.out.println(new StringBuilder()
                .append("Der Stick braucht:\n")
                .append(calday)
                .append(" Tage\n")
                .append(calhour)
                .append(" Stunden\n")
                .append(calmin)
                .append(" Minuten\n")
                .append(calsec)
                .append(" Sekunden\num ")
                .append(x)
                .append(" GB zu schreiben")
        );
        System.out.println("---------------------------------");
    }
}