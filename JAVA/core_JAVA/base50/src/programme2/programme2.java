package programme2;
/* 判断101-200之间有多少个素数，并输出所有素数。 */
public class programme2 {
    public static void main(String[] args){
        for(int i = 101; i < 201; i++){
            if(IsRightNum(i)){
                System.out.print(i + " ");
            }
        }
    }

    private static boolean IsRightNum(int i){
        for(int j =2; j < i; j++){
            if(i % j == 0){ return false;}
        }
        return true;
    }
}
