package org.example;


public class Rover {
    public static final Integer N = 1;
    public static final Integer E = 2;
    public static final Integer S = 3;
    public static final Integer W = 4;
    Integer x = 0;
    Integer y = 0;
    private Integer maxX;
    private Integer maxY;
    private Integer minX = 0;
    private Integer minY = 0;
    Integer facing = N;

    public Rover() {
    }

    public Integer getMaxX() {
        return maxX;
    }

    public void setMaxX(int maxX) {
        this.maxX = maxX;
    }

    public Integer getMaxY() {
        return maxY;
    }

    public void setMaxY(int maxY) {
        this.maxY = maxY;
    }


    public void setPosition(Integer x, Integer y, Integer facing) {
        if (getMaxX() == null) {
            this.x = x;
            this.y = y;
            this.facing = facing;
        } else {
            boolean isOutOfBoundsX = false;
            boolean isOutOfBoundsY = false;

            if (x > getMaxX()) {
                isOutOfBoundsX = true;
            }

            if (y > getMaxY()) {
                isOutOfBoundsY = true;
            }

            if (isOutOfBoundsX && isOutOfBoundsY) {
                System.out.println("You are out of borders!!");
                this.x = getMaxX();
                this.y = getMaxY();
                System.out.println("Your position is set to " + this.x + " " + this.y);
            } else if (isOutOfBoundsX) {
                System.out.println("You cannot cross border for X coordinate!!");
                this.x = getMaxX();
                this.y = y;
                System.out.println("Your position is set to " + this.x + " " + this.y);
            } else if (isOutOfBoundsY) {
                System.out.println("You cannot cross border for Y coordinate!!");
                this.x = x;
                this.y = getMaxY();
                System.out.println("Your position is set to " + this.x + " " + this.y);
            } else {
                this.x = x;
                this.y = y;
            }
            this.facing = facing;
        }
    }

    public String getPosition() {
        char dir = 'N';
        if (facing == 1) {
            dir = 'N';
        } else if (facing == 2) {
            dir = 'E';
        } else if (facing == 3) {
            dir = 'S';
        } else if (facing == 4) {
            dir = 'W';
        }
        return x + " " + y + " " + dir;
    }

    public void process(String commands) {
        for (int idx = 0; idx < commands.length(); idx++) {
            process(commands.toUpperCase().charAt(idx));
        }
    }

    private void process(Character command) {
        if (command.equals('L')) {
            turnLeft();
        } else if (command.equals('R')) {
            turnRight();
        } else if (command.equals('M')) {
            controlledMove();
        } else {
            throw new IllegalArgumentException(
                    "Speak in Mars language, please!");
        }
    }

    private void move() {
        if (facing == N) {
            this.y++;
        } else if (facing == E) {
            this.x++;
        } else if (facing == S) {
            this.y--;
        } else if (facing == W) {
            this.x--;
        }
    }

    private void controlledMove() {
        if (getMaxX() == null) {
            move();
        } else {
            if (facing == N) {
                if (++this.y > getMaxY()) {
                    System.out.println("You can't move to the north anymore");
                    this.y = getMaxY();
                }
            } else if (facing == E) {
                if (++this.x > getMaxX()) {
                    System.out.println("You can't move to the east anymore");
                    this.x = getMaxX();
                }
            } else if (facing == S) {
                if (--this.y < minY) {
                    System.out.println("You can't move to the south anymore");
                    this.y = minY;
                }
            } else if (facing == W) {
                if (--this.x < minX) {
                    System.out.println("You can't move to the west anymore");
                    this.x = minX;
                }
            }

        }
    }

    private void turnLeft() {
        facing = (facing - 1) < N ? W : facing - 1;
    }

    private void turnRight() {
        facing = (facing + 1) > W ? N : facing + 1;
    }

    public void setArea(int x, int y) {
        setMaxX(x);
        setMaxY(y);
    }

    public static void main(String args[]) {
        Rover rover = new Rover();
        rover.setArea(5, 5);
        rover.setPosition(0, 0, 4);
        System.out.println(rover.getPosition());
        rover.setPosition(1, 2, N);
        System.out.println(rover.getPosition());
        rover.process("LMLMLMLMM");
        System.out.println(rover.getPosition() + "..."); // prints 1 3 N
        rover.setPosition(3, 3, E);
        rover.process("MMRMMRMRRM");
        System.out.println(rover.getPosition()); // prints 5 1 E
        rover.turnLeft();
        System.out.println(rover.getPosition());
//        rover.setPosition(6, 7, N);
    }


}
