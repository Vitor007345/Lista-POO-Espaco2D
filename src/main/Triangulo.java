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
	public Triangulo(Ponto2D... pontos) {
		super(pontos);
		if(!Triangulo.ehUmTringulo(pontos)) {
			throw new IllegalArgumentException("Os pontos passados não são um triangulo");
		}
	}
	public Triangulo(Triangulo triangulo) {
		super(triangulo);
	}
	
	//getters
	public double[] getLados() {
		double lado0 = this.getPonto(0).calcularDistanciaPontos(this.getPonto(1));
		double lado1 = this.getPonto(1).calcularDistanciaPontos(this.getPonto(2));
		double lado2 = this.getPonto(2).calcularDistanciaPontos(this.getPonto(0));
		return new double[] {lado0, lado1, lado2};
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
		double[] lados = this.getLados();
		double sp = (lados[0] + lados[1] + lados[2])/2;
		return Math.sqrt(sp*(sp - lados[0])*(sp - lados[1])*(sp - lados[2]));	
	}
	
	@Override
	public double calcularPerimetro() {
		double[] lados = this.getLados();
		return lados[0] + lados[1] + lados[2];
	}
	
	public Tipo tipoTriangulo() {
		double[] lados = this.getLados();
		boolean ab = Forma.doubleSaoIguais(lados[0], lados[1]);
		boolean bc = Forma.doubleSaoIguais(lados[1], lados[2]);
		if(ab && bc) return Tipo.EQUILATERO;
		if(ab || bc || Forma.doubleSaoIguais(lados[0], lados[2])/*ac*/) return Tipo.ISOSCELES;
		return Tipo.ESCALENO;
	}
}
