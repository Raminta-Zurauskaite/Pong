/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package zaidimas_pong;

import java.util.Scanner;

/**
 *
 * @author Ramune
 */
public class UserInput {
    private Scanner scanner = new Scanner(System.in);
    
    public Command getCommand(){
        char n = scanner.next().charAt(0);
        switch(n){
            case 'w':
                return Command.UP;
            case 's':
                return Command.DOWN;
            case 'q':
                return Command.QUIT;
            default:
                return Command.NOTHING;
        }
    }
}
