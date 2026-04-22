package main;


public class Ponto2D {
	
	//atributos
	private double x;
	private double y;
	
	
	
	//constructors
	public Ponto2D(){
		this(0, 0);
	}
	public Ponto2D(double x, double y) {
		this.setX(x);
		this.setY(y);
	}
	public Ponto2D(Ponto2D ponto) {
		this.setX(ponto.getX());
		this.setY(ponto.getY());
	}
	
	
	//setters
	 public void setX(double x) {
		 this.x = x;
	 }
	 public void setY(double y) {
		 this.y = y;
	 }
		
	//getters
	double getX() {return this.x;}
	double getY() {return this.y;}
	
	//methods
	double calcularDistanciaPontos(Ponto2D ponto) {
		return Math.sqrt(Math.pow(ponto.getX() - this.getX(), 2) + Math.pow(ponto.getY() - this.getY(), 2));
	}
	
	@Override
	public String toString() {
		return "(" + this.getX() + ", " + this.getY() + ")";
	}
	
	public static boolean arrayDePontosEhNaoNulo(Ponto2D[] pontos) {
		boolean pontosValidos = false;
		if(pontos != null) {
			pontosValidos = true;
			for(int i = 0; i < pontos.length && pontosValidos; i++) {
				if(pontos[i] == null) pontosValidos = false;
			}
		}
		return pontosValidos;
	}
	public static Ponto2D[] copyArr(Ponto2D[] pontos) {
		Ponto2D[] copy = null;
		if(pontos != null) {
			copy = new Ponto2D[pontos.length];
			for(int i = 0; i < pontos.length; i++) {
				copy[i] = new Ponto2D(pontos[i]);
			}
		}
		return copy;
	}
	
}
