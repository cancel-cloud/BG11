# 1

### Bewertet den folgenden Testfall. Erfüllt dieser die Anforderungen an einen
Unit-Test?

```java
@Test
public void kurzNamen(){
 List<String> namen = new LinkedList<>();
 namen.add("Anja");
 namen.add("Susanne");
 namen.add("Heidi");
 namen.add("Uwe");
 namen.add("Markus");
 List<String> kurzeNamen = namen.stream().filter(n -> n.length() <=
4).collect(Collectors.toList());
 assertEquals("Anja", kurzeNamen.get(0));
 assertEquals("Uwe", kurzeNamen.get(1));
}
```
#### Ergebniss
Ja, dieser Testfall erfüllt die Anforderungen an einen Unit-Test, da er:
- Isoliert: Der Test prüft nur eine einzelne Funktion (die Filterung von kurzen Namen aus der Liste) und ist unabhängig von anderen Teilen des Codes.
- Automatisiert: Der Test kann automatisch ausgeführt werden, ohne manuelle Eingriffe oder Interaktionen.
- Wiederholbar: Der Test liefert bei jedem Durchlauf das gleiche Ergebnis, solange sich der Code nicht ändert.
- Aussagekräftig: Der Test überprüft eine spezifische Anforderung an die Funktion (die Filterung von kurzen Namen aus der Liste) und liefert ein klares Ergebnis, ob die Funktion korrekt funktioniert oder nicht.
- Keine Nebeneffekte: Der Test verändert nicht den Zustand des Systems oder der Daten, auf die er zugreift.
  <br>
  <br>
Insgesamt ist der Testfall gut geschrieben und erfüllt die Anforderungen an einen Unit-Test.

---
# 2
### Bewertet den folgenden Testfall. Erfüllt dieser die Anforderungen an einen Unit-Test?
```java
@Test
public void networkAvailable() throws IOException{
        boolean reachable=
        InetAddress.getByName("http://www.google.de").isReachable(100);
        assertTrue("Google ist nicht erreichbar.",reachable);
        }
```

#### Ergebniss
Nein, dieser Testfall erfüllt nicht alle Anforderungen an einen Unit-Test, da er:
- Nicht isoliert ist: Der Test prüft nicht nur eine Funktion, sondern ist auch von der Netzwerkverbindung abhängig, was bedeutet, dass er möglicherweise nicht funktioniert, wenn die Verbindung unterbrochen ist oder der Server nicht verfügbar ist.
- Nicht wiederholbar ist: Der Test liefert möglicherweise bei jedem Durchlauf unterschiedliche Ergebnisse, je nachdem, ob die Verbindung zum Server hergestellt werden kann oder nicht.
- Nicht aussagekräftig ist: Der Test prüft nur, ob eine Verbindung zu einem bestimmten Server hergestellt werden kann, aber es ist unklar, ob dies ein zuverlässiger Indikator dafür ist, ob das Netzwerk insgesamt verfügbar ist.
- Möglicherweise Nebeneffekte hat: Der Test greift auf eine externe Ressource (den Google-Server) zu und kann möglicherweise Auswirkungen auf den Server haben.
    <br>
    <br>
Insgesamt ist der Testfall nicht gut geschrieben und erfüllt nicht alle Anforderungen an einen Unit-Test. Wenn Netzwerktests durchgeführt werden müssen, sollten sie in einer separaten Testklasse geschrieben werden, die isoliert, wiederholbar und aussagekräftig ist und keine Nebeneffekte hat.

---
# 3
### Bewertet den folgenden Testfall. Erfüllt dieser die Anforderungen an einen Unit-Test?
```java
@Test
public void arbeitstag() throws IOException {
LocalDate date = LocalDate.of (2018, 3, 12);
Day0fWeek day0fWeek = date.getDay0fWeek();
boolean arbeitstag = day0fWeek.getValue ( ) < 6;
assertTrue( "Datum nicht als Arbeitstag erkannt." arbeitstag);
}
```

#### Ergebniss

Ja, dieser Testfall erfüllt die Anforderungen an einen Unit-Test, da er:

- Isoliert ist: Der Test prüft nur eine Funktion (die Überprüfung, ob das Datum ein Arbeitstag ist oder nicht) und ist unabhängig von anderen Teilen des Codes.
- Automatisiert ist: Der Test kann automatisch ausgeführt werden, ohne manuelle Eingriffe oder Interaktionen.
- Wiederholbar ist: Der Test liefert bei jedem Durchlauf das gleiche Ergebnis, solange sich das Datum nicht ändert.
- Aussagekräftig ist: Der Test überprüft eine spezifische Anforderung an die Funktion (die Überprüfung, ob das Datum ein Arbeitstag ist oder nicht) und liefert ein klares Ergebnis, ob die Funktion korrekt funktioniert oder nicht.
- Keine Nebeneffekte hat: Der Test verändert nicht den Zustand des Systems oder der Daten, auf die er zugreift.
<br>
<br>
Insgesamt ist der Testfall gut geschrieben und erfüllt die Anforderungen an einen Unit-Test.

---
# 4
#### Überlegt euch für die folgende Klasse sinnvolle Testfälle.
```java
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;
import java.util.stream. Collectors;
public class Bibliothek {
private List<Buch> buecher = new LinkedList<> ();
public void registrieren(Buch buch) {
this.buecher. add(buch);
}
public Buch leihen (String iban, Kunde kunde) {
Optional<Buch> buch = this.buecher.stream().filter (b ->
b.getIban (.equals (iban)).filter(b -> b.getLeihe () == null).findFirst);
if (buch.isPresent ()) {
Buch buchgeliehen = buch.get ();
buchgeliehen.setLeihe (new Leihe (kunde));
return buchgeliehen;
}
return null;
}
public List<Buch> suchen (String titel) {
return this.buecher.stream).filter (b -> b.getTitel().contains(titel)).filter(b -> b.getLeihe() == null).collect(Collectors.toList ));
}
```

#### Ergebniss
- Testfall für die Methode registrieren(): Überprüfung, ob ein Buch erfolgreich zur Bibliothek hinzugefügt wurde und in der Liste der Bücher vorhanden ist.
- Testfall für die Methode leihen(): Überprüfung, ob ein Buch erfolgreich ausgeliehen wurde und ob es von einem Kunden ausgeliehen wurde, der in der Leihe-Klasse gespeichert ist. Darüber hinaus sollte überprüft werden, ob das Buch nicht bereits verliehen ist und ob der Rückgabewert des Methodenaufrufs korrekt ist.
- Testfall für die Methode suchen(): Überprüfung, ob eine Liste von Büchern zurückgegeben wird, die den angegebenen Titel enthalten und nicht verliehen sind.
- Testfall für die Methode leihen(), wenn das Buch bereits verliehen ist: Überprüfung, ob die Methode null zurückgibt, wenn das Buch bereits ausgeliehen ist und nicht erneut ausgeliehen werden kann.
- Testfall für die Methode suchen(), wenn es keine Bücher mit dem angegebenen Titel gibt: Überprüfung, ob eine leere Liste zurückgegeben wird, wenn kein Buch mit dem angegebenen Titel vorhanden ist.
- Testfall für die Methode leihen(), wenn die übergebene IBAN nicht existiert: Überprüfung, ob die Methode null zurückgibt, wenn die übergebene IBAN nicht in der Liste der Bücher vorhanden ist.
- Testfall für die Methode leihen(), wenn der übergebene Kunde null ist: Überprüfung, ob die Methode null zurückgibt, wenn ein null-Kunde übergeben wird.