import acm.program.*;
import acm.graphics.*;
import java.awt.*;

public class AnalogClock extends GraphicsProgram {
	private static final long serialVersionUID = 1L;
	
	GOval framework2 = new GOval (45,45,160,160);
	GOval framework3 = new GOval (40,40,170,170);
	
	GOval mainFramework = new GOval (50,50,150,150);
		double radius = mainFramework.getWidth() / 2;
		double radiusHours = radius / 5;
		double centerH = mainFramework.getX() + mainFramework.getWidth() - radius; //Centro del circulo (h,k)
		double centerK = mainFramework.getY() + mainFramework.getHeight() - radius;
		
		double X = mainFramework.getX() + radius;
		double Y = mainFramework.getY();
		double yHours = mainFramework.getY() + radiusHours;
//----------------------------------------------------------------------------------------------------------------
	GOval framework21 = new GOval (mainFramework.getX() - (mainFramework.getX() * 0.1), mainFramework.getY() - (mainFramework.getY() * 0.1), mainFramework.getWidth() + (mainFramework.getWidth() * 0.06666), mainFramework.getHeight() + (mainFramework.getHeight() * 0.06666));
	GOval framework31 = new GOval (mainFramework.getX() - (mainFramework.getX() * 0.2), mainFramework.getY() - (mainFramework.getY() * 0.2), mainFramework.getWidth() + (mainFramework.getWidth() * 0.13333), mainFramework.getHeight() + (mainFramework.getHeight() * 0.13333));
//-------------------------------------------------------------------------------://Bolita del centro (estetica)
		double less = radius / 25; //parametro de resta en Xeje y Yeje
		double widthEje = less * 2;
		double Xeje = centerH - less;
		double Yeje = centerK - less;												
		
	GOval eje = new GOval (Xeje,Yeje,widthEje,widthEje);
	//---------------------------------------------------------------------------: punteros
	GLine seconds = new GLine (centerH,centerK,X,Y);
	GLine minutes = new GLine (centerH,centerK,X,Y);
	GLine hours = new GLine (centerH,centerK,X,yHours);

//---------------------------------------------------------------------------------:clases principales movimiento de los punteros,
	public GPoint moveSeconds (double Teta, double Alfa, double Hypo) {
		double sinAlfa = GMath.sinDegrees(Alfa);
		double sinTeta = GMath.sinDegrees(Teta);
		double sin90 = GMath.sinDegrees(90);
		double varY = (sinAlfa * Hypo) / sin90;
		double Y2 = Y + radius - varY;
		double varX = (sinTeta * Hypo) / sin90;
		double X2 = X + varX;
		GPoint puntoSec = new GPoint (X2,Y2);
	return (puntoSec);
	}
	
	public void secondsPointer (int sec) {
		double h = 0;
		double k = 90;
		double Hypo = radius;
		while(true) {
			add(seconds);
			seconds.setColor(Color.GREEN);
			double X = moveSeconds(h,k,Hypo).getX();
			double Y = moveSeconds(h,k,Hypo).getY();
			seconds.setEndPoint(X,Y);
			pause(sec);
			h = h + 6;
			k = k - 6;	
			if (h == 360) {
				break;
			}
		}
	}
																							
	public void minutesPointer (double h1, double k1) {
			add(minutes);
			minutes.setColor(Color.GREEN);
			h1 = h1 + 6;
			k1 = k1 - 6;
			double Hypo = radius;
			double X = moveSeconds(h1,k1,Hypo).getX();
			double Y = moveSeconds(h1,k1,Hypo).getY();
			minutes.setEndPoint(X,Y);	
	}
	
	public void hourPointer (double h2, double k2) { 
			add(hours);
			hours.setColor(Color.GREEN);
			h2 = h2 + 30;
			k2 = k2 - 30;
			double HypoHours = radiusHours * 4;
			double X = moveSeconds(h2,k2,HypoHours).getX();
			double Y = moveSeconds(h2,k2,HypoHours).getY();
			hours.setEndPoint(X,Y);
		}
//----------------------------------------------------------------------------------------------------------
	int sec = 10;
	double h1 = 0;
	double k1 = 90;
	double h2 = 0;
	double k2 = 90;
	int contador = 0;
//-------------------------------------------------------------------------------------------:Ejecucion
	public void run () {
		setBackground(Color.BLACK);
		add(mainFramework);
		mainFramework.setVisible(false);
		
		add(framework3);
		framework3.setColor(Color.GREEN);
		framework3.setFilled(true);
		framework3.setFillColor(Color.GREEN);
		add(framework2);
		framework2.setColor(Color.GREEN);
		framework2.sendToFront();
		framework2.setFilled(true);
		framework2.setFillColor(Color.BLACK);
		add(eje);
		eje.setFilled(true);
		eje.setFillColor(Color.GREEN);
		eje.sendToFront();
		add(minutes);
		minutes.setColor(Color.GREEN);
		add(hours);
		hours.setColor(Color.GREEN);
		while(true) {
			secondsPointer(sec);
			remove(minutes);
			h1 = h1 + 6;
			k1 = k1 - 6;
			minutesPointer(h1,k1);
			contador ++;
			if (contador == 59) {
				remove(hours);
				hourPointer(h2,k2);
				h2 = h2 + 30;
				k2 = k2 - 30;
				contador = -1;
			}
		}
	}
}