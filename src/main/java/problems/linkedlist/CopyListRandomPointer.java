package problems.linkedlist;

import java.util.HashMap;

/**
 * Created by kiryl_zayets on 10/15/18.
 */
public class CopyListRandomPointer {


    class RandomListNode {
        int label;
        RandomListNode next, random;

        RandomListNode(int x) { this.label = x; }
    }

    ;


    HashMap<RandomListNode, RandomListNode> storage = new HashMap<>();


    private RandomListNode getOrCreate(RandomListNode node) {
        if (node != null) {
            if (storage.containsKey(node)) return storage.get(node);
            else {
                storage.put(node, new RandomListNode(node.label));
                return storage.get(node);
            }

        }
        return null;
    }

    public RandomListNode copyRandomList(RandomListNode head) {
        RandomListNode start = head;

        RandomListNode newHead = new RandomListNode(head.label);

        storage.put(head, newHead);

        while (head != null) {

            newHead.next = getOrCreate(head.next);
            newHead.random = getOrCreate(head.random);

            newHead = newHead.next;
            head = head.next;
        }

        return storage.get(head);

    }


}
