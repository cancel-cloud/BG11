package de.lukas.aufgabe1;

public class Arbeitsvertrag {
    public Arbeitsvertrag(double gehalt, String taetigkeit) {
        this.gehalt = gehalt;
        this.taetigkeit = taetigkeit;
    }

    double gehalt;
    String taetigkeit;
    Mitarbeiter mitarbeiter;

    public double getGehalt() {
        return gehalt;
    }

    public Mitarbeiter getMitarbeiter() {
        return mitarbeiter;
    }

    public void setMitarbeiter(Mitarbeiter mitarbeiter) {
        this.mitarbeiter = mitarbeiter;
    }

    public String getTaetigkeit() {
        return taetigkeit;
    }

    public void setGehalt(double gehalt) {
        this.gehalt = gehalt;
    }

    public void setTaetigkeit(String taetigkeit) {
        this.taetigkeit = taetigkeit;
    }
}
