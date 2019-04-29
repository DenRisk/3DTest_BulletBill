package Basics;

public class Time {

    public static long curTime = 0;
    public static long timePassed = 0;
    public static long lastTime = 0;
    public static double timeFraction = 0.0;

    public static void updateTime() {

        lastTime = curTime;
        curTime = System.currentTimeMillis();
        timePassed = (curTime - lastTime);
        timeFraction = (timePassed / 1000.0);
    }
}
