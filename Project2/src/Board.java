/**
 * Created by jakesnyder-hansen on 2/24/16.
 */
public class Board {
  private int boarddimensions;
    private Object[][] boardarray;
    public Board(int x){
        this.boarddimensions = x;
    }
    public Board(){
        this.boarddimensions = 3;
    }
    public void intializeboard(){
        Object[] boardarray = Object[boarddimensions][boarddimensions];
    }
    public int getboarddimensions(){
        return boarddimensions;
    }
    public void setboarddimensions(int x){
        boarddimensions = x;
    }
    public void setpieces(Pieces x){
        boardarray[x.getXlocation()][x.getYlocation()] = x;
    }


}
