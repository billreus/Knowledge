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