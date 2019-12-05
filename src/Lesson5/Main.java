package Lesson5;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Semaphore;

public class Main {
    public static final int CARS_COUNT = 4;

    public static final CountDownLatch READY = new CountDownLatch(CARS_COUNT);
    public static final CountDownLatch END = new CountDownLatch(CARS_COUNT * 2);
    public static int WIN = 1;
    public static final Semaphore smp = new Semaphore(CARS_COUNT / 2);

    private static final int FIRST_ROAD = 60;
    public static final int SECOND_ROAD = 40;

    public static void main(String[] args) throws InterruptedException {
        System.out.println("ВАЖНОЕ ОБЪЯВЛЕНИЕ >>> Подготовка!!!");
        Race race = new Race(new Road(FIRST_ROAD), new Tunnel(), new Road(SECOND_ROAD));
        Car[] cars = new Car[CARS_COUNT];
        for (int i = 0; i < cars.length; i++) {
            cars[i] = new Car(race, 20 + (int) (Math.random() * 10));
        }
        for (int i = 0; i < cars.length; i++) {
            new Thread(cars[i]).start();
        }
        READY.await();
        System.out.println("ВАЖНОЕ ОБЪЯВЛЕНИЕ >>> Гонка началась!!!");
        END.await();
        System.out.println("ВАЖНОЕ ОБЪЯВЛЕНИЕ >>> Гонка закончилась!!!");
    }
}