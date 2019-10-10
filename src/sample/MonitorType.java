package sample;

public enum MonitorType {
  LCD(""),
  LED("");

  public final String values;

  MonitorType(String value) {
    values = value;
  }

  public String getValue() {
    return this.values;
  }
}
