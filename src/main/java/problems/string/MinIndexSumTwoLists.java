package problems.string;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by kiryl_zayets on 11/10/18.
 */
public class MinIndexSumTwoLists {

    public String[] findRestaurant(String[] list1, String[] list2) {
        HashMap<String, Integer> storage = new HashMap<>();
        HashMap<Integer, List<String>> reverse = new HashMap<>();

        int minDistance = Integer.MAX_VALUE;

        for (int i=0; i<list1.length;i++){
            storage.put(list1[i],i);
        }

        for (int j=0; j<list2.length; j++){

            String sample = list2[j];

            if (storage.containsKey(sample)){
                int dist = storage.get(sample);
                int diff = dist+j;
                if (diff <= minDistance) {
                    minDistance = diff;

                    if (reverse.containsKey(diff)){
                        List<String> l = reverse.get(diff);
                        l.add(sample);
                        reverse.put(diff, l);
                    }
                    else {
                        List<String> tmp =new ArrayList<>();
                        tmp.add(sample);
                        reverse.put(diff, tmp);
                    }

                }
            }
        }


        return reverse.get(minDistance).toArray(new String[reverse.get(minDistance).size()]);


    }


    public static void main(String[] args){
        MinIndexSumTwoLists misl = new MinIndexSumTwoLists();
        misl.findRestaurant(new String[]{"Shogun","Tapioca Express","Burger King","KFC"}, new String[]{"KFC","Shogun","Burger King"});
    }

}