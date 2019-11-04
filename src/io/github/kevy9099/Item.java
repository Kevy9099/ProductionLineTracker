package io.github.kevy9099;

/**
 * Item Interface creates fields called name, and manufacturer that returns a String.
 *
 * @author Kevin Mak 9/26/2019
 */
public interface Item {

  void setName(String n);

  String getName();

  void setManufacturer(String m);

  String getManufacturer();
}
