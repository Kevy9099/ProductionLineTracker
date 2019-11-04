package io.github.kevy9099;

/**
 * MoviePlayer class display description of product in the console. MoviePlayer extends the class
 * Product and implements the methods from MultimediaControl.
 *
 * @author Kevin Mak 9/24/2019
 */
public class MoviePlayer extends Product implements MultimediaControl {
  Screen screen;
  MonitorType monitorType;

  /**
   * Constructor of class MoviePlayer accepting and setting its own parameters, and calls the parent
   * class fields.
   *
   * @param name Name of a Product (ie Asus ROG Zephyrus)
   * @param manufacturer Manufacturer that created the Product (ie Microsoft)
   * @param screen ScreenSpecification of the Product (ie 15 in Full HD display)
   * @param monitorType MonitorType of the product (ie LED back light)
   */
  public MoviePlayer(String name, String manufacturer, Screen screen, MonitorType monitorType) {
    super(name, manufacturer, ItemType.Visual);
    this.screen = screen;
    this.monitorType = monitorType;
  }

  /** Method that enables access to play, that has no returnType. */
  public void play() {
    System.out.println("Playing...");
  }

  /** Method that enables access to stop, that has no returnType. */
  public void stop() {
    System.out.println("Stopping..");
  }

  /** Method that enables access to previous, that has no returnType. */
  public void previous() {
    System.out.println("<< Back");
  }

  /** Method that enables access to next, that has no returnType. */
  public void next() {
    System.out.println("Next >>");
  }

  /**
   * Method that enables access to screen.
   *
   * @return screen
   */
  public Screen getScreen() {
    return screen;
  }

  /**
   * Method that sets a value of screen.
   *
   * @param screen ScreenSpecification of the Product. (ie 15 in Full HD display)
   */
  public void setScreen(Screen screen) {
    this.screen = screen;
  }

  /**
   * Method that enables access to monitorType.
   *
   * @return monitorType
   */
  public MonitorType getMonitorType() {
    return monitorType;
  }

  /**
   * Method that sets a value of monitorType.
   *
   * @param monitorType MonitorType of the product (ie LED back light)
   */
  public void setMonitorType(MonitorType monitorType) {
    this.monitorType = monitorType;
  }

  /**
   * MoviePlayer fields are represented as strings, using the toString( ). Sets the fields of
   * MoviePlayer and Parent fields to a single string displays to the console.
   *
   * @return strings of screenSpecifications, a monitorType, parent toString().
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
