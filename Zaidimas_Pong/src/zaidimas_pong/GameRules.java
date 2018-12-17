/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package zaidimas_pong;

import java.io.IOException;

/**
 *
 * @author Ramune
 */
public class GameRules {
    
    private Map map;
    private Racket racket;
    private Ball ball;
    
    //int direction = 2; //ball can go 6 different directions: north east - 1, east - 2, south east - 3, south west - 4, west - 5, north west - 6
    int directionY=1;
    int directionX=1;
    
    public GameRules(Ball ball, Racket racket, Map map){
        this.ball = ball;
        this.racket = racket;
        this.map = map;
    }
    
    public boolean isGameOver(){
            return (ball.getBallX() == 0);
    }
    
    public void endGame() throws IOException {
        System.out.println("GAME OVER!");
        System.in.read();
        System.exit(0);
    }
    
    public void moveBall(){
       if (map.isWall(ball.getBallX()+directionX, ball.getBallY()+directionY) || racket.hitsRacket(ball.getBallX()+directionX, ball.getBallY()+directionY)){
           if (ball.getBallY()+directionY==0 || ball.getBallY()+directionY==map.getHeight()-1){
               directionY*=-1;
           }
           else {
               directionX*=-1;
           }
       }
       else {
           ball.ChangeX(directionX);
           ball.ChangeY(directionY);
       }
    }
        
        public void processCommand (Command command) throws Exception{
            switch(command){
                case DOWN:
                    tryMoveRacket(1);
                    break;
                case NOTHING:
                    break;
                case QUIT:
                    endGame();
                    break;
                case UP:
                    tryMoveRacket(-1);
                    break;
                default:
                    break;
            }
        }
        
        private void tryMoveRacket(int dy){
            int nextY = racket.getRacketY() +dy;
            
            if ((racket.getRacketY()-1 == 0 && dy == -1) || (racket.getRacketY()+1 == 18 && dy == 1))
                return;
            racket.setRacketY(nextY);
            }
}
