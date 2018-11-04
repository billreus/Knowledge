package programme9;

import java.util.Scanner;

/*
一个数如果恰好等于它的因子之和，这个数就称为"完数"。例如6=1＋2＋3.编程找出1000以内的所有完数。
 */
public class programme9 {
    public static void main(String args[]){
        for(int i=1; i<=1000; i++){
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

    }
}
