package Lesson4;

class MFY {
    private int countPrint = 0;
    private int countScan = 0;

    void print() {
        countPrint++;
        System.out.println("Отпечатано страниц: " + countPrint);
        sleep();
    }

    void scan() {
        countScan++;
        System.out.println("Отсканировано страниц: " + countScan);
        sleep();
    }

    private void sleep() {
        try {
            Thread.sleep(50);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

class Print implements Runnable {

    private MFY mfy;

    Print(MFY mfy) {
        this.mfy = mfy;
    }

    @Override
    public void run() {
        mfy.print();
        mfy.print();
        mfy.print();
        mfy.print();
        mfy.print();
    }
}

class Scan implements Runnable {
    private MFY mfy;

    Scan(MFY mfy) {
        this.mfy = mfy;
    }

    @Override
    public void run() {
        mfy.scan();
        mfy.scan();
        mfy.scan();
        mfy.scan();
        mfy.scan();
    }
}


public class Task3 {
    public static void main(String[] args) {
        MFY mfy = new MFY();

        Print print = new Print(mfy);
        Scan scan = new Scan(mfy);

        new Thread(print).start();
        new Thread(scan).start();
    }
}