public class Magier extends Spielfigur implements Angriffskraft, Zauberfaehig {

    private int zauberstaerke;

    public Magier(String name, int lebenspunkte, int angriffswert, int zauberstaerke) {
        super(name, lebenspunkte, angriffswert);
        this.zauberstaerke = zauberstaerke;
    }

    @Override
    public int fuehreAngriffAus() {
        return angriffswert;
    }

    @Override
    public int verstaerkeAngriff() {
        return angriffswert + 2;
    }

    @Override
    public int fuehreZauberAus() {
        return zauberstaerke;
    }
}