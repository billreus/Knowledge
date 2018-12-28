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
    - [657. 机器人是否返回原点](#657-机器人是否返回原点)
    - [344. 反转字符串](#344-反转字符串)
        - [基本思路](#基本思路-1)
        - [改进](#改进-3)
    - [944. 删列造序](#944-删列造序)
    - [500. 键盘行](#500-键盘行)
        - [基本思路](#基本思路-2)
        - [改进](#改进-4)
- [数组](#数组)
    - [905. 按奇偶排序数组](#905-按奇偶排序数组)
        - [基本思路](#基本思路-3)
        - [改进](#改进-5)
    - [832. 翻转图像](#832-翻转图像)
        - [基本思路](#基本思路-4)
        - [改进](#改进-6)
    - [461. 汉明距离](#461-汉明距离)
        - [基本思路](#基本思路-5)
        - [改进](#改进-7)
    - [942. 增减字符串匹配](#942-增减字符串匹配)
        - [思路](#思路)
    - [922.按奇偶排序数组II](#922按奇偶排序数组ii)
        - [思路](#思路-1)
        - [改进](#改进-8)
    - [852. 山脉数组的峰顶索引](#852-山脉数组的峰顶索引)
        - [基本思路](#基本思路-6)
        - [改进](#改进-9)
    - [961. 重复N次元素](#961-重复n次元素)
        - [基本思路](#基本思路-7)
        - [改进](#改进-10)
    - [476. 数字的补救](#476-数字的补救)
    - [728. 自然数](#728-自然数)
- [二叉树](#二叉树)
    - [104. 二叉树的最大深度](#104-二叉树的最大深度)
    - [617. 合并二叉树](#617-合并二叉树)
        - [基本思路](#基本思路-8)
        - [改进](#改进-11)
    - [226. 翻转二叉树](#226-翻转二叉树)
    - [590. N叉树的后序遍历](#590-n叉树的后序遍历)
        - [基本思路](#基本思路-9)
        - [改进](#改进-12)
    - [589. N叉树的前序遍历](#589-n叉树的前序遍历)
- [链表](#链表)
    - [237. 删除链表中的节点](#237-删除链表中的节点)
- [智力题](#智力题)
    - [292. Nim游戏](#292-nim游戏)

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

## 657. 机器人是否返回原点

```java
class Solution {
    public boolean judgeCircle(String moves) {
        char[] mmoves = moves.toCharArray();
        int heng =0;
        int shu = 0;
        
        for(char move:mmoves){
            if(move == 'R'){heng++;}
            if(move == 'L'){heng--;}
            if(move == 'U'){shu++;}
            if(move == 'D'){shu--;}
        }
        if(heng == 0 && shu == 0){return true;}
        else{return false;}
    }
}
```

## 344. 反转字符串

### 基本思路

转换成char型反向存储

```java
class Solution {
    public String reverseString(String s) {
        char[] res = new char[s.length()];
        char[] ss = s.toCharArray();
        int i =s.length()-1;
        for(char cs : ss){
            res[i] = cs;
            i--;
        }
        return String.valueOf(res);
    }
}
```

### 改进

在原字符串上进行头尾互换即可

```java
class Solution {
    public String reverseString(String s) {
            char[] c = s.toCharArray();
            for(int i=0;i<s.length()/2;i++){
                char temp = c[i];
                c[i] = c[s.length()-1-i];
                c[s.length()-1-i] = temp;
            }
            return String.valueOf(c);
        }
}
```

## 944. 删列造序

```java
class Solution {
    public int minDeletionSize(String[] A) {
        if(A == null || A.length == 0) return 0;
        int count = 0;
        for(int i=0; i<A[0].length(); i++){
            for(int j=0; j<A.length-1; j++){
                if(A[j].charAt(i) > A[j+1].charAt(i)){
                    count++;
                    break;
                }
            }
            
        }
        return count;
    }
}
```

## 500. 键盘行

### 基本思路

1. 创建三个字符串用于存储三行字符
2. 遍历输入的字符
3. 以头字符作为依据，遍历每个字符的字母判断是否包含在该行，不再直接跳出
4. 最后把结果list转换成string

```java
class Solution {
    public String[] findWords(String[] words) {
        String s1 = "qwertyuiop";
        String s2 = "asdfghjkl";
        String s3 = "zxcvbnm";
        String tmp = s1;       
         List<String> list = new ArrayList<String>();
        for(String s : words){
            String ss = s.toLowerCase();
            char c = ss.charAt(0);
            if(s1.contains(c+"")){
                tmp = s1;
            }
            else if(s2.contains(c+"")){
                tmp = s2;
            }
            else if(s3.contains(c+"")){
                tmp = s3;
            }
            list.add(s);
            for(char cs : ss.toCharArray()){
                if(!tmp.contains(cs+"")){
                    list.remove(s);
                    break;
                }
            }
        } 
        String[] result = new String[list.size()];
        return list.toArray(result);
    }
}
```

### 改进

不用头字符作为依据，而是在遍历字符时以目标不在三行中的false作为判断，满足三行true条件才加入到list中

```java
class Solution {
    public String[] findWords(String[] words) {
        String s1 = "qwertyuiop";
        String s2 = "asdfghjkl";
        String s3 = "zxcvbnm";
        List<String> list = new LinkedList<>();
        for(int i = 0; i < words.length; i ++) {
            String s4 = words[i].toLowerCase();
            Boolean flag1 = true, flag2 = true, flag3 = true;    
            for(int j = 0; j < words[i].length(); j ++) {
                if(s1.indexOf(s4.charAt(j)) == -1) {
                    flag1 = false;
                }
                if(s2.indexOf(s4.charAt(j)) == -1) {
                    flag2 = false;
                }
                if(s3.indexOf(s4.charAt(j)) == -1) {
                    flag3 = false;
                }
            }
            if(flag1 == true || flag2 == true || flag3 == true) {
                list.add(words[i]);
            }
        }
        String[] res = new String[list.size()];
        for(int i = 0; i < list.size(); i ++) {
            res[i] = list.get(i);
        }
        return res;
    }
}
```

# 数组

转换二进制字符: `String x = Integer.toBinaryString(x);`

长度判断:`String.lengeth(); char.length;`

* length用于计算字符串数组，length()用于字符长度

二进制数最左边的最高位，且高位后面全部补零：`Integer.highestOneBit(num) `

&位与运算，0可以清零，1可以保护

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

## 942. 增减字符串匹配

### 思路

读到I从小到达排列，读到D从大到小排列

```java
class Solution {
    public int[] diStringMatch(String S) {
        int N = S.length();
        char[] ss = S.toCharArray();
        int min = 0;
        int max = S.length();
        int[] result = new int[N+1];
        
        for(int i=0; i < N ; i++){
            if(ss[i] == 'I'){
                result[i] = min;
                min++;
            }
            if(ss[i] == 'D'){
                result[i] = max;
                max--;
            }
        }
        result[N] = max;
        return result;
    }
}
```

## 922.按奇偶排序数组II

### 思路

创建一个新数组存储，从A判断来的奇偶数

```java
class Solution {
    public int[] sortArrayByParityII(int[] A) {
        int ou = 0;
        int ji = 1;
        int[] B = new int[A.length];
        
        for(int i = 0; i < A.length; i++){
            if(A[i]%2 == 0){
                B[ou] = A[i];
                ou = ou + 2;
            }
            else{
                B[ji] = A[i];
                ji = ji + 2;
            }
        }
        return B;
    }
}
```

### 改进

对于`if(A[i]%2 == 0)`优化成`if(A[i] & 1 == 0)`

## 852. 山脉数组的峰顶索引

### 基本思路

遍历找到最大值

```java
class Solution {
    public int peakIndexInMountainArray(int[] A) {
        int max = A[0];
        int index = 0;
        
        for(int i=1;  i<A.length; i++){
            if(A[i] > A[index]){
                max = A[i];
                index = i;
            }
        }
        return index;
    }
}
```

### 改进

二分法

```java
class Solution {
    public int peakIndexInMountainArray(int[] A) {
        return mountainIndex(A,0,A.length - 1);
    }
    
    public static int mountainIndex(int[] A,int l,int r) {
            int mid = l + (r - l) / 2;
            if(A[mid] > A[mid - 1] && A[mid] > A[mid + 1])
                return mid;
            else if(A[mid] < A[mid + 1])
                return mountainIndex(A,mid+1,r);
            else
                return mountainIndex(A,l,mid);
        
    }
}
```

## 961. 重复N次元素

### 基本思路

1. 对A进行排序，遍历A
2. 记录重复次数，满足一半就返回；不满足就重置计数

```java
class Solution {
    public int repeatedNTimes(int[] A) {
        Arrays.sort(A);
        int ret = A[0];
        int num = 0;
        
        for(int i=0; i < A.length; i++){
            if(A[i] != ret){
                ret = A[i];
                num = 1;
            }
            else{
                num++;
                if(num == A.length/2){
                    return ret;
                }
            }
        }
        return ret;
    }
}
```

### 改进

最快速度是使用set，长度为A/2+1，当无法存储时即此为结果

```java
class Solution {
    public int repeatedNTimes(int[] A) {
        Set<Integer> set = new HashSet<>(A.length / 2 + 1);
        for (int i : A) {
            if (!set.add(i)) {
                return i;
            }
        }
        return 0;
    }
}
```

由于有一半数肯定是相同的，只需要排序后判断最后一个数和中间右是否相同，如果相同则后一半都为答案数，如果不同则中间左边一位肯定是。

```java
public int repeatedNTimes(int[] A) {
    Arrays.sort(A);
    return A[A.length / 2] == A[A.length - 1] ? A[A.length - 1] : A[A.length / 2 - 1];
}
```

* 此方法速度最慢，只是简洁。

## 476. 数字的补救

主要注意取反头有补码表示正负

1. highestOneBit(num)最高为置1,-1以后首位为0其它为1。
2. &保证补码为0不干扰数字

```java
class Solution {
    public int findComplement(int num) {
        return ~num&(Integer.highestOneBit(num)-1);
    }
}
```

## 728. 自然数

使用/=10迭代来实现移位，使用%10来取右边最后一位。

```java
class Solution {
    public List<Integer> selfDividingNumbers(int left, int right) {
        List<Integer> res = new ArrayList<>();
        for(int i = left; i <= right; i++){
            if(check(i)) res.add(i);
        }
        return res;
    }
    
    private boolean check(int n){
        int d =n;
        while(d != 0){
            int test = d % 10;
            if(test == 0 || (n % test) != 0) {return false;}
            d /= 10;
        }
        return true;
    }
}
```

# 二叉树

存放不确定长度数组：`List<Integer> list = new ArrayList<Integer>();`

数组增加：`list.add()`

栈操作:`pop(), isEmpty(), push(), peek()`

## 104. 二叉树的最大深度

递归遍历

```java
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public int maxDepth(TreeNode root) {
        return root == null ? 0 : (1+ Math.max(maxDepth(root.left), maxDepth(root.right)));
    }
}
```

## 617. 合并二叉树

### 基本思路

1. 判断t1和t2是否为空，给val赋值并赋值
2. 分别递归t1,t2左节点和t1,t2右节点

```java
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
        TreeNode newtree = null;
        int val = 0;
        
        if(t1 != null && t2 != null){
            val = t1.val + t2.val;
            newtree = new TreeNode(val);
            
            newtree.left = mergeTrees(t1.left, t2.left);
            newtree.right = mergeTrees(t1.right, t2.right);
        } else if( t1 != null){
            newtree = new TreeNode(t1.val);
            
            newtree.left = mergeTrees(t1.left, null);
            newtree.right = mergeTrees(t1.right, null);
        }else if( t2 != null){
            newtree = new TreeNode(t2.val);
            
            newtree.left = mergeTrees(null, t2.left);
            newtree.right = mergeTrees(null, t2.right);
        }else{
            newtree = null;
        }
        return newtree;
    }
}
```

### 改进

无需新建一个树去存放结果，在t1上操作合并递归即可

```java
class Solution {
    public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
        if (t1 == null) {
            return t2;
        }
        if (t2 == null) {
            return t1;
        }
        // 节点的值合并
        t1.val = t1.val + t2.val;
        // 继续
        t1.left =  mergeTrees(t1.left, t2 != null ? t2.left : null);
        t1.right = mergeTrees(t1.right, t2 != null ? t2.right : null);
        return t1;
    }
}
```

## 226. 翻转二叉树

左右置换，递归左右节点

```java
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public TreeNode invertTree(TreeNode root) {
         if (root != null) {
            TreeNode tmpNode = root.left;
            root.left = root.right;
            root.right = tmpNode;
            invertTree(root.left);
            invertTree(root.right);
        }
        return root;
    }
}
```

## 590. N叉树的后序遍历


### 基本思路

建立两个Stack，一个用于把每层放入，再每层弹出给下一个stack和把root交给子节点。下一个stack用于把值传递给list。

```java
/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val,List<Node> _children) {
        val = _val;
        children = _children;
    }
};
*/
class Solution {
    public List<Integer> postorder(Node root) {
        List<Integer> list = new ArrayList<Integer>();
        
        if(root == null) return list;
        if(root.children == null){
            list.add(root.val);
            return list;
        }
        
        Stack<Node> stack = new Stack<Node>();
        Stack<Node> restack = new Stack<Node>();
        stack.push(root);
        while(!stack.isEmpty()){
            root = stack.pop();
            restack.push(root);
            for(int i=0; i<root.children.size(); i++){
                stack.push(root.children.get(i));
            }
        }
        
        while(!restack.isEmpty()){
            list.add(restack.pop().val);
        }
        return list;
    }
}

```

### 改进

递归思想，遍历root.children并作为node递归。

```java
class Solution {
    List<Integer> list = new ArrayList();

    public List<Integer> postorder(Node root) {
        if (root != null) {
            for (Node node : root.children) {
                postorder(node);
            }
            list.add(root.val);
        }
        return list;
    }
}
```

## 589. N叉树的前序遍历

与后序方法类似，只需要更改list添加数的位置。

```java
class Solution {

    List<Integer> list = new ArrayList();

    public List<Integer> preorder(Node root) {
        if (root != null) {
            list.add(root.val);
            for (Node node : root.children) {
                preorder(node);
            }
        }
        return list;
    }
}
```

# 链表

## 237. 删除链表中的节点

由于不删除结尾节点，所以只需要把删除节点的值和指向用下一个值替代即可

```java
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public void deleteNode(ListNode node) {
        node.val = node.next.val;
        node.next = node.next.next;
    }
}
```

# 智力题

## 292. Nim游戏

巴什博奕，n%(m+1)!=0时，先手总是会赢

```java
class Solution {
    public boolean canWinNim(int n) {
        return n%4!=0;
    }
}
```

