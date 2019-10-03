package sample;
//Issue 2
public enum ItemType {
  Audio("AU"),
  Visual("VI"),
  AudioMobile("AM"),
  VisualMobile("VM");

  public final String values;

  ItemType(String value) {
    values = value;
  }

  public String getValue() {
    return this.values;
  }
}
