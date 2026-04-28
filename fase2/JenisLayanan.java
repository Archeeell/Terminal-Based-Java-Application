package fase2;

public enum JenisLayanan {

    REGULER("Reguler", 10000),
    EXPRESS("Express", 20000),
    SETRIKA_SAJA("Setrika Saja", 5000);

    private final String label;
    private final double hargaPerKg;

    JenisLayanan(String label, double hargaPerKg) {
        this.label = label;
        this.hargaPerKg = hargaPerKg;
    }

    public String getLabel() {
        return label;
    }

    public double getHargaPerKg() {
        return hargaPerKg;
    }

    @Override
    public String toString() {
        return label + " (Rp " + (long) hargaPerKg + "/kg)";
    }
}
