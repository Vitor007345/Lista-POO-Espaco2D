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
	
	
	//setters
	 void setX(double x) {
		 this.x = x;
	 }
	 void setY(double y) {
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
	
	
}
