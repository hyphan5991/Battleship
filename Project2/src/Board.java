/**
 * Created by jakesnyder-hansen on 2/24/16.
 */
public class Board {
    private int boarddimensions;
    private Pieces[][] boardarray;
    public Board(int x){
        if (x > 10){
            this.boarddimensions = 10;
        }
        else {
            this.boarddimensions = x;
        }
        boardarray = new Pieces[boarddimensions][boarddimensions];

    }
    public Board(){
        this.boarddimensions = 3;
        boardarray = new Pieces[boarddimensions][boarddimensions];
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
    public Pieces getPiece(int xlocation , int ylocation){
        return boardarray[xlocation][ylocation];
    }



}
