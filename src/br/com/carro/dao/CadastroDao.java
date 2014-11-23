package br.com.carro.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import br.com.carro.bean.Cadastro;
import br.com.carro.bean.Cliente;
import br.com.carro.conexao.ConexaoFactory;

public class CadastroDao {
private Connection conexao = ConexaoFactory.getConnection();
	
	public void fechar(){
		ConexaoFactory.fechar(conexao);
	}
	
	
	
	public void deletarCadastro(int codigo,Connection con) throws SQLException{
		String sql = "DELETE FROM  T_ESTACI_CLIENTE WHERE ID_CLIENTE = ?";
		try{
			con.setAutoCommit(false);
			PreparedStatement stmtDelete = conexao.prepareStatement(sql);
			stmtDelete.setInt(1, codigo);
			stmtDelete.execute();
			con.commit();			
			stmtDelete.close();			
			con.setAutoCommit(true);
		}catch(SQLException e){
			con.rollback();
			throw new RuntimeException(e);
			
		}
	}
	public List<Cadastro> listaCadastro(Connection con) throws SQLException{
		List<Cadastro> lista = new ArrayList<>();
		String sql ="SELECT CLI.ID_CLIENTE,CLI.NOME,CLI.DT_NASCIMENTO,CAD.DT_CADASTRO " +
				"FROM T_ESTACI_CLIENTE CLI INNER JOIN T_ESTACI_CADASTRO CAD ON(CLI.ID_CLIENTE = CAD.ID_CLIENTE) ORDER BY ID_CLIENTE DESC";
		
		
		PreparedStatement stmt = con.prepareStatement(sql);
		ResultSet rs = stmt.executeQuery();
		while(rs.next()){
			Cadastro cad = new Cadastro();
			Cliente cli = new Cliente();
			
			cli.setId_Cliente(rs.getInt("ID_CLIENTE"));
			cli.setNome(rs.getString("NOME"));
			Calendar nasc = Calendar.getInstance();
			nasc.setTime(rs.getDate("DT_NASCIMENTO"));
			cli.setDt_Nascimento(nasc);
			cad.setCliente(cli);
			Calendar dt = Calendar.getInstance();
			dt.setTime(rs.getDate("DT_CADASTRO"));
			cad.setDtCadastro(dt);
			lista.add(cad);
	        
		}
		stmt.close();
		rs.close();
		
		return lista;
	}

}
