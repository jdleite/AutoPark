package br.com.carro.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import br.com.carro.bean.Cliente;
import br.com.carro.bean.Veiculo;
import br.com.carro.conexao.ConexaoFactory;

public class ClienteDao {
	private Connection conexao = ConexaoFactory.getConnection();
	
	public void fechar(){
		ConexaoFactory.fechar(conexao);
	}
	
	/*cadasta o cliente no banco de dados*/
	public void cadastrarCliente(Cliente cliente,Veiculo vei,Connection con) throws SQLException{
		String sql = "INSERT INTO T_ESTACI_CLIENTE (ID_CLIENTE,NOME,DT_NASCIMENTO,SEXO) VALUES (SQ_CLIENTE.NEXTVAL,?,?,?)";
	   try{
		   con.setAutoCommit(false);
		   PreparedStatement stmtCliente = con.prepareStatement(sql);
		   stmtCliente.setString(1,cliente.getNome());
		   stmtCliente.setDate(2, new Date(cliente.getDt_Nascimento().getTimeInMillis()));		   
		   stmtCliente.setString(3, cliente.getSexo());
		   stmtCliente.execute();
		   con.commit();
		   stmtCliente.close();
		   con.setAutoCommit(true);
		   
		   	
	   }catch(SQLException e){
		   /*faz com que os dados volte ao que era, antes do cadastro*/
		   con.rollback();
		   fechar();
	   }
	

	}
}