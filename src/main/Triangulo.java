package main;


public class Triangulo extends Forma{
	
	public enum Tipo {
		EQUILATERO,
		ISOSCELES,
		ESCALENO;
		
		private static final String[] tiposStr = {"Equilátero", "Isósceles", "Escaleno"};
		
		@Override
		public String toString() {
			return Tipo.tiposStr[this.ordinal()];
		}
		
	}
	
	//constructors
	public Triangulo(Ponto2D[] pontos) {
		super(pontos);
		if(!Triangulo.ehUmTringulo(pontos)) {
			throw new IllegalArgumentException("Os pontos passados não são um triangulo");
		}
	}
	public Triangulo(Triangulo triangulo) {
		super(triangulo);
	}
	
	//methods
	public static boolean ehUmTringulo(Ponto2D[] pontos) {
		boolean ehTriangulo = false;
		if(pontos !=  null && pontos.length == 3 && Ponto2D.arrayDePontosEhNaoNulo(pontos)) {
			double lado1 = pontos[0].calcularDistanciaPontos(pontos[1]);
			double lado2 = pontos[1].calcularDistanciaPontos(pontos[2]);
			double lado3 = pontos[2].calcularDistanciaPontos(pontos[0]);
			if((lado1 + lado2 > lado3) && (lado1 + lado3 > lado2) && (lado2 + lado3 > lado1)) {
				ehTriangulo = true;
			}
		}
		return ehTriangulo;
	}
	public static boolean ehUmTringulo(Forma forma) {
		return ehUmTringulo(forma.getPontosRef());
	}
	
	@Override
	public double calcularArea() {
		double lado1 = this.getPonto(0).calcularDistanciaPontos(this.getPonto(1));
		double lado2 = this.getPonto(1).calcularDistanciaPontos(this.getPonto(2));
		double lado3 = this.getPonto(2).calcularDistanciaPontos(this.getPonto(0));
		double sp = (lado1 + lado2 + lado3)/2;
		return Math.sqrt(sp*(sp - lado1)*(sp - lado2)*(sp - lado3));	
	}
	
	@Override
	public double calcularPerimetro() {
		double lado1 = this.getPonto(0).calcularDistanciaPontos(this.getPonto(1));
		double lado2 = this.getPonto(1).calcularDistanciaPontos(this.getPonto(2));
		double lado3 = this.getPonto(2).calcularDistanciaPontos(this.getPonto(0));
		return lado1 + lado2 + lado3;
	}
	
	public Tipo tipoTriangulo() {
		double lado1 = this.getPonto(0).calcularDistanciaPontos(this.getPonto(1));
		double lado2 = this.getPonto(1).calcularDistanciaPontos(this.getPonto(2));
		double lado3 = this.getPonto(2).calcularDistanciaPontos(this.getPonto(0));
		
		if(lado1 == lado2 && lado2 == lado3) return Tipo.EQUILATERO;
		if((lado1 == lado2) || (lado1 ==  lado3) || (lado2 == lado3)) return Tipo.ISOSCELES;
		return Tipo.ESCALENO;
	}
}
