package main;

public abstract class Forma {
	//atributes
	private Ponto2D[] pontos;
	
	//constructors
	public Forma(Ponto2D... pontos) {
		this.pontos = pontos;
	}
	
	public Forma(Forma forma) {
		this.pontos = forma.getPontosCopy();
	}
	
	
	//getters
	public Ponto2D getPonto(int index) {
		if(index >= 0 && index < this.pontos.length) {
			return new Ponto2D(this.pontos[index]);
		}
		return null;	
	}
	
	protected Ponto2D[] getPontosRef() {
		return this.pontos;
	}
	
	public Ponto2D[] getPontosCopy() {
		return Ponto2D.copyArr(this.pontos);
	}
	
	//methods
	public abstract double calcularArea();
	public abstract double calcularPerimetro();
	
	
	public static Forma geraForma(Ponto2D... pontos) {
		Forma forma = null;
		if(Circulo.podeGerarUmCirculo(pontos)) {
			forma = new Circulo(pontos);
		}else if(Triangulo.ehUmTringulo(pontos)) {
			forma = new Triangulo(pontos);
		}else if(Quadrado.ehUmQuadrado(pontos)) {
			forma = new Quadrado(pontos);
		}
		return forma;
	}
	
	
	public static boolean doubleSaoIguais(double a, double b) {
		return Math.abs(a - b) < 1e-9;
	}
	
	@Override
	public String toString() {
		String str = "{pontos: [";
		if(this.pontos.length == 0) {
			return  str + "]}";
		}
		str += this.pontos[0].toString();
		for(int i = 1; i < this.pontos.length; i++) {
			str += ", " + this.pontos[i].toString();
		}
		str += "]}";
		return str;
		
	}
	
}
