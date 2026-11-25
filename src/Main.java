public class Main {

    public static void main(String[] args) {

        Krieger held = new Krieger("Krieger", 100, 20, 10);

        Magier gegner = new Magier("Magier", 80, 15, 25);

        Heiler unterstuetzung = new Heiler("Heiler", 90, 10, 15);

        System.out.println("Alle Figuren:");
        held.zeigeStatus();
        gegner.zeigeStatus();
        unterstuetzung.zeigeStatus();
        System.out.println();

        System.out.println("Der Krieger nutzt seine Angriffskraft:");
        System.out.println("Schaden: " + held.verstaerkeAngriff());
        System.out.println();

        System.out.println("Der Magier nutzt seinen Zauber:");
        System.out.println("Schaden: " + gegner.fuehreZauberAus());
        System.out.println();

        System.out.println("Der Heiler heilt sich:");
        unterstuetzung.heile();
        System.out.println();

        Kampf.starteKampf(held, gegner);
    }
}