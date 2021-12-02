public enum GasLabel {
    O3("¬µg/m3", "ozone content"),
    SO2("¬µg/m3", "sulfur dioxide content"),
    NO2("¬µg/m3", "nitrogen dioxide content"),
    PM10("¬µg/m3","fine particles content");

    public final String unit;
    public final String description;

    private GasLabel(String unit, String description) {
        this.unit = unit;
        this.description = description;
    }
}