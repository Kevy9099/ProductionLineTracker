package io.github.kevy9099;

public abstract class Product implements Item {
  public ItemType type;
  private String manufacturer;
  private String name;

  /**
   * The parent class that describes the basic of a product. returns a name,manufacturer, and type
   * of a product input by the user.
   *
   * @param name of the product.
   * @param manufacturer or builder of the product.
   * @param type the product is used for.
   */
  public Product(String name, String manufacturer, ItemType type) {
    this.type = type;
    this.manufacturer = manufacturer;
    this.name = name;
  }

  public ItemType getType() {
    return type;
  }

  public void setType(ItemType type) {
    this.type = type;
  }

  public String getManufacturer() {
    return manufacturer;
  }

  public void setManufacturer(String manufacturer) {
    this.manufacturer = manufacturer;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  /**
   * The parent toString( ), provides the basic details of a product.
   *
   * @return strings of name, manufacturer, and type.
   */
  public String toString() {
    return "Product = "
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
