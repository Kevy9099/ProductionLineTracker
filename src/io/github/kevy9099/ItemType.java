package io.github.kevy9099;

/**
 * ItemType enum create objects with corresponding values. ItemType will set an ItemType or Type for
 * product.
 *
 * @author Kevin Mak 9/24/2019
 */
public enum ItemType {
  Audio("AU"),
  Visual("VI"),
  AudioMobile("AM"),
  VisualMobile("VM");

  public final String values;

  /**
   * ItemType will pass in a value of a String.
   *
   * @param value value is the ItemType the user chooses.
   */
  ItemType(String value) {
    this.values = value;
  }

  /**
   * Method that enables access to a value.
   *
   * @return value
   */
  public String getValue() {
    return this.values;
  }
}
