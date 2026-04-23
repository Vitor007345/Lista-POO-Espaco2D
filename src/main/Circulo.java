package main;

public class Circulo extends Forma{
	//atributes
	private double raio;
	
	//constructors
	public Circulo(Ponto2D[] pontos) {
		super(new Ponto2D[] {pontos[0]});
		Double raio = calculaRaioSePossivel(pontos);
		if(raio == null)throw new IllegalArgumentException("Esse conjunto de pontos não pode ser convertido em um circulo");
		this.raio = raio;
		
	}
	public Circulo(Ponto2D centro, double raio) {
		super(new Ponto2D[] {centro});
		this.raio = raio;
	}
	
	public Circulo(Circulo circulo) {
		super(circulo);
		this.raio = circulo.raio;
	}
	
	//public static methods
	public static boolean ehUmCirculo(Ponto2D[] pontos) {
		return pontos != null && pontos.length == 1 && Ponto2D.arrayDePontosEhNaoNulo(pontos);
	}
	
	public static boolean podeGerarUmCirculo(Ponto2D[] pontos) {
		return pontos != null && pontos.length == 2 && Ponto2D.arrayDePontosEhNaoNulo(pontos);
	}
	
	public static boolean ehUmCirculo(Forma forma) {
		return ehUmCirculo(forma.getPontosRef());
	}
	//private static methods
	private static Double calculaRaioSePossivel(Ponto2D[] pontos) {
		Double raio = null;
		if(podeGerarUmCirculo(pontos)) {
			raio = pontos[0].calcularDistanciaPontos(pontos[1]);
		}
		return raio;
	}
	
	//normal public methods
	
	public double calcularArea() {
		return this.raio * this.raio * Math.PI;
	}
	public double calcularPerimetro() {
		return 2 * this.raio * Math.PI;
	}
	
}
