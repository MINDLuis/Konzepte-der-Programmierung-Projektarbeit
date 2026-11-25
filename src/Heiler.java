public class Heiler extends Spielfigur implements Heilfaehig {

    private int heilkraft;

    public Heiler(String name, int lebenspunkte, int angriffswert, int heilkraft) {
        super(name, lebenspunkte, angriffswert);
        this.heilkraft = heilkraft;
    }

    @Override
    public int fuehreAngriffAus() {
        return angriffswert;
    }

    @Override
    public void heile() {
        lebenspunkte = lebenspunkte + heilkraft;
        System.out.println(
                name + " heilt sich um " + heilkraft + " Lebenspunkte."
        );
    }
}