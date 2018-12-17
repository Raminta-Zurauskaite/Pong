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
public class Ball {
    
    private int ballX;
    private int ballY;
    
    public Ball(int ballX, int ballY){
        this.ballX = ballX;
        this.ballY = ballY;
    }
    
    public void ChangeX(int x){
        this.ballX=ballX+x;
    }
    
    public void ChangeY(int y){
        this.ballY=ballY+y;
    }
    
    public int getBallX() {
        return ballX;
    }

    public void setBallX(int ballX) {
        this.ballX = ballX;
    }

    public int getBallY() {
        return ballY;
    }

    public void setBallY(int ballY) {
        this.ballY = ballY;
    }
}
