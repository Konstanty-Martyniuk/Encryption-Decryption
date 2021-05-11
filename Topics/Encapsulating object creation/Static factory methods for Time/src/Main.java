import java.util.Scanner;

class Time {

    int hour;
    int minute;
    int second;

    public static Time noon() {
        return of(12, 0, 0);
    }

    public static Time midnight() {
        return of(0, 0, 0);
    }

    public static Time ofSeconds(long seconds) {
        int hours = (int) seconds / 3600;
        int hour = hours < 23 ? hours : hours % 24;
        int minutes = (int) ((seconds % 3600) / 60);
        int second = (int) (seconds % 60);
        return of(hour, minutes, second);
    }

    public static Time of(int hour, int minute, int second) {
        if (isValidTime(hour, minute, second)) {
            Time time = new Time();
            time.hour = hour;
            time.minute = minute;
            time.second = second;
            return time;
        }
        return null;
    }

    private static boolean isValidTime(int hour, int minute, int second) {
        if (hour < 0 || hour > 23) {
            return false;
        }
        if (minute < 0 || minute > 59) {
            return false;
        }
        return second >= 0 && second < 60;
    }
}

/* Do not change code below */
public class Main {

    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);

        final String type = scanner.next();
        Time time = null;

        switch (type) {
            case "noon":
                time = Time.noon();
                break;
            case "midnight":
                time = Time.midnight();
                break;
            case "hms":
                int h = scanner.nextInt();
                int m = scanner.nextInt();
                int s = scanner.nextInt();
                time = Time.of(h, m, s);
                break;
            case "seconds":
                time = Time.ofSeconds(scanner.nextInt());
                break;
            default:
                time = null;
                break;
        }

        if (time == null) {
            System.out.println(time);
        } else {
            System.out.println(String.format("%s %s %s", time.hour, time.minute, time.second));
        }
    }
}