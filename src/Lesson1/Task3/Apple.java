package Lesson1.Task3;

public class Apple implements Fruit {
    private float count;

    public Apple(int count) {
        this.count = count;
    }

    @Override
    public float getCount() {
        return count;
    }
}
