package programme9;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/*
一个数如果恰好等于它的因子之和，这个数就称为"完数"。例如6=1＋2＋3.编程找出1000以内的所有完数。
 */
public class programme9 {
    public static void main(String args[]){
/*        for(int i=1; i<=1000; i++){
            int sum = 0;
            for(int j=1; j<i/2+1; j++){
                if(i % j == 0){
                    sum = sum + j;
                    if(i == sum){
                        System.out.print(sum + " ");
                    }
                }
            }
        }
*/

        List<Integer> list = new ArrayList<>();
        int[][] array = new int[3+1][3+1];
        for(int i=0; i<=3; i++){
            //List<Integer> list = new ArrayList<>();

            for(int j=0; j<=i; j++){
                if(i==0 || j==i){array[i][j] = 1;}
                else{array[i][j] = array[i-1][j-1] + array[i-1][j];}
                if(i==3){list.add(array[i][j]);}
                System.out.print(list);
            }
        }
      // System.out.print(list);
    }
}
