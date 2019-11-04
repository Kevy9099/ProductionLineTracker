package io.github.kevy9099;

/**
 * Screen class display description of a screen for a product in the console.
 *
 * @author Kevin Mak 9/24/2019
 */
public class Screen implements ScreenSpec {
  final String resolution;
  final int refreshRate;
  final int responseTime;

  /**
   * Describes the Screen Specifications of a product. Implements ScreenSpec class.
   *
   * @param resolution Resolution is a measure of an image display onto a screen. (ie 1920 x 1080)
   * @param refreshRate Refresh Rate is a measure of time in seconds to display images on a screen.
   *     (ie Hertz)
   * @param responseTime Response Time is a measure of time the display interacts on a screen. (ie
   *     milliSeconds)
   */
  public Screen(String resolution, int refreshRate, int responseTime) {
    this.resolution = resolution;
    this.refreshRate = refreshRate;
    this.responseTime = responseTime;
  }

  /**
   * Method that enables access to resolution.
   *
   * @return resolution
   */
  public String getResolution() {
    return resolution;
  }

  /**
   * Method that enables access to resolution.
   *
   * @return refreshRate
   */
  public int getRefreshRate() {
    return refreshRate;
  }

  /**
   * Method that enables access to resolution.
   *
   * @return responseTime
   */
  public int getResponseTime() {
    return responseTime;
  }

  /**
   * Screen fields are represented as strings, using the toString( ). Sets the fields of Screen to
   * the console.
   *
   * @return resolution, refreshRate, responseTime
   */
  public String toString() {
    return "  "
        + "Resolution: "
        + resolution
        + "  "
        + "Refresh Rate: "
        + refreshRate
        + "  "
        + "Response Time: "
        + responseTime;
  }
}
