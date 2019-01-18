package problems.tree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by kiryl_zayets on 1/15/19.
 */
public class CourseSchedule {

    public boolean canFinish(int numCourses, int[][] prerequisites) {

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

}
