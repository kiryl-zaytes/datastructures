package problems.backtracking;

import java.util.HashSet;

/**
 * Created by kiryl_zayets on 2/27/19.
 */
public class RobotCleaner {
    interface Robot {
        // Returns true if the cell in front is open and robot moves into the
        // cell.
        // Returns false if the cell in front is blocked and robot stays in
        // the current cell.
        public boolean move();

        // Robot will stay in the same cell after calling turnLeft/turnRight.
        // Each turn will be 90 degrees.
        public void turnLeft();

        public void turnRight();

        // Clean the current cell.
        public void clean();
    }

    int[][] directions = new int[][]{{0, 1}, {1, 0}, {0, -1}, {-1, 0}};

    public void cleanRoom(Robot robot) {
        HashSet<String> cleaned = new HashSet<>();
        move(robot, 0, 0, 0, cleaned);
    }

    private void move(Robot robot, int x, int y, int direction, HashSet<String> moves) {
        String s = x + "-" + y;
        if (moves.contains(s)) return;
        robot.clean();
        moves.add(s);

        for (int i = 0; i < directions.length; i++) {
            if (robot.move()) {
                int dx = x+directions[direction][0];
                int dy = y+directions[direction][1];
                move(robot, dx, dy, direction, moves);
                robot.turnLeft();
                robot.turnLeft();
                robot.move();
                robot.turnRight();
                robot.turnRight();
            }
            robot.turnRight();
            direction+=1;
            direction%=4;
        }

    }
}

