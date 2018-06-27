package utils;

public class TimeKeeper {
    private long startTime;

    public TimeKeeper() {
        startTime = System.currentTimeMillis();
    }

    public void tic(String message){
        System.out.println(message);
        startTime = System.currentTimeMillis();
    }

    public void tic(){
        startTime = System.currentTimeMillis();
    }

    public long toc(String message){
        long totalTime = System.currentTimeMillis() - startTime;
        System.out.println(message + " ( " + (totalTime / 1000D ) + " seconds )");
        return totalTime;
    }

    public long toc(){
        return System.currentTimeMillis() - startTime;
    }
}
