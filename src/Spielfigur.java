public abstract class Spielfigur {

    private final String name;
    private final int maxLebenspunkte;
    protected int lebenspunkte;
    protected final int angriffswert;

    public Spielfigur(String name, int lebenspunkte, int angriffswert) {
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("Der Name darf nicht leer sein.");
        }
        if (lebenspunkte <= 0) {
            throw new IllegalArgumentException("Lebenspunkte müssen größer als 0 sein.");
        }
        if (angriffswert < 0) {
            throw new IllegalArgumentException("Der Angriffswert darf nicht negativ sein.");
        }

        this.name = name;
        this.maxLebenspunkte = lebenspunkte;
        this.lebenspunkte = lebenspunkte;
        this.angriffswert = angriffswert;
    }

    public String getName() {
        return name;
    }

    public int getLebenspunkte() {
        return lebenspunkte;
    }

    public int getMaxLebenspunkte() {
        return maxLebenspunkte;
    }

    public boolean lebtNoch() {
        return lebenspunkte > 0;
    }

    public void nimmSchaden(int schaden) {
        if (schaden > 0) {
            lebenspunkte = Math.max(0, lebenspunkte - schaden);
        }
    }

    public int erhalteHeilung(int heilung) {
        if (heilung < 0) {
            throw new IllegalArgumentException("Heilung darf nicht negativ sein.");
        }
        if (!lebtNoch()) {
            return 0;
        }

        int geheilt = Math.min(heilung, maxLebenspunkte - lebenspunkte);
        lebenspunkte += geheilt;
        return geheilt;
    }

    public void zeigeStatus() {
        System.out.println(
                name + " | Lebenspunkte: " + lebenspunkte +
                " | Angriffswert: " + angriffswert
        );
    }

    public abstract int fuehreAngriffAus();
}