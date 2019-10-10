package sample;

public abstract class Product implements Item {
  private int id;
  private String type;
  private String manufacturer;
  private String name;

 public Product(int id, String type, String manufacturer, String name) {
    this.id = id;
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

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
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
        + "Id = "
        + id
        + ", Type = '"
        + type
        + '\''
        + ", Manufacturer = '"
        + manufacturer
        + '\''
        + ", Name = '"
        + name
        + '\'';
  }
}
