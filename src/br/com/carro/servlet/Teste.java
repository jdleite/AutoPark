package br.com.carro.servlet;

import java.sql.Connection;
import java.util.Calendar;

import br.com.carro.bean.Cliente;
import br.com.carro.bean.Veiculo;
import br.com.carro.bo.ClienteBo;
import br.com.carro.conexao.ConexaoFactory;

public class Teste {
	public static void main(String[] args) {
		
		Cliente cli = new Cliente();
		Veiculo vei = new Veiculo();
	    ClienteBo bo = new ClienteBo();
		Connection con = ConexaoFactory.getConnection();
		try{
	
			cli.setNome("asd ");
			cli.setDt_Nascimento(Calendar.getInstance());
		    Calendar c = Calendar.getInstance();
		    String dtCadastro = "10/07/2010";
		    int dia = Integer.parseInt(dtCadastro.substring(0,2));
		    int mes = Integer.parseInt(dtCadastro.substring(3,5));
		    int ano = Integer.parseInt(dtCadastro.substring(6,10));
		    c.set(ano, (mes - 1),dia);
			cli.setDt_Nascimento(c);
			cli.setSexo("m");
			vei.setTipo("Carro");
			vei.setCor("Azul");
			vei.setPlaca("cpd0376");
			vei.setMarca("Volks");
			
			bo.gravar(cli,vei, con);
			System.out.println("Clinte gravado");
			
		}catch(Exception e){
			e.printStackTrace();
		}
			
			
			
			
			
		
		
	}

}
