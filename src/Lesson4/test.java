//package Lesson4;
//
//class MFY {
//
//    void print(int listToPrint) {
//        int countPrint = 1;
//        for (int i = 0; i < listToPrint; i++) {
//            System.out.println("Отпечатано страниц: " + countPrint);
//            countPrint++;
//            sleep();
//        }
////        notify();
////        try {
////            wait();
////        } catch (InterruptedException e) {
////            e.printStackTrace();
////        }
//    }
//
//    void scan(int listToScan) {
//        int countScan = 1;
//        for (int i = 0; i < listToScan; i++) {
//            System.out.println("Отсканировано страниц: " + countScan);
//            countScan++;
//            sleep();
//        }
////        notify();
////        try {
////            wait();
////        } catch (InterruptedException e) {
////            e.printStackTrace();
////        }
//    }
//
//    private void sleep() {
//        try {
//            Thread.sleep(50);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//    }
//}
//
//class Print implements Runnable {
//
//    private MFY mfy;
//
//    Print(MFY mfy) {
//        this.mfy = mfy;
//    }
//
//    @Override
//    public void run() {
//        mfy.print(5);
//        mfy.print(5);
//    }
//}
//
//class Scan implements Runnable {
//    private MFY mfy;
//
//    Scan(MFY mfy) {
//        this.mfy = mfy;
//    }
//
//    @Override
//    public void run() {
//        mfy.scan(5);
//        mfy.scan(5);
//    }
//}
//
//
//public class Task3 {
//    public static void main(String[] args) {
//        MFY mfy = new MFY();
//
//        Print print = new Print(mfy);
//        Scan scan = new Scan(mfy);
//
//        new Thread(print).start();
//        new Thread(scan).start();
//    }
//}