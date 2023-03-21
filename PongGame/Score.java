package PongGame;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Rectangle;

public class Score extends Rectangle{

    int GAME_WIDTH;
    int GAME_HEIGHT;
    int player1;
    int player2; 

    Score(int GAME_WIDTH, int GAME_HEIGHT){
        this.GAME_HEIGHT = GAME_HEIGHT;
        this.GAME_WIDTH = GAME_WIDTH;

    }

    public void draw(Graphics g){
        g.setColor(Color.BLACK);
        g.setFont(new Font("Consolas", Font.PLAIN,60));
        g.drawString(String.valueOf(player1),GAME_HEIGHT-100,50);
        g.drawString(String.valueOf(player2),GAME_HEIGHT-35,50);
    }
    
}
