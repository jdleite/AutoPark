package br.com.carro.servlet;

import java.io.IOException;
import java.sql.Connection;
import java.util.Calendar;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.carro.bean.Cliente;
import br.com.carro.bean.Veiculo;
import br.com.carro.bo.ClienteBo;
import br.com.carro.conexao.ConexaoFactory;
import br.com.carro.dao.ClienteDao;
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
			break;		
		case "buscarCodigo":
			buscarCodigo(req);
			pagina = "cadastro.jsp";
			break;
		}
		req.getRequestDispatcher(pagina).forward(req, resp);
		
		
	}
	
	
	public void cadastrar(HttpServletRequest req){
		try{
			String nome = req.getParameter("nome");
			String nascimento = req.getParameter("data");
			String sexo = req.getParameter("sexo");
			Calendar nasci = DateUtils.parseCalendar(nascimento);
			String cor = req.getParameter("cor");
			String marca = req.getParameter("marca");
			String placa = req.getParameter("placa");
			String tipo = req.getParameter("tipo");
			int ident = Integer.parseInt(req.getParameter("ident"));
			
			Veiculo veiculo = new Veiculo(ident,cor,marca,placa,tipo);
			
			Cliente cliente = new Cliente(nome,nasci,sexo,veiculo);
			ClienteBo bo = new ClienteBo();

			Connection con = ConexaoFactory.getConnection();
			bo.gravar(cliente,con);
			
			req.setAttribute("gravado", "Cliente Cadastrado com Sucesso!");
			
			
		}catch(Exception e){
			req.setAttribute("erro", e.getMessage());
		}
				
		
		
	}
	public void buscarCodigo(HttpServletRequest req){		
		ClienteBo bo = new ClienteBo();		
		
		try{
			req.setAttribute("numero", bo.buscarCodigo());			
		}catch(Exception e){

			req.setAttribute("erro","não existe dispesa!");
		}
		
		
		
		
	}
	

}