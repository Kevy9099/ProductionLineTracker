package io.github.kevy9099;

public enum ItemType {
  Audio("AU"),
  Visual("VI"),
  AudioMobile("AM"),
  VisualMobile("VM");

  public final String values;

  ItemType(String value) {
    this.values = value;
  }

  public String getValue() {
    return this.values;
  }
}
