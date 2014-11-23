package br.com.carro.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import br.com.carro.bean.Cadastro;
import br.com.carro.bean.Cliente;
import br.com.carro.conexao.ConexaoFactory;

public class ClienteDao {
	private Connection conexao = ConexaoFactory.getConnection();
	
	public void fechar(){
		ConexaoFactory.fechar(conexao);
	}
	
	/*cadasta o cliente no banco de dados*/
	public void cadastrarCliente(Cadastro cadastro,Connection con) throws SQLException{
		String sql = "INSERT INTO T_ESTACI_CLIENTE (ID_CLIENTE,NOME,DT_NASCIMENTO,SEXO) VALUES (SQ_CLIENTE.NEXTVAL,?,?,?)";
			
	   try{
		   con.setAutoCommit(false);
		   PreparedStatement stmtCadastro = con.prepareStatement(sql);
		   stmtCadastro.setString(1,cadastro.getCliente().getNome());
		   stmtCadastro.setDate(2, new Date(cadastro.getCliente().getDt_Nascimento().getTimeInMillis()));		   
		   stmtCadastro.setString(3, cadastro.getCliente().getSexo());		   
		   stmtCadastro.execute();
		   con.commit();
		   stmtCadastro.close();
		   con.setAutoCommit(true);		   	
	   }catch(SQLException e){
		   con.rollback();
		   fechar();
	   }
	   sql = "INSERT INTO T_ESTACI_VEICULO(ID_VEICULO,ID_CLIENTE,TIPO,PLACA,MARCA,COR)VALUES"+
       "(SQ_VEICULO.NEXTVAL,?,?,?,?,?)";
	   try{
		   con.setAutoCommit(false);
		   PreparedStatement stmtVeiculo = con.prepareStatement(sql);
		   stmtVeiculo.setInt(1, cadastro.getCliente().getVeiculo().getIdCliente());
		   stmtVeiculo.setString(2, cadastro.getCliente().getVeiculo().getTipo());
		   stmtVeiculo.setString(3, cadastro.getCliente().getVeiculo().getPlaca());
		   stmtVeiculo.setString(4, cadastro.getCliente().getVeiculo().getMarca());
		   stmtVeiculo.setString(5, cadastro.getCliente().getVeiculo().getCor());
		   stmtVeiculo.execute();
		   con.commit();
		   stmtVeiculo.close();
		   con.setAutoCommit(true);
		   
	   }catch(SQLException e){
		   con.rollback();
		   fechar();
	   }
	   
	   sql = "INSERT INTO T_ESTACI_CADASTRO(ID_CLIENTE,DT_CADASTRO)VALUES"+
	   "(?,SYSDATE)";
	    try{
	    	con.setAutoCommit(false);
	    	PreparedStatement stmtCadastro = con.prepareStatement(sql);
	    	stmtCadastro.setInt(1, cadastro.getCliente().getVeiculo().getIdCliente());
	    	stmtCadastro.execute();
	    	con.commit();
	    	stmtCadastro.close();
	    	con.close();
	    }catch(SQLException e){
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
	
	public List<Cliente> listarCliente(Connection con) throws SQLException{
		List<Cliente> lista = new ArrayList<>();
		String sql = "SELECT NOME FROM T_ESTACI_CLIENTE";
		
			PreparedStatement stmt = con.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();
				while(rs.next()){
					Cliente cliente = new Cliente();
					cliente.setNome(rs.getString("NOME"));
					lista.add(cliente);
						
				}
				stmt.close();
				rs.close();	
		return lista;
	}
	
}