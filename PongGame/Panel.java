package PongGame;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.Random;

import javax.swing.JPanel;

public class Panel extends JPanel implements Runnable{
    public static final int GAME_WIDTH = 900;
    public static final int GAME_HEIGHT = 500;
    public static final int BALL_SIZE = 20;

    // creating a variable refrence
    Ball ball1;

    Graphics graphics;
    Image image;
    Paddle paddle1;
    Paddle paddle2;

    Score score;


    Thread myThread;
    
    Panel(){
        //creating panel 
        this.setPreferredSize(new Dimension(GAME_WIDTH, GAME_HEIGHT));
        //creating ball
        
        newBall();
        myThread = new Thread(this);
        myThread.start();
        paddle1 = new Paddle(0, 0, 20, 80,1); 
        paddle2 = new Paddle(880, 0, 20, 80,2);
        this.setFocusable(true);
        this.addKeyListener(new AL());   
        score = new Score(GAME_WIDTH, GAME_HEIGHT);  
        

    }

    public void newBall(){
        Random random = new Random();
        ball1 = new Ball(GAME_WIDTH/2, random.nextInt(GAME_HEIGHT/2), BALL_SIZE, BALL_SIZE);

    }

    // this function helps us to draw things on panel
    @Override
    public void paint(Graphics g){
        super.paint(g);
        image = createImage(GAME_WIDTH, GAME_HEIGHT);
        graphics = image.getGraphics();
        draw(graphics);
        g.drawImage(image,0,0,this);
    }

    public void draw(Graphics g){
        ball1.drawBall(g);
        paddle1.drawPaddle(g);
        paddle2.drawPaddle(g);
        score.draw(g);
        
        
    }

    @Override
    public void run(){
        long lastTime = System.nanoTime();
        double fps = 60.0; // desired frames per second
        double time_per_frame = 1000000000/fps; // time after which the frame should be updated
        while(true){
            long nowTime = System.nanoTime();
            if(nowTime - lastTime >= time_per_frame){
                ball1.moveBall();
                paddle1.movePaddle();
                paddle2.movePaddle();
                repaint();
                collision();
                lastTime = nowTime;
            }
        }
    }

    public void collision(){

       
        
        if(ball1.intersects(paddle1)  || ball1.intersects(paddle2)){
            ball1.xSpeed = -ball1.xSpeed;
        }

       

        if(ball1.x < 0){
            newBall();
            score.player1++;
        }
        
        if (ball1.x >=Panel.GAME_WIDTH){
            newBall();
            score.player2++;
        }

        

        
    }

    class AL extends KeyAdapter{

        @Override
        public void keyPressed(KeyEvent e){
            paddle1.keyPressed(e);
            paddle2.keyPressed(e);
            
        }

        public void keyReleased(KeyEvent e){
            paddle1.keyReleased(e);
            paddle2.keyReleased(e);
        }

    }

}