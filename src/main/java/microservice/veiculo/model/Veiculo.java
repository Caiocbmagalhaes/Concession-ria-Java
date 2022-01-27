package microservice.veiculo.model;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="VEICULO_CONCESSIONARIA")
public class Veiculo {
	
	private String marca;
	
	private String modelo; 
	
	private String cor;
	
	private double valor;
	
	private int ano;

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public String getCor() {
		return cor;
	}

	public void setCor(String cor) {
		this.cor = cor;
	}

	public double getValor() {
		return valor;
	}

	public void setValor(double valor) {
		this.valor = valor;
	}

	public int getAno() {
		return ano;
	}

	public void setAno(int ano) {
		this.ano = ano;
	}

	@Override
	public String toString() {
		return "Veiculo [marca=" + marca + ", modelo=" + modelo + ", cor=" + cor + ", valor=" + valor + ", ano=" + ano
				+ "]";
	} 
}