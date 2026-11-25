public abstract class Spielfigur {

    protected String name;
    protected int lebenspunkte;
    protected int angriffswert;

    public Spielfigur(String name, int lebenspunkte, int angriffswert) {
        this.name = name;
        this.lebenspunkte = lebenspunkte;
        this.angriffswert = angriffswert;
    }

    public String getName() {
        return name;
    }

    public int getLebenspunkte() {
        return lebenspunkte;
    }

    public boolean lebtNoch() {
        return lebenspunkte > 0;
    }

    public void nimmSchaden(int schaden) {
        if (schaden > 0) {
            lebenspunkte = lebenspunkte - schaden;

            if (lebenspunkte < 0) {
                lebenspunkte = 0;
            }
        }
    }

    public void zeigeStatus() {
        System.out.println(
                name + " | Lebenspunkte: " + lebenspunkte +
                " | Angriffswert: " + angriffswert
        );
    }

    public abstract int fuehreAngriffAus();
}