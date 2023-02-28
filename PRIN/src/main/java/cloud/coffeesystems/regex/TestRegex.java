package cloud.coffeesystems.regex;

import java.util.Scanner;

import static cloud.coffeesystems.regex.Checker.checkWebAddressValidity;

public class TestRegex {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        boolean running = true;
        while (running) {
            String tmp = input.nextLine();
            if (tmp.equals("exit")) {
                System.out.println("Testen beendet");
                running = false;
            }
            System.out.println(Checker.checkNameValidity(tmp));
        }


        //Task 3
        boolean isValid = checkWebAddressValidity("https://www.example.com");
        if (isValid) {
            System.out.println("Web address is valid");
        } else {
            System.out.println("Web address is invalid");
        }

        //Task 4
        boolean isProductNameValid = Checker.Shipment.checkProductNameValidity("Product Name");
        if (isProductNameValid) {
            System.out.println("Product name is valid");
        } else {
            System.out.println("Product name is invalid");
        }

        boolean isProductIdValid = Checker.Shipment.checkProductIdValidity("ABCD1234");
        if (isProductIdValid) {
            System.out.println("Product ID is valid");
        } else {
            System.out.println("Product ID is invalid");
        }


    }

}