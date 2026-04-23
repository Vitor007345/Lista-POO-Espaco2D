package main;

public class Quadrado extends Forma{
	//atributes
	private double lado;
	
	//constructors
	public Quadrado(Ponto2D[] pontos) {
		super(pontos);
		Double lado = calculaLadoSeForQuadrado(pontos);
		if(lado == null)throw new IllegalArgumentException("Os pontos passados não são um quadrado");
		this.lado = lado;
	}
	
	public Quadrado(Quadrado quadrado) {
		super(quadrado);
		this.lado = quadrado.lado;
	}
	
	//getters
	public double getLado() {
		return this.lado;
	}
	
	//private static methods
	private static double[] calculaDistancias(Ponto2D[] pontos) {
		double[] distancias = new double[6];
		int k = 0;
		for(int i = 0; i < 4; i++) {
			for(int j = i + 1; j < 4; j++) {
				distancias[k++] = pontos[i].calcularDistanciaPontos(pontos[j]);
			}
		}
		return distancias;
	}
	
	private static double[] calculaMinMaxDistancias(double[] distancias) {
		double min = distancias[0]; //possivel lado
		double max= distancias[0]; //possivel diagonal
		for(int i = 1; i < 6; i++) {
			final double dist = distancias[i];
			if(dist < min)min = dist;
			if(dist > max)max = dist;
		}
		return new double[] {min, max};
	}
	
	private static boolean ehUmQuadrado(double[] minMax, double[] distancias) {
		boolean ehQuadrado = false;
		double min = minMax[0];
		double max = minMax[1];
		
		if(!Forma.doubleSaoIguais(min, max)) {
			int countMin = 0;
			int countMax = 0;
			
			ehQuadrado = true;
			for(int i = 0; i < 6 && ehQuadrado; i++) {
				final double dist = distancias[i];
				if(Forma.doubleSaoIguais(dist, min)) countMin++;
				else if(Forma.doubleSaoIguais(dist, max)) countMax++;
				else ehQuadrado = false;
			}
			if(ehQuadrado && (countMin != 4 || countMax != 2)) ehQuadrado = false;
		}
		return ehQuadrado;
	}
	
	private static boolean ehUmQuadrado(double[] distancias) {
		return ehUmQuadrado(calculaMinMaxDistancias(distancias), distancias);
	}
	
	private static Double calculaLadoSeForQuadrado(Ponto2D[] pontos) {
		Double lado = null;
		if(pontos !=  null && pontos.length == 4 && Ponto2D.arrayDePontosEhNaoNulo(pontos)) {
			double[] distancias = calculaDistancias(pontos);
			double[] minMax = calculaMinMaxDistancias(distancias);
			if(ehUmQuadrado(minMax, distancias)) {
				lado = minMax[0];
			}
		}
		return lado;
		
	}
	
	//public static methods
	public static boolean ehUmQuadrado(Ponto2D[] pontos) {
		boolean ehQuadrado = false;
		if(pontos !=  null && pontos.length == 4 && Ponto2D.arrayDePontosEhNaoNulo(pontos)) {
			double[] distancias = calculaDistancias(pontos);
			
			ehQuadrado = ehUmQuadrado(distancias);
			
		}
		return ehQuadrado;
	}
	public static boolean ehUmQuadrado(Forma forma) {
		return ehUmQuadrado(forma.getPontosRef());
	}
	
	
	//normal public methods
	public double calcularArea() {
		return this.lado * this.lado;
	}
	public double calcularPerimetro() {
		return this.lado * 4;
	}
	
	
	
}