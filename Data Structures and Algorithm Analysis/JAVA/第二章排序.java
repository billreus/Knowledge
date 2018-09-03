//排序算法类的模版
public class Example
{
    public static void sort(Comparable[] a)
    
    private static boolean less(Comparable v, Comparable w)
    { return v.compareTo(w) < 0 }

    private static void exch(Comparable[] a, int i, int j)
    { Comparable t = a[i]; a[i] = a[j]; a[j] = t; }

    private static void show(Comparable[] a)
    {
        for (int i = 0; i < a.length; i++)
            StdOut.print(a[i] + " ");
        StdOut.println();
    }

    public static boolean isSorted(Comparable[] a)
    {
        for (int i = 1; i < a.length; i++)
            if (less(a[i], a[i-1])) return false;
        return true;
    }

    public static void main(String[] args)
    {
        String[] a = In.readStrings();
        sort(a);
        assert isSorted(a);
        show(a);
    }
}

// 算法2.1 选择排序
public class Selection
{
    public static void sort(Comparable[] a)
    {
        int N = a.length;
        for (int i = 0; i < N; i++)
        {
            int min = i;
            for (int j = i+1; j < N; j++)
                if (less(a[j], a[min])) min = j; //less 比较大小，前者小返回True
            exch(a, i, min);  //把min的值赋值给i，等价于选取了排序的数放到该位置
        }
    }
}

//算法2.2 插入排序
public class Insertion
{
    public static void sort(Comparable[] a)
    {
        int N = a.length;
        for (int i =1; i < N; i++) //从a[1]开始比较
        {   // 如果a[i]比左边小，交换，然后继续和左边比较，比较到比左边大就停止，开始i+1的索引
            for (int j = i; j > 0 && less(a[j], a[j-1]); j--)
                exch(a, j, j-1);
        }
    }
}

//算法2.3 希尔排序
public class Shell
{
    public static void sort(Comparable[] a)
    {
        int N = a.length;
        int h = 1;
        while (h < N/3) h = 3*h + 1; //给h的间隔赋值，在吃采用1,4,13,40....h从高到底运算
        while (h >= 1) 
        {
            for (int i = h; i < N; i++) //一个h间隔的排序
            {//从h往右索引，与j-h,j-2h....对比
                for (int j = i; j >= h && less(a[j], a[j-h]); j -= h)
                    exch(a, j, j-h);
            }    
            h = h/3;
        }
    }
}

//原地归并的抽象方法
public static void merge(Comparable[] a, int lo, int mid, int hi)
{//将a[lo..mid]和a[mid+1..hi]归并
    //k为原始数组a的序列，i和j为复制序列aux的左右半边序列
    int i = lo, j = mid+1;

    //a数组复制到aux
    for (int k = lo; k<= hi; k++)
        aux[k] = a[k];

    for (int k = lo; k <= hi; k++)
        if (i > mid)                    a[k] = aux[j++]; //左半边用尽，取右边
        else if (j > hi)                a[k] = aux[i++]; //右半边用尽，取左边
        else if (less(aux[j], aux[i]))  a[k] = aux[j++]; //右半边当前值小于左边，取右边
        else                            a[k] = aux[i++]; //右半边当前值大于左边，取左边
}

//算法2.4 自顶向下的排序
public class Merge
{
    private static Comparable[] aux;

    public static void sort(Comparable[] a)
    {
        aux = new Comparable[a.length];
        sort(a, 0, a.length-1);
    }

    private static void sort(Comparable[] a, int lo, int hi)
    {
        if(hi <= lo) return;
        int mid = lo + (hi - lo)/2;
        sort(a, lo, mid);  //排序左半边，不断重复调用切分到(a,0,1)
        sort(a, mid+1, hi); //排序右半边
        merge(a, lo, mid, hi); //合并排序
    }
}

//算法2.5 自底向上的排序
public class MergeBU
{
    private static Comparable[] aux;

    public static void sort(Comparable[] a)
    {
        int N = a.length;

        aux = new Comparable[N];
        for (int sz = 1; sz < N; sz = sz + sz)
            for (int lo = 0; lo < N-sz; lo += sz + sz)
                merge(a, lo, lo+sz-1, Math.min(lo+sz+sz-1, N-1));
    }
}