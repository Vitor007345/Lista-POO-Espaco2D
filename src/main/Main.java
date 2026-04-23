package main;


public class Main {
	
	public static void main(String[] args) {
		
		Espaco2D espaco2D = new Espaco2D();
		Quadrado q = new Quadrado(new Ponto2D(0,0), new Ponto2D(1,1), new Ponto2D(0,1), new Ponto2D(1, 0));
		Triangulo tIsosceles = new Triangulo(new Ponto2D(0,0), new Ponto2D(2,2), new Ponto2D(0,2));
		Triangulo tEquilatero = new Triangulo(new Ponto2D(0,0), new Ponto2D(2,0), new Ponto2D(1, Math.sqrt(3)));
		Triangulo tEscaleno = new Triangulo(new Ponto2D(0,0), new Ponto2D(4,0), new Ponto2D(1, 2));
		Circulo c = new Circulo(new Ponto2D(3, 2), new Ponto2D(4, 7));
		
		espaco2D.addForma(q);
		espaco2D.addForma(tIsosceles);
		espaco2D.addForma(tEquilatero);
		espaco2D.addForma(tEscaleno);
		espaco2D.addForma(c);
		
		System.out.println("Espaco1:");
		System.out.println(espaco2D);
		System.out.println("Tipos de triangulo: " + espaco2D.tiposTriangulosStr());
		System.out.println("Area total: " + espaco2D.calcularAreaTotal() + " Perimetro total: " + espaco2D.calcularPerimetroTotal());
		
		
		Espaco2D espaco2Dv2 = new Espaco2D();
		espaco2Dv2.addForma(Forma.geraForma(new Ponto2D(0,0), new Ponto2D(1,1), new Ponto2D(0,1), new Ponto2D(1, 0)));
		espaco2Dv2.addForma(Forma.geraForma(new Ponto2D(0,0), new Ponto2D(2,2), new Ponto2D(0,2)));
		espaco2Dv2.addForma(Forma.geraForma(new Ponto2D(0,0), new Ponto2D(2,0), new Ponto2D(1, Math.sqrt(3))));
		espaco2Dv2.addForma(Forma.geraForma(new Ponto2D(0,0), new Ponto2D(4,0), new Ponto2D(1, 2)));
		espaco2Dv2.addForma(Forma.geraForma(new Ponto2D(3, 2), new Ponto2D(4, 7)));
		
		System.out.println("\n\nEspaco2:");
		System.out.println(espaco2Dv2);
		System.out.println("Tipos de triangulo: " + espaco2Dv2.tiposTriangulosStr());
		System.out.println("Area total: " + espaco2Dv2.calcularAreaTotal() + " Perimetro total: " + espaco2Dv2.calcularPerimetroTotal());
		
		
	}

}
