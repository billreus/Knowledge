<!-- TOC -->

- [字符串](#字符串)
    - [771. 宝石与石头](#771-宝石与石头)
        - [最初想法](#最初想法)
        - [改进](#改进)
    - [929. 独特的电子邮件](#929-独特的电子邮件)
        - [基本思路](#基本思路)
        - [改进](#改进-1)
    - [709. 转换成小写字母](#709-转换成小写字母)

<!-- /TOC -->

# 字符串

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