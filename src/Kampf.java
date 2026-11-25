public class Kampf {

    public static void starteKampf(Spielfigur figur1, Spielfigur figur2) {

        System.out.println("Der Kampf beginnt:");
        figur1.zeigeStatus();
        figur2.zeigeStatus();
        System.out.println();

        int runde = 1;

        while (figur1.lebtNoch() && figur2.lebtNoch()) {

            System.out.println("Runde " + runde + ":");

            int schaden1 = figur1.fuehreAngriffAus();
            figur2.nimmSchaden(schaden1);

            System.out.println(
                    figur1.getName() + " greift an und verursacht "
                    + schaden1 + " Schaden."
            );
            figur2.zeigeStatus();

            if (!figur2.lebtNoch()) {
                break;
            }

            int schaden2 = figur2.fuehreAngriffAus();
            figur1.nimmSchaden(schaden2);

            System.out.println(
                    figur2.getName() + " greift an und verursacht "
                    + schaden2 + " Schaden."
            );
            figur1.zeigeStatus();

            System.out.println();
            runde++;
        }

        System.out.println();

        if (!figur1.lebtNoch()) {
            System.out.println(figur2.getName() + " hat gewonnen!");
        } else {
            System.out.println(figur1.getName() + " hat gewonnen!");
        }
    }
}