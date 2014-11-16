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
			String tipo = req.getParameter("tipo");
			String placa = req.getParameter("placa");
			String marca =req.getParameter("marca");
			String cor = req.getParameter("cor");
			Connection con = ConexaoFactory.getConnection();
			Cliente cliente = new Cliente(nome,nascimento,sexo);
			ClienteBo bo = new ClienteBo();
			
			bo.gravar(cliente,con);
			
			req.setAttribute("gravado", "Cliente Cadastrado com Sucesso!");
			
			
		}catch(Exception e){
			req.setAttribute("erro", e.getMessage());
		}
		
		
		
		
	}
	

}