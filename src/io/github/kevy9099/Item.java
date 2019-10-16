package io.github.kevy9099;
// Issue 2 Vars for Item. Declaration not fixed yet, because the vars are not in used yet.
public interface Item {

  private int getId() {
    return 0;
  }
  void setName(String n);

  String getName();

  void setManufacturer(String m);

  String getManufacturer();
}
