package io.github.kevy9099;

/**
 * Widget Class creates an object of Product with in the addButtonAction.
 *
 * @author Kevin Mak 9/26/2019
 */
public class Widget extends Product {
  /**
   * Constructor of Widget accepts and set parameters of name manufacturer and ItemType. Calls class
   * Product super constructor.
   *
   * @param name Name of a Product. (ie iPod)
   * @param manufacturer Manufacturer that created the Product. (ie Apple)
   * @param type Type for the Usage of the Product. (ie Audio)
   */
  public Widget(String name, String manufacturer, ItemType type) {
    super(name, manufacturer, type);
  }
}
