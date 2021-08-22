package api.dateday;

public class DaySeconds {
    public static int getSecondDay() {
        int hour = 24;
        int minute = 60;
        int second = 60;
        int Day = hour*minute*second;
        return Day;
    }
}
