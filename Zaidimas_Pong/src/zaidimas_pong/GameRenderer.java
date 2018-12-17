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
public class GameRenderer {
    
    private Map map;
    private Racket racket;
    private Ball ball;
    
    public GameRenderer(Ball ball, Racket racket, Map map){
        this.ball = ball;
        this.racket = racket;
        this.map = map;
    }
    
    public void render(){
            for (int y = 0; y<map.getHeight(); y++){
                for (int x=0; x<map.getWidth(); x++){
                    if ((y==(racket.racketY-1) || y==(racket.racketY+1) || y==racket.racketY) && x==0){
                        System.out.print("|");
                    }
                    else
                        if (x==ball.getBallX() && y==ball.getBallY()){
                            System.out.print("O");
                        }
                        else
                            if (map.isWall(x,y)){
                                System.out.print("X");
                            }else{
                                System.out.print(" ");
                            }
                }
                System.out.println();
            }
        }
}
