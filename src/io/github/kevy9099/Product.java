package io.github.kevy9099;

/**
 * The parent class that describes the basic details of a product. Type accepts and set an ItemType
 * that is implemented by the Item class. Manufacturer and Name accepts and set a string.
 *
 * @author Kevin Mak 9/26/2019
 */
public abstract class Product implements Item {
  private String name;
  private String manufacturer;
  public ItemType type;

  /**
   * Constructor of class Product accepting and setting its own parameters.
   *
   * @param name Name of a Product (ie iPod)
   * @param manufacturer Manufacturer that created the Product (ie Apple)
   * @param type Type for the Usage of the Product. (ie Audio)
   */
  public Product(String name, String manufacturer, ItemType type) {
    this.name = name;
    this.type = type;
    this.manufacturer = manufacturer;
  }

  /**
   * Method that enables access to type of ItemType.
   *
   * @return type
   */
  public ItemType getType() {
    return type;
  }

  /**
   * Method that sets a value of type.
   *
   * @param type Type for the Usage of the Product. (ie Audio)
   */
  public void setType(ItemType type) {
    this.type = type;
  }

  /**
   * Method that enables access to manufacturer.
   *
   * @return manufacturer
   */
  public String getManufacturer() {
    return manufacturer;
  }

  /**
   * Method that sets a value of manufacturer.
   *
   * @param manufacturer Manufacturer that created the Product (ie Apple)
   */
  public void setManufacturer(String manufacturer) {
    this.manufacturer = manufacturer;
  }

  /**
   * Method that enables access to name.
   *
   * @return name
   */
  public String getName() {
    return name;
  }

  /**
   * Method that sets a value of name.
   *
   * @param name Name of a Product. (ie iPod)
   */
  public void setName(String name) {
    this.name = name;
  }

  /**
   * The parent toString( ), provides the basic details of a product and sets fields to a single
   * line of Strings.
   *
   * @return strings of name, manufacturer, and type.
   */
  public String toString() {
    return " Product = "
        + " Name: "
        + name
        + "  "
        + " Manufacturer: "
        + manufacturer
        + "  "
        + " Type: "
        + type
        + "  ";
  }
}
