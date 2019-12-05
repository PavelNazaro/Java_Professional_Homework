package Lesson4;

import java.io.*;

public class Task2 {
    private static final String pathToFile = "src/Lesson4/ChatHistory.txt";
    private static File file = new File(pathToFile);

    public static void main(String[] args) throws IOException, InterruptedException {
        WriteInFile10Str writeInFile10Str = new WriteInFile10Str();

        PrintOneStr printOneStr = new PrintOneStr(writeInFile10Str);
        PrintTwoStr printTwoStr = new PrintTwoStr(writeInFile10Str);
        PrintThreeStr printThreeStr = new PrintThreeStr(writeInFile10Str);

        new Thread(printOneStr).start();
        new Thread(printTwoStr).start();
        Thread printThreeStrThread = new Thread(printThreeStr);
        printThreeStrThread.start();

        printThreeStrThread.join();

        if (file.exists()) {
            BufferedReader br = new BufferedReader(new FileReader(file));

            String str;
            while ((str = br.readLine()) != null) {
                System.out.println(str);
            }

            br.close();
        }
        else {
            System.out.println("File not found!");
        }
    }
}

class WriteInFile10Str {

    private static final String pathToFile = "src/Lesson4/ChatHistory.txt";
    private static File file = new File(pathToFile);
    private static int score = 1;

    synchronized void printOneStr(String string) {
        while (score != 1) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        score++;
        try {
            writeInFile(string);
        } catch (IOException e) {
            e.printStackTrace();
        }
        sleep();
        notifyAll();
    }

    synchronized void printTwoStr(String string) {
        while (score != 2) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        score++;
        try {
            writeInFile(string);
        } catch (IOException e) {
            e.printStackTrace();
        }
        sleep();
        notifyAll();
    }

    synchronized void printThreeStr(String string) {
        while (score != 3) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        score = 1;
        try {
            writeInFile(string);
        } catch (IOException e) {
            e.printStackTrace();
        }
        sleep();
        notifyAll();
    }

    private void sleep() {
        try {
            Thread.sleep(20);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private static void writeInFile(String string) throws IOException {
        if (!file.exists()){
            boolean created = file.createNewFile();
        }

        try (FileWriter writer = new FileWriter(file, true)) {
            writer.write(string + System.lineSeparator());
            writer.flush();

        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }
}

class PrintOneStr implements Runnable {

    private WriteInFile10Str writeInFile10Str;

    PrintOneStr(WriteInFile10Str writeInFile10Str) {
        this.writeInFile10Str = writeInFile10Str;
    }

    @Override
    public void run() {
        for (int i = 1; i <= 10; i++) {
            writeInFile10Str.printOneStr("Первый поток, строка №: " + i);
        }
    }
}

class PrintTwoStr implements Runnable {

    private WriteInFile10Str writeInFile10Str;

    PrintTwoStr(WriteInFile10Str writeInFile10Str) {
        this.writeInFile10Str = writeInFile10Str;
    }

    @Override
    public void run() {
        for (int i = 1; i <= 10; i++) {
            writeInFile10Str.printTwoStr("Второй поток, строка №: " + i);
        }
    }
}

class PrintThreeStr implements Runnable {

    private WriteInFile10Str writeInFile10Str;

    PrintThreeStr(WriteInFile10Str writeInFile10Str) {
        this.writeInFile10Str = writeInFile10Str;
    }

    @Override
    public void run() {
        for (int i = 1; i <= 10; i++) {
            writeInFile10Str.printThreeStr("Третий поток, строка №: " + i);
        }
    }
}
