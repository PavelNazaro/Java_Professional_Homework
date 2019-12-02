package Lesson5;

import static Lesson5.Main.*;

public class Road extends Stage {
    public Road(int length) {
        this.length = length;
        this.description = "Дорога " + length + " метров";
    }

    @Override
    public void go(Car c) {
        try {
            System.out.println(c.getName() + " начал этап: " + description);
            Thread.sleep(length / c.getSpeed() * 1000);
            System.out.println(c.getName() + " закончил этап: " + description);
            if (length == SECOND_ROAD && WIN > 0){
                WIN--;
                System.out.println(c.getName() + " WIN !!!");
            }
            END.countDown();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}