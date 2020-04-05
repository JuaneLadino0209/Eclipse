import acm.program.*;
import acm.graphics.*;
import java.awt.*;
import java.awt.event.*;

public class Dinosaur extends GraphicsProgram {
	private static final long serialVersionUID = 1L;
	private static final int WIN_WIDTH = 1024;
	private static final int WIN_HEIGTH = 600;
	private static String movimiento = "";
	double limitBackgroundY1 = 0;
	double limitBackgroundY2 = 500;

	double X1 = 50;
	double X2 = 974;
	double Y = 175;
	
	GRect Player1 = new GRect (X1,Y,10,100);
	GRect Player2 = new GRect (X2,Y,10,100);
	GOval Ball = new GOval (WIN_WIDTH/2, 225, 15, 15);
	GLine surface = new GLine (0, limitBackgroundY2,WIN_WIDTH,limitBackgroundY2);
	GLabel scoreBoard2 = new GLabel ("0", WIN_WIDTH/2 + 25,575);
	GLabel scoreBoard1 = new GLabel ("0", WIN_WIDTH/2 - 50,575);
	GRect scoreFramework = new GRect (WIN_WIDTH/2 - 55, 510,135,75);
	GLabel fillSpace = new GLabel (":", WIN_WIDTH/2 - 12.5,575);
	GLine medium1 = new GLine (WIN_WIDTH/2 + Ball.getWidth()/2,0,WIN_WIDTH/2 + Ball.getHeight()/2,limitBackgroundY2);
	

	int x;
	
	
	
