package problems.tree;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by kiryl_zayets on 1/15/19.
 */
public class CourseSchedule {

    public boolean canFinish(int numCourses, int[][] prerequisites) {

        HashMap<Integer, HashSet<Integer>> dependsOn = new HashMap<>();
        int[] degree = new int[numCourses];
        int count = 0;


        for (int c=0; c < numCourses; c++) {
            if (dependsOn.get(c) == null) dependsOn.put(c, new HashSet<Integer>());
        }

        for(int i = 0 ; i < prerequisites.length; i++){
            int[] p = prerequisites[i];
            dependsOn.get(p[1]).add(p[0]);
            degree[p[0]]++;
        }

        Queue<Integer> q = new LinkedList<>();

        for (int i=0; i<degree.length; i++){
            if (degree[i] == 0) q.offer(i);
        }

        while (!q.isEmpty()){
            int c = q.poll();
            count++;
            HashSet<Integer> tmp = dependsOn.get(c);
            for (int i : tmp){
                degree[i]--;
                if (degree[i] == 0) q.offer(i);
            }

        }

        return count == numCourses;

    }


    public boolean canFinish1(int numCourses, int[][] prerequisites) {

        boolean[][] dependsOn = new boolean[numCourses][numCourses];
        int[] degree = new int[numCourses];

        for (int i=0; i<prerequisites.length; i++){
            int[] prereg = prerequisites[i];
            dependsOn[prereg[1]][prereg[0]] = true;
            degree[prereg[0]]++;
        }

        Queue<Integer> queue = new LinkedList<>();

        for (int i=0; i < degree.length; i++){
            if (degree[i] == 0) queue.add(i);
        }

        int count = 0;

        while (!queue.isEmpty()){
            int course = queue.poll();
            count++;
            for (int i=0; i < dependsOn.length;i++){
                if (dependsOn[course][i]){
                    degree[i]--;
                    if (degree[i] == 0) queue.offer(i);
                }
            }
        }
        if (numCourses == count) return true;
        return false;
    }


    public static void main(String[] args){
        CourseSchedule cs = new CourseSchedule();
        cs.canFinish(2, new int[][]{{1,0}});
    }

}
