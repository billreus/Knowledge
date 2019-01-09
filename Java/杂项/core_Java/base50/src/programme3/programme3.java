package programme3;
/*
 *打印出100-999所有的"水仙花数"，所谓"水仙花数"是指一个三位数，其各位数字立方和等于该数本身。
 *例如：153是一个"水仙花数"，因为153=1的三次方＋5的三次方＋3的三次方。
*/
public class programme3 {
    public static void main(String args[]){
        for(int i =100; i<1000; i++){
            int ge = i%10;
            int ten = i/10%10;
            int hundred = i/100;
            if(i == ((ge * ge * ge)+(ten * ten * ten)+(hundred * hundred * hundred))){
                System.out.print(i + " ");
            }
        }
    }
}
