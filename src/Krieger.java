public class Krieger extends Spielfigur implements Angriffskraft {

    private int schadenBonus;

    public Krieger(String name, int lebenspunkte, int angriffswert, int schadenBonus) {
        super(name, lebenspunkte, angriffswert);
        this.schadenBonus = schadenBonus;
    }

    @Override
    public int fuehreAngriffAus() {
        return angriffswert;
    }

    @Override
    public int verstaerkeAngriff() {
        return angriffswert + schadenBonus;
    }
}