package br.com.carro.bo;

import java.sql.Connection;
import java.sql.SQLException;

import br.com.carro.bean.Cliente;
import br.com.carro.bean.Veiculo;
import br.com.carro.conexao.ConexaoFactory;
import br.com.carro.dao.ClienteDao;

public class ClienteBo {
	public ClienteDao dao = new ClienteDao();
	Connection con = ConexaoFactory.getConnection();

	public void gravar(Cliente cliente,Veiculo vei, Connection con) throws SQLException {
		dao.cadastrarCliente(cliente,vei, con);
	}

}