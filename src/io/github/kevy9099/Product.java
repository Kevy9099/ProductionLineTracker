package io.github.kevy9099;

public abstract class Product implements Item {
 public ItemType type;
  private String manufacturer;
  private String name;

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

  public String toString() {
    return "Product{"
        + ", Type = '" + type + '\'' + ", Manufacturer = '"
        + manufacturer + '\'' + ", Name = '" + name + '\'';
  }
}
