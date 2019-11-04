package io.github.kevy9099;

/**
 * ScreenSpec Interface creates fields that gives description to a Product Screen: Resolution,
 * RefreshRate, and ResponseTime.
 *
 * @author Kevin Mak 9/26/2019
 */
public interface ScreenSpec {
  String getResolution();

  int getRefreshRate();

  int getResponseTime();
}
