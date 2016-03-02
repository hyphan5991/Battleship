

/**
 * Created by jakesnyder-hansen on 2/29/16.
 */


public class BoardArray {


    private static int[][] boardArray;
    public static int EMPTY = 0;
    public static int SHIP = 1;
    public static int MINE = 2;
    public static int SHIP_HIT = 3;
    public static int EMPTY_HIT = 4;
    public static int MINE_HIT = 5;
    public static int shipNumber;
    public static int num;

    public BoardArray(int x, int y) {
        num = 0;
        if (x > 10) {
            x = 10;
        } else if (y > 10) {
            y = 10;
        } else if (x < 3) {
            x = 3;
        } else if (y < 3) {
            y = 3;
        }

        boardArray = new int[y][x];
        for (int i = 0; i < boardArray.length; i++) {
            for (int j = 0; j < boardArray[i].length; j++) {
                boardArray[i][j] = EMPTY;
            }
        }

        int max = x * y;

        if (max <= 16) {
            num = 1;

        } else if (max > 16 && max <= 36) {
            num = 2;
        } else {
            num = 3;
        }
        shipNumber = num * 3;
        int sumShips = 0;

        int i = 0;
        boolean passed3 = false;
        while (i < num) {

            int shipX = findX(x);
            int shipY = findY(y);
            if (boardArray[shipY][shipX] == EMPTY) {

                boolean passed2 = false;
                int j = 0;
                int orientpassed = 6;

                while (!passed2 && j < 50) {

                    int orient = (int) Math.round((5 * Math.random()));

                    if (orient == 0) {
                        try {
                            if (boardArray[shipY - 1][shipX] == EMPTY && boardArray[shipY - 2][shipX] == EMPTY) {
                                passed2 = true;
                            } else {
                                passed2 = false;
                            }
                        } catch (ArrayIndexOutOfBoundsException b) {
                            passed2 = false;
                        } catch (IndexOutOfBoundsException e) {
                            passed2 = false;
                        }

                    } else if (orient == 1) {
                        try {
                            if (boardArray[shipY][shipX + 1] == EMPTY && boardArray[shipY][shipX + 2] == EMPTY) {
                                passed2 = true;
                            } else {
                                passed2 = false;
                            }
                        } catch (ArrayIndexOutOfBoundsException b) {
                            passed2 = false;
                        } catch (IndexOutOfBoundsException e) {
                            passed2 = false;
                        }
                    } else if (orient == 2) {
                        try {
                            if (boardArray[shipY + 1][shipX] == EMPTY && boardArray[shipY + 2][shipX] == EMPTY) {
                                passed2 = true;
                            } else {
                                passed2 = false;
                            }
                        } catch (ArrayIndexOutOfBoundsException b) {
                            passed2 = false;
                        } catch (IndexOutOfBoundsException e) {
                            passed2 = false;
                        }

                    } else if (orient == 3) {
                        try {
                            if (boardArray[shipY][shipX - 1] == EMPTY && boardArray[shipY][shipX - 2] == EMPTY) {
                                passed2 = true;
                            } else {
                                passed2 = false;
                            }
                        } catch (ArrayIndexOutOfBoundsException b) {
                            passed2 = false;
                        } catch (IndexOutOfBoundsException e) {
                            passed2 = false;
                        }

                    } else if (orient == 4) {
                        try {
                            if (boardArray[shipY - 1][shipX] == EMPTY && boardArray[shipY + 1][shipX] == EMPTY) {
                                passed2 = true;
                            } else {
                                passed2 = false;
                            }
                        } catch (ArrayIndexOutOfBoundsException b) {
                            passed2 = false;
                        } catch (IndexOutOfBoundsException e) {
                            passed2 = false;
                        }

                    } else if (orient == 5) {
                        try {
                            if (boardArray[shipY][shipX + 1] == EMPTY && boardArray[shipY][shipX - 1] == EMPTY) {
                                passed2 = true;
                            } else {
                                passed2 = false;
                            }
                        } catch (ArrayIndexOutOfBoundsException b) {
                            passed2 = false;
                        } catch (IndexOutOfBoundsException e) {
                            passed2 = false;
                        }

                    }
                    orientpassed = orient;
                    j++;
                }

                if (passed2) {
                    switch (orientpassed) {
                        case 0:
                            boardArray[shipY][shipX] = SHIP;
                            boardArray[(shipY - 1)][shipX] = SHIP;
                            boardArray[(shipY - 2)][shipX] = SHIP;
                            break;
                        case 1:
                            boardArray[shipY][shipX] = SHIP;
                            boardArray[shipY][(shipX + 1)] = SHIP;
                            boardArray[shipY][(shipX + 2)] = SHIP;
                            break;
                        case 2:
                            boardArray[shipY][shipX] = SHIP;
                            boardArray[shipY + 1][shipX] = SHIP;
                            boardArray[shipY + 2][shipX] = SHIP;
                            break;
                        case 3:
                            boardArray[shipY][shipX] = SHIP;
                            boardArray[shipY][(shipX - 1)] = SHIP;
                            boardArray[shipY][(shipX - 2)] = SHIP;
                            break;
                        case 4:
                            boardArray[shipY][shipX] = SHIP;
                            boardArray[(shipY - 1)][shipX] = SHIP;
                            boardArray[(shipY + 1)][shipX] = SHIP;
                            break;
                        case 5:
                            boardArray[shipY][shipX] = SHIP;
                            boardArray[shipY][(shipX + 1)] = SHIP;
                            boardArray[shipY][(shipX - 1)] = SHIP;
                            break;
                        default:
                            System.out.print("something went wrong");
                            break;

                    }
                    i++;
                }
            }
//                else {
//                    i = 0;
//                }
        }
        int j = 0;

        while (j < num){
            int mineX = findX(x);
            int mineY = findY(y);
            if (boardArray[mineY][mineX] == EMPTY) {
                boardArray[mineY][mineX] = MINE;
                j++;
            }
        }

    }


    public static int findX(int x) {

        int num = (int) Math.round(((x - 1) * Math.random()));

        return num;
    }

    public static int findY(int y) {
        int num = (int) Math.round(((y - 1) * Math.random()));
        return num;
    }

    public int[][] getBOARDARRAY() {

        return boardArray;
    }

    public void setBOARDARRAY(int[][] BOARDARRAY) {

        this.boardArray = BOARDARRAY;
    }

    public static int getShipNumber() {
        return shipNumber;
    }

    public static void setShipNumber(int shipNumber) {
        BoardArray.shipNumber = shipNumber;
    }
    public static int[][] getBoardArray() {
        return boardArray;
    }
    public static void main(String[] args) {
        BoardArray tp = new BoardArray(4, 5);
        for (int i = 0; i < tp.getBOARDARRAY()[0].length; i++) {
            System.out.print(tp.getBOARDARRAY()[0][i] + " ");
        }
        System.out.print("\n");
        for (int i = 0; i < tp.getBOARDARRAY()[1].length; i++) {
            System.out.print(tp.getBOARDARRAY()[1][i] + " ");
        }
        System.out.print("\n");
        for (int i = 0; i < tp.getBOARDARRAY()[2].length; i++) {
            System.out.print(tp.getBOARDARRAY()[2][i] + " ");
        }
        System.out.print("\n");
        for (int i = 0; i < tp.getBOARDARRAY()[3].length; i++) {
            System.out.print(tp.getBOARDARRAY()[3][i] + " ");
        }
        System.out.print("\n");
        for (int i = 0; i < tp.getBOARDARRAY()[4].length; i++) {
            System.out.print(tp.getBOARDARRAY()[4][i] + " ");
        }



    }
}
