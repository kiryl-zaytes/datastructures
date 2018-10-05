package datastructures;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

/**
 * Design a data structure that supports all following operations in average O(1) time.
 insert(val): Inserts an item val to the set if not already present.
 remove(val): Removes an item val from the set if present.
 getRandom: Returns a random element from current set of elements. Each element must have the same probability of being returned.
 *
 * HashMap to store val and pos in ArrayList. ArrayList to store value for get random operation. Delete and add to both structures at same time.
 * To keep array del in O(1) replace i with last and delete last.
 */
public class RandomSet {

    HashMap<Integer, Integer> storage;
    ArrayList<Integer> randomizer;
    Random r = new Random();

    public RandomSet() {
        storage = new HashMap<>();
        randomizer = new ArrayList();
    }

    public boolean insert(int val) {
        if (storage.containsKey(val)) return false;
        storage.put(val, randomizer.size());
        randomizer.add(val);
        return true;
    }


    public boolean remove(int val) {
        if (!storage.containsKey(val)) return false;
        int pos = storage.get(val);
        if (pos < randomizer.size() -1){
            Integer last = randomizer.get(randomizer.size() - 1);
            randomizer.set(pos, last);
            storage.put(last, pos);
        }
        randomizer.remove(randomizer.size() -1);
        storage.remove(val);
        return true;
    }


    public int getRandom() {
        int i = r.nextInt(randomizer.size());
        return randomizer.get(i);
    }


    public static void main(String[] args) {

        RandomSet randomSet = new RandomSet();
        randomSet.insert(5);
        randomSet.insert(6);

        randomSet.getRandom();
        randomSet.remove(5);
        randomSet.insert(7);
        randomSet.getRandom();
        randomSet.getRandom();
    }


}
