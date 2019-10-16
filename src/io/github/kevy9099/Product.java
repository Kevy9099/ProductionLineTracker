package io.github.kevy9099;

public abstract class Product implements Item {
  private String type;
  private String manufacturer;
  private String name;

 public Product(String name, String type, String manufacturer) {
    this.type = type;
    this.manufacturer = manufacturer;
    this.name = name;
  }

  public String getType() {
    return type;
  }

  public void setType(String type) {
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
