package Lesson6.Task2;

import java.util.Arrays;

public class ExtractNumber {
    protected static final int numberToExtract = 4;

    public static void main(String[] args) {
        System.out.println(Arrays.toString(zadanie(new int[]{5, 3, 2, 4, 1, 2, 4, 3, 7})));
        System.out.println(Arrays.toString(zadanie(new int[]{5, 3, 2, 4, 1, 2, 8, 3, 7})));
        System.out.println(Arrays.toString(zadanie(new int[]{5, 3, 2, 8, 1, 2, 4, 3, 7})));
        System.out.println(Arrays.toString(zadanie(new int[]{5, 3, 2, 8, 1, 2, 8, 3, 7})));
    }

    protected static int[] zadanie(int[] arr){
        int index = -1;

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == numberToExtract){
                index = i;
            }
        }

        if (index >= 0){
            int[] newArr = new int[arr.length - index - 1];
            int j = 0;

            for (int i = 0; i < arr.length; i++) {
                if (i > index){
                    newArr[j] = arr[i];
                    j++;
                }
            }

            return newArr;
        }

        throw new RuntimeException();
    }
}