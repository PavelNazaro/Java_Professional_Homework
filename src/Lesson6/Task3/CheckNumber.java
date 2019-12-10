package Lesson6.Task3;

public class CheckNumber {
    protected static final int numberToCheck1 = 1;
    protected static final int numberToCheck2 = 4;

    public static void main(String[] args) {
        System.out.println(zadanie(new int[]{5, 3, 2, 4, 1, 2, 4, 3, 7}));
        System.out.println(zadanie(new int[]{5, 3, 2, 4, 4, 2, 4, 3, 7}));
        System.out.println(zadanie(new int[]{5, 3, 2, 1, 1, 2, 1, 3, 7}));
        System.out.println(zadanie(new int[]{5, 3, 2, 8, 8, 2, 8, 3, 7}));
    }

    protected static boolean zadanie(int[] arr){
        int indexCheck1 = 0;
        int indexCheck2 = 0;

        for (int i : arr) {
            if (i == numberToCheck1){
                indexCheck1 ++;
            }
            if (i == numberToCheck2){
                indexCheck2 ++;
            }
        }

        return indexCheck1 > 0 && indexCheck2 > 0;
    }
}