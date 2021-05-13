class Move {
    public static void moveRobot(Robot robot, int toX, int toY) {
        if (robot.getX() < toX) {
            moveRobotToPositiveX(robot, toX);
        } else if (robot.getX() > toX) {
            moveRobotToNegativeX(robot, toX);
        }
        if (robot.getY() < toY) {
            moveRobotToPositiveY(robot, toY);
        } else if (robot.getY() > toY) {
            moveRobotToNegativeY(robot, toY);
        }
    }

    private static void moveRobotToNegativeX(Robot robot, int toX) {
        if (robot.getDirection() == Direction.LEFT) {
            moveToNegativeX(robot, toX);
        } else if (robot.getDirection() == Direction.UP) {
            robot.turnLeft();
            moveToNegativeX(robot, toX);
        } else if (robot.getDirection() == Direction.DOWN) {
            robot.turnRight();
            moveToNegativeX(robot, toX);
        } else {
            robot.turnLeft();
            robot.turnLeft();
            moveToNegativeX(robot, toX);
        }
    }

    private static void moveRobotToPositiveX(Robot robot, int toX) {
        if (robot.getDirection() == Direction.RIGHT) {
            moveToPositiveX(robot, toX);
        } else if (robot.getDirection() == Direction.UP) {
            robot.turnRight();
            moveToPositiveX(robot, toX);
        } else if (robot.getDirection() == Direction.DOWN) {
            robot.turnLeft();
            moveToPositiveX(robot, toX);
        } else {
            robot.turnLeft();
            robot.turnLeft();
            moveToPositiveX(robot, toX);
        }
    }

    private static void moveRobotToPositiveY(Robot robot, int toY) {
        if (robot.getDirection() == Direction.UP) {
            moveToPositiveY(robot, toY);
        } else if (robot.getDirection() == Direction.LEFT) {
            robot.turnRight();
            moveToPositiveY(robot, toY);
        } else if (robot.getDirection() == Direction.RIGHT) {
            robot.turnLeft();
            moveToPositiveY(robot, toY);
        } else {
            robot.turnLeft();
            robot.turnLeft();
            moveToPositiveY(robot, toY);
        }
    }

    private static void moveRobotToNegativeY(Robot robot, int toY) {
        if (robot.getDirection() == Direction.DOWN) {
            moveToNegativeY(robot, toY);
        } else if (robot.getDirection() == Direction.LEFT) {
            robot.turnLeft();
            moveToNegativeY(robot, toY);
        } else if (robot.getDirection() == Direction.RIGHT) {
            robot.turnRight();
            moveToNegativeY(robot, toY);
        } else {
            robot.turnLeft();
            robot.turnLeft();
            moveToNegativeY(robot, toY);
        }
    }

    private static void moveToPositiveX(Robot robot, int toX) {
        int moves = toX - robot.getX();
        for (int i = 0; i < moves; i++) {
            robot.stepForward();
        }
    }

    private static void moveToNegativeX(Robot robot, int toX) {
        int moves = robot.getX() - toX;
        for (int i = 0; i < moves; i++) {
            robot.stepForward();
        }
    }
    private static void moveToPositiveY(Robot robot, int toY) {
        int moves = toY - robot.getY();
        for (int i = 0; i < moves; i++) {
            robot.stepForward();
        }
    }

    private static void moveToNegativeY(Robot robot, int toY) {
        int moves = robot.getY() - toY;
        for (int i = 0; i < moves; i++) {
            robot.stepForward();
        }
    }
}

//Don't change code below

enum Direction {
    UP(0, 1),
    DOWN(0, -1),
    LEFT(-1, 0),
    RIGHT(1, 0);

    private final int dx;
    private final int dy;

    Direction(int dx, int dy) {
        this.dx = dx;
        this.dy = dy;
    }

    public Direction turnLeft() {
        switch (this) {
            case UP:
                return LEFT;
            case DOWN:
                return RIGHT;
            case LEFT:
                return DOWN;
            case RIGHT:
                return UP;
            default:
                throw new IllegalStateException();
        }
    }

    public Direction turnRight() {
        switch (this) {
            case UP:
                return RIGHT;
            case DOWN:
                return LEFT;
            case LEFT:
                return UP;
            case RIGHT:
                return DOWN;
            default:
                throw new IllegalStateException();
        }
    }

    public int dx() {
        return dx;
    }

    public int dy() {
        return dy;
    }
}

class Robot {
    private int x;
    private int y;
    private Direction direction;

    public Robot(int x, int y, Direction direction) {
        this.x = x;
        this.y = y;
        this.direction = direction;
    }

    public void turnLeft() {
        direction = direction.turnLeft();
    }

    public void turnRight() {
        direction = direction.turnRight();
    }

    public void stepForward() {
        x += direction.dx();
        y += direction.dy();
    }

    public Direction getDirection() {
        return direction;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
}