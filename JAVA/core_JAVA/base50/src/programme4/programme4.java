package programme4;

/*
将一个正整数分解质因数。例如：输入90,打印出90=2*3*3*5。
 */

import java.util.Scanner;

public class programme4 {
    public static void main(String args[]){
        System.out.println("输入你要分解的正整数");
        Scanner scanner = new Scanner(System.in);
        int number = scanner.nextInt();
        System.out.print(number + " = ");
        for(int i=2; i < number + 1;i++){
            while (number % i == 0 && number != i ){
                number = number / i;
                System.out.print( i + " * ");
            }
            if(number==i) {//上面的都不能整除，说明这是一个质数
                System.out.print(i);
                break;
            }
        }
        scanner.close();
    }
}
