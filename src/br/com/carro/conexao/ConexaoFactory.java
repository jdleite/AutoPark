package br.com.carro.conexao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexaoFactory {
	public static Connection getConnection(){
		try{
			return DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","SYSTEM","al.1245*");
		}catch(SQLException e){
			throw new RuntimeException(e);
		}
	}
	public static void fechar(Connection c){
		try{
			c.close();
			
		}catch(SQLException e){

			throw new RuntimeException(e);
		}
	}
}