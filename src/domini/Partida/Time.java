package domini.Partida;

public class Time {
    private long total;
    private long begin;

    public Time() {}

    public Time(double start_time)
    {
        total = (long) start_time;
    }

    public void start()
    {
        begin = System.nanoTime();
    }

    public void stop()
    {
        total = System.nanoTime() - begin;
    }

    public void reset()
    {
        total = 0;
        begin = System.nanoTime();
    }

    public double getTotal() {
        return total;
    }

    public double getTimeSeconds()
    {
        return (System.nanoTime()-begin)/1000000000.0;
    }
}
