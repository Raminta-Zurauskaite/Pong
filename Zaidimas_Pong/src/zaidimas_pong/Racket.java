/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package zaidimas_pong;

/**
 *
 * @author Ramune
 */
public class Racket {
    int racketY = 1; //racket takes up 3 spaces; in default example it goes from 0 to 2, middle being 1;
    
    public Racket(int racketY){
        super();
        this.racketY = racketY;
    }

    public int getRacketY() {
        return racketY;
    }

    public void setRacketY(int racketY) {
        this.racketY = racketY;
    }
    
    public boolean hitsRacket(int ballX, int ballY){
        if (ballX == 0 && (ballY == racketY || ballY == racketY-1 || ballY == racketY+1)){
            return true;
        }
        else {
            return false;
        }
    }
}
