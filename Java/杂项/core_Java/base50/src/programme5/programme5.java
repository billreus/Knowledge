package programme5;

import java.util.Scanner;

/*
利用条件运算符的嵌套来完成此题：学习成绩>=90分的同学用A表示，60-89分之间的用B表示，60分以下的用C表示。
 */
public class programme5 {
    public static void main(String args[]){
        System.out.println("请输入你的分数： ");
        Scanner scanner = new Scanner(System.in);
        int score = scanner.nextInt();
        if(score >= 90){System.out.println("A");}
        else if(score < 60){System.out.println("C");}
        else {System.out.println("B");}
    }
}
