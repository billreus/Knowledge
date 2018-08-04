/*-----链表-----*/
#ifndef _List_H

struct Node; //Node 结构体变量声明，就像int a 一样，Node是变量名 
typedef struct Node *PtrToNode; //typedef定义，定义新的类型，这种类型的名字叫做PtrToNode，它的类型是指向Node结构体的指针； 
typedef PtrToNode List; //定义一个链表，其存储的数据格式是Node结构体，名字是List。
typedef PtrToNode Position;//依旧是PtrToNode类型的指针，只不过换了个名字叫Position而已。 
typedef int ElementType;

List MakeEmpty(List L);
int IsEmpty(List L);
int IsLast(Position P, List L);
Position Find (ElementType X, List L);
void Delete(ElementType X, List L);
Position Header(List L);
Position First(List L);
Position Advance(Position P);
ElementType Retrieve(Position P);

#endif /* _List_H*/

struct Node
{
    ElementType Element;
    Position Next;
};
