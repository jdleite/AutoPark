package br.com.carro.bean;


public class Veiculo {
	private int idVeiculo;
	private int idCliente;
	private String tipo;
	private String placa;
	private String marca;
	private String cor;
	
	public Veiculo(){
		
	}
	
	
	public Veiculo(String tipo, String placa,
			String marca, String cor) {
		super();
		this.tipo = tipo;
		this.placa = placa;
		this.marca = marca;
		this.cor = cor;
	}


	public int getIdVeiculo() {
		return idVeiculo;
	}


	public void setIdVeiculo(int idVeiculo) {
		this.idVeiculo = idVeiculo;
	}


	public int getIdCliente() {
		return idCliente;
	}


	public void setIdCliente(int idCliente) {
		this.idCliente = idCliente;
	}


	public String getTipo() {
		return tipo;
	}


	public void setTipo(String tipo) {
		this.tipo = tipo;
	}


	public String getPlaca() {
		return placa;
	}


	public void setPlaca(String placa) {
		this.placa = placa;
	}


	public String getMarca() {
		return marca;
	}


	public void setMarca(String marca) {
		this.marca = marca;
	}


	public String getCor() {
		return cor;
	}


	public void setCor(String cor) {
		this.cor = cor;
	}
	
	
	

}
