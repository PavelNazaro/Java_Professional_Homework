package Lesson1.Task3;

public class Orange implements Fruit {
    private float count;

    public Orange(int count) {
        this.count = count;
    }

    @Override
    public float getCount() {
        return count;
    }
}
