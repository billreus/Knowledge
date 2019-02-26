<!-- TOC -->

- [字符串](#字符串)
    - [StringBuffer](#stringbuffer)
- [list](#list)
    - [ArrayList](#arraylist)
    - [Stack](#stack)
- [数据结构类](#数据结构类)
    - [LinkedList](#linkedlist)
        - [3.从头到尾打印链表](#3从头到尾打印链表)
    - [Tree](#tree)
        - [4.重建二叉树](#4重建二叉树)
    - [Stack & Queue](#stack--queue)
        - [5.用两个栈实现队列](#5用两个栈实现队列)
- [算法类](#算法类)
    - [斐波那契数列](#斐波那契数列)
        - [7.斐波那契数列](#7斐波那契数列)
        - [8.跳格子](#8跳格子)
    - [9.变态跳台阶](#9变态跳台阶)
    - [搜索算法](#搜索算法)
        - [1. 二维数组中的查找](#1-二维数组中的查找)
        - [6.旋转数组的最小数字](#6旋转数组的最小数字)
    - [其它算法](#其它算法)
        - [2.替换空格](#2替换空格)

<!-- /TOC -->

# 字符串

## StringBuffer

* appen():连接，添加
* insert():添加
* reverse():反转
* replace(start, end, words):替换
* substring(start, end):截取
* delete(start, end):删除
* indexOf(words, start):查找

# list

## ArrayList

* add():添加

## Stack

* push()：入栈
* pop():弹栈
* peek():栈顶
* empty():是否为空

# 数据结构类

## LinkedList

### 3.从头到尾打印链表

使用栈

```java
import java.util.Stack;
import java.util.ArrayList;
public class Solution {
    public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
        Stack<Integer> list = new Stack<Integer>();
        ArrayList<Integer> res = new ArrayList<>();
        while(listNode != null){
            list.push(listNode.val);
            listNode=listNode.next;
        }
        while(!list.isEmpty()){
            res.add(list.pop());
        }
        return res;
    }
}
```

使用递归

```java
import java.util.ArrayList;
public class Solution {
    public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
        ArrayList<Integer> list = new ArrayList<Integer>();
        ListNode preNode = listNode;
        if(preNode != null) {
            if(preNode.next != null){
                list = printListFromTailToHead(preNode.next);
            }
            list.add(preNode.val);
        }
        return list;
    }
}
```

## Tree

### 4.重建二叉树

前序遍历用于判断每个主节点，中序遍历用于判断左右个数

```java
public class Solution {
    public TreeNode reConstructBinaryTree(int [] pre,int [] in) {
        if(pre == null || in == null || pre.length != in.length) return null;
        return construct(pre, 0, in, 0, in.length-1);
    }
    private TreeNode construct(int[] pre,int preStart,int preEnd, int[] in, int inStart, int inEnd){
        if(inStart>inEnd || preStart>preEnd) return null;//空节点
        TreeNode root = new TreeNode(pre[preStart]);
        for(int i=inStart; i<=inEnd; i++){
            if(pre[preStart] == in[i]){
                root.left = construct(pre, preStart+1, preStart+i-inStart, in, inStart, i-1);
                root.right = construct(pre, preStart+1+i-inStart, preEnd, in, i+1, inEnd);
                break;
            }
        }
        return root;
    }
}
```

## Stack & Queue

### 5.用两个栈实现队列

入队：将元素进栈A

出队：判断栈B是否为空，如果为空，则将栈A中所有元素pop，并push进栈B，栈B出栈；

```java
public class Solution {
    Stack<Integer> stack1 = new Stack<Integer>();
    Stack<Integer> stack2 = new Stack<Integer>();
    
    public void push(int node) {
        stack1.push(node);
    }
    
    public int pop() {
        int val;
        if(stack2.empty()){
            while(!stack1.empty()){
                val = stack1.peek();
                stack1.pop();
                stack2.push(val);
            }
        }
        return stack2.pop();
    }
}
```

# 算法类

## 斐波那契数列

### 7.斐波那契数列

```java
public class Solution {
    public int Fibonacci(int n) {
        int res=0;
        int pre=1;
        int prepre=0;
        if(n==0) return 0;
        if(n==1) return 1;
        for(int i=2;i<=n;i++){
            res = pre + prepre;
            prepre = pre;
            pre = res; 
        }
        return res;
    }
}
```

### 8.跳格子

a.如果两种跳法，1阶或者2阶，那么假定第一次跳的是一阶，那么剩下的是n-1个台阶，跳法是f(n-1);

b.假定第一次跳的是2阶，那么剩下的是n-2个台阶，跳法是f(n-2)

c.由a\b假设可以得出总跳法为: f(n) = f(n-1) + f(n-2) 

d.然后通过实际的情况可以得出：只有一阶的时候 f(1) = 1 ,只有两阶的时候可以有 f(2) = 2

e.可以发现最终得出的是一个斐波那契数列：

           | 1, (n=1)

f(n) =     | 2, (n=2)

           | f(n-1)+f(n-2) ,(n>2,n为整数)

```java
public class Solution {
    public int JumpFloor(int target) {
        if(target ==0) return 0;
        else if(target == 1) return 1;
        else if(target == 2) return 2;
        else return JumpFloor(target - 1)+JumpFloor(target - 2);
    }
}
```

## 9.变态跳台阶

1）这里的f(n) 代表的是n个台阶有一次1,2,...n阶的 跳法数。

2）n = 1时，只有1种跳法，f(1) = 1

3) n = 2时，会有两个跳得方式，一次1阶或者2阶，这回归到了问题（1） ，f(2) = f(2-1) + f(2-2) 

4) n = 3时，会有三种跳得方式，1阶、2阶、3阶，

    那么就是第一次跳出1阶后面剩下：f(3-1);第一次跳出2阶，剩下f(3-2)；第一次3阶，那么剩下f(3-3)

    因此结论是f(3) = f(3-1)+f(3-2)+f(3-3)

5) n = n时，会有n中跳的方式，1阶、2阶...n阶，得出结论：

    f(n) = f(n-1)+f(n-2)+...+f(n-(n-1)) + f(n-n) => f(0) + f(1) + f(2) + f(3) + ... + f(n-1)
    
6) 由以上已经是一种结论，但是为了简单，我们可以继续简化：

    f(n-1) = f(0) + f(1)+f(2)+f(3) + ... + f((n-1)-1) = f(0) + f(1) + f(2) + f(3) + ... + f(n-2)

    f(n) = f(0) + f(1) + f(2) + f(3) + ... + f(n-2) + f(n-1) = f(n-1) + f(n-1)

    可以得出：

    f(n) = 2*f(n-1)

7) 得出最终结论,在n阶台阶，一次有1、2、...n阶的跳的方式时，总得跳法为：

              | 1       ,(n=0 ) 

f(n) =        | 1       ,(n=1 )

              | 2*f(n-1),(n>=2)

```java
public class Solution {
    public int JumpFloorII(int target) {
        if(target == 0) return 1;
        if(target == 1) return 1;
        return 2*JumpFloorII(target-1);
    }
}
```

## 搜索算法

### 1. 二维数组中的查找

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
### 6.旋转数组的最小数字

二分查找

```java
public static int minNumberInRotateArray(int[] array) {
        if (array.length == 0)
            return 0;
        int left = 0;
        int right = array.length - 1;
        int middle = -1;
        while (array[left]>=array[right]) {
            if(right-left==1){
                middle = right;
                break;
            }
            middle = left + (right - left) / 2;
            if (array[middle] >= array[left]) {
                left = middle;
            }
            if (array[middle] <= array[right]) {
                right = middle;
            }
        }
        return array[middle];
    }

```

## 其它算法

### 2.替换空格

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



