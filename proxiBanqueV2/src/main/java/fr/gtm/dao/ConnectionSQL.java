package fr.gtm.dao;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * @author Mehdi Colbert
  *Classe permettant de se connecter au serveur mySQL.
 */
public class ConnectionSQL {

	//=============Propriétés Classe=============
	private static String url = "jdbc:mysql://localhost/proxibanquebdd";
	private static String login = "root";
	private static String psw = "";
	private static Connection cn = null;
	private static Statement st = null;
	//===========================================
	
	
	//=============Getters-Setters=============
	public static String getUrl() {
		return url;
	}
	public static void setUrl(String url) {
		ConnectionSQL.url = url;
	}
	public static String getLogin() {
		return login;
	}
	public static void setLogin(String login) {
		ConnectionSQL.login = login;
	}
	public static String getPsw() {
		return psw;
	}
	public static void setPsw(String psw) {
		ConnectionSQL.psw = psw;
	}
	public static Connection getCn() {
		return cn;
	}
	public static void setCn(Connection cn) {
		ConnectionSQL.cn = cn;
	}
	public static Statement getSt() {
		return st;
	}
	public static void setSt(Statement st) {
		ConnectionSQL.st = st;
	}
	//===========================================
	
	
	//=============Méthode connect=============
	public static Statement connect() {
		try {
			//Chargement des drivers
			Class.forName("com.mysql.jdbc.Driver");
			
			//Connection au serveur
			cn = DriverManager.getConnection(url, login, psw);
			st = cn.createStatement();
			System.out.println("connection ok !");
		}catch (ClassNotFoundException e) {
			e.printStackTrace();
		}catch (SQLException e) {
			e.printStackTrace();
		}
		return st;
	}

	// =====================CONNECTION=====================
	public static void getStatement() {
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			
		} catch (ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		Statement monStatement = null;
		try {
			Connection myCon = DriverManager.getConnection("jdbc:mysql://localhost:3306/proxibanquebdd", "root", "");
			monStatement = myCon.createStatement();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}


	

}
