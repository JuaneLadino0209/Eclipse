import acm.program.*;
import acm.util.RandomGenerator;
import acm.graphics.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import java.io.*;

public class Rally extends GraphicsProgram {

	private static final long serialVersionUID = 1L;
	public static final int WIN_WIDTH = 600;
	public static final int WIN_HEIGHT = 600;
	public static String movimiento = "";
	double limitBackgroundY1 = 10; //
	double limitBackgroundY2 = 590;
	double limitBackgroundX1 = 5;
	double limitBackgroundX2 = 440;

	double startEnemy = -151;
	
	double speedEnemy = 1.5;
	double speedUser = 1.5;
	double speedGameBackground = 1 ;

	 int X = 175;
	 int Y = 450;
//Menu (Hi-Score,Score,Lives) -------------------------------------------------------------
	 GRoundRect scoreBoard1 = new GRoundRect (455,5,140,100);
		GRoundRect scoreBoard2 = new GRoundRect (465,50,120,45);
		GLabel hiScoreLetter = new GLabel ("HI-SCORE",465,40);
		GLabel hiScore1 = new GLabel ("0",505,83);
		GLabel hiScore2 = new GLabel ("0",525,83);
		
		GRoundRect scoreBoard3 = new GRoundRect (455,115,140,100);
		GRoundRect scoreBoard4 = new GRoundRect (465,160,120,45);
		GLabel ScoreLetter = new GLabel ("SCORE",485,150);
		int scoreCounterUnd = 0;
		int scoreCounterDec = 0;

		GLabel Score1 = new GLabel ("0",505,193);
		GLabel Score2 = new GLabel ("0",525,193);
		
		GRoundRect scoreBoard5 = new GRoundRect (455,225,140,100);
		GRoundRect scoreBoard6 = new GRoundRect (465,270,120,45);
		int livesCounter = 3;
		
		GLabel lives = new GLabel ("LIVES",495,260);
		GLabel lives1 = new GLabel ("0",505,303);
		GLabel lives2 = new GLabel ("3",525,303);
		GCompound HiScore = new GCompound();
		GCompound Score = new GCompound();
		GCompound Lives = new GCompound();
		GCompound Menu = new GCompound();
	
//Objects (User(Automovil Principal), enemies)----------------------------------------------------------------------------------
	GImage enemy1 = new GImage ("C:\\Users\\juane\\eclipse-workspace\\Java_Projects\\src\\imageEnemy.png",25,startEnemy);
	GRect var1enemy1 = new GRect (40,startEnemy + 135, 70,10);
	GRect var2enemy1 = new GRect (30,startEnemy + 100,90,30);
	GRect var3enemy1 = new GRect (25,startEnemy + 12,100,30);
	GRect var4enemy1 = new GRect (40,startEnemy,70,20);
	
	GImage enemy2 = new GImage ("C:\\Users\\juane\\eclipse-workspace\\Java_Projects\\src\\imageEnemy.png",175,startEnemy);
	GRect var1enemy2 = new GRect (190,startEnemy + 135, 70,10);
	GRect var2enemy2 = new GRect (180,startEnemy + 100,90,30);
	GRect var3enemy2 = new GRect (175,startEnemy + 12,100,30);
	GRect var4enemy2 = new GRect (190,startEnemy,70,20);
	
	GImage enemy3 = new GImage ("C:\\Users\\juane\\eclipse-workspace\\Java_Projects\\src\\imageEnemy.png",325,startEnemy);
	GRect var1enemy3 = new GRect (340,startEnemy + 135, 70,10);
	GRect var2enemy3 = new GRect (330,startEnemy + 100,90,30);
	GRect var3enemy3 = new GRect (325,startEnemy + 12,100,30);
	GRect var4enemy3 = new GRect (340,startEnemy,70,20);
	ArrayList<GObject> enemies = new ArrayList<GObject> (Arrays.asList(enemy1,enemy2,enemy3));
	
	//GRect User = new GRect (X,Y,100,120);
	GImage User = new GImage ("C:\\Users\\juane\\eclipse-workspace\\Java_Projects\\src\\imageUser.png",X,Y);
	GRect var1User = new GRect (190,452,70,20);//aleron user
	GRect var2User = new GRect (180,470,90,30);// llantas delanteras
	GRect var3User = new GRect (175,555,100,30); //llantas trasera user
	GRect var4User = new GRect (190,580,70,20); // spoiler trasero
//gameBackground (Carretera)----------------------------------------------------------------------------------------------------
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
//Metodo que lee Textos-------------------------------------------------------------------------------------------------
	File textoRecord = new File("C:\\Users\\juane\\eclipse-workspace\\Java_Projects\\src\\Score.txt");
	public String Record(File a) {
		try {
			Scanner test = new Scanner(a);
			String read = test.next();
			test.close();
			return read;
		}
		catch (IOException ex) {
			return "Error";
		}
	}
	public void init() {
		setSize(WIN_WIDTH, WIN_HEIGHT);
		setForeground(Color.YELLOW);
		setBackground(Color.black);
//--------------------------------------------------------------------------------------------------
		String f = Record(textoRecord);
		char h = f.charAt(1);
		char k = f.charAt(0);
		String hiScoreUnd = Character.toString(h);
		String hiScoreDec = Character.toString(k);
		hiScore2.setLabel(hiScoreUnd);
		hiScore1.setLabel(hiScoreDec);
//Print Menu----------------------------------------------------------------------------------------
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
		
//Print User-------------------------------------------------------------------------------------------------------------------------
		add(line1);
		add(line2);
		add(line3);
		User.setBounds(175, 450, 100, 150);
		add(User);	 
		var1User.setVisible(getIgnoreRepaint());
		add(var1User);
		var2User.setVisible(getIgnoreRepaint());
		add(var2User);
		var3User.setVisible(getIgnoreRepaint());
		add(var3User);
		var4User.setVisible(getIgnoreRepaint());
		add(var4User);
//print GameBackground-----------------------------------------------------------------------------------------------------------------
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
		gameBackground.sendToBack();
//--------------------------------------------------------------------------------------------------
		addKeyListeners();
	}
	public void run() {
	while(true) {
//Print Enemies------------------------------------------------------------------------------------------------------------
		enemy1.setBounds(25, startEnemy, 100, 150);
		add(enemy1);
		var1enemy1.setVisible(getIgnoreRepaint());
		add(var1enemy1);
		var2enemy1.setVisible(getIgnoreRepaint());
		add(var2enemy1);
		var3enemy1.setVisible(getIgnoreRepaint());
		add(var3enemy1);
		var4enemy1.setVisible(getIgnoreRepaint());
		add(var4enemy1);

		enemy2.setBounds(175, startEnemy, 100, 150);
		add(enemy2);
		var4enemy2.setVisible(getIgnoreRepaint());
		add(var4enemy2);
		var3enemy2.setVisible(getIgnoreRepaint());
		add(var3enemy2);
		var2enemy2.setVisible(getIgnoreRepaint());
		add(var2enemy2);
		var1enemy2.setVisible(getIgnoreRepaint());
		add(var1enemy2);
		
		enemy3.setBounds(325, startEnemy, 100, 150);
		add(enemy3);
		var4enemy3.setVisible(getIgnoreRepaint());
		add(var4enemy3);
		var3enemy3.setVisible(getIgnoreRepaint());
		add(var3enemy3);
		var2enemy3.setVisible(getIgnoreRepaint());
		add(var2enemy3);
		var1enemy3.setVisible(getIgnoreRepaint());
		add(var1enemy3);
//------------------------------------------------------------------------------------------------------------
		
		RandomGenerator random;
		RandomGenerator random2;
		RandomGenerator random3;
		int numEnemies = 2;
		int indexEnemies =0;
		int indexEnemies1 = 0;
		int contador = 0;
		
		while (true) {
			if (contador == 0) {
				enemies = new ArrayList<GObject> (Arrays.asList(enemy1,enemy2,enemy3));

					random = new RandomGenerator();
					indexEnemies = random.nextInt(0, enemies.size() -1);
					random2 = new RandomGenerator();
					numEnemies = random2.nextInt(1,2);
					random3 = new RandomGenerator ();
					indexEnemies1 = random3.nextInt(0, enemies.size() -1);
					contador ++;	
			}
//Animacion si keyCode == VK_RIGTH-------------------------------------------------------------------------------------------------	
			if (movimiento.equals("derecha")) {
				
				User.move(speedUser, 0);
				gameBackground.move(0, speedGameBackground);
				var1User.move(speedUser, 0);
				var2User.move(speedUser, 0);
				var3User.move(speedUser, 0);
				var4User.move(speedUser, 0);
				
				if (indexEnemies == 0) {
					enemy1.move(0,speedEnemy);
					var1enemy1.move(0, speedEnemy);
					var2enemy1.move(0, speedEnemy);
					var3enemy1.move(0, speedEnemy);
					var4enemy1.move(0, speedEnemy);
					if (numEnemies == 2) {
						enemies.remove(enemy1);
						if (indexEnemies1 == 0) {
							enemy2.move(0, speedEnemy);
							var1enemy2.move(0, speedEnemy);
							var2enemy2.move(0, speedEnemy);
							var3enemy2.move(0, speedEnemy);
							var4enemy2.move(0, speedEnemy);
						}
						else if (indexEnemies1 == 1) {
							enemy3.move(0, speedEnemy);
							var1enemy3.move(0, speedEnemy);
							var2enemy3.move(0, speedEnemy);
							var3enemy3.move(0, speedEnemy);
							var4enemy3.move(0, speedEnemy);
						}
					}
				}
				else if (indexEnemies == 1 ) {
					enemy2.move(0,speedEnemy);
					var1enemy2.move(0, speedEnemy);
					var2enemy2.move(0, speedEnemy);
					var3enemy2.move(0, speedEnemy);
					var4enemy2.move(0, speedEnemy);
					if (numEnemies == 2) {
						enemies.remove(enemy2);
						if (indexEnemies1 == 0) {
							enemy1.move(0,speedEnemy);
							var1enemy1.move(0, speedEnemy);
							var2enemy1.move(0, speedEnemy);
							var3enemy1.move(0, speedEnemy);
							var4enemy1.move(0, speedEnemy);
						}
						else if (indexEnemies1 == 1) {
							enemy3.move(0, speedEnemy);
							var1enemy3.move(0, speedEnemy);
							var2enemy3.move(0, speedEnemy);
							var3enemy3.move(0, speedEnemy);
							var4enemy3.move(0, speedEnemy);
						}
					}
				}
				else if (indexEnemies == 2 ) {
					enemy3.move(0,speedEnemy);
					var1enemy3.move(0, speedEnemy);
					var2enemy3.move(0, speedEnemy);
					var3enemy3.move(0, speedEnemy);
					var4enemy3.move(0, speedEnemy);
					if (numEnemies == 2) {
						enemies.remove(enemy3);
						if (indexEnemies1 == 0) {
							enemy1.move(0, speedEnemy);
							var1enemy1.move(0, speedEnemy);
							var2enemy1.move(0, speedEnemy);
							var3enemy1.move(0, speedEnemy);
							var4enemy1.move(0, speedEnemy);
						}
						else if (indexEnemies1 == 1) {
							enemy2.move(0, speedEnemy);
							var1enemy2.move(0, speedEnemy);
							var2enemy2.move(0, speedEnemy);
							var3enemy2.move(0, speedEnemy);
							var4enemy2.move(0, speedEnemy);
						}
					}
				}
				contador++;
				}
//Animacion si keyCode == VK_LEFT----------------------------------------------------------------------------------------------------------
			else if (movimiento.equals("izquierda")) {
				
				User.move(speedUser * -1, 0);
				gameBackground.move(0, speedGameBackground);
				
				var1User.move(speedUser * -1, 0);
				var2User.move(speedUser * -1, 0);
				var3User.move(speedUser * -1, 0);
				var4User.move(speedUser * -1, 0);
				
				if (indexEnemies == 0) {
					enemy1.move(0,speedEnemy);
					var1enemy1.move(0, speedEnemy);
					var2enemy1.move(0, speedEnemy);
					var3enemy1.move(0, speedEnemy);
					var4enemy1.move(0, speedEnemy);
					if (numEnemies == 2) {
						enemies.remove(enemy1);
						if (indexEnemies1 == 0) {
							enemy2.move(0, speedEnemy);
							var1enemy2.move(0, speedEnemy);
							var2enemy2.move(0, speedEnemy);
							var3enemy2.move(0, speedEnemy);
							var4enemy2.move(0, speedEnemy);
						}
						else if (indexEnemies1 == 1) {
							enemy3.move(0, speedEnemy);
							var1enemy3.move(0, speedEnemy);
							var2enemy3.move(0, speedEnemy);
							var3enemy3.move(0, speedEnemy);
							var4enemy3.move(0, speedEnemy);
						}
					}
				}
				else if (indexEnemies == 1 ) {
					enemy2.move(0,speedEnemy);
					var1enemy2.move(0, speedEnemy);
					var2enemy2.move(0, speedEnemy);
					var3enemy2.move(0, speedEnemy);
					var4enemy2.move(0, speedEnemy);
					if (numEnemies == 2) {
						enemies.remove(enemy2);
						if (indexEnemies1 == 0) {
							enemy1.move(0,speedEnemy);
							var1enemy1.move(0, speedEnemy);
							var2enemy1.move(0, speedEnemy);
							var3enemy1.move(0, speedEnemy);
							var4enemy1.move(0, speedEnemy);
						}
						else if (indexEnemies1 == 1) {
							enemy3.move(0, speedEnemy);
							var1enemy3.move(0, speedEnemy);
							var2enemy3.move(0, speedEnemy);
							var3enemy3.move(0, speedEnemy);
							var4enemy3.move(0, speedEnemy);
						}
					}
				}
				else if (indexEnemies == 2 ) {
					enemy3.move(0,speedEnemy);
					var1enemy3.move(0, speedEnemy);
					var2enemy3.move(0, speedEnemy);
					var3enemy3.move(0, speedEnemy);
					var4enemy3.move(0, speedEnemy);
					if (numEnemies == 2) {
						enemies.remove(enemy3);
						if (indexEnemies1 == 0) {
							enemy1.move(0, speedEnemy);
							var1enemy1.move(0, speedEnemy);
							var2enemy1.move(0, speedEnemy);
							var3enemy1.move(0, speedEnemy);
							var4enemy1.move(0, speedEnemy);
						}
						else if (indexEnemies1 == 1) {
							enemy2.move(0, speedEnemy);
							var1enemy2.move(0, speedEnemy);
							var2enemy2.move(0, speedEnemy);
							var3enemy2.move(0, speedEnemy);
							var4enemy2.move(0, speedEnemy);
						}
					}
				}
				contador++;
				}
//Animacion si keyCode == VK_UP-----------------------------------------------------------------------------------------------
			else if (movimiento.equals("up")) {
				User.move(0,speedUser*-1);
				gameBackground.move(0, speedGameBackground);

				var1User.move(0,speedUser*-1);
				var2User.move(0,speedUser*-1);
				var3User.move(0,speedUser*-1);
				var4User.move(0,speedUser*-1);
				
				if (indexEnemies == 0) {
					enemy1.move(0,speedEnemy);
					var1enemy1.move(0, speedEnemy);
					var2enemy1.move(0, speedEnemy);
					var3enemy1.move(0, speedEnemy);
					var4enemy1.move(0, speedEnemy);
					if (numEnemies == 2) {
						enemies.remove(enemy1);
						if (indexEnemies1 == 0) {
							enemy2.move(0, speedEnemy);
							var1enemy2.move(0, speedEnemy);
							var2enemy2.move(0, speedEnemy);
							var3enemy2.move(0, speedEnemy);
							var4enemy2.move(0, speedEnemy);
						}
						else if (indexEnemies1 == 1) {
							enemy3.move(0, speedEnemy);
							var1enemy3.move(0, speedEnemy);
							var2enemy3.move(0, speedEnemy);
							var3enemy3.move(0, speedEnemy);
							var4enemy3.move(0, speedEnemy);
						}
					}
				}
				else if (indexEnemies == 1 ) {
					enemy2.move(0,speedEnemy);
					var1enemy2.move(0, speedEnemy);
					var2enemy2.move(0, speedEnemy);
					var3enemy2.move(0, speedEnemy);
					var4enemy2.move(0, speedEnemy);
					if (numEnemies == 2) {
						enemies.remove(enemy2);
						if (indexEnemies1 == 0) {
							enemy1.move(0,speedEnemy);
							var1enemy1.move(0, speedEnemy);
							var2enemy1.move(0, speedEnemy);
							var3enemy1.move(0, speedEnemy);
							var4enemy1.move(0, speedEnemy);
						}
						else if (indexEnemies1 == 1) {
							enemy3.move(0, speedEnemy);
							var1enemy3.move(0, speedEnemy);
							var2enemy3.move(0, speedEnemy);
							var3enemy3.move(0, speedEnemy);
							var4enemy3.move(0, speedEnemy);
						}
					}
				}
				else if (indexEnemies == 2 ) {
					enemy3.move(0,speedEnemy);
					var1enemy3.move(0, speedEnemy);
					var2enemy3.move(0, speedEnemy);
					var3enemy3.move(0, speedEnemy);
					var4enemy3.move(0, speedEnemy);
					if (numEnemies == 2) {
						enemies.remove(enemy3);
						if (indexEnemies1 == 0) {
							enemy1.move(0, speedEnemy);
							var1enemy1.move(0, speedEnemy);
							var2enemy1.move(0, speedEnemy);
							var3enemy1.move(0, speedEnemy);
							var4enemy1.move(0, speedEnemy);
						}
						else if (indexEnemies1 == 1) {
							enemy2.move(0, speedEnemy);
							var1enemy2.move(0, speedEnemy);
							var2enemy2.move(0, speedEnemy);
							var3enemy2.move(0, speedEnemy);
							var4enemy2.move(0, speedEnemy);
						}
					}
				}
				contador++;
				}	
//Animacion si keyCode == VK_DOWN----------------------------------------------------------------------------------------------------------------
			else if (movimiento.equals("down")) {
				User.move(0,speedUser);
				gameBackground.move(0, speedGameBackground);

				var1User.move(0,speedUser);
				var2User.move(0,speedUser);
				var3User.move(0,speedUser);
				var4User.move(0,speedUser);
				
				if (indexEnemies == 0) {
					enemy1.move(0,speedEnemy);
					var1enemy1.move(0, speedEnemy);
					var2enemy1.move(0, speedEnemy);
					var3enemy1.move(0, speedEnemy);
					var4enemy1.move(0, speedEnemy);
					if (numEnemies == 2) {
						enemies.remove(enemy1);
						if (indexEnemies1 == 0) {
							enemy2.move(0, speedEnemy);
							var1enemy2.move(0, speedEnemy);
							var2enemy2.move(0, speedEnemy);
							var3enemy2.move(0, speedEnemy);
							var4enemy2.move(0, speedEnemy);
						}
						else if (indexEnemies1 == 1) {
							enemy3.move(0, speedEnemy);
							var1enemy3.move(0, speedEnemy);
							var2enemy3.move(0, speedEnemy);
							var3enemy3.move(0, speedEnemy);
							var4enemy3.move(0, speedEnemy);
						}
					}
				}
				else if (indexEnemies == 1 ) {
					enemy2.move(0,speedEnemy);
					var1enemy2.move(0, speedEnemy);
					var2enemy2.move(0, speedEnemy);
					var3enemy2.move(0, speedEnemy);
					var4enemy2.move(0, speedEnemy);
					if (numEnemies == 2) {
						enemies.remove(enemy2);
						if (indexEnemies1 == 0) {
							enemy1.move(0,speedEnemy);
							var1enemy1.move(0, speedEnemy);
							var2enemy1.move(0, speedEnemy);
							var3enemy1.move(0, speedEnemy);
							var4enemy1.move(0, speedEnemy);
						}
						else if (indexEnemies1 == 1) {
							enemy3.move(0, speedEnemy);
							var1enemy3.move(0, speedEnemy);
							var2enemy3.move(0, speedEnemy);
							var3enemy3.move(0, speedEnemy);
							var4enemy3.move(0, speedEnemy);
						}
					}
				}
				else if (indexEnemies == 2 ) {
					enemy3.move(0,speedEnemy);
					var1enemy3.move(0, speedEnemy);
					var2enemy3.move(0, speedEnemy);
					var3enemy3.move(0, speedEnemy);
					var4enemy3.move(0, speedEnemy);
					if (numEnemies == 2) {
						enemies.remove(enemy3);
						if (indexEnemies1 == 0) {
							enemy1.move(0, speedEnemy);
							var1enemy1.move(0, speedEnemy);
							var2enemy1.move(0, speedEnemy);
							var3enemy1.move(0, speedEnemy);
							var4enemy1.move(0, speedEnemy);
						}
						else if (indexEnemies1 == 1) {
							enemy2.move(0, speedEnemy);
							var1enemy2.move(0, speedEnemy);
							var2enemy2.move(0, speedEnemy);
							var3enemy2.move(0, speedEnemy);
							var4enemy2.move(0, speedEnemy);
						}
					}
				}
				contador++;
				}	
//Animacion si keyCode == ""------------------------------------------------------------------------------------------------------------------
			else if (movimiento.equals("stop")) {
				User.move(0, 0);
				gameBackground.move(0, speedGameBackground);

				var1User.move(0, 0);
				var2User.move(0, 0);
				var3User.move(0, 0);
				var4User.move(0, 0);
				
				if (indexEnemies == 0) {
					enemy1.move(0,speedEnemy);
					var1enemy1.move(0, speedEnemy);
					var2enemy1.move(0, speedEnemy);
					var3enemy1.move(0, speedEnemy);
					var4enemy1.move(0, speedEnemy);
					if (numEnemies == 2) {
						enemies.remove(enemy1);
						if (indexEnemies1 == 0) {
							enemy2.move(0, speedEnemy);
							var1enemy2.move(0, speedEnemy);
							var2enemy2.move(0, speedEnemy);
							var3enemy2.move(0, speedEnemy);
							var4enemy2.move(0, speedEnemy);
						}
						else if (indexEnemies1 == 1) {
							enemy3.move(0, speedEnemy);
							var1enemy3.move(0, speedEnemy);
							var2enemy3.move(0, speedEnemy);
							var3enemy3.move(0, speedEnemy);
							var4enemy3.move(0, speedEnemy);
						}
					}
				}
				else if (indexEnemies == 1 ) {
					enemy2.move(0,speedEnemy);
					var1enemy2.move(0, speedEnemy);
					var2enemy2.move(0, speedEnemy);
					var3enemy2.move(0, speedEnemy);
					var4enemy2.move(0, speedEnemy);
					if (numEnemies == 2) {
						enemies.remove(enemy2);
						if (indexEnemies1 == 0) {
							enemy1.move(0,speedEnemy);
							var1enemy1.move(0, speedEnemy);
							var2enemy1.move(0, speedEnemy);
							var3enemy1.move(0, speedEnemy);
							var4enemy1.move(0, speedEnemy);
						}
						else if (indexEnemies1 == 1) {
							enemy3.move(0, speedEnemy);
							var1enemy3.move(0, speedEnemy);
							var2enemy3.move(0, speedEnemy);
							var3enemy3.move(0, speedEnemy);
							var4enemy3.move(0, speedEnemy);
						}
					}
				}
				else if (indexEnemies == 2 ) {
					enemy3.move(0,speedEnemy);
					var1enemy3.move(0, speedEnemy);
					var2enemy3.move(0, speedEnemy);
					var3enemy3.move(0, speedEnemy);
					var4enemy3.move(0, speedEnemy);
					if (numEnemies == 2) {
						enemies.remove(enemy3);
						if (indexEnemies1 == 0) {
							enemy1.move(0, speedEnemy);
							var1enemy1.move(0, speedEnemy);
							var2enemy1.move(0, speedEnemy);
							var3enemy1.move(0, speedEnemy);
							var4enemy1.move(0, speedEnemy);
						}
						else if (indexEnemies1 == 1) {
							enemy2.move(0, speedEnemy);
							var1enemy2.move(0, speedEnemy);
							var2enemy2.move(0, speedEnemy);
							var3enemy2.move(0, speedEnemy);
							var4enemy2.move(0, speedEnemy);
						}
					}
				}
				contador++;
				}
//litmites var1User--------------------------------------------------------------------------------------------------------------------------
			if (var1User.getLocation().getY() > limitBackgroundY2 - 147) {
				var1User.setLocation(var1User.getLocation().getX(), limitBackgroundY2 - 147);
			}
			else if (var1User.getLocation().getY() < limitBackgroundY1 + 3) {
				var1User.setLocation(var1User.getLocation().getX(), limitBackgroundY1 + 3);
			}
			if (var1User.getLocation().getX() > limitBackgroundX2 - 85) {
				
				var1User.setLocation(limitBackgroundX2 - 85, var1User.getY());
			}
			else if (var1User.getLocation().getX() < limitBackgroundX1 +15) {
				
				var1User.setLocation(limitBackgroundX1 +15, var1User.getY());
			}
//limites var2User------------------------------------------------------------------------------------------------------------------------
			if (var2User.getLocation().getY() > limitBackgroundY2 - 130) {
				var2User.setLocation(var2User.getLocation().getX(), limitBackgroundY2 - 130);
			}
			else if (var2User.getLocation().getY() < limitBackgroundY1 + 20) {
				var2User.setLocation(var2User.getLocation().getX(), limitBackgroundY1 + 20);
			}
			if (var2User.getLocation().getX() > limitBackgroundX2 - 95) {
				
				var2User.setLocation(limitBackgroundX2 - 95, var2User.getY());
			}
			else if (var2User.getLocation().getX() < limitBackgroundX1 + 5) {
				
				var2User.setLocation(limitBackgroundX1 + 5, var2User.getY());
			}
//limites var3User----------------------------------------------------------------------------------------------------------------------
			if (var3User.getLocation().getY() > limitBackgroundY2 - 45) {
				var3User.setLocation(var3User.getLocation().getX(), limitBackgroundY2 - 45);
			}
			else if (var3User.getLocation().getY() < limitBackgroundY1 + 105) {
				var3User.setLocation(var3User.getLocation().getX(), limitBackgroundY1 + 105);
			}
			if (var3User.getLocation().getX() > limitBackgroundX2 - 100) {
				
				var3User.setLocation(limitBackgroundX2 - 100, var3User.getY());
			}
			else if (var3User.getLocation().getX() < limitBackgroundX1 ) {
				
				var3User.setLocation(limitBackgroundX1, var3User.getY());
			}
//limites var4User---------------------------------------------------------------------------------------------------------------------------
			if (var4User.getLocation().getY() > limitBackgroundY2 - 20) {
				var4User.setLocation(var4User.getLocation().getX(), limitBackgroundY2 - 20);
			}
			else if (var4User.getLocation().getY() < limitBackgroundY1 + 130) {
				var4User.setLocation(var4User.getLocation().getX(), limitBackgroundY1 + 130);
			}
			if (var4User.getLocation().getX() > limitBackgroundX2 - 85) {
				
				var4User.setLocation(limitBackgroundX2 - 85, var4User.getY());
			}
			else if (var4User.getLocation().getX() < limitBackgroundX1 + 15 ) {
				
				var4User.setLocation(limitBackgroundX1 + 15, var4User.getY());
			}
//limites User-------------------------------------------------------------------------------------------------------------------------------------------------			
			if (User.getLocation().getY() > limitBackgroundY2 - User.getHeight()) {
				
				User.setLocation(User.getLocation().getX(), limitBackgroundY2 - User.getHeight());
			}
			else if (User.getLocation().getY() < limitBackgroundY1) {
			
				User.setLocation(User.getLocation().getX(), limitBackgroundY1);
			}
			if (User.getLocation().getX() > limitBackgroundX2 - User.getWidth()) {
							
				User.setLocation(limitBackgroundX2 - User.getWidth(), User.getY());
			}
			else if (User.getLocation().getX() < limitBackgroundX1) {
						
				User.setLocation(limitBackgroundX1, User.getY());
			}
//Limites Enemies (Aumento de Score,Aumneto de velocidad, reinicio de random)----------------------------------------------------------------
			 if (enemy1.getY() > limitBackgroundY2 ) {
				 scoreCounterUnd ++;
				 if (scoreCounterUnd < 10) {
				 String A = Integer.toString(scoreCounterUnd);
				 Score2.setLabel(A);
				 }
				 else if (scoreCounterUnd == 10) {
					 scoreCounterDec ++;
					 scoreCounterUnd = 0;
					 String A = Integer.toString(scoreCounterUnd);
					 String B = Integer.toString(scoreCounterDec);
					 Score2.setLabel(A);
					 Score1.setLabel(B); 
				 }
				 enemy1.setLocation(25,startEnemy);
				 var1enemy1.setLocation(40, startEnemy + 135);
				 var2enemy1.setLocation(30, startEnemy + 100);
				 var3enemy1.setLocation(25, startEnemy + 12);
				 var4enemy1.setLocation(40, startEnemy);

				 enemy1.move(0, 0);
				 var1enemy1.move(0, 0);
				 var2enemy1.move(0, 0);
				 var3enemy1.move(0, 0);
				 var4enemy1.move(0, 0);

				 contador = 0;
				 speedEnemy += 0.02;
				 speedUser += 0.01;
			 }
			 if (enemy2.getY() > limitBackgroundY2 ) {
				 scoreCounterUnd ++;
				 if (scoreCounterUnd < 10) {
				 String A = Integer.toString(scoreCounterUnd);
				 Score2.setLabel(A);
				 }
				 else if (scoreCounterUnd == 10) {
					 scoreCounterDec ++;
					 scoreCounterUnd = 0;
					 String A = Integer.toString(scoreCounterUnd);
					 String B = Integer.toString(scoreCounterDec);
					 Score2.setLabel(A);
					 Score1.setLabel(B); 
				 }
				 enemy2.setLocation(175,startEnemy);
				 var1enemy2.setLocation(190, startEnemy + 135);
				 var2enemy2.setLocation(180, startEnemy + 100);
				 var3enemy2.setLocation(175, startEnemy + 12);
				 var4enemy2.setLocation(190, startEnemy);

				 enemy2.move(0, 0);
				 var1enemy2.move(0, 0);
				 var2enemy2.move(0, 0);
				 var3enemy2.move(0, 0);
				 var4enemy2.move(0, 0);
				 contador = 0;
				 speedEnemy += 0.02;
				 speedUser += 0.01;
			 }
			 if (enemy3.getY() > limitBackgroundY2) {
				 scoreCounterUnd ++;
				 if (scoreCounterUnd < 10) {
				 String A = Integer.toString(scoreCounterUnd);
				 Score2.setLabel(A);
				 }
				 else if (scoreCounterUnd == 10) {
					 scoreCounterDec ++;
					 scoreCounterUnd = 0;
					 String A = Integer.toString(scoreCounterUnd);
					 String B = Integer.toString(scoreCounterDec);
					 Score2.setLabel(A);
					 Score1.setLabel(B); 
				 }
				 enemy3.setLocation(325,startEnemy);
				 var1enemy3.setLocation(340, startEnemy + 135);
				 var2enemy3.setLocation(330, startEnemy + 100);
				 var3enemy3.setLocation(325, startEnemy + 12);
				 var4enemy3.setLocation(340, startEnemy);

				 enemy3.move(0, 0);
				 var1enemy3.move(0, 0);
				 var2enemy3.move(0, 0);
				 var3enemy3.move(0, 0);
				 var4enemy3.move(0, 0);
				 contador = 0;
				 speedEnemy += 0.02;
				 speedUser += 0.01;
			 }
			 if (gameBackground.getY() >= 100) {
				 gameBackground.setLocation(0, 0);
			 }
//Opciones de perdida -------------------------------------------------------------------------------------------------------------------
			 if (var1User.getY() <= var1enemy1.getY() + var1enemy1.getHeight() && var1User.getY() + var1User.getHeight() >= var1enemy1.getY() && var1User.getX() <= var1enemy1.getX() + var1enemy1.getWidth() && var1User.getX() + var1User.getWidth() >= var1enemy1.getX()) {
				 break;
			 }
			 else if (var1User.getY() <= var1enemy2.getY() + var1enemy2.getHeight() && var1User.getY() + var1User.getHeight() >= var1enemy2.getY() && var1User.getX() <= var1enemy2.getX() + var1enemy2.getWidth() && var1User.getX() + var1User.getWidth() >= var1enemy2.getX()) {
				 break;
			 }
			 else if (var1User.getY() <= var1enemy3.getY() + var1enemy3.getHeight() && var1User.getY() + var1User.getHeight() >= var1enemy3.getY() && var1User.getX() <= var1enemy3.getX() + var1enemy3.getWidth() && var1User.getX() + var1User.getWidth() >= var1enemy3.getX()) {
				 break;
			 }
			 
			 if (var1User.getY() <= var2enemy1.getY() + var2enemy1.getHeight() && var1User.getY() + var1User.getHeight() >= var2enemy1.getY() && var1User.getX() <= var2enemy1.getX() + var2enemy1.getWidth() && var1User.getX() + var1User.getWidth() >= var2enemy1.getX()) {
				 break;
			 }
			 else if (var1User.getY() <= var2enemy2.getY() + var2enemy2.getHeight() && var1User.getY() + var1User.getHeight() >= var2enemy2.getY() && var1User.getX() <= var2enemy2.getX() + var2enemy2.getWidth() && var1User.getX() + var1User.getWidth() >= var2enemy2.getX()) {
				 break;
			 }
			 else if (var1User.getY() <= var2enemy3.getY() + var2enemy3.getHeight() && var1User.getY() + var1User.getHeight() >= var2enemy3.getY() && var1User.getX() <= var2enemy3.getX() + var2enemy3.getWidth() && var1User.getX() + var1User.getWidth() >= var2enemy3.getX()) {
				 break;
			 }
			 
			 if (var1User.getY() <= var3enemy1.getY() + var3enemy1.getHeight() && var1User.getY() + var1User.getHeight() >= var3enemy1.getY() && var1User.getX() <= var3enemy1.getX() + var3enemy1.getWidth() && var1User.getX() + var1User.getWidth() >= var3enemy1.getX()) {
				 break;
			 }
			 else if (var1User.getY() <= var3enemy2.getY() + var3enemy2.getHeight() && var1User.getY() + var1User.getHeight() >= var3enemy2.getY() && var1User.getX() <= var3enemy2.getX() + var3enemy2.getWidth() && var1User.getX() + var1User.getWidth() >= var3enemy2.getX()) {
				 break;
			 }
			 else if (var1User.getY() <= var3enemy3.getY() + var3enemy3.getHeight() && var1User.getY() + var1User.getHeight() >= var3enemy3.getY() && var1User.getX() <= var3enemy3.getX() + var3enemy3.getWidth() && var1User.getX() + var1User.getWidth() >= var3enemy3.getX()) {
				 break;
			 }
			 
			 if (var1User.getY() <= var4enemy1.getY() + var4enemy1.getHeight() && var1User.getY() + var1User.getHeight() >= var4enemy1.getY() && var1User.getX() <= var4enemy1.getX() + var4enemy1.getWidth() && var1User.getX() + var1User.getWidth() >= var4enemy1.getX()) {
				 break;
			 }
			 else if (var1User.getY() <= var4enemy2.getY() + var4enemy2.getHeight() && var1User.getY() + var1User.getHeight() >= var4enemy2.getY() && var1User.getX() <= var4enemy2.getX() + var4enemy2.getWidth() && var1User.getX() + var1User.getWidth() >= var4enemy2.getX()) {
				 break;
			 }
			 else if (var1User.getY() <= var4enemy3.getY() + var4enemy3.getHeight() && var1User.getY() + var1User.getHeight() >= var4enemy3.getY() && var1User.getX() <= var4enemy3.getX() + var4enemy3.getWidth() && var1User.getX() + var1User.getWidth() >= var4enemy3.getX()) {
				 break;
			 }
//------------------------------------------------------------------------------------------------------------------------------------------------
			 if (var2User.getY() <= var1enemy1.getY() + var1enemy1.getHeight() && var2User.getY() + var2User.getHeight() >= var1enemy1.getY() && var2User.getX() <= var1enemy1.getX() + var1enemy1.getWidth() && var2User.getX() + var2User.getWidth() >= var1enemy1.getX()) {
				 break;
			 }
			 else if (var2User.getY() <= var1enemy2.getY() + var1enemy2.getHeight() && var2User.getY() + var2User.getHeight() >= var1enemy2.getY() && var2User.getX() <= var1enemy2.getX() + var1enemy2.getWidth() && var2User.getX() + var2User.getWidth() >= var1enemy2.getX()) {
				 break;
			 }
			 else if (var2User.getY() <= var1enemy3.getY() + var1enemy3.getHeight() && var2User.getY() + var2User.getHeight() >= var1enemy3.getY() && var2User.getX() <= var1enemy3.getX() + var1enemy3.getWidth() && var2User.getX() + var2User.getWidth() >= var1enemy3.getX()) {
				 break;
			 }
			 
			 if (var2User.getY() <= var2enemy1.getY() + var2enemy1.getHeight() && var2User.getY() + var2User.getHeight() >= var2enemy1.getY() && var2User.getX() <= var2enemy1.getX() + var2enemy1.getWidth() && var2User.getX() + var2User.getWidth() >= var2enemy1.getX()) {
				 break;
			 }
			 else if (var2User.getY() <= var2enemy2.getY() + var2enemy2.getHeight() && var2User.getY() + var2User.getHeight() >= var2enemy2.getY() && var2User.getX() <= var2enemy2.getX() + var2enemy2.getWidth() && var2User.getX() + var2User.getWidth() >= var2enemy2.getX()) {
				 break;
			 }
			 else if (var2User.getY() <= var2enemy3.getY() + var2enemy3.getHeight() && var2User.getY() + var2User.getHeight() >= var2enemy3.getY() && var2User.getX() <= var2enemy3.getX() + var2enemy3.getWidth() && var2User.getX() + var2User.getWidth() >= var2enemy3.getX()) {
				 break;
			 }
			 
			 if (var2User.getY() <= var3enemy1.getY() + var3enemy1.getHeight() && var2User.getY() + var2User.getHeight() >= var3enemy1.getY() && var2User.getX() <= var3enemy1.getX() + var3enemy1.getWidth() && var2User.getX() + var2User.getWidth() >= var3enemy1.getX()) {
				 break;
			 }
			 else if (var2User.getY() <= var3enemy2.getY() + var3enemy2.getHeight() && var2User.getY() + var2User.getHeight() >= var3enemy2.getY() && var2User.getX() <= var3enemy2.getX() + var3enemy2.getWidth() && var2User.getX() + var2User.getWidth() >= var3enemy2.getX()) {
				 break;
			 }
			 else if (var2User.getY() <= var3enemy3.getY() + var3enemy3.getHeight() && var2User.getY() + var2User.getHeight() >= var3enemy3.getY() && var2User.getX() <= var3enemy3.getX() + var3enemy3.getWidth() && var2User.getX() + var2User.getWidth() >= var3enemy3.getX()) {
				 break;
			 }
			 
			 if (var2User.getY() <= var4enemy1.getY() + var4enemy1.getHeight() && var2User.getY() + var2User.getHeight() >= var4enemy1.getY() && var2User.getX() <= var4enemy1.getX() + var4enemy1.getWidth() && var2User.getX() + var2User.getWidth() >= var4enemy1.getX()) {
				 break;
			 }
			 else if (var2User.getY() <= var4enemy2.getY() + var4enemy2.getHeight() && var2User.getY() + var2User.getHeight() >= var4enemy2.getY() && var2User.getX() <= var4enemy2.getX() + var4enemy2.getWidth() && var2User.getX() + var2User.getWidth() >= var4enemy2.getX()) {
				 break;
			 }
			 else if (var2User.getY() <= var4enemy3.getY() + var4enemy3.getHeight() && var2User.getY() + var2User.getHeight() >= var4enemy3.getY() && var2User.getX() <= var4enemy3.getX() + var4enemy3.getWidth() && var2User.getX() + var2User.getWidth() >= var4enemy3.getX()) {
				 break;
			 }
//------------------------------------------------------------------------------------------------------------------------------------------------------
			 if (var3User.getY() <= var1enemy1.getY() + var1enemy1.getHeight() && var3User.getY() + var3User.getHeight() >= var1enemy1.getY() && var3User.getX() <= var1enemy1.getX() + var1enemy1.getWidth() && var3User.getX() + var3User.getWidth() >= var1enemy1.getX()) {
				 break;
			 }
			 else if (var3User.getY() <= var1enemy2.getY() + var1enemy2.getHeight() && var3User.getY() + var3User.getHeight() >= var1enemy2.getY() && var3User.getX() <= var1enemy2.getX() + var1enemy2.getWidth() && var3User.getX() + var3User.getWidth() >= var1enemy2.getX()) {
				 break;
			 }
			 else if (var3User.getY() <= var1enemy3.getY() + var1enemy3.getHeight() && var3User.getY() + var3User.getHeight() >= var1enemy3.getY() && var3User.getX() <= var1enemy3.getX() + var1enemy3.getWidth() && var3User.getX() + var3User.getWidth() >= var1enemy3.getX()) {
				 break;
			 }
			 
			 if (var3User.getY() <= var2enemy1.getY() + var2enemy1.getHeight() && var3User.getY() + var3User.getHeight() >= var2enemy1.getY() && var3User.getX() <= var2enemy1.getX() + var2enemy1.getWidth() && var3User.getX() + var3User.getWidth() >= var2enemy1.getX()) {
				 break;
			 }
			 else if (var3User.getY() <= var2enemy2.getY() + var2enemy2.getHeight() && var3User.getY() + var3User.getHeight() >= var2enemy2.getY() && var3User.getX() <= var2enemy2.getX() + var2enemy2.getWidth() && var3User.getX() + var3User.getWidth() >= var2enemy2.getX()) {
				 break;
			 }
			 else if (var3User.getY() <= var2enemy3.getY() + var2enemy3.getHeight() && var3User.getY() + var3User.getHeight() >= var2enemy3.getY() && var3User.getX() <= var2enemy3.getX() + var2enemy3.getWidth() && var3User.getX() + var3User.getWidth() >= var2enemy3.getX()) {
				 break;
			 }
			 
			 if (var3User.getY() <= var3enemy1.getY() + var3enemy1.getHeight() && var3User.getY() + var3User.getHeight() >= var3enemy1.getY() && var3User.getX() <= var3enemy1.getX() + var3enemy1.getWidth() && var3User.getX() + var3User.getWidth() >= var3enemy1.getX()) {
				 break;
			 }
			 else if (var3User.getY() <= var3enemy2.getY() + var3enemy2.getHeight() && var3User.getY() + var3User.getHeight() >= var3enemy2.getY() && var3User.getX() <= var3enemy2.getX() + var3enemy2.getWidth() && var3User.getX() + var3User.getWidth() >= var3enemy2.getX()) {
				 break;
			 }
			 else if (var3User.getY() <= var3enemy3.getY() + var3enemy3.getHeight() && var3User.getY() + var3User.getHeight() >= var3enemy3.getY() && var3User.getX() <= var3enemy3.getX() + var3enemy3.getWidth() && var3User.getX() + var3User.getWidth() >= var3enemy3.getX()) {
				 break;
			 }
			 
			 if (var3User.getY() <= var4enemy1.getY() + var4enemy1.getHeight() && var3User.getY() + var3User.getHeight() >= var4enemy1.getY() && var3User.getX() <= var4enemy1.getX() + var4enemy1.getWidth() && var3User.getX() + var3User.getWidth() >= var4enemy1.getX()) {
				 break;
			 }
			 else if (var3User.getY() <= var4enemy2.getY() + var4enemy2.getHeight() && var3User.getY() + var3User.getHeight() >= var4enemy2.getY() && var3User.getX() <= var4enemy2.getX() + var4enemy2.getWidth() && var3User.getX() + var3User.getWidth() >= var4enemy2.getX()) {
				 break;
			 }
			 else if (var3User.getY() <= var4enemy3.getY() + var4enemy3.getHeight() && var3User.getY() + var3User.getHeight() >= var4enemy3.getY() && var3User.getX() <= var4enemy3.getX() + var4enemy3.getWidth() && var3User.getX() + var3User.getWidth() >= var4enemy3.getX()) {
				 break;
			 }
//---------------------------------------------------------------------------------------------------------------------------------------------------------------
			 if (var4User.getY() <= var1enemy1.getY() + var1enemy1.getHeight() && var4User.getY() + var4User.getHeight() >= var1enemy1.getY() && var4User.getX() <= var1enemy1.getX() + var1enemy1.getWidth() && var4User.getX() + var4User.getWidth() >= var1enemy1.getX()) {
				 break;
			 }
			 else if (var4User.getY() <= var1enemy2.getY() + var1enemy2.getHeight() && var4User.getY() + var4User.getHeight() >= var1enemy2.getY() && var4User.getX() <= var1enemy2.getX() + var1enemy2.getWidth() && var4User.getX() + var4User.getWidth() >= var1enemy2.getX()) {
				 break;
			 }
			 else if (var4User.getY() <= var1enemy3.getY() + var1enemy3.getHeight() && var4User.getY() + var4User.getHeight() >= var1enemy3.getY() && var4User.getX() <= var1enemy3.getX() + var1enemy3.getWidth() && var4User.getX() + var4User.getWidth() >= var1enemy3.getX()) {
				 break;
			 }
			 
			 if (var4User.getY() <= var2enemy1.getY() + var2enemy1.getHeight() && var4User.getY() + var4User.getHeight() >= var2enemy1.getY() && var4User.getX() <= var2enemy1.getX() + var2enemy1.getWidth() && var4User.getX() + var4User.getWidth() >= var2enemy1.getX()) {
				 break;
			 }
			 else if (var4User.getY() <= var2enemy2.getY() + var2enemy2.getHeight() && var4User.getY() + var4User.getHeight() >= var2enemy2.getY() && var4User.getX() <= var2enemy2.getX() + var2enemy2.getWidth() && var4User.getX() + var4User.getWidth() >= var2enemy2.getX()) {
				 break;
			 }
			 else if (var4User.getY() <= var2enemy3.getY() + var2enemy3.getHeight() && var4User.getY() + var4User.getHeight() >= var2enemy3.getY() && var4User.getX() <= var2enemy3.getX() + var2enemy3.getWidth() && var4User.getX() + var4User.getWidth() >= var2enemy3.getX()) {
				 break;
			 }
			 
			 if (var4User.getY() <= var3enemy1.getY() + var3enemy1.getHeight() && var4User.getY() + var4User.getHeight() >= var3enemy1.getY() && var4User.getX() <= var3enemy1.getX() + var3enemy1.getWidth() && var4User.getX() + var4User.getWidth() >= var3enemy1.getX()) {
				 break;
			 }
			 else if (var4User.getY() <= var3enemy2.getY() + var3enemy2.getHeight() && var4User.getY() + var4User.getHeight() >= var3enemy2.getY() && var4User.getX() <= var3enemy2.getX() + var3enemy2.getWidth() && var4User.getX() + var4User.getWidth() >= var3enemy2.getX()) {
				 break;
			 }
			 else if (var4User.getY() <= var3enemy3.getY() + var3enemy3.getHeight() && var4User.getY() + var4User.getHeight() >= var3enemy3.getY() && var4User.getX() <= var3enemy3.getX() + var3enemy3.getWidth() && var4User.getX() + var4User.getWidth() >= var3enemy3.getX()) {
				 break;
			 }
			 
			 if (var4User.getY() <= var4enemy1.getY() + var4enemy1.getHeight() && var4User.getY() + var4User.getHeight() >= var4enemy1.getY() && var4User.getX() <= var4enemy1.getX() + var4enemy1.getWidth() && var4User.getX() + var4User.getWidth() >= var4enemy1.getX()) {
				 break;
			 }
			 else if (var4User.getY() <= var4enemy2.getY() + var4enemy2.getHeight() && var4User.getY() + var4User.getHeight() >= var4enemy2.getY() && var4User.getX() <= var4enemy2.getX() + var4enemy2.getWidth() && var4User.getX() + var4User.getWidth() >= var4enemy2.getX()) {
				 break;
			 }
			 else if (var4User.getY() <= var4enemy3.getY() + var4enemy3.getHeight() && var4User.getY() + var4User.getHeight() >= var4enemy3.getY() && var4User.getX() <= var4enemy3.getX() + var4enemy3.getWidth() && var4User.getX() + var4User.getWidth() >= var4enemy3.getX()) {
				 break;
			 }
			 pause(3);
		}
//------------------------------------------------------------------------------------------------------------------------------------------------
		livesCounter --;
		String B = Integer.toString(livesCounter);
		if (livesCounter > -1) {
			lives2.setLabel(B);
		}
		else {
			GLabel lost = new GLabel ("GAME OVER", 80,300);
			lost.setFont("Century Gothic-50");
			lost.setColor(Color.WHITE);
			add(lost);
			break;
		}
		speedEnemy = 1.5;
		User.setLocation(175, 450);
		var1User.setLocation(190, 452);
		var2User.setLocation(180, 470);
		var3User.setLocation(175, 555);
		var4User.setLocation(190, 580);

		enemy1.setLocation(25, startEnemy);
		var1enemy1.setLocation(40, startEnemy + 135);
		var2enemy1.setLocation(30, startEnemy + 100);
		var3enemy1.setLocation(25, startEnemy + 12);
		var4enemy1.setLocation(40, startEnemy);

		enemy2.setLocation(175, startEnemy);
		var1enemy2.setLocation(190, startEnemy + 135);
		var2enemy2.setLocation(180, startEnemy + 100);
		var3enemy2.setLocation(175, startEnemy + 12);
		var4enemy2.setLocation(190, startEnemy);

		enemy3.setLocation(125, startEnemy);
		var1enemy3.setLocation(340, startEnemy + 135);
		var2enemy3.setLocation(330, startEnemy + 100);
		var3enemy3.setLocation(325, startEnemy + 12);
		var4enemy3.setLocation(340, startEnemy);
//Modificar HiScore---------------------------------------------------------------------------------------------------------------------------
		int intRecord = Integer.parseInt(Record(textoRecord));
		String n1 = Score1.getLabel() + Score2.getLabel();
		int intScore = Integer.parseInt(n1);

		if (intRecord < intScore) {
			try {
				BufferedWriter fd = new BufferedWriter(new FileWriter(textoRecord));
				fd.write(n1);
				fd.close();
			}
			catch (IOException ex) {
				add(new GLabel("ERROR", 50,50));
			}
			char h = Record(textoRecord).charAt(0);
			String h1 = Character.toString(h);
			char k = Record(textoRecord).charAt(1);
			String k1 = Character.toString(k);

			hiScore1.setLabel(h1);
			hiScore2.setLabel(k1);
		}
		scoreCounterUnd = 0;
		Score1.setLabel("0");
		scoreCounterDec = 0;
		Score2.setLabel("0");
		
		pause(3);
	}
}

	
	public void keyPressed(KeyEvent e) {
		if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
			movimiento = "derecha";
		}
		else if (e.getKeyCode() == KeyEvent.VK_LEFT) {
			movimiento = "izquierda";
		}
		else if (e.getKeyCode() == KeyEvent.VK_UP) {
			movimiento = "up";
		}
		else if (e.getKeyCode() == KeyEvent.VK_DOWN) {
			movimiento = "down";
		}
	}
	public void keyReleased(KeyEvent e1) {
		if (e1.getKeyCode() == KeyEvent.VK_RIGHT) {
			movimiento = "stop";
		}
		else if (e1.getKeyCode() == KeyEvent.VK_LEFT) {
			movimiento = "stop";
		}
		else if (e1.getKeyCode() == KeyEvent.VK_UP) {
			movimiento = "stop";
		}
		else if (e1.getKeyCode() == KeyEvent.VK_DOWN) {
			movimiento = "stop";
		}
	}
}

