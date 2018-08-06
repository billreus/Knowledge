#include <stdio.h>
#include <Part2_List.h>

/* 测试一个链表是否为空表 */

int
IsEmpty(List L)
{
    return L->Next == NULL;
}

/* 测试当前位置是否是链表的末尾函数 */

int
IsLast(Position P, List L)
{
    return P->Next == NULL;
}

/* 返回某个元素在表中的位置(Element指位置对应元素A)) */

Position
Find( ElementType X, List L)
{
    Position P;

    P = L->Next;
    while(P != NULL && P->Element != X)
        P = P->Next;
    
    return P;
}

/* 找出X的表元前驱元P */

Position
FindPrevious( ElementType X, List L)
{
    Position P;

    P = L;
    while( P->Next != NULL && P->Next->Element != X)
        P = P->Next;
    
    return P;
}

/* 删除表L中的某个元素X */

void
Delete(ElementType X, List L)
{
    Position P, TmpCell;

    P = FindPrevious(X, L); //X的前驱元为P

    if(!IsLast(P, L))
    {
        TmpCell = P->Next; //P->Next->Element = X 
        P->Next = TmpCell->Next;
        free(TmpCell);
    }
}

/* 链表中插入元素 */

void
Insert(ElementType X, List L, Position P)
{
    Position TmpCell;
    
    /* 分配新单元地址 */
    TmpCell = malloc( sizeof( struct Node ) );
    if( TmpCell == NULL )
        FatalError( "Out of space !!" );
    
    TmpCell->Element = X;
    TmpCell->Next = P->Next;
    P->Next = TmpCell;
}


/*-----多项式ADT-----*/

/*多项式初始化w为0*/
void
ZeroPolynomial( Polynomial Poly )
{
    int i;

    for( i = 0; i <= MaxDegree; i++ )
        Poly->CoeffArray[i] = 0;
    Poly->HighPower = 0;
}

/*两多项式相加*/
void
AddPolynomial( const Polynomial Poly1, const 
            Polynomial Poly2, Polynomial PolySum )
{
    int i;

    ZeroPolynomial( PolySum );
    PolySum->HighPower = Max( Poly1->HighPower,
                              Poly2->HighPower);//多项式的最高幂次
    
    for(i = PolySum->HighPower; i >= 0; i--)
        PolySum->CoeffArray[i] = Poly1->CoeffArray[i]
                                    + Poly2->CoeffArray[i]; //coeffarray多项式系数数组
}