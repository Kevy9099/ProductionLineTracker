package io.github.kevy9099;

public class MoviePlayer extends Product implements MultimediaControl {
  Screen screen;
  MonitorType monitorType;

  /**
   * Similar to AudioPlayer functionality, MoviePlayer will display a Screen Specifications and a
   * Monitor Type. Visual is called by ItemType enum class.
   *
   * @param name of the product.
   * @param manufacturer or builder of the product.
   * @param screen specifications of the product.
   * @param monitorType display specifications.
   */
  public MoviePlayer(String name, String manufacturer, Screen screen, MonitorType monitorType) {
    super(name, manufacturer, ItemType.Visual);
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

  /**
   * MoviePlayer fields are represented as strings, using the toString( ) method.
   *
   * @return strings of screenSpecifications, a monitorType, parent super toString().
   */
  public String toString() {
    return super.toString()
        + "  "
        + "Screen Specifications = "
        + this.screen
        + "  "
        + "Monitor Type: "
        + this.monitorType
        + "  ";
  }
}
