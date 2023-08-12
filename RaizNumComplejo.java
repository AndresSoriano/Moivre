import java.lang.Math;
import java.util.Scanner;

public class RaizNumComplejo{

	public static void main (String [] args){
		Scanner scan = new Scanner(System.in);
		System.out.println("Ingresa Datos");
		System.out.println("a = ");
		//Obtenmos la parte real
		int a = scan.nextInt();
		System.out.println("b = ");
		//Obtenemos la parte imaginaria
		int b = scan.nextInt();
		System.out.println("raiz = ");
		//Obtenemos la cantidad de raices
		int raiz = scan.nextInt();

		//Comienza el procedimiento de la formula de Moivre
		procedimientoMoivre(raiz, a, b);
		
	}
	
	/*Método donde se realiza la logica de las operaciones para la formula de Moivre
	y así obtener las raices n-esimas de un numero complejo.*/
	public static void procedimientoMoivre(int raiz, int real, int imagin){
		double a= real, b = imagin;
		double mod, ang, raizN;
		double[] parteReal = new double[raiz];
		double[] parteImag = new double[raiz];

		mod = obtenModulo(a, b);
		ang = obtenTheta(a, b);
		raizN = obtenRaizN(mod, raiz);

		/*ciclo en el que se haran las operaciones para la cantidad de raices solicitadas,
		es decir, las raices n-esimas*/
		for(int i = 0; i < raiz; i++){
			double grados = obtenGrados(i);
			double argumento = obtenArgumento(ang, grados, raiz);
			System.out.println("z"+i+" = ("+raizN+")*[Cos(("+ang+" + "+grados+"/"+raiz+")) + iSen(("+ang+" + "+grados+"/"+raiz+"))]\n");
			double resCos = obtenCoseno(argumento);
			double resSen = obtenSeno(argumento);
			
			parteReal[i] = resultadoReal(raizN, resCos);
			parteImag[i] = resultadoImag(raizN, resSen);
			System.out.println("Z"+i+" = "+ parteReal[i] + "+ i(" + parteImag[i] +")\n\n");
		}
		Grafica g = new Grafica(parteReal, parteImag);
	}

	/*Para obtener el módulo de nuestro numero complejo
	*La raiz cuadrada del cuadrado de la parte real "a" más el cuadrado de la parte imaginaria "b"*/
	public static double obtenModulo(double a, double b){
		return Math.sqrt( Math.pow(a, 2) + Math.pow(b, 2) );
	}

	/*Para obtener el angulo "Theta" de nuestro numero complejo
	*Para esto hacemos la siguiente operación:
	*Theta = ArcTang(b / a)*/
	public static double obtenTheta(double a, double b){
		return Math.toDegrees(Math.atan( b / a ));
	}
	
	/*Obtenemos la raiz n-esima del modulo de nuestro numero complejo
	*Este numero se multiplicara con otros dos resultados para obtener nuestras reaices*/
	public static double obtenRaizN(double mod, double raiz){
		double poten = 1.0/raiz;
		return Math.pow(mod, poten);
	}

	/*Para la formula de Moivre necesitamos obtener los grados, esto con la siguientes operaciones
	* (2)*(pi)*(k)*, esto para k = 0, 1, 2, ..., n, y pi=180*/
	public static int obtenGrados(int k){
		return 180*(2*k);
	}
	
	/*Obtenemos el argumento que sera usado por las funciones de cos() y sen() en la funcion de Moivre
	*Este argumento se obtiene de la sig. manera:  (Tetha + ( 2 * pi * k)) / k, siendo k el valor dela raiz solicitada*/
	public static double obtenArgumento(double theta, double angulo, int raiz){
		return (theta + angulo)/raiz;
	}

	/*Método con el cual obtenemos el resultado de la siguiente operación:
	*cos((Tetha + ( 2 * pi * k)) / k)*/
	public static double obtenCoseno(double argumento){
		return Math.cos(Math.toRadians(argumento));
	}

	/*Método con el cual obtenemos el resultado de la siguiente operación:
	*sen((Tetha + ( 2 * pi * k)) / k)*/
	public static double obtenSeno(double argumento){
		return Math.sin(Math.toRadians(argumento));
	}
	
	/*En este realizamos la operación para obtener la parte real de la raiz de nuestro numero complejo
	*esto de la sig forma: (Raiz n-esima del modulo)*(cos((Tetha + ( 2 * pi * k)) / k))*/
	public static double resultadoReal(double raizR, double resCos){
		return raizR*resCos;
	}

	/*En este realizamos la operación para obtener la parte imaginaria de la raiz de nuestro numero complejo
	*esto de la sig forma: (Raiz n-esima del modulo)*(sen((Tetha + ( 2 * pi * k)) / k))*/
	public static double resultadoImag(double raizR, double resSen){
		return raizR*resSen;
	}

}