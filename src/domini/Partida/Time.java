package domini.Partida;

import java.lang.System;

public class Time {
    private long total = 0;
    private long begin, end;

    public Time() {}

    public Time(double start_time)
    {
        total = (long) start_time;
    }

    public void start()
    {
        begin = System.currentTimeMillis();
        end = begin;
    }

    public void stop()
    {
        end = System.currentTimeMillis();
        total += end - begin;
    }

    public void reset()
    {
        total = 0;
    }

    public double getTime()
    {
        return total;
    }

    public double getTimeSeconds()
    {
        return total/1000.0;
    }
}
