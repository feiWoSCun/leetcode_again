package feiWoSCun.after2024.lru.lru20240412;

/**
 * @description: 请你设计并实现一个满足  LRU (最近最少使用) 缓存 约束的数据结构。
 * 实现 LRUCache 类：
 * LRUCache(int capacity) 以 正整数 作为容量 capacity 初始化 LRU 缓存
 * int get(int key) 如果关键字 key 存在于缓存中，则返回关键字的值，否则返回 -1 。
 * void put(int key, int value) 如果关键字 key 已经存在，则变更其数据值 value ；
 * 如果不存在，则向缓存中插入该组 key-value 。如果插入操作导致关键字数量超过 capacity ，
 * 则应该 逐出 最久未使用的关键字。
 * 函数 get 和 put 必须以 O(1) 的平均时间复杂度运行。
 * @author: feiWoSCun
 * @Time: 2024/4/12
 * @Email: 2825097536@qq.com
 */
class LRUCache {
    public static void main(String[] args) {
        //["LRUCache","put","put","get","put","get","put","get","get","get"]
        //[[2],[1,1],[2,2],[1],[3,3],[2],[4,4],[1],[3],[4]]
        LRUCache lruCache = new LRUCache(2);
        lruCache.put(1, 1);
        lruCache.put(2, 2);
        lruCache.get(1);
        lruCache.put(3, 3);
        lruCache.get(2);
        lruCache.put(4, 4);
        lruCache.get(1);
        lruCache.get(3);
        lruCache.get(4);
    }

    LruLinkedList lruLinkedList;

    int capacity;

    public LRUCache(int capacity) {
        lruLinkedList = new LruLinkedList(capacity);
        this.capacity = capacity;
    }

    public int get(int key) {
        Node node = this.lruLinkedList.get(key);
        return node == null ? -1 : node.val;
    }

    public void put(int key, int value) {
        this.lruLinkedList.add(new Node(key, value));
    }
}
//使用链表，头节点是最近使用
//删除的是末尾的元素
//提供删除元素 del(ley)->node
//头节点添加元素
//长度限制，删除末尾元素del(last.key)

class LruLinkedList {
    int capacity;
    int size;
    Node last;
    Node first;

    public LruLinkedList(int capacity) {
        this.capacity = capacity;
    }

    public void add(Node node) {
        Node temp = this.get(node.key);
        if (temp != null) {
            temp.val = node.val;
            this.refresh(temp);
            return;
        }
        if (first == null && first == last) {
            first = node;
            last = node;
        } else {
            node.next = first;
            first.pre = node;
            first = node;
        }
        this.size++;
        //容量超出限制
        if (this.size > this.capacity) {
            this.del(this.last);
        }

    }

    public void del(Node node) {
        if (node.key == first.key && first == last) {
            first = last = null;
        } else if (node.key == first.key) {
            first = first.next;
            first.pre = null;
        } else if (node.key == last.key) {
            last = last.pre;
            last.next = null;
        } else {
            node.pre.next = node.next;
            node.next.pre = node.pre;
            node.pre = null;
            node.next = null;
        }
        this.size--;
    }

    public Node get(int k) {
        Node temp = first;
        while (temp != null) {
            if (temp.key == k) {
                break;
            }
            temp = temp.next;
        }
        if (temp == null) {
            return null;
        }
        refresh(temp);
        return temp;

    }

    private void refresh(Node temp) {
        this.del(temp);
        this.add(temp);
    }

}

class Node {
    int val;
    int key;
    Node next;
    Node pre;

    public Node(int key, int val) {
        this.key = key;
        this.val = val;
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */