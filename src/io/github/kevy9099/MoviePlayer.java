package io.github.kevy9099;

public class MoviePlayer extends Product implements MultimediaControl {
  Screen screen;
  MonitorType monitorType;

  public MoviePlayer(String name, String manufacturer, Screen screen, MonitorType monitorType) {
    super(name, "VISUAL", manufacturer);
    this.screen = screen;
    this.monitorType = monitorType;
  }

  public void play() {
    System.out.println("Playing...");
  }

  public void stop() {
    System.out.println("Stopping...");
  }

  public void previous() {
    System.out.println("<< Back");
  }

  public void next() {
    System.out.println("Next >>");
  }

  public Screen getScreen() {
    return screen;
  }

  public void setScreen(Screen screen) {
    this.screen = screen;
  }

  public MonitorType getMonitorType() {
    return monitorType;
  }

  public void setMonitorType(MonitorType monitorType) {
    this.monitorType = monitorType;
  }

  public String toString() {
    return super.toString()
        + ", Screen Size = '"
        + this.screen
        + "\'"
        + ", Monitor Type = '"
        + this.monitorType
        + "\'"
        + '}';
  }
}
