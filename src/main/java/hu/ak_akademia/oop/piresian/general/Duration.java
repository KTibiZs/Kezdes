package hu.ak_akademia.oop.piresian.general;

/**
 * <b>Exercise: Piresian Mobile Tariffs #1 (Piréz mobiltelefon-tarifák #1)</b>
 * <p>
 * Class to represent the duration of a call. Also includes a few convenience methods dedicated to specific tariff types.
 *
 * @author A&amp;K Akad&eacute;mia (Lajos Czuczor)
 */
public class Duration {
    String rawDuration;

    public Duration(String rawDuration) {
        this.rawDuration = rawDuration;
    }

    public String getRawDuration() {
        return rawDuration;
    }

    public double rawDurationToSec(String rawDuration)  {
        int temp;
        String[] time = rawDuration.split(":");
        int minute = Integer.parseInt(time[0]);
        int second = Integer.parseInt(time[1]);
        temp = second + (60 * minute);
        return temp;
    }
}
