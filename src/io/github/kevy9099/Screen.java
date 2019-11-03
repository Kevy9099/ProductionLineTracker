package io.github.kevy9099;

public class Screen implements ScreenSpec {
  final String resolution;
  final int refreshRate;
  final int responseTime;

  /**
   * Describes the Screen Specifications of a product. Implements ScreenSpec class.
   *
   * @param resolution measure of an image display onto a screen.
   * @param refreshRate measure of time in seconds to display images on a screen.
   * @param responseTime measure of time in seconds the display interacts on a screen.
   */
  public Screen(String resolution, int refreshRate, int responseTime) {
    this.resolution = resolution;
    this.refreshRate = refreshRate;
    this.responseTime = responseTime;
  }

  public String getResolution() {
    return resolution;
  }

  public int getRefreshRate() {
    return refreshRate;
  }

  public int getResponseTime() {
    return responseTime;
  }

  /**
   * Screen Specifications converts to strings, using toString( ) method.
   *
   * @return strings of Resolution, Refresh Rate, Response Time.
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
