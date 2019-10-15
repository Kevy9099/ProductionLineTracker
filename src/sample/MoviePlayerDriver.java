package sample;

import java.util.ArrayList;

public class MoviePlayerDriver extends MoviePlayer{
    public MoviePlayerDriver(String type, String manufacturer, String name, String screen, String monitorType) {
        super(type, manufacturer, name, screen, monitorType);
    }
    public static void main(String[] args) {
        MoviePlayerDriver movie = new MoviePlayerDriver("AM", "Microsoft", "Windows",
                        "Windows Audio", "Windows Media Player");
        ArrayList<MoviePlayerDriver> movieLine = new ArrayList<>();
        movieLine.add(movie);
        System.out.println(movieLine.toString());
    }
}
