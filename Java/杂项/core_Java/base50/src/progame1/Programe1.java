package progame1;

import java.util.Scanner;

// 斐波那契数列
public class Programe1 {
    public static void main(String[] args){
        System.out.print("输入想知道的月份");
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        System.out.print("第" + n + "个月兔子总数为" + fun(n));
        scanner.close();
    }

    public static int fun(int n){
        if (n == 1 | n ==2)
            return 1;
        else
            return fun(n-1) + fun(n-2);
    }
}
