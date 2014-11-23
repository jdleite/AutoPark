package br.com.carro.servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Calendar;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.carro.bean.Cadastro;
import br.com.carro.bean.Cliente;
import br.com.carro.bean.Veiculo;
import br.com.carro.bo.CadastroBo;
import br.com.carro.bo.ClienteBo;
import br.com.carro.conexao.ConexaoFactory;
import br.com.carro.dateUtils.DateUtils;
@WebServlet("/estacioServlet")
public class EstacionamentoServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		doPost(req,resp);
	}
	
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		String pagina="";
		String acao = req.getParameter("acao");
		
		switch (acao) {
		case "cadastrar":
			cadastrar(req);
			pagina = "cadastro.jsp";
			buscarCodigo(req);
			break;		
		case "buscarCodigo":
			buscarCodigo(req);
			pagina = "cadastro.jsp";
			break;
		case"listarCadastro":
			listarCadastro(req);
			pagina="listarCliente.jsp";
			break;
		case"excluirCadastro":
			excluirCadastro(req);
			listarCadastro(req);			
			pagina="listarCliente.jsp";
			break;
		}
		req.getRequestDispatcher(pagina).forward(req, resp);
		
		
	}
	
	
	public void cadastrar(HttpServletRequest req){
		try{
			String nome = req.getParameter("nome").toUpperCase();
			String nascimento = req.getParameter("data");
			String sexo = req.getParameter("sexo").toUpperCase();
			Calendar nasci = DateUtils.parseCalendar(nascimento);
			String cor = req.getParameter("cor").toUpperCase();
			String marca = req.getParameter("marca").toUpperCase();
			String placa = req.getParameter("placa").toUpperCase();
			String tipo = req.getParameter("tipo").toUpperCase();
			int ident = Integer.parseInt(req.getParameter("ident"));
			
			Veiculo veiculo = new Veiculo(ident,cor,marca,placa,tipo);
			
			Cliente cliente = new Cliente(nome,nasci,sexo,veiculo);
			
			Cadastro cadastro = new Cadastro(cliente);
			
			ClienteBo bo = new ClienteBo();

			Connection con = ConexaoFactory.getConnection();
			bo.gravar(cadastro,con);
			
			
		}catch(Exception e){
			req.setAttribute("erro", e.getMessage());
		}
				
		
		
	}
	public void buscarCodigo(HttpServletRequest req){		
		ClienteBo bo = new ClienteBo();
		
		
		try{
			req.setAttribute("numero", bo.buscarCodigo() +1);			
		}catch(Exception e){

			req.setAttribute("erro","não existe dispesa!");
		}
		
		
		
		
	}
	
	public void listarCadastro(HttpServletRequest req){
		CadastroBo bo =new  CadastroBo();
		try{
		Connection con = ConexaoFactory.getConnection();
		List<Cadastro> lista = bo.buscarTodos(con);
		req.setAttribute("dados", lista);
		con.close();
		}catch(SQLException e){
			e.printStackTrace();
			
		}
		}
	
	public void excluirCadastro(HttpServletRequest req){
		int codigo = Integer.parseInt(req.getParameter("ident"));
		Connection con = ConexaoFactory.getConnection();
		try{
			CadastroBo bo = new CadastroBo();
			bo.deletarCadastro(con, codigo);
			req.setAttribute("msg", "Cadastro Removido");
		}catch(SQLException e){
			req.setAttribute("erro", "Cadastro não encontrado");
		}
		
		
	}
	

}