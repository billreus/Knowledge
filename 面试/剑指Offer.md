<!-- TOC -->

- [字符串](#%E5%AD%97%E7%AC%A6%E4%B8%B2)
  - [StringBuffer](#stringbuffer)
- [list](#list)
  - [ArrayList](#arraylist)
  - [Stack](#stack)
- [数据结构类](#%E6%95%B0%E6%8D%AE%E7%BB%93%E6%9E%84%E7%B1%BB)
  - [LinkedList](#linkedlist)
    - [3.从头到尾打印链表](#3%E4%BB%8E%E5%A4%B4%E5%88%B0%E5%B0%BE%E6%89%93%E5%8D%B0%E9%93%BE%E8%A1%A8)
  - [Tree](#tree)
    - [4.重建二叉树](#4%E9%87%8D%E5%BB%BA%E4%BA%8C%E5%8F%89%E6%A0%91)
  - [Stack & Queue](#stack--queue)
    - [5.用两个栈实现队列](#5%E7%94%A8%E4%B8%A4%E4%B8%AA%E6%A0%88%E5%AE%9E%E7%8E%B0%E9%98%9F%E5%88%97)
- [算法类](#%E7%AE%97%E6%B3%95%E7%B1%BB)
  - [搜索算法](#%E6%90%9C%E7%B4%A2%E7%AE%97%E6%B3%95)
    - [1. 二维数组中的查找](#1-%E4%BA%8C%E7%BB%B4%E6%95%B0%E7%BB%84%E4%B8%AD%E7%9A%84%E6%9F%A5%E6%89%BE)
  - [其它算法](#%E5%85%B6%E5%AE%83%E7%AE%97%E6%B3%95)
    - [2.替换空格](#2%E6%9B%BF%E6%8D%A2%E7%A9%BA%E6%A0%BC)

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



