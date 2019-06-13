package br.com.ufc.si.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.ufc.si.Connection.ConnectionPostgres;
import br.com.ufc.si.Entity.User;

public class UserDAO {
	
	private Connection conn;
	private ConnectionPostgres connPostgres;
	
	public UserDAO(ConnectionPostgres connPostgres) {
		this.connPostgres = connPostgres;
	}
	
	public void create(User user) {
		String query = "INSERT INTO users (firstName, lastName, email, gender, password, number, street, city, state, zipCode, country, role) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
		
		try {
			this.conn = this.connPostgres.getConnection();
			PreparedStatement stmt = this.conn.prepareStatement(query);
			stmt.setString(1, user.getFirstName());
			stmt.setString(2, user.getLastName());
			stmt.setString(3, user.getEmail());
			stmt.setString(4, user.getGender());
			stmt.setString(5, user.getPassword());
			stmt.setInt(6, user.getNumber());
			stmt.setString(7, user.getStreet());
			stmt.setString(8, user.getCity());
			stmt.setString(9, user.getState());
			stmt.setString(10, user.getZipCode());
			stmt.setString(11, user.getCountry());
			stmt.setLong(12, user.getRole());
			
			stmt.executeUpdate();
			stmt.close();
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				this.conn.close();
			}catch(SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	public User read(Long userId) {
		String query = "SELECT * FROM users WHERE userId = ?";
		User user = null;
		
		try {
			
			this.conn = this.connPostgres.getConnection();
			PreparedStatement stmt = this.conn.prepareStatement(query);
			stmt.setLong(1, userId);
			
			ResultSet rs = stmt.executeQuery();
			if(rs.next()) {
				user = new User();
				user.setUserId(rs.getLong("userId"));
				user.setFirstName(rs.getString("firstName"));
				user.setLastName(rs.getString("lastName"));
				user.setEmail(rs.getString("email"));
				user.setPassword(rs.getString("password"));
				user.setGender(rs.getString("gender"));
				user.setNumber(rs.getInt("number"));
				user.setStreet(rs.getString("street"));
				user.setCity(rs.getString("city"));
				user.setState(rs.getString("state"));
				user.setZipCode(rs.getString("zipCode"));
				user.setCountry(rs.getString("country"));
				user.setRole(rs.getLong("role"));
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
		return user;
	}
	
	public void update(User user) {
		String query = "UPDATE users SET userId = ?, firstName = ?, lastName = ?, email = ?, password = ?, gender = ?"
						+ ", number = ?, street = ?, city = ?, state = ?, zipCode = ?, country = ?, role = ? WHERE userId = ?";
		try { 
			
			this.conn = this.connPostgres.getConnection();
			
			PreparedStatement stmt = this.conn.prepareStatement(query);
			
			stmt.setLong(1, user.getUserId());
			stmt.setString(2, user.getFirstName());
			stmt.setString(3, user.getLastName());
			stmt.setString(4, user.getEmail());
			stmt.setString(5, user.getPassword());
			stmt.setString(6, user.getGender());
			stmt.setInt(7, user.getNumber());
			stmt.setString(8, user.getStreet());
			stmt.setString(9, user.getCity());
			stmt.setString(10, user.getState());
			stmt.setString(11, user.getZipCode());
			stmt.setString(12, user.getCountry());
			stmt.setLong(13, user.getRole());
			stmt.setLong(14, user.getUserId());
			
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
	
	public void delete(Long userId) {
		String query = "DELETE FROM users WHERE userId = ?";
		
		try {
			
			this.conn = this.connPostgres.getConnection();
			
			PreparedStatement stmt = this.conn.prepareStatement(query);
			stmt.setLong(1, userId);
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
	
	public List<User> getAllUsers() {
		String query = "SELECT * FROM users";
		List<User> userList = new ArrayList<User>();
		
		try {
			
			this.conn = this.connPostgres.getConnection();
			PreparedStatement stmt = this.conn.prepareStatement(query);
			ResultSet rs = stmt.executeQuery();
			
			while(rs.next()) {
				User user = new User();
				
				user.setUserId(rs.getLong("userId"));
				user.setFirstName(rs.getString("firstName"));
				user.setLastName(rs.getString("lastName"));
				user.setEmail(rs.getString("email"));
				user.setPassword(rs.getString("password"));
				user.setGender(rs.getString("gender"));
				user.setNumber(rs.getInt("number"));
				user.setStreet(rs.getString("street"));
				user.setCity(rs.getString("city"));
				user.setState(rs.getString("state"));
				user.setZipCode(rs.getString("zipCode"));
				user.setCountry(rs.getString("country"));
				user.setRole(rs.getLong("role"));
				
				userList.add(user);
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
		return userList;
	}
}
