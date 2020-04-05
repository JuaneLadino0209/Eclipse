import acm.program.GraphicsProgram;
import java.awt.Color;
import java.awt.event.MouseEvent;

import acm.graphics.*;

public class Buscaminas extends GraphicsProgram {
	private static final long serialVersionUID = 1L;
	public static int Size_W = 35;
	public static int Size_H = 35;
	GObject seleccionado;
	GPoint selected;
	GRect Tablero = new GRect(0, 0, Size_W*10, Size_H);
	Contenido cont = new Contenido();
	int [][] array = cont.Armar();
	GRect cuadpunt = new GRect(Size_W*16/5, Size_H/6, 150, 25);
	int bombs = 36;
	GLabel bombas = new GLabel(bombs+"", (Size_W*16/5)+70, (Size_H/6)+20);
	int marked = 0;
	public void BuildMap() {
		for (int i = 1; i <= 18; i++) {
			for (int j = 0; j < 10; j++) {
				GRect cuad = new GRect(j*Size_W, i*Size_H, Size_W, Size_H);
				GLabel label = new GLabel(array[j][i-1]+"", j*Size_W+10, (i+1)*Size_H-(Size_H/2)+5);
				switch (array[j][i-1]) {
				case 0:
					label.setLabel("");
					break;
				case 1:
					label.setColor(Color.CYAN);
					break;
				case 2:
					label.setColor(Color.GREEN);
					break;
				case 3:
					label.setColor(Color.MAGENTA);
					break;
				case 4:
					label.setColor(Color.BLUE);
					break;
				case 5:
					label.setColor(Color.ORANGE);
					break;
				case 6:
					label.setColor(Color.WHITE);
					break;
				case 7:
					label.setColor(Color.YELLOW);
					break;
				case 8:
					label.setColor(Color.PINK);
					break;
				case 9:
					label.setColor(Color.RED);
					break;
				}
				label.setFont("OCRAExtendet-bold-20");
				add(label);
				cuad.setFillColor(Color.GRAY);
				cuad.setFilled(true);
				cuad.addMouseListener(this);
				add(cuad);
			}
		}
	}
	public void init() {
		setSize(Size_W*10+2, Size_H*19+2);
		setBackground(Color.LIGHT_GRAY);
		Tablero.setFillColor(Color.LIGHT_GRAY);
		Tablero.setFilled(true);
		cuadpunt.setFilled(true);
		bombas.setFont("OCRAExtendet-bold-20");
		bombas.setColor(Color.RED);
		BuildMap();
		add(Tablero);
		add(cuadpunt);
		add(bombas);
	}
	public void mouseClicked (MouseEvent e) {
		selected = new GPoint(e.getPoint());
		seleccionado = getElementAt(selected);
		if (e.getButton() == 1) {
			if ((seleccionado != null) && (seleccionado != Tablero) && (seleccionado != cuadpunt) && (seleccionado != bombas) && !(seleccionado.getClass().equals(GLabel.class))) {
				if(((GRect) seleccionado).getFillColor().equals(Color.GRAY)) {
					remove(seleccionado);
					if (array[(int) (seleccionado.getX()/Size_W)][(int) ((seleccionado.getY()/Size_H)-1)] == 9) {
						for (int i = 1; i <= 18; i++) {
							for (int j = 0; j < 10; j++) {
								GObject element = getElementAt(j*Size_W, i*Size_H);
								if (element != null) {
									if (((GRect) element).getFillColor().equals(Color.GRAY)){
										remove(element);
									}
									else if (((GRect) element).getFillColor().equals(Color.BLACK)) {
										if ((array[j][i-1] != 9)) {
											((GRect) element).setFillColor(Color.RED);
										}
									}
								}
								
							}
						}
						bombas.setLabel("Perdiste");
						bombas.move(-30, 0);
					}
				}
			}
		}
		else if (e.getButton() == 3) {
			if ((seleccionado != null) && (seleccionado != Tablero) && (seleccionado != cuadpunt) && (seleccionado != bombas) && !(seleccionado.getClass().equals(GLabel.class))) {
				if (((GRect) seleccionado).getFillColor().equals(Color.GRAY) && (bombs >= 1)) {
					double X = seleccionado.getLocation().getX();
					double Y = seleccionado.getLocation().getY();
					GRect indicador = new GRect(X, Y, Size_W, Size_H);
					indicador.setFilled(true);
					add(indicador);
					bombs --;
					bombas.setLabel(bombs+"");
					if (array[(int) X/Size_W][(int) (Y/Size_H)-1] == 9) {
						marked ++;
					}
				}
				else if (((GRect) seleccionado).getFillColor().equals(Color.BLACK)) {
					remove(seleccionado);
					bombs ++;
					bombas.setLabel(bombs+"");
					if (array[(int) seleccionado.getLocation().getX()/Size_W][(int) (seleccionado.getLocation().getY()/Size_H)-1] == 9) {
						marked --;
					}
				}
			}
			if (marked == 36) {
				for (int i = 1; i <= 18; i++) {
					for (int j = 0; j < 10; j++) {
						GObject element = getElementAt(j*Size_W, i*Size_H);
						if (element != null) {
							if (((GRect) element).getFillColor().equals(Color.GRAY)){
								remove(element);
							}
						}
					}
				}
				bombas.setLabel("Ganaste");
				bombas.move(-30, 0);
			}
		}
	}
}