package main;

import java.util.ArrayList;
import java.util.Arrays;

public class Espaco2D {
	private ArrayList<Forma> formas;
	
	public Espaco2D() {
		this.formas = new ArrayList<>();
	}
	
	public Espaco2D(Forma... formas) {
		this.formas = new ArrayList<>(Arrays.asList(formas));
	}
	
	public Espaco2D(Espaco2D espaco) {
		this.formas = new ArrayList<>(espaco.formas); //não tem problema só fazer shallow copy pq fiz forma e todas a suas classes filhas imutaveis
	}
	
	//methods
	public boolean addForma(Forma forma) {
		return this.formas.add(forma);
	}
	
	public Forma getForma(int index) {
		return this.formas.get(index);
	}
	
	public Forma removeForma(int index) {
		return this.formas.remove(index);
	}
	
	public boolean removeForma(Forma forma) {
		return this.formas.remove(forma);
	}
	
	public void limparEspaco() {
		this.formas.clear();
	}
	
	
	public double calcularAreaTotal() {
		double area = 0;
		for(Forma forma : this.formas) {
			area += forma.calcularArea();
		}
		return area;
	}
	
	public double calcularPerimetroTotal() {
		double perimetro = 0;
		for(Forma forma : this.formas) {
			perimetro += forma.calcularPerimetro();
		}
		return perimetro;
	}
	
	public Triangulo.Tipo[] tiposTriangulos() {
		Triangulo.Tipo[] tipos = new Triangulo.Tipo[this.formas.size()];
		int i = 0;
		for(Forma forma : this.formas) {
			tipos[i] = null;
			if(forma instanceof Triangulo) {
				
				tipos[i] = ((Triangulo)forma).tipoTriangulo();
			}
			i++;
		}
		return tipos;
	}
	
	public String tiposTriangulosStr() {
		return Arrays.toString(this.tiposTriangulos()).replace("null", "Essa forma não um Triangulo");
	}
	
	@Override
	public String toString() {
		String str = "\n";
		for(Forma f : this.formas) {
			str += f.toString() + "\n";
		}
		return str;
	}
	
}
