package problems.math;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by kiryl_zayets on 3/6/19.
 */
public class RevealCardsInIncreasingOrder {

    public int[] deckRevealedIncreasing(int[] deck) {
        int[] answ = new int[deck.length];
        Arrays.sort(deck);
        Queue<Integer> q = new LinkedList<>();

        for (int i=0; i < deck.length; i++){
            q.offer(i);
        }

        for(int i=0; i < deck.length; i++){
            answ[q.poll()] = deck[i];
            if (!q.isEmpty()) q.add(q.poll());
        }
        return answ;
    }

}
