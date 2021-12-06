public enum Compound {
    O3("Âµg/m3", "ozone content"),
    SO2("Âµg/m3", "sulfur dioxide content"),
    NO2("Âµg/m3", "nitrogen dioxide content"),
    PM10("Âµg/m3","fine particles content");

    private final String unit;
    private final String description;

    private Compound(String unit, String description) {
        this.unit = unit;
        this.description = description;
    }

    public String getUnit() { return unit; }
    public String getDescription() { return description; }
}