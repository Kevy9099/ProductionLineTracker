package sample;

import java.util.ArrayList;

public class AudioPlayerTest extends AudioPlayer {
  public AudioPlayerTest(
      String type,
      String manufacturer,
      String name,
      String audioSpecification,
      String mediaType) {
    super(name, manufacturer, type, audioSpecification, mediaType);
  }

  public static void main(String[] args) {
    AudioPlayerTest test = new AudioPlayerTest("AM", "Microsoft", "Windows",
                "Windows Audio", "Windows Media Player");
    ArrayList<AudioPlayerTest> AudioLine = new ArrayList<>();
    AudioLine.add(test);
    System.out.println(AudioLine.toString());
  }
}
