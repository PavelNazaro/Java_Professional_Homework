package Lesson1;

public class PlayMethods{
    public static void main(String[] args) {
        //Task1
        System.out.println("Task1:");
        int[] array = {1, 2, 3, 4};
        Methods arr = new Methods(array);
        arr.swapArr();

        //Task2
        System.out.println("Task2:");
        arr.createArrayList();
    }
}
