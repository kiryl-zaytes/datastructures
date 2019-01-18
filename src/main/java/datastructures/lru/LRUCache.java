package datastructures.lru;

import java.util.HashMap;

/**
 * Created by kiryl_zayets on 1/8/19.
 */
public class LRUCache {

    class DNode{

        Integer key;
        Integer value;

        DNode prev = null;
        DNode next = null;
    }

    HashMap<Integer, DNode> cache;
    DNode head = null;
    DNode tail = null;
    int size = 0;
    int capacity = 0;

    public LRUCache(int capacity) {

        this.capacity = capacity;
        cache = new HashMap<>();
        head = new DNode();
        tail = new DNode();
        head.next = tail;
        head.prev = null;
        tail.next = null;
        tail.prev = head;

    }

    public int get(int key) {
        if (!cache.containsKey(key)) return -1;
        DNode node = cache.get(key);
        moveToHead(node);
        return node.value;
    }

    public void put(int key, int value) {

        if (cache.containsKey(key)){
            cache.get(key).value = value;
            moveToHead(cache.get(key));
        }

        else if (size >= capacity){
            DNode nodeToRemove = popLast();
            DNode node = new DNode();
            node.key = key;
            node.value = value;
            add(node);
            cache.put(key, node);
            cache.remove(nodeToRemove.key);
        }
        else {
            size++;
            DNode node = new DNode();
            node.key = key;
            node.value = value;
            add(node);
            cache.put(key, node);
        //   moveToHead(cache.get(key));
        }
    }


    private void moveToHead(DNode node){
        remove(node);
        add(node);
    }


    private void add(DNode node){
        node.next = head.next;
        node.prev = head;
        head.next.prev  = node;
        head.next = node;
    }

    private void remove(DNode node){

        DNode prev = node.prev;
        DNode next = node.next;

        prev.next = next;
        next.prev = prev;

        node.next = null;
        node.prev = null;
        node = null;
    }

    private DNode popLast(){
        DNode node = tail.prev;
        tail.prev = node.prev;
        node.prev.next = node.next;
        return node;
    }

    public static void main(String[] args){
        LRUCache obj = new LRUCache(2);
        obj.put(1,1);
        obj.put(2,2);
        obj.get(1);
        obj.put(3,3);
        obj.get(2);
        obj.put(4,4);
        obj.get(1);
        obj.get(3);
        obj.get(4);
    }
//[null,null,null,1,null,-1,null,-1,3,4]
}
