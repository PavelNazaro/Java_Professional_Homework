package Lesson4;
class Prints {
    private static int score = 1;

    synchronized void printA() {
        while (score != 1) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        score++;
        System.out.println("A");
        notifyAll();
    }

    synchronized void printB() {
        while (score != 2) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        score++;
        System.out.println("B");
        notifyAll();
    }

    synchronized void printC() {
        while (score != 3) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        score = 1;
        System.out.println("C");
        notifyAll();
    }
}

class PrintA implements Runnable {

    private Prints prints;

    PrintA(Prints prints) {
        this.prints = prints;
    }

    @Override
    public void run() {
        for (int i = 0; i < 3; i++) {
            prints.printA();
        }
    }
}

class PrintB implements Runnable {

    private Prints prints;

    PrintB(Prints prints) {
        this.prints = prints;
    }

    @Override
    public void run() {
        for (int i = 0; i < 3; i++) {
            prints.printB();
        }
    }
}

class PrintC implements Runnable {

    private Prints prints;

    PrintC(Prints prints) {
        this.prints = prints;
    }

    @Override
    public void run() {
        for (int i = 0; i < 3; i++) {
            prints.printC();
        }
    }
}

public class Task1 {
    public static void main(String[] args) {
        Prints prints = new Prints();

        PrintA printA = new PrintA(prints);
        PrintB printB = new PrintB(prints);
        PrintC printC = new PrintC(prints);

        new Thread(printA).start();
        new Thread(printB).start();
        new Thread(printC).start();
    }
}