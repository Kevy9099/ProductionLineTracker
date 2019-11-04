package io.github.kevy9099;

/**
 * MonitorType enum create objects with corresponding values. MonitorType will set Monitor
 * description for product. Only LCD and LED are provided.
 *
 * @author Kevin Mak 9/24/2019
 */
public enum MonitorType {
  LCD(),
  LED();

  public final String monitors;

  /** MonitorType Method is set to a variable and initialize to a string. */
  MonitorType() {
    monitors = "";
  }

  /**
   * Method that enables access to a MonitorType.
   *
   * @return monitors
   */
  public String getMonitor() {
    return this.monitors;
  }
}
