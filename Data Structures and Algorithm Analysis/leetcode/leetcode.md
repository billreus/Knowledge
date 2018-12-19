<!-- TOC -->

- [字符串](#字符串)
    - [771. 宝石与石头](#771-宝石与石头)
        - [最初想法](#最初想法)
        - [改进](#改进)
    - [929. 独特的电子邮件](#929-独特的电子邮件)
        - [基本思路](#基本思路)
        - [改进](#改进-1)
    - [709. 转换成小写字母](#709-转换成小写字母)
    - [804. 唯一摩尔斯密码词](#804-唯一摩尔斯密码词)
        - [最初想法](#最初想法-1)
        - [改进](#改进-2)
- [数组](#数组)
    - [905. 按奇偶排序数组](#905-按奇偶排序数组)
        - [基本思路](#基本思路-1)
        - [改进](#改进-3)
    - [832. 翻转图像](#832-翻转图像)
        - [基本思路](#基本思路-2)
        - [改进](#改进-4)
    - [461. 汉明距离](#461-汉明距离)
        - [基本思路](#基本思路-3)
        - [改进](#改进-5)

<!-- /TOC -->

# 字符串

String转换成char

```java
String s = "abcd";
char[] ss = s.toCharArray();
```

char转换成String:`String.valueOf(ss);`

String看作字符串，char看作字符

返回指定索引处的字符：`char word = words.chartAt(int index);`

返回指定字符所在索引：`stringword.indexOf(word)`

切割字符串(前开后闭)：`word.substring(0,3);`

替换字符:`word.replace(".", ",")`

* list,set添加使用add，stringbuilder和char添加使用append
* string作为字符串是不可改变的，需要添加型字符串可以使用Stringbuilder和StringBuffer

## 771. 宝石与石头

### 最初想法

遍历两个string，嵌套for循环比较

```java
class Solution {

    public int numJewelsInStones(String J, String S) {
        
        int count = 0;
        
        for(int i = 0; i < J.length(); i++){
        
            char J_char = J.charAt(i);
            
            for(int k = 0; k < S.length(); k++){
                
                char S_char = S.charAt(k);
                
                if(J_char == S_char) count++;
            }
        }

        return count;
    }
}
```

用时19ms

### 改进

以下两种方法，也只优化到了18ms，省略了嵌套的for循环

第一种思想

* 用一个统计数组存储24个字母，先对石头遍历一遍遍历到的加一，再对宝石遍历，宝石提到的字符，直接提取统计的数据累加。

```java
class Solution{
    public int numJewelsInStones(String J, String S){
        char[] j = J.toCharArray();
        char[] s = S.toCharArray();
        int count = new int['z' - 'A' + 1];
        
        for (char ch:s){
            count[ch -'A']++;
        }
        
        int sum = 0;
        
        for (char ch:j){
            sum += count[ch - 'A'];
        }
        return sum;
    }
}
```

第二种思想

* 使用index直接在石头中定位到宝石的位置进行累加。

```java
class Solution{
    public int numJewelsInStones(String J, String S){
        char[] s = s.toCharArray();
        int sum = 0;
        
        for (char ch:s){
            if(J.indexOf(ch) >= 0) sum++;
        }
        return sum;
}
```

## 929. 独特的电子邮件

* leetcode答案中9,10ms为错误答案

### 基本思路

主要需要解决的问题：

1. 对于@前后字符的分割
2. 对于+和,的处理
3. 对于本地名称的去重

解决方法：

1. 使用indexOf()方法进行定位，substring()方法进行切割
2. 使用substring()处理"+"，用replace()处理"，"
3. 使用HastSet去重

```java
    public int numUniqueEmails(String[] emails) {
        Set<String> set=new HashSet<>();
        for(String email:emails){
            //本地名称(前闭后开)
            String name=email.substring(0,email.indexOf("@"));
            //域名
            String domain=email.substring(email.indexOf("@"));
            //根据指定规则解析后的本地名称，先按加号切割字符串，然后替换'.'
            String newName=name.substring(0,name.indexOf("+")).replaceAll(".","");
            //使用HashSet去重
            set.add(newName+domain);
        }
        return set.size();
    }
```

### 改进

```java
class Solution {

    public int numUniqueEmails(String[] emails) {
        ArrayList<String> ans = new ArrayList<>();
        
        for (String email : emails) {
            String web[] = email.split("@");
            web[0] = web[0].replace(".", "");

            for (int i = 0; i < web[0].length(); i++) {
                if (web[0].charAt(i) == '+') {
                    web[0] = web[0].substring(0, i);
                }
            }
            email = web[0] + "@" + web[1];
            if(!ans.contains(email))
                ans.add(email);
        }
        return ans.size();
    }
}
```

## 709. 转换成小写字母

String中toLowerCase()可以使字符变成小写字母，toUpperCase()变成大写字母；

```java
class Solution {
    public String toLowerCase(String str) {
        return str.toLowerCase();
    }
}
```

## 804. 唯一摩尔斯密码词

### 最初想法

1. 创建一个String存储摩斯密码，一个char存储24个字母，一个stringbuilder存储测试的摩斯密码，一个HashSet去重统计最后输出
2. 双重for把words提取出单个字母，再for对比24个字母，相同即添加对应位置的摩斯密码，最后转化成string添加到hashset计算size
```java
class Solution {
    public int uniqueMorseRepresentations(String[] words) {
        String[] j = {".-","-...","-.-.","-..",".","..-.","--.","....","..",".---","-.-",".-..","--","-.","---",".--.","--.-",".-.","...","-","..-","...-",".--","-..-","-.--","--.."};
        char[] w ={'a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z'};
        HashSet<String> set = new HashSet<String>();
        
        for(String word : words){
            //StringBuffer ms = new StringBuffer();
            //单线程使用builder即可，速度快3ms
            StringBuilder ms = new StringBuilder();
            char[] wor = word.toCharArray();
            for(char ww : wor){
                for(int i=0; i<w.length; i++){
                    if(ww == w[i]){
                        ms.append(j[i]);
                    }
                }
            }
            set.add(ms.toString());
        }
        return set.size();
    }
}
```

### 改进

无需存储完整的24字母，使用ascii码，获取word字母减去97即可得到对应在摩斯数组中的位置
```java
class Solution {
    public int uniqueMorseRepresentations(String[] words) {
        int baseIndex = 97;
        Set<String> set = new HashSet<>();
        for (String word : words) {
        	int lenght = word.length();
        	StringBuilder sb = new StringBuilder();
			for (int i = 0; i < lenght; i++) {
				sb.append(morse[word.charAt(i) - baseIndex]);
			}
			set.add(sb.toString());
		}
        return set.size();
    }
    
    String[] morse = {
        ".-","-...","-.-.","-..",".","..-.","--.","....","..",".---","-.-",".-..","--","-.","---",".--.","--.-",".-.","...","-","..-","...-",".--","-..-","-.--","--.."
    };
}
```

# 数组

转换二进制字符: `String x = Integer.toBinaryString(x);`

长度判断:`String.lengeth(); char.length;`

* length用于计算字符串数组，length()用于字符长度

## 905. 按奇偶排序数组

### 基本思路

遍历数组，偶数正向赋值给新数组，奇数反向赋值给新数组。

```java
class Solution {
    public int[] sortArrayByParity(int[] A) {
        int[] doub = new int[A.length];
        int d = 0;
        int l = A.length - 1;
                    
        for(int i=0 ; i<A.length; i++){

            if(A[i] % 2 == 0){
                doub[d] = A[i];
                d++;
            }
            else{
                doub[l] = A[i];
                l--;
            }
            
        }
        return doub;
    }
}
```

### 改进

基本的方法开辟了额外空间，不开辟新空间可以遍历数组，找到第一个奇数后就从当前位置搜索下一个偶数，并交换。不过效率不一定高。

```python
class Solution:
    def sortArrayByParityII(self, A):
        """
        :type A: List[int]
        :rtype: List[int]
        """
        A_len, i, j = len(A), 0, 1
        while i < A_len:
            if A[i] % 2 == 1:
                while A[j] % 2 == 1:
                    j += 2
                
                A[i], A[j] = A[j], A[i]

            i += 2

        return A
```

## 832. 翻转图像

### 基本思路

1. 获取数列行列
2. 固定行进行反转和取反
3. 遍历列

```java
class Solution {
    public int[][] flipAndInvertImage(int[][] A) {
        int lineLen = A.length;
        int columnLen = A[0].length;        
        int picture [][] = new int[lineLen][columnLen];
        
        
        for (int i=0; i < lineLen; i++){
            int copy = columnLen - 1;
            for(int j=0; j < columnLen; j++){
                picture[i][j] = A[i][copy];
                copy--;
                notA(picture, i, j);
            }
        }
        return picture;
    }

    public void notA(int[][] A,int x,int y){
            if(A[x][y] ==0){
                A[x][y] =1;
            }else{A[x][y] =0;}
    }    
}
```

### 改进

每行的取反和头尾交换其实不需要遍历整个数组，只需要一个临时数去存储头，然后把头尾交换取反即可，交换到中间就整行交换结束。

```java
class Solution {
    public int[][] flipAndInvertImage(int[][] A) {
        for(int i =0;i<A.length;i++){
            int temp;
            int front = 0;
            int end = A[i].length-1;
            while(front <=end ){ //一行的交换取反
                temp = A[i][front]; //头存在临时里面
                A[i][front] = 1-A[i][end]; //头等于尾且取反
                A[i][end] = 1-temp; //临时取反
                front ++;
                end --;
            }
        }
        return A;
    }
}
```

## 461. 汉明距离

### 基本思路

1. x与y转换成2进制，并且补位成等长
2. 遍历比较每一位，累计不同

```java
class Solution {
    public int hammingDistance(int x, int y) {
        String xTwo = Integer.toBinaryString(x);
        String yTwo = Integer.toBinaryString(y);
        int xlength = xTwo.length();
        int ylength = yTwo.length();
        
        if(xlength < ylength){                        
            for(int i=0;i < ylength - xlength;i++)
                xTwo = "0"+xTwo;                  
        }
        else{
            for(int i=0;i < xlength - ylength;i++)
                yTwo = "0"+yTwo;     
        }
        
        char[] xc = xTwo.toCharArray();
        char[] yc = yTwo.toCharArray();
        //System.out.printf("%s, %s", xTwo, yTwo);
        int count = 0;
        for(int i=0; i<xc.length; i++){
            if(xc[i] != yc[i]){
                count++;
            }
        }
        return count;
    }
}
```

### 改进

1. 主要核心是异或(^),相同为0，不同为1；
2. 统计异或以后为1的位；

```java
class Solution {
    public int hammingDistance(int x, int y) {
        int i = x ^ y;
        int c = 0;
        while(i > 0){
            // 最后一位是否为1
            if((i & 1) == 1){//位与运算，都为1为1
                c ++;
            }
            i = i >> 1;
        }
        return c;
    }
}
```