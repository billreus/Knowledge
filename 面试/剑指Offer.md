# 字符串

## StringBuffer

* appen():连接，添加
* insert():添加
* reverse():反转
* replace(start, end, words):替换
* substring(start, end):截取
* delete(start, end):删除
* indexOf(words, start):查找


# 1. 二维数组中的查找

遍历复杂度过高，采取的方法是先用右上角的数比较，如果右上角的数大了就左移一列，如果小了就下移一行。

```java
public class Solution {
    public boolean Find(int target, int [][] array) {
        int row = array.length, col = array[0].length;
        boolean res = false;
        if(row>0 && col>0 && array!=null){
            int rows = 0, cols = col-1; 
            while(cols>=0 && rows<row){
                if( target == array[rows][cols]){
                    res = true;
                    break;
                }
                if(target < array[rows][cols]){
                    cols--;
                }
                else{
                    rows++;
                }
            }
        }
        return res;
    }
}
```

## 2.替换空格

使用indexOf寻找空格，subSequence来截取字母，最后添加%20和字母

```java
public class Solution {
    public String replaceSpace(StringBuffer str) {
    	int len = str.length();
        int index = 0;
        int fromIndex = 0;
        StringBuffer res = new StringBuffer();
        while(index<len){
            index = str.indexOf(" ", fromIndex);
            if(index>=0){
                res.append(str.subSequence(fromIndex, index)).append("%20");
                index += 1;
                fromIndex = index;
            }
            else{
                res.append(str.subSequence(fromIndex, len));
                break;
            }
            
        }
        return res.toString();
    }
}
```