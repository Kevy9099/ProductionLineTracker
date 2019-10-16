package io.github.kevy9099;

public class Screen implements ScreenSpec {
    String resolution;
    int refreshRate;
    int responseTime;

    public Screen (String resolution, int refreshRate, int responseTime){
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

    public String toString() {
            return "Screen{" + "Resolution = '" + resolution + '\'' + ", Refresh Rate = " + refreshRate
                    + '\'' + ", Response Time = " + responseTime + '\'';
    }
}
