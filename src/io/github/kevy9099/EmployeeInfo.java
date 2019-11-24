package io.github.kevy9099;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * A class that creates an employee that is recorded. The Employee holds a name(last, and surname),
 * username, password and an email. (log In) it validates a password for each employee and checks
 * for employee name.
 */
public class EmployeeInfo {

  final StringBuilder name;
  String username;
  final String password;
  String email;

  /**
   * A constructor that passes name and password. new object of StringBuild calls a name. if
   * CheckName of name is valid and validPassword of password, sets employee username, email, and
   * password. else, it uses default username email, and password.
   *
   * @param name A name of the employee.
   * @param password Unique password of the employee.
   */
  public EmployeeInfo(String name, String password) {
    this.name = new StringBuilder(name);
    if (checkName(name)) {
      setUsername(name);
      setEmail(name);
    } else {
      username = "default";
      email = "user@oracleacademy.Test";
    }

    if (isValidPassword(password)) {
      this.password = password;
    } else {
      this.password = "pw";
    }
  }

  /**
   * A function that passes a name. checks pattern whitespaces after and before. finds the name and
   * whitespaces.
   *
   * @param name A name of the employee.
   */
  private void setUsername(String name) {
    Pattern nameAfterSpace = Pattern.compile("\\s(.*)", Pattern.MULTILINE);
    Matcher nameAfterSpaceMatch = nameAfterSpace.matcher(name);
    nameAfterSpaceMatch.find();
    String lastName = nameAfterSpaceMatch.group(1);

    String initials = name.substring(0, 1) + lastName;

    this.username = initials.toLowerCase();
  }

  /**
   * Function the checks a pattern and matcher for Name.
   *
   * @param name A name of the employee.
   * @return credentials a name that matches Name.
   */
  private boolean checkName(String name) {
    Pattern pattern = Pattern.compile("\\s");
    Matcher matcher = pattern.matcher(name);
    if (matcher.find()) return true;
    else return false;
  }

  /**
   * A function for Email that checks pattern and whitespaces( before and after) of group 1. uses
   * regex syntax to check these lines. email is then initialize to firstName, lastName and a email
   * test.
   *
   * @param name A name of the employee.
   */
  private void setEmail(String name) {
    Pattern nameBeforeSpace = Pattern.compile("(.*)\\s", Pattern.MULTILINE);
    Matcher nameBeforeSpaceMatch = nameBeforeSpace.matcher(name);
    nameBeforeSpaceMatch.find();
    String firstName = nameBeforeSpaceMatch.group(1);

    Pattern nameAfterSpace = Pattern.compile("\\s(.*)", Pattern.MULTILINE);
    Matcher nameAfterSpaceMatch = nameAfterSpace.matcher(name);
    nameAfterSpaceMatch.find();
    String lastName = nameAfterSpaceMatch.group(1);

    this.email = firstName.toLowerCase() + "." + lastName.toLowerCase() + "@oracleacademy.Test";
  }

  /**
   * A function that checks input of password, for incorrect or correct characters.
   *
   * @param password Unique password of the employee.
   * @return boolean true or false for matcher.
   */
  private boolean isValidPassword(String password) {
    String regex = "^(?=.[A-Z])+^(?!.[^!a-zA-Z0-9@#$^+=])";
    Pattern pattern = Pattern.compile(regex);
    Matcher matcher = pattern.matcher(password);
    return matcher.find();
  }

  /**
   * reverseString methods to ensure that sensitive information is not leaked, the information is
   * saved to file is encoded.
   *
   * @param password Unique password of the employee.
   * @return reverseString to secure the user password.
   */
  public String reverseString(String password) {
    int length = password.length();
    if (length == 0) {
      return password;
    }
    return reverseString(password.substring(1)) + password.charAt(0);
  }

  /**
   * ToString method that outputs name, username, email, and password to the Employee Tab.
   *
   * @return name, username, email and password.
   */
  public String toString() {
    return "Employee Details\n"
        + "Name : "
        + name
        + "\n"
        + "Username : "
        + username
        + "\n"
        + "Email : "
        + email
        + "\n"
        + "Initial Password : "
        + password;
  }
}
