package Lesson1;

import java.util.ArrayList;

public class Methods implements IMethods{
    private int[] task1Arr;

    public Methods(int[] task1Arr) {
        this.task1Arr = task1Arr;
    }

    @Override
    public void swapArr() {
        displayArr();
        int a = task1Arr[1];
        task1Arr[1] = task1Arr[2];
        task1Arr[2] = a;
        displayArr();
    }

    @Override
    public void displayArr() {
        for (int i = 0; i < task1Arr.length; i++) {
            System.out.print(task1Arr[i]);
        }
        System.out.println();
    }

    @Override
    public void createArrayList(){
        ArrayList<Integer> list = new ArrayList<>();
        for (Integer integer: task1Arr) {
            list.add(integer);
        }
        System.out.println(list);
    }
}
