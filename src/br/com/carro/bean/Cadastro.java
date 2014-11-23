package br.com.carro.bean;

import java.util.Calendar;


public class Cadastro {
	private Cliente cliente;
	private Calendar dtCadastro;
	
	
	
	public Cadastro(){
		
	}



	public Cadastro(Cliente cliente) {
		super();
		this.cliente = cliente;
	}



	public Cliente getCliente() {
		return cliente;
	}



	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}




	public Calendar getDtCadastro() {
		return dtCadastro;
	}



	public void setDtCadastro(Calendar dtCadastro) {
		this.dtCadastro = dtCadastro;
	}




	
	

}
