package Lesson8;

public class Main {
    public static void main(String[] args) {
        spiral(5,4);
    }

    private static void spiral(int l, int k) {
        int[][] arr = new int[k][l];
        int count = 1;
        int stop = k * l;
        int i = 0, j = 0;
        if (k == 1 || l == 1){
            while(j < l){
                arr[i][j++] = count++;
            }

            i++;j--;

            while(i < k){
                arr[i++][j] = count++;
            }
        }else {
            int m = 0;
            int col;

            if (k >= l){
                col = k/2;
            }
            else{
                col = l/2;
            }

            if (k == l && k%2 != 0){
                col++;
            }

            while (col > 0) {
                while (j < l-m){
                    arr[i][j++] = count++;
                }

                if (count > stop){
                    break;
                }

                i++;j--;

                while (i < k-m){
                    arr[i++][j] = count++;
                }

                if (count > stop){
                    break;
                }

                i--;j--;

                while (j >= m) {
                    arr[i][j--] = count++;
                }

                if (count > stop){
                    break;
                }

                i--;j++;

                while (i > m){
                    arr[i--][j] = count++;
                }

                i++;j++;

                col--;
                m++;
            }
        }

        for (i = 0; i < k; i++) {
            for (j = 0; j < l; j++) {
                if (arr[i][j] <= 9){
                    System.out.print(0);
                }
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }
}