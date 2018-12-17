package zaidimas_pong;

/**
 *
 * @author Ramune
 */
public class Zaidimas_Pong {
        
        public static void main (String args[]) throws Exception{
            Map map = new Map();
            Ball ball = new Ball(10, 4);
            Racket racket = new Racket(1);
            GameRenderer renderer = new GameRenderer(ball, racket, map);
            
            GameRules gameRules = new GameRules(ball, racket, map);
            UserInput userInput = new UserInput();
        
            while (true){
                renderer.render();
            
                if (gameRules.isGameOver())
                    gameRules.endGame();
                
                Command command = userInput.getCommand();
                gameRules.processCommand(command);
                
                gameRules.moveBall();
            }
        }
}
