package io.github.kevy9099;

public interface Item {

  private int getId() {
    return 0;
  }

  void setName(String n);

  String getName();

  void setManufacturer(String m);

  String getManufacturer();
}
