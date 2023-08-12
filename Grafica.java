import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Graphics;
import java.awt.Color;

public class Grafica extends JPanel {
	private int centro = 200;
	double[] parteReal;
	double[] parteImag;
	@Override
	public void paint(Graphics g){
		super.paint(g);
		int centroAux = centro;
		int x2 = 0, y2 = 0;
		int numDeRectas = parteReal.length;

		g.setColor(Color.RED);
		//Eje de los Reales
		g.drawLine(1, centro, 399, centro);
		g.drawLine(1, centro + 1, 399, centro + 1);		

		//Creando rectas de las raices
		for(int j = 0; j < numDeRectas; j++){
			x2 = 200 + (int)(parteReal[j] * 60);
			y2 = 200 - (int)(parteImag[j] * 60);
			g.setColor(Color.BLUE);
			g.drawLine(centro, centro, x2, y2);
			g.drawLine(centro+1, centro+1, x2+1, y2+1);
		}

		g.setColor(Color.BLACK);
		//Crea numeros del plano en X
		for(int i = 0; i < 3; i++){
			g.drawLine(centroAux + 60, 195, centroAux + 60, 205);
			centroAux = centroAux + 60;
		}
		centroAux = centro;
		//Crea numero del plano en -x
		for(int i = 0; i < 3; i++){
			g.drawLine(centroAux - 60, 195, centroAux - 60, 205);
			centroAux = centroAux - 60;
		}
		centroAux = centro;
		//Crea numeros del plano en y
		for(int i = 0; i < 3; i++){
			g.drawLine(195, centroAux - 60, 205, centroAux - 60);
			centroAux = centroAux - 60;
		}
		centroAux = centro;
		//Crea numero del plano en -y
		for(int i = 0; i < 3; i++){
			g.drawLine(195, centroAux + 60, 205, centroAux + 60);
			centroAux = centroAux + 60;
		}
		
		g.setColor(Color.RED);
		//Eje de los imaginarios
		g.drawLine(centro, 1, centro, 399);
		g.drawLine(centro + 1, 1, centro + 1, 399);
	}

	public Grafica(double[] parteReal, double[] parteImag){
		JFrame ventana = new JFrame("Ventana");
		this.parteReal = parteReal;
		this.parteImag = parteImag;
		ventana.add(this);
		ventana.setSize(400, 400);
		ventana.setLocationRelativeTo(null);
		ventana.setVisible(true);
		ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}