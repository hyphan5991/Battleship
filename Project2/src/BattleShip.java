public class BattleShip {
    private static int turns;
    private static int hitvalue;
    public static void turnchange(){
        turns++;
    }
    public static int getturns(){
        return turns;
    }
    public static void shiphit(){
        hitvalue++;
    }

}