	public void init () {
		setBackground(Color.BLACK);
		add(surface);
		surface.setColor(Color.GREEN);
		Ball.setFilled(true);
		Ball.setFillColor(Color.GREEN);
		add(Ball);
		setSize(WIN_WIDTH ,  WIN_HEIGTH);
		add(Player1);
		Player1.setFilled(true);
		Player1.setFillColor(Color.GREEN);
		add(Player2);
		Player2.setFilled(true);
		Player2.setFillColor(Color.GREEN);
		add(scoreBoard1);
		scoreBoard1.setColor(Color.GREEN);
		scoreBoard1.setFont("OCRAExtended-bold-80");
		add(scoreBoard2);
		scoreBoard2.setColor(Color.GREEN);
		scoreBoard2.setFont("OCRAExtended-bold-80");
		add(fillSpace);
		fillSpace.setFont("OCRAExtended-bold-80");
		fillSpace.setColor(Color.GREEN);
		add(scoreFramework);
		scoreFramework.setColor(Color.GREEN);
		
		add(medium1);
		medium1.setColor(Color.GREEN);
		addKeyListeners();
	}
	public void run() {
		x = 2;
		int a = 1;
		int b = -1;
		int score1 = 0;
		int score2 = 0;
		while (true) {
			if (movimiento.equals("up1")) {
				if (Ball.getX() == Player2.getX() - Ball.getWidth() && Ball.getY() >= Player2.getY() - Ball.getHeight()/2 && Ball.getY() + Ball.getHeight() <= Player2.getY() + Player2.getHeight() + Ball.getHeight()/2) {
					a = -1;
				}
				else if (Ball.getX() == Player1.getX() + Player1.getWidth() && Ball.getY() >= Player1.getY() - Ball.getHeight()/2 && Ball.getY() + Ball.getHeight() <= Player1.getY() + Player1.getHeight() + Ball.getHeight()/2) {
					a = 1;
				}
				if (Ball.getY() == limitBackgroundY1) {
					b = 1;
				}
				else if (Ball.getY() == limitBackgroundY2 - Ball.getHeight()) {
					b = -1;
				}
				
				Player1.move(0, -1);
					Ball.move(a, b);
				
				
			}
			else if (movimiento.equals("up2")) {
				if (Ball.getX() == Player2.getX() - Ball.getWidth() && Ball.getY() >= Player2.getY() - Ball.getHeight()/2 && Ball.getY() + Ball.getHeight() <= Player2.getY() + Player2.getHeight() + Ball.getHeight()/2) {
					a = -1;
				}
				else if (Ball.getX() == Player1.getX() + Player1.getWidth() && Ball.getY() >= Player1.getY() - Ball.getHeight()/2 && Ball.getY() + Ball.getHeight() <= Player1.getY() + Player1.getHeight() + Ball.getHeight()/2) {
					a = 1;
				}
				if (Ball.getY() == limitBackgroundY1) {
					b = 1;
				}
				else if (Ball.getY() == limitBackgroundY2 -  Ball.getHeight()) {
					b = -1;
				}
				
				Player2.move(0, -1);
				Ball.move(a, b);
				
			}
			else if (movimiento.equals("stop1")) {
				if (Ball.getX() == Player2.getX() - Ball.getWidth() && Ball.getY() >= Player2.getY() - Ball.getHeight()/2 && Ball.getY() + Ball.getHeight() <= Player2.getY() + Player2.getHeight() + Ball.getHeight()/2) {
					a = -1;
				}
				else if (Ball.getX() == Player1.getX() + Player1.getWidth() && Ball.getY() >= Player1.getY() - Ball.getHeight()/2 && Ball.getY() + Ball.getHeight() <= Player1.getY() + Player1.getHeight() + Ball.getHeight()/2) {
					a = 1;
				}
				if (Ball.getY() == limitBackgroundY1) {
					b = 1;
				}
				else if (Ball.getY() == limitBackgroundY2 -  Ball.getHeight()) {
					b = -1;
				}
				
				Player1.move(0, 0);
				Ball.move(a, b);
				
			}
			else if (movimiento.equals("stop2")) {
				if (Ball.getX() == Player2.getX() - Ball.getWidth() && Ball.getY() >= Player2.getY() - Ball.getHeight()/2 && Ball.getY() + Ball.getHeight() <= Player2.getY() + Player2.getHeight() + Ball.getHeight()/2) {
					a = -1;
				}
				else if (Ball.getX() == Player1.getX() + Player1.getWidth() && Ball.getY() >= Player1.getY() - Ball.getHeight()/2 && Ball.getY() + Ball.getHeight() <= Player1.getY() + Player1.getHeight() + Ball.getHeight()/2) {
					a = 1;
				}
				if (Ball.getY() == limitBackgroundY1) {
					b = 1;
				}
				else if (Ball.getY() == limitBackgroundY2 -  Ball.getHeight()) {
					b = -1;
				}
				
				Player2.move(0, 0);
				Ball.move(a, b);
				
			}

			else if (movimiento.equals("down1")) {
				if (Ball.getX() == Player2.getX() - Ball.getWidth() && Ball.getY() >= Player2.getY() - Ball.getHeight()/2 && Ball.getY() + Ball.getHeight() <= Player2.getY() + Player2.getHeight() + Ball.getHeight()/2) {
					a = -1;
				}
				else if (Ball.getX() == Player1.getX() + Player1.getWidth() && Ball.getY() >= Player1.getY() - Ball.getHeight()/2 && Ball.getY() + Ball.getHeight() <= Player1.getY() + Player1.getHeight() + Ball.getHeight()/2) {
					a = 1;
				}
				if (Ball.getY() == limitBackgroundY1) {
					b = 1;
				}
				else if (Ball.getY() == limitBackgroundY2 -  Ball.getHeight()) {
					b = -1;
				}
				
				Player1.move(0, 1);
				Ball.move(a, b);
				
			}
			else if (movimiento.equals("down2")) {
				if (Ball.getX() == Player2.getX() - Ball.getWidth() && Ball.getY() >= Player2.getY() - Ball.getHeight()/2 && Ball.getY() + Ball.getHeight() <= Player2.getY() + Player2.getHeight() + Ball.getHeight()/2) {
					a = -1;
				}
				else if (Ball.getX() == Player1.getX() + Player1.getWidth() && Ball.getY() >= Player1.getY() - Ball.getHeight()/2 && Ball.getY() + Ball.getHeight() <= Player1.getY() + Player1.getHeight() + Ball.getHeight()/2) {
					a = 1;
				}
				if (Ball.getY() == limitBackgroundY1) {
					b = 1;
				}
				else if (Ball.getY() == limitBackgroundY2 -  Ball.getHeight()) {
					b = -1;
				}
				
				Player2.move(0, 1);
				Ball.move(a, b);
				
				
			}
			
					if (Player1.getLocation().getY() > limitBackgroundY2 - Player1.getHeight()) {
						x = 0;
						Player1.setLocation(Player1.getLocation().getX(), limitBackgroundY2 - Player1.getHeight());;
					}
					else if (Player1.getLocation().getY() < limitBackgroundY1) {
						x = 2;
						Player1.setLocation(Player1.getLocation().getX(), limitBackgroundY1);;
					}
					if (Player2.getLocation().getY() > limitBackgroundY2 - Player1.getHeight()) {
						x = 0;
						Player2.setLocation(Player2.getLocation().getX(), limitBackgroundY2 - Player1.getHeight());;
					}
					
					else if (Player2.getLocation().getY() < limitBackgroundY1) {
						x = 2;
						Player2.setLocation(Player2.getLocation().getX(), limitBackgroundY1);;
					}
			if (Ball.getLocation().getX()< -2) {
				Ball.setLocation(WIN_WIDTH/2, limitBackgroundY2/2);
				score2 ++;
				String scoreBoard = Integer.toString(score2);
				scoreBoard2.setLabel(scoreBoard);
				if (score2 == 5) {
					GLabel winner2 = new GLabel ("PLAYER 2 WON", WIN_WIDTH/2 - 200, WIN_HEIGTH/2 - 150);
					add(winner2);
					winner2.setFont("OCRAExtended-60");
					winner2.setColor(Color.GREEN);
					break;
				}
				
			}
			else if (Ball.getLocation().getX() > WIN_WIDTH) {
				Ball.setLocation(WIN_WIDTH/2, limitBackgroundY2/2);
				score1 ++;
				String scoreBoard = Integer.toString(score1);
				scoreBoard1.setLabel(scoreBoard);
				if (score1 == 5) {
					GLabel winner1 = new GLabel ("PLAYER 1 WON", WIN_WIDTH/2 - 200, WIN_HEIGTH/2 - 150);
					add(winner1);
					winner1.setFont("OCRAExtended-60");
					winner1.setColor(Color.GREEN);
					break;
				}
			}
			pause(3);
		}
	}
	public void keyPressed(KeyEvent e) {
		if (e.getKeyCode() == KeyEvent.VK_W) {
			movimiento = "up1";
			x = 2;
		}
		else if (e.getKeyCode() == KeyEvent.VK_S) {
			movimiento = "down1";
			x = 2;
		}
		else if (e.getKeyCode() == KeyEvent.VK_UP) {
			movimiento = "up2";
			x = 2;
		}
		else if (e.getKeyCode() == KeyEvent.VK_DOWN) {
			movimiento = "down2";
			x = 2;
		}
	
	}
	public void keyReleased(KeyEvent e1) {

		if (e1.getKeyCode() == KeyEvent.VK_W) {
			movimiento = "stop1";
		}
		else if (e1.getKeyCode() == KeyEvent.VK_S) {
			movimiento = "stop1";
		}
		else if (e1.getKeyCode() == KeyEvent.VK_UP) {
			movimiento = "stop2";
		}
		else if (e1.getKeyCode() == KeyEvent.VK_DOWN) {
			movimiento = "stop2";
		}
		
	}
	
}