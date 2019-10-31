package io.github.kevy9099;

public enum MonitorType {
  LCD(""),
  LED("");

  public final String values;

  MonitorType(String values1) {
    values = values1;
  }

  public String getValue() {
    return this.values;
  }
}
