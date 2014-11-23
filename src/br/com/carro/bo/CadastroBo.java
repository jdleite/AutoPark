package br.com.carro.bo;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import br.com.carro.bean.Cadastro;
import br.com.carro.dao.CadastroDao;

public class CadastroBo {
   CadastroDao dao = new CadastroDao();
	public void deletarCadastro(Connection con,int codigo) throws SQLException{
		dao.deletarCadastro(codigo, con);
	}
	public List<Cadastro> buscarTodos(Connection con) throws SQLException{
		return dao.listaCadastro(con);
	}
}
