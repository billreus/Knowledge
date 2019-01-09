package programme8;

import java.util.Scanner;

/*
求s=a+aa+aaa+aaaa+aa...a的值，其中a是一个数字。
例如2+22+222+2222+22222(此时共有5个数相加)，几个数相加有键盘控制。输出结果的形式如：2+22+222=246；
 */
public class programme8 {
    public static void main(String args[]){
        int a = 0;
        int n = 0;
        Scanner scanner = new Scanner(System.in);
        System.out.print("输入a的值：");
        a = scanner.nextInt();
        System.out.print("输入n的值：");
        n = scanner.nextInt();
        int num = a;
        int out = a;

        System.out.print(a );
        for (int i = 1; i < n; i++){
            num = num * 10 + a;
            out = out + num;
            System.out.print(" + " + num);
        }
        System.out.print(" = " + out);
    }
}
