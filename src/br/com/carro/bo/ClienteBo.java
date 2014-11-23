package br.com.carro.bo;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import br.com.carro.bean.Cadastro;
import br.com.carro.bean.Cliente;
import br.com.carro.conexao.ConexaoFactory;
import br.com.carro.dao.ClienteDao;

public class ClienteBo {
	public ClienteDao dao = new ClienteDao();
	Connection con = ConexaoFactory.getConnection();

	public void gravar(Cadastro cadastro, Connection con) throws SQLException {
		dao.cadastrarCliente(cadastro,con);
	}
	public int buscarCodigo() throws SQLException{
		return dao.buscarCodigo();
	}
	
	
	public List<Cliente> buscarCliente(Connection c) throws SQLException{
		return dao.listarCliente(c);
	}

}