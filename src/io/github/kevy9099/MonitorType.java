package io.github.kevy9099;

public enum MonitorType {
  LCD(),
  LED();

  public final String monitors;

  MonitorType() {
    monitors = "";
  }

  public String getMonitor() {
    return this.monitors;
  }
}
