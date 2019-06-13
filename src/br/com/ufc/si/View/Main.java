package br.com.ufc.si.View;

import java.sql.SQLException;

public class Main {
	public static void main(String[] args) throws SQLException{
		InterfaceMain menu = new InterfaceMain();
		try {
			menu.start();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}	
}
