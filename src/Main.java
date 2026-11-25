public class Main {

    public static void main(String[] args) {

        Krieger held = new Krieger("Krieger", 100, 20, 10);

        Magier gegner = new Magier("Magier", 80, 15, 25);

        Krieger magierKrieger = new Krieger("Krieger des Magiers", 100, 20, 10);

        Heiler unterstuetzung = new Heiler("Heiler", 90, 10, 15);

        System.out.println("Alle Figuren:");
        held.zeigeStatus();
        gegner.zeigeStatus();
        magierKrieger.zeigeStatus();
        unterstuetzung.zeigeStatus();
        System.out.println();

        System.out.println("Der Krieger nutzt seine Angriffskraft:");
        System.out.println("Schaden: " + held.verstaerkeAngriff());
        System.out.println();

        System.out.println("Der Magier nutzt seinen Zauber:");
        System.out.println("Schaden: " + gegner.fuehreZauberAus());
        System.out.println();

        Kampf.starteKampf(
                new Spielfigur[] { gegner, magierKrieger },
                new Spielfigur[] { held, unterstuetzung }
        );
    }
}