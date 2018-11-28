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

//自底向上的排序
public class MergeBU
{
    private static Comparable[] aux;

    public static void sort(Comparable[] a)
    {
        int N = a.length;

        aux = new Comparable[N];
        for (int sz = 1; sz < N; sz = sz + sz)//sz子数组大小1,2,4,8....
            for (int lo = 0; lo < N-sz; lo += sz + sz)//子数组索引
                merge(a, lo, lo+sz-1, Math.min(lo+sz+sz-1, N-1));
    }
}

//快速排序的切分
private static int partition 
{
    int i = lo, j = hi + 1;
    Comparable v = a[lo];
    while(ture)
    {
        while(less(a[++i], v)) if(i == hi) break;
        while(less(v, a[--j])) if(j == lo) break;
        if(i >= j) break;
        exch(a, i, j);
    }    
    exch(a, lo, j);
    return j;
}


//算法2.5 快速排序
public class Quick
{
    public static void sort(Comparable[] a)
    {
        StdRandom.shuffle(a);// 消除对输入的依赖（打乱数据）
        sort(a, 0, a.length - 1); 
    }

    private static void sort(Comparable[] a, int lo, int hi)
    {
        if(hi <= lo) return;
        int j = partition(a, lo, hi); //切分，本质是把每个数放到对应的位置
        sort(a, lo, j-1);//左半边
        sort(a, j+1, hi);//右半边
    }
}

//三向排序
public class Quick3way
{
    private static void sort(Comparable[] a, int lo, int hi)
    {
        if(hi <= lo) return;
        int lt = lo, i = lo+1, gt = hi;
        Comparable v = a[lo];
        while(i <= gt)
        {
            int cmp = a[i].compareTo(v); //a[i]与v比较，a[i]小返回1,大返回0；
            if(cmp < 0) exch(a, lt++, i++);
            else if (cmp > 0) exch(a, i, gt--);
            else i++;            
        }
        sort(a, lo, lt - 1);
        sort(a, gt+1, hi);
    }
}