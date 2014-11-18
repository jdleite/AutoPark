package br.com.carro.bean;

import java.util.Calendar;

public class Cliente {
	private int id_Cliente;
	private String nome;
	private Calendar dt_Nascimento;
	private String sexo;
	private Veiculo veiculo;
	public Cliente(){
		
	}
	public Cliente(String nome, Calendar dt_Nascimento,
			String sexo, Veiculo veiculo) {
		super();
		this.nome = nome;
		this.dt_Nascimento = dt_Nascimento;
		this.sexo = sexo;
		this.veiculo = veiculo;
	}
	public int getId_Cliente() {
		return id_Cliente;
	}
	public void setId_Cliente(int id_Cliente) {
		this.id_Cliente = id_Cliente;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public Calendar getDt_Nascimento() {
		return dt_Nascimento;
	}
	public void setDt_Nascimento(Calendar dt_Nascimento) {
		this.dt_Nascimento = dt_Nascimento;
	}
	public String getSexo() {
		return sexo;
	}
	public void setSexo(String sexo) {
		this.sexo = sexo;
	}
	public Veiculo getVeiculo() {
		return veiculo;
	}
	public void setVeiculo(Veiculo veiculo) {
		this.veiculo = veiculo;
	}
	
	
}