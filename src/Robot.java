enum Direction {UP, RIGHT, DOWN, LEFT} // можно вынести в отдельный класс

/*
Реализовать класс Robot с конструкторами, в т.ч. конструктор копирования,
методами get.. и turnLeft turnRight stepForward
Реализовать класс-наследник от Robot
с функцией moveTo , перемещающей робота
из текущего положения в заданную точку
используя только функции, реализованные в Robot
 */

public class Robot {
    private int x, y;
    private Direction dir = Direction.UP;

    public Robot() {
        x = 0;
        y = 0;
        dir = Direction.UP;
    }

    public Robot(int x, int y, Direction dir) {
        this.x = x;
        this.y = y;
        this.dir = dir;
    }

    public void turnRight() {
        switch (dir) {
            case RIGHT:
                dir = Direction.DOWN;
                break;
            case LEFT:
                dir = Direction.UP;
                break;
            case DOWN:
                dir = Direction.LEFT;
                break;
            case UP:
                dir = Direction.RIGHT;
                break;
        }
    }

    public void turnLeft() {

        switch (dir) {
            case RIGHT:
                dir = Direction.UP;
                break;
            case LEFT:
                dir = Direction.DOWN;
                break;
            case DOWN:
                dir = Direction.RIGHT;
                break;
            case UP:
                dir = Direction.LEFT;
                break;

        }
    }

    public void stepForward() {
        switch (getDir()) {
            case UP:
                y++;
                break;
            case DOWN:
                y--;
                break;
            case LEFT:
                x--;
                break;
            case RIGHT:
                x++;
                break;
        }
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public Direction getDir() {
        return dir;
    }
}

class SmartRobot extends Robot {
    public SmartRobot() {
        super(0, 0, Direction.UP);
    }

    public void moveTo(int toX, int toY) {

        switch (getDir()) {
            case UP:
                if (toX >= getX()) turnRight();
                else turnLeft();
                break;
            case DOWN:
                if (toX >= getX()) turnLeft();
                else turnRight();
                break;
            case RIGHT:
                if (toX >= getX()) break;
                else {
                    turnLeft();
                    turnLeft();
                }
                break;
            case LEFT:
                if (toX >= getX()) {
                    turnRight();
                    turnRight();
                } else break;
                break;
        }
        System.out.println("Двигаемся по осям: ");

        while (getX() != toX) {
            System.out.println("{" + getX() + ";" + getY() + "}");
            stepForward();
        }

        if (getDir() == Direction.LEFT) {
            if (toY > getY()) turnRight();
            else turnLeft();

            while (getY() != toY) {
                System.out.println("{" + getX() + ";" + getY() + "}");
                stepForward();
            }
        }

        if (getDir() == Direction.RIGHT) {
            if (toY < getY()) turnRight();
            else turnLeft();

            while (getY() != toY) {
                System.out.println("{" + getX() + ";" + getY() + "}");
                stepForward();

            }
        }

    }

}

