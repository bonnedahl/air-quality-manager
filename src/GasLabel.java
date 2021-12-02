public enum GasLabel {
    O3("¬µg/m3", "ozone content"),
    SO2("¬µg/m3", "sulfur dioxide content"),
    NO2("¬µg/m3", "nitrogen dioxide content"),
    PM10("¬µg/m3","fine particles content");

    private final String unit;
    private final String description;

    private GasLabel(String unit, String description) {
        this.unit = unit;
        this.description = description;
    }

    public String getUnit() { return unit; }
    public String getDescription() { return description; }
}