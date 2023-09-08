package de.lukas.aufgabe1;

public class Main {
    public static void main(String[] args) {
        Arbeitsvertrag arbeitsvertrag = new Arbeitsvertrag(400000, "Softwareentwickler");
        Mitarbeiter mitarbeiter = new Mitarbeiter(arbeitsvertrag, "Bodo", "Bach");
        System.out.println("Bodo Bach ist ein sehr guter Mitarbeiter." +
                "Er ist sehr fleißig und arbeitet sehr viel." +
                "Er ist sehr gut in seinem Job.");
        System.out.println(mitarbeiter.getVorname() + " " + mitarbeiter.getNachname()
                + " verdient " + mitarbeiter.getArbeitsvertrag().getGehalt()
                + " Euro als " + mitarbeiter.getArbeitsvertrag().getTaetigkeit()
                + ".");
    }
}