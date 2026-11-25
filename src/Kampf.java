public class Kampf {

    public static void starteKampf(Spielfigur figur1, Spielfigur figur2) {
        starteKampf(new Spielfigur[] { figur1 }, new Spielfigur[] { figur2 });
    }

    public static void starteKampf(Spielfigur[] team1, Spielfigur[] team2) {
        validiereTeam(team1, "Team 1");
        validiereTeam(team2, "Team 2");

        System.out.println("Der Kampf beginnt:");
        zeigeTeamstatus("Team 1", team1);
        zeigeTeamstatus("Team 2", team2);
        System.out.println();

        int runde = 1;

        while (hatLebendeFiguren(team1) && hatLebendeFiguren(team2)) {
            System.out.println("Runde " + runde + ":");
            fuehreTeamzugAus("Team 1", team1, "Team 2", team2);
            if (hatLebendeFiguren(team2)) {
                fuehreTeamzugAus("Team 2", team2, "Team 1", team1);
            }
            System.out.println();
            runde++;
        }

        boolean team1HatGewonnen = hatLebendeFiguren(team1);
        Spielfigur[] gewinner = team1HatGewonnen ? team1 : team2;
        String teamName = team1HatGewonnen ? "Team 1" : "Team 2";
        System.out.println(teamName + " hat gewonnen: " + namenLebenderFiguren(gewinner));
    }

    private static void fuehreTeamzugAus(
            String teamName,
            Spielfigur[] team,
            String gegnerTeamName,
            Spielfigur[] gegnerTeam
    ) {
        System.out.println(teamName + " ist am Zug:");
        for (Spielfigur figur : team) {
            if (!figur.lebtNoch() || !hatLebendeFiguren(gegnerTeam)) {
                continue;
            }

            if (figur instanceof Heilfaehig) {
                Spielfigur verletzterVerbuendeter = findeVerletztenVerbuendeten(team);
                if (verletzterVerbuendeter != null) {
                    ((Heilfaehig) figur).heile(verletzterVerbuendeter);
                    zeigeTeamstatus(teamName, team);
                    continue;
                }
            }

            Spielfigur ziel = findeErstesLebendesMitglied(gegnerTeam);
            int schaden = figur.fuehreAngriffAus();
            ziel.nimmSchaden(schaden);
            System.out.println(teamName + " - " + figur.getName() + " greift "
                    + gegnerTeamName + " - " + ziel.getName()
                    + " an und verursacht " + schaden + " Schaden.");
            ziel.zeigeStatus();
        }
    }

    private static Spielfigur findeVerletztenVerbuendeten(Spielfigur[] team) {
        Spielfigur ziel = null;
        int groessterHeilbedarf = 0;

        for (Spielfigur figur : team) {
            int heilbedarf = figur.getMaxLebenspunkte() - figur.getLebenspunkte();
            if (figur.lebtNoch() && heilbedarf > groessterHeilbedarf) {
                ziel = figur;
                groessterHeilbedarf = heilbedarf;
            }
        }
        return ziel;
    }

    private static Spielfigur findeErstesLebendesMitglied(Spielfigur[] team) {
        for (Spielfigur figur : team) {
            if (figur.lebtNoch()) {
                return figur;
            }
        }
        return null;
    }

    private static boolean hatLebendeFiguren(Spielfigur[] team) {
        return findeErstesLebendesMitglied(team) != null;
    }

    private static void zeigeTeamstatus(String teamName, Spielfigur[] team) {
        System.out.println(teamName + ":");
        for (Spielfigur figur : team) {
            figur.zeigeStatus();
        }
    }

    private static String namenLebenderFiguren(Spielfigur[] team) {
        StringBuilder namen = new StringBuilder();
        for (Spielfigur figur : team) {
            if (figur.lebtNoch()) {
                if (namen.length() > 0) {
                    namen.append(", ");
                }
                namen.append(figur.getName());
            }
        }
        return namen.toString();
    }

    private static void validiereTeam(Spielfigur[] team, String teamName) {
        if (team == null || team.length == 0) {
            throw new IllegalArgumentException(teamName + " muss mindestens eine Spielfigur enthalten.");
        }
        for (Spielfigur figur : team) {
            if (figur == null) {
                throw new IllegalArgumentException(teamName + " darf keine leeren Einträge enthalten.");
            }
        }
    }
}