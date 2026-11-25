public class Heiler extends Spielfigur implements Heilfaehig {

    private int heilkraft;

    public Heiler(String name, int lebenspunkte, int angriffswert, int heilkraft) {
        super(name, lebenspunkte, angriffswert);
        if (heilkraft < 0) {
            throw new IllegalArgumentException("Die Heilkraft darf nicht negativ sein.");
        }
        this.heilkraft = heilkraft;
    }

    @Override
    public int fuehreAngriffAus() {
        return angriffswert;
    }

    @Override
    public void heile(Spielfigur ziel) {
        if (ziel == null) {
            throw new IllegalArgumentException("Das Heilungsziel darf nicht null sein.");
        }

        int geheilt = ziel.erhalteHeilung(heilkraft);
        if (geheilt == 0) {
            System.out.println(getName() + " kann " + ziel.getName() + " nicht weiter heilen.");
            return;
        }
        System.out.println(getName() + " heilt " + ziel.getName() + " um " + geheilt + " Lebenspunkte.");
    }
}