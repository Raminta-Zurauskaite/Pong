package zaidimas_pong;

import java.io.IOException;
import java.util.Scanner;

/**
 *
 * @author Ramune
 */
public class Zaidimas_Pong {
        static int MAP [][] = new int [][] {
                {0,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1},
		{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1},
		{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1},
                {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1},
                {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1},
		{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1},
                {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1},
                {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1},
		{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1},
                {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1},
                {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1},
		{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1},
                {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1},
                {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1},
		{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1},
                {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1},
                {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1},
		{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1},
		{0,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1},
        };
        
        static int ballX = 5;
        static int ballY = 5;
        static int direction = 2; //ball can go 6 different directions: north east - 1, east - 2, south east - 3, south west - 4, west - 5, north west - 6
        static int racketY = 1; //racket takes up 3 spaces; in default example it goes from 0 to 2, middle being 1;
        
        public static void main (String args[]) throws IOException{
            
            Scanner scanner = new Scanner(System.in);
        
            while (true){
                render (racketY, ballX, ballY);
            
                if (ballOutOfBounds(ballY))
                    endGame();
                
                
                int n = scanner.next().charAt(0);
                processUserInput(n);
                
                moveBall();
            }
        }
        
        private static boolean ballOutOfBounds(int ballY) throws IOException {
            return (ballX == 0);
        }
    
        private static void endGame() throws IOException {
            System.out.println("Game over");
            System.in.read();
            System.exit(0);
        }
        
        private static void moveBall() {
            switch (direction){
                case 1:
                    if (MAP[ballY-1][ballX+1]==1){
                        if (ballX==18 && ballY==0)
                        {
                            direction = 4;
                        }
                        else if (ballY-1==0){
                            direction = 3;
                            ballX+=1;
                        }
                        else {
                            direction = 6;
                            ballY-=1;
                        }
                    }
                    else{
                        ballX+=1;
                        ballY-=1;
                    }
                    break;
                case 2:
                    if (MAP[ballY][ballX+1]==1){
                        direction = 5;
                        
                    } 
                    else {
                        ballX+=1;
                    }
                    break;
                case 3:
                    if (MAP[ballY+1][ballX+1]==1)
                    {
                        if (ballX==18 && ballY==18){
                            direction = 6;
                        }
                        else if (ballY+1==18){
                            direction = 1;
                            ballX+=1;
                        }
                        else{
                            direction = 4;
                            ballY+=1;
                        }
                    }
                    else {
                        ballX+=1;
                        ballY+=1;
                    }
                    break;
                case 4:
                    if ((ballX-1)==0 && ballY==racketY && ballY+1==MAP.length){
                        direction = 1;
                    }
                    else if ((ballX-1)==0 && ballY==racketY){
                        direction = 3;
                        ballY+=1;
                    }
                    else if ((ballX-1)==0 && ballY==(racketY+1)){
                        direction = 2;
                        ballY+=1;
                    }
                    else if ((ballX-1)==0 && ballY==(racketY+2)){
                        direction = 1;
                    }
                    else if (ballY+1==MAP.length){
                        direction = 6;
                        ballX-=1;
                    }
                    else {
                        ballY+=1;
                        ballX-=1;
                    }
                    break;
                case 5:
                    if ((ballX-1)==0 && ballY==racketY){
                        direction = 2;
                    } 
                    else if ((ballX-1)==0 && ballY-1==racketY){
                        direction = 3;
                        ballY+=1;
                    }
                    else if ((ballX-1)==0 && ballY+1==racketY){
                        direction = 1;
                        ballY-=1;
                    }
                    else {
                        ballX-=1;
                    }
                    break;
                case 6:
                    if ((ballX-1)==0 && ballY==racketY && ballY-1==0){
                        direction = 3;
                    }
                    else if ((ballX-1)==0 && ballY==racketY){
                        direction = 1;
                        ballY-=1;
                    }
                    else if ((ballX-1)==0 && ballY==(racketY-1)){
                        direction = 2;
                        ballY-=1;
                    }
                    else if ((ballX-1)==0 && ballY==(racketY-2)){
                        direction = 3;
                    }
                    else if (ballY-1==0){
                        direction = 4;
                        ballX-=1;
                    }
                    else {
                        ballY-=1;
                        ballX-=1;
                    }
                    break;
            }
        }
        
        private static void processUserInput(int n){
            switch(n){
                case 's':
                    if (racketY < (MAP.length-1))
                        racketY+=1;
                    break;
                case 'w':
                    if (racketY > 1)
                        racketY-=1;
                    break;
                case 'a':
                    break;
                case 'q':
                    System.exit(1);
                    break;
            }
        }
        
        private static void render(int racketY, int ballX, int ballY){
            for (int y = 0; y<MAP.length; y++){
                for (int x=0; x<MAP[0].length; x++){
                    if ((y==(racketY-1) || y==(racketY+1) || y==racketY) && x==0){
                        System.out.print("|");
                    }
                    else
                        if (x==ballX && y==ballY){
                            System.out.print("O");
                        }
                        else
                            if (MAP[y][x] == 1){
                                System.out.print("X");
                            }else{
                                System.out.print(" ");
                            }
                }
                System.out.println();
            }
        }
}
