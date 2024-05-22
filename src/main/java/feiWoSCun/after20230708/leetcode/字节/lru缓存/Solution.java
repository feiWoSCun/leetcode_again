package feiWoSCun.after20230708.leetcode.字节.lru缓存;

import java.util.HashMap;
import java.util.Map;

/**
 * @description:
 * @author: feiWoSCun
 * @Time: 2023/12/5
 * @Email: 2825097536@qq.com
 */
public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        LRUCache cache=new LRUCache(1);
        cache.put(2,1);
        System.out.println(cache.get(2));
    }

}

class LRUCache {
    class Node {
        int val;
        int value;
        private Node next;
        private Node pre;

        public Node(int val) {
            this.val = val;
        }

        public Node() {
        }

        public Node(int val, int value) {
            this.val = val;
            this.value = value;
        }
    }

    private int capacity;

    private Node head;
    private Node tail;
    private Map<Integer, Node> cache = new HashMap<>(16);
   private int nowSize;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        head = new Node();
        tail = new Node();
        head.next = tail;
        tail.pre = head;
    }

    /**
     * 获取节点
     *
     * @param key
     * @return
     */
    public int get(int key) {
        if (cache.containsKey(key)) {
            Node node = cache.get(key);
            moveToHead(node);
            return node.value;
        } else {
            return -1;
        }
    }
    public void put(int key, int value) {
        if (nowSize == capacity) {
            removeTail();
        }
        //添加元素
        Node cache = this.cache.get(key);
        if (cache == null) {
            Node node = new Node(key, value);
            addNodeToHead(node);
            this.cache.put(key, node);
            nowSize++;
        } else {
            modifyValue(cache, value);
        }
    }

    private void modifyValue(Node node, int val) {
        Node temp = cache.get(node.val);
        temp.value = val;
    }

    /**
     * 删除节点
     *
     * @param node
     */
    private void remove(Node node) {
        Node pre = node.pre;
        Node next = node.next;
        pre.next = next;
        next.pre = pre;
        cache.remove(node.val);
        nowSize--;
    }

    private void removeTail() {
        Node pre = tail.pre;
        remove(pre);
    }

    /**
     * 添加元素到尾部
     *
     * @param node
     */
    private void addNodeToHead(Node node) {
        Node temp = head.next;
        node.next =temp ;
        temp.pre=node;
        head.next=node;
        node.pre=head;
    }

    private void moveToHead(Node node) {
        remove(node);
        addNodeToHead(node);
        nowSize++;
    }
}