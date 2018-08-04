class Node(object):
    def __init__(self, value=None, next=None):
        self.value = value
        self.next = next
    
    def __str__(self):
        """方便你打出来调试，复杂的代码可能需要断点调试"""
        return '<Node: value: {}, next={}>'.format(self.value, self.next)
    
    __repr__=__str__


class LinkedList(object):
    def __init__(self, maxsize=None):
        self.maxsize = maxsize  # 默认None，无限扩充
        self.root = Node() # 默认root节点指向None
        self.tailnode = None
        self.length = 0
    
    def __len__(self):
        return self.length
    
    def append(self, value):
        if self.maxsize is not None and len(self) >= self.maxsize:
            raise Exception('LinkedList is Full')
        node = Node(value)
        tailnode = self.tailnode
        if tailnode is None:
            self.root.next = node
        else:
            tailnode.next = node
        self.tailnode = node
        self.length += 1

    def appendleft(self, value):
        if self.maxsize is not None and len(self) >= self.maxsize:
            raise Exception('LinkedList is Full')
        headnode = self.root.next
        node = Node(value)
        self.root.next = node
        node.next = headnode
        self.length += 1