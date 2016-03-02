public class BattleShip {


    private static int turns;
    private static int hitvalue;


    public static int gethitvalue(){
        return hitvalue;
    }
    public static void turnchange(){
        turns++;
    }
    public static int getturns(){
        return turns;
    }
    public static void shiphit(){
        hitvalue++;
    }
    public static void setTurns(int turns) {
        BattleShip.turns = turns;
    }
    public static void setHitvalue(int hitvalue) {
        BattleShip.hitvalue = hitvalue;
    }
}
