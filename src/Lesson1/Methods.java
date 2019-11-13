package Lesson1;

public class Methods implements IMethods{
    private int[] task1Arr;

    public Methods(int[] task1Arr) {
        this.task1Arr = task1Arr;
    }

    @Override
    public void swapArr() {
        display();
        int a = task1Arr[1];
        task1Arr[1] = task1Arr[2];
        task1Arr[2] = a;
        display();
    }

    @Override
    public void display() {
        for (int i = 0; i < task1Arr.length; i++) {
            System.out.print(task1Arr[i]);
        }
        System.out.println();
    }
}
