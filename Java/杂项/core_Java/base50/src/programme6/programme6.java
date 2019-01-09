package programme6;

import java.util.Scanner;

/*
输入两个正整数m和n，求其最大公约数和最小公倍数。
 */
public class programme6 {
    public static void main(String args[]){
        System.out.println("输入两个数：");
        Scanner scanner = new Scanner(System.in);
        int num1 = scanner.nextInt();
        int num2 = scanner.nextInt();
        int temp = 1;
        int bigDivisor = 0;
        int multiple = num1 * num2;

        if(num1 < num2){
            temp = num1;
            num1 = num2;
            num2 = temp;
        }

        if(num1 % num2 != 0){
            temp = num1 % num2;
            num1 = num2;
            num2 = temp;
        }

        bigDivisor = num2;
        multiple = multiple / bigDivisor;
        System.out.println("最大公约数是："+bigDivisor );
        System.out.println("最小公倍数是："+multiple);
        scanner.close();
    }
}
