package br.com.ufc.si.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.ufc.si.Connection.ConnectionPostgres;
import br.com.ufc.si.Entity.Telephone;

public class TelephoneDAO {
	
	private Connection conn;
	private ConnectionPostgres connPostgres;
	
	public TelephoneDAO(ConnectionPostgres connPostgres) {
		this.connPostgres = connPostgres;
	}
	
	public void create (Telephone tel) {
		String query = "INSERT INTO telephone (userId, telephone) VALUES (?, ?)";
		try {
			this.conn = this.connPostgres.getConnection();
			PreparedStatement stmt = this.conn.prepareStatement(query);
			
			stmt.setLong(1, tel.getUserId());
			stmt.setString(2, tel.getTelephone());
			
			stmt.executeUpdate();
			stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				this.conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	public List<Telephone> read (Long userId) {
		String query = "SELECT * FROM telephone WHERE userId = ?";
		List<Telephone> telephones = new ArrayList<Telephone>();
		try {
			this.conn = this.connPostgres.getConnection();
			PreparedStatement stmt = this.conn.prepareStatement(query);
			stmt.setLong(1, userId);
			
			ResultSet rs = stmt.executeQuery();
			while(rs.next()) {
				Telephone tel = new Telephone();
				tel.setTelId(rs.getLong("telId"));
				tel.setUserId(rs.getLong("userId"));
				tel.setTelephone(rs.getString("telephone"));
				
				telephones.add(tel);
			}
			stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				this.conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return telephones;
	}
	
	public void update (Telephone tel) {
		String query = "UPDATE telephone SET telId = ?, userId = ?, telephone = ? where telId = ?";
		try {
			this.conn = this.connPostgres.getConnection();
			PreparedStatement stmt = this.conn.prepareStatement(query);
			
			stmt.setLong(1, tel.getTelId());
			stmt.setLong(2, tel.getUserId());
			stmt.setString(3, tel.getTelephone());
			stmt.setLong(4, tel.getTelId());
			
			stmt.executeUpdate();
			stmt.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				this.conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	public void delete (Long telId) {
		String query = "DELETE FROM telephone t WHERE t.telId = ?";
		try {
			this.conn = this.connPostgres.getConnection();
			PreparedStatement stmt = this.conn.prepareStatement(query);
			stmt.setLong(1, telId);
			
			stmt.executeUpdate();
			stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				this.conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	public List<Telephone> getAllPhones(){
		String query = "SELECT * FROM userTelephones";
		List<Telephone> telephones = new ArrayList<Telephone>();
		try {
			this.conn = this.connPostgres.getConnection();
			PreparedStatement stmt = this.conn.prepareStatement(query);
			ResultSet rs = stmt.executeQuery();
			
			while(rs.next()) {
				Telephone tel = new Telephone();
				tel.setTelId(rs.getLong("telId"));
				tel.setUserId(rs.getLong("userId"));
				tel.setTelephone(rs.getString("telephone"));
				
				telephones.add(tel);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				this.conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return telephones;
	}
	
}
