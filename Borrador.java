
import acm.program.*;

import java.awt.Color;
import java.io.*;
import java.util.*;

import acm.graphics.*;

public class Borrador extends GraphicsProgram {
	public static final int WIN_WIDTH = 600;
	public static final int WIN_HEIGHT = 620;
	/*int startEnemy = 50;
	GImage User = new GImage ("C:\\Users\\prestamour\\Documents\\JuanLadino\\Ejercicios_Practica\\imagen3.png",250,450);
	GRect var1User = new GRect (190,452,70,20);//aleron user
	GRect var2User = new GRect (180,470,90,30);// llantas delanteras
	GRect var3User = new GRect (175,555,100,30); //llantas trasera user
	GRect var4User = new GRect (190,580,70,20);
//----------------------------------------------------------------------------------------
	GImage enemy1 = new GImage ("C:\\Users\\prestamour\\Documents\\JuanLadino\\Ejercicios_Practica\\imagen4.png",25,startEnemy);
	GRect var1enemy1 = new GRect (40,startEnemy + 135, 70,10);
	GRect var2enemy1 = new GRect (30,startEnemy + 100,90,30);
	GRect var3enemy1 = new GRect (25,startEnemy + 12,100,30);
	GRect var4enemy1 = new GRect (40,startEnemy,70,20);
//--------------------------------------------------------------------------------------------
	GImage enemy2 = new GImage ("C:\\Users\\prestamour\\Documents\\JuanLadino\\Ejercicios_Practica\\imagen4.png",175,startEnemy);
	GRect var1enemy2 = new GRect (190,startEnemy + 135, 70,10);
	GRect var2enemy2 = new GRect (180,startEnemy + 100,90,30);
	GRect var3enemy2 = new GRect (175,startEnemy + 12,100,30);
	GRect var4enemy2 = new GRect (190,startEnemy,70,20);
//-------------------------------------------------------------------------------------------------------------
	GImage enemy3 = new GImage ("C:\\Users\\prestamour\\Documents\\JuanLadino\\Ejercicios_Practica\\imagen4.png",325,startEnemy);
	GRect var1enemy3 = new GRect (340,startEnemy + 135, 70,10);
	GRect var2enemy3 = new GRect (330,startEnemy + 100,90,30);
	GRect var3enemy3 = new GRect (325,startEnemy + 12,100,30);
	GRect var4enemy3 = new GRect (340,startEnemy,70,20);
	public void run() {
		setSize(WIN_WIDTH,WIN_HEIGHT);
		User.setBounds(175, 450, 100, 150);
		add(User);
		add(var1User);
		add(var2User);
		add(var3User);
		add(var4User);
		enemy1.setBounds(25, startEnemy, 100, 150);
		add(enemy1);
		add(var4enemy1);
		add(var3enemy1);
		add(var2enemy1);
		add(var1enemy1);
		enemy2.setBounds(175, startEnemy, 100, 150);
		add(enemy2);
		add(var4enemy2);
		add(var3enemy2);
		add(var2enemy2);
		add(var1enemy2);
		enemy3.setBounds(325, startEnemy, 100, 150);
		add(enemy3);
		add(var4enemy3);
		add(var3enemy3);
		add(var2enemy3);
		add(var1enemy3);
	}
	GRoundRect scoreBoard1 = new GRoundRect (455,5,140,100);
	GRoundRect scoreBoard2 = new GRoundRect (465,50,120,45);
	GLabel hiScoreLetter = new GLabel ("HI-SCORE",465,40);
	GLabel hiScore1 = new GLabel ("0",505,83);
	GLabel hiScore2 = new GLabel ("0",525,83);
	
	GRoundRect scoreBoard3 = new GRoundRect (455,115,140,100);
	GRoundRect scoreBoard4 = new GRoundRect (465,160,120,45);
	GLabel ScoreLetter = new GLabel ("SCORE",485,150);
	GLabel Score1 = new GLabel ("0",505,193);
	GLabel Score2 = new GLabel ("0",525,193);
	
	GRoundRect scoreBoard5 = new GRoundRect (455,225,140,100);
	GRoundRect scoreBoard6 = new GRoundRect (465,270,120,45);
	GLabel lives = new GLabel ("LIVES",495,260);
	GLabel lives1 = new GLabel ("0",505,303);
	GLabel lives2 = new GLabel ("0",525,303);
	
	GRect canvas = new GRect (0,-100,450,700);
	GRect line0 = new GRect (147,-90,6,80);
	GRect line1 = new GRect (147,10,6,80);
	GRect line2 = new GRect (147,110,6,80);
	GRect line3 = new GRect (147,210,6,80);
	GRect line4 = new GRect (147,310,6,80);
	GRect line5 = new GRect (147,410,6,80);
	GRect line6 = new GRect (147,510,6,80);
	
	GRect line00 = new GRect (297,-90,6,80);
	GRect line11 = new GRect (297,10,6,80);
	GRect line22 = new GRect (297,110,6,80);
	GRect line33 = new GRect (297,210,6,80);
	GRect line44 = new GRect (297,310,6,80);
	GRect line55 = new GRect (297,410,6,80);
	GRect line66 = new GRect (297,510,6,80);
	
	GCompound gameBackground = new GCompound ();
	public void run() {
		setSize(600,600);
		setForeground(Color.yellow);
		setBackground(Color.black);
		GCompound HiScore = new GCompound();
		GCompound Score = new GCompound();
		GCompound Lives = new GCompound();
		GCompound Menu = new GCompound();

		scoreBoard1.setFilled(true);
		scoreBoard1.setFillColor(Color.red); //darkGray, orange,pink,red
		scoreBoard2.setFilled(true);
		scoreBoard2.setFillColor(Color.black);
		scoreBoard3.setFilled(true);
		scoreBoard3.setFillColor(Color.DARK_GRAY);
		scoreBoard4.setFilled(true);
		scoreBoard4.setFillColor(Color.black);
		scoreBoard5.setFilled(true);
		scoreBoard5.setFillColor(Color.ORANGE);
		scoreBoard6.setFilled(true);
		scoreBoard6.setFillColor(Color.black);
		

		
		hiScoreLetter.setFont("Century Gothic-25");
		hiScore1.setFont("OCR A Extended-bold-30");
		hiScore2.setFont("OCR A Extended-bold-30");
		hiScoreLetter.setColor(Color.WHITE);
		hiScore1.setColor(Color.WHITE);
		hiScore2.setColor(Color.WHITE);

		
		ScoreLetter.setFont("Century Gothic-25");
		Score1.setFont("OCR A Extended-bold-30");
		Score2.setFont("OCR A Extended-bold-30");
		ScoreLetter.setColor(Color.WHITE);
		Score1.setColor(Color.WHITE);
		Score2.setColor(Color.WHITE);
		
		lives.setFont("Century Gothic-25");
		lives1.setFont("OCR A Extended-bold-30");
		lives2.setFont("OCR A Extended-bold-30");
		lives.setColor(Color.WHITE);
		lives1.setColor(Color.WHITE);
		lives2.setColor(Color.WHITE);
		
		HiScore.add(scoreBoard1);
		HiScore.add(scoreBoard2);
		HiScore.add(hiScoreLetter);

		Score.add(scoreBoard3);
		Score.add(scoreBoard4);
		Score.add(ScoreLetter);
		
		Lives.add(scoreBoard5);
		Lives.add(scoreBoard6);
		Lives.add(lives);
		Menu.add(HiScore);
		Menu.add(Score);
		Menu.add(Lives);
		add(Menu);
		add(hiScore1);
		add(hiScore2);
		add(Score1);
		add(Score2);
		add(lives1);
		add(lives2);

	
		
		canvas.setFilled(true);
		canvas.setFillColor(Color.GRAY);
		canvas.setColor(getForeground());
		add(canvas);
		gameBackground.add(canvas);
		
		line0.setFilled(true);
		line0.setColor(getForeground());
		gameBackground.add(line0);
		
		line1.setFilled(true);
		line1.setColor(getForeground());
		gameBackground.add(line1);

		line2.setFilled(true);
		line2.setColor(getForeground());
		gameBackground.add(line2);
		
		line3.setFilled(true);
		line3.setColor(getForeground());
		gameBackground.add(line3);

		line4.setFilled(true);
		line4.setColor(getForeground());
		gameBackground.add(line4);

		line5.setFilled(true);
		line5.setColor(getForeground());
		gameBackground.add(line5);

		line6.setFilled(true);
		line6.setColor(getForeground());
		gameBackground.add(line6);
		
		line00.setFilled(true);
		line00.setColor(getForeground());
		gameBackground.add(line00);


		line11.setFilled(true);
		line11.setColor(getForeground());
		gameBackground.add(line11);

		line22.setFilled(true);
		line22.setColor(getForeground());
		gameBackground.add(line22);

		line33.setFilled(true);
		line33.setColor(getForeground());
		gameBackground.add(line33);

		line44.setFilled(true);
		line44.setColor(getForeground());
		gameBackground.add(line44);

		line55.setFilled(true);
		line55.setColor(getForeground());
		gameBackground.add(line55);

		line66.setFilled(true);
		line66.setColor(getForeground());
		gameBackground.add(line66);
		add(gameBackground);
	}*/
	public static int lastNum (File file) {
		try {
			FileReader texto = new FileReader(file);
			char a = (char) texto.read();
			String b = String.valueOf(a);
			int c = Integer.parseInt(b);
			return c;

		}
		catch (IOException ex) {
			System.out.println("Error");
			return -1;
		}
	}
	
	public void run() {
		File fd = new File("hiScore.txt");
		System.out.println(lastNum(fd));
		
	}
	
}
