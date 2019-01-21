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
        int n=19;
        while(n!=4 && n!=16 && n!=37 && n!=58 && n!=89 && n!=145 && n!=42 && n!=20){
            int num = 0;
            int t=0;
            while(n!=0){
                t = n%10;
                num +=t*t;
                n/=10;
            }
            n = num;
        }
        int res = 0;
        if(n==1) res=1;
        else res=2;
      System.out.print(res);
    }
}
