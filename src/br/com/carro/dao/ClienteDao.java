package br.com.carro.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.carro.bean.Cliente;
import br.com.carro.bean.Veiculo;
import br.com.carro.conexao.ConexaoFactory;

public class ClienteDao {
	private Connection conexao = ConexaoFactory.getConnection();
	
	public void fechar(){
		ConexaoFactory.fechar(conexao);
	}
	
	/*cadasta o cliente no banco de dados*/
	public void cadastrarCliente(Cliente cliente,Connection con) throws SQLException{
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
	
	public int buscarCodigo()throws SQLException{
		int id = 0;
		PreparedStatement estruturaFornecedor = 
				this.conexao.prepareStatement("select ID_CLIENTE from T_ESTACI_CLIENTE");
		ResultSet resultadoDados = estruturaFornecedor.executeQuery();
		   
		Cliente cli = new Cliente();
			while(resultadoDados.next()){
			 cli.setId_Cliente(resultadoDados.getInt("id_cliente"));			 
			 
			}		
			 id = cli.getId_Cliente();
			resultadoDados.close();
			estruturaFornecedor.close();
		
			
			
		

		return id;
		
	}
}