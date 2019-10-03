package sample;

public abstract class Product implements Item {
  private int id;
  private String type;
  private String manufacturer;
  private String name;

  Product(int id, String type, String manufacturer, String name) {
    this.id = id;
    this.type = type;
    this.manufacturer = manufacturer;
    this.name = name;
  }

  public String getType() {
    return type;
  }

  public String setType(String type) {
    this.type = type;
    return type;
  }

  public int getId() {
    return id;
  }

  public int setId(int id) {
    this.id = id;
    return id;
  }

  public String getManufacturer() {
    return manufacturer;
  }

  public String setManufacturer(String manufacturer) {
    this.manufacturer = manufacturer;
    return manufacturer;
  }

  public String getName() {
    return name;
  }

  public String setName(String name) {
    this.name = name;
    return name;
  }

  public String toString() {
    return "Product{"
        + "id="
        + id
        + ", type='"
        + type
        + '\''
        + ", manufacturer='"
        + manufacturer
        + '\''
        + ", name='"
        + name
        + '\''
        + '}';
  }
}
