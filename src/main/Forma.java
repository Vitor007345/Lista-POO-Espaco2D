package main;

public abstract class Forma {
	//atributes
	private Ponto2D[] pontos;
	
	//constructors
	public Forma(Ponto2D[] pontos) {
		this.pontos = pontos;
	}
	
	public Forma(Forma forma) {
		this.pontos = Ponto2D.copyArr(forma.pontos);
	}
	
	
	//getters
	public Ponto2D getPonto(int index) {
		if(index >= 0 && index < this.pontos.length) {
			return new Ponto2D(this.pontos[index]);
		}
		return null;	
	}
	
	//methods
	public abstract double calcularArea();
	public abstract double calcularPerimetro();
	
	/*
	public static Forma geraForma(Ponto2D[] pontos) {
		return null;
	}
	*/
	
}
