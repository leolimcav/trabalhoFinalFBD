package br.com.ufc.si.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.ufc.si.Connection.ConnectionPostgres;
import br.com.ufc.si.Entity.Place;

public class PlaceDAO {
	
	private Connection conn;
	private ConnectionPostgres connPostgres;
	
	public PlaceDAO(ConnectionPostgres connPostgres) {
		this.connPostgres = connPostgres;
	}
	
	public void create (Place place) {
		String query = "INSERT INTO place (city, country, description, ownerId) VALUES (?, ?, ?, ?)";
		try {
			this.conn = this.connPostgres.getConnection();
			PreparedStatement stmt = this.conn.prepareStatement(query);
			
			stmt.setString(1, place.getCity());
			stmt.setString(2, place.getCountry());
			stmt.setString(3, place.getDescription());
			stmt.setLong(4, place.getOwnerId());
			
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
	
	public Place read (Long placeId) {
		String query = "SELECT * FROM place WHERE placeId = ?";
		Place place = null;
		
		try {
			this.conn = this.connPostgres.getConnection();
			
			PreparedStatement stmt = this.conn.prepareStatement(query);
			stmt.setLong(1, placeId);
			
			ResultSet rs = stmt.executeQuery();
			if(rs.next()) {
				place = new Place();
				place.setPlaceId(rs.getLong("placeId"));
				place.setCity(rs.getString("city"));
				place.setCountry(rs.getString("country"));
				place.setDescription(rs.getString("description"));
				place.setOwnerId(rs.getLong("ownerId"));
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
		return place;
	}
	
	public void update (Place place) {
		String query = "UPDATE place SET placeId = ?, city = ?, country = ?, description = ?, ownerId = ?";
		try {
			this.conn = this.connPostgres.getConnection();
			PreparedStatement stmt = this.conn.prepareStatement(query);
			
			stmt.setLong(1, place.getPlaceId());
			stmt.setString(2, place.getCity());
			stmt.setString(3, place.getCountry());
			stmt.setString(4, place.getDescription());
			stmt.setLong(5, place.getOwnerId());
			
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
	
	public void delete (Long placeId) {
		String query = "DELETE FROM place WHERE placeId = ?";
		try {
			this.conn = this.connPostgres.getConnection();
			PreparedStatement stmt = this.conn.prepareStatement(query);
			stmt.setLong(1, placeId);
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
	
	public List<Place> getUserPlaces(Long userId){
		String query = "SELECT * FROM place p WHERE p.ownerId = ?";
		List<Place> places = new ArrayList<Place>();
		
		try {
			this.conn = this.connPostgres.getConnection();
			PreparedStatement stmt = this.conn.prepareStatement(query);
			ResultSet rs = stmt.executeQuery();
			
			while(rs.next()) {
				Place place = new Place();
				place.setPlaceId(rs.getLong("placeId"));
				place.setCity(rs.getString("city"));
				place.setCountry(rs.getString("country"));
				place.setDescription(rs.getString("description"));
				place.setOwnerId(rs.getLong("ownerId"));
				
				places.add(place);
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
		return places;
	}
	
	public List<Place> getAllPlaces(){
		String query = "SELECT * FROM usersPlaces";
		
		List<Place> places = new ArrayList<Place>();
		
		try {
			this.conn = this.connPostgres.getConnection();
			PreparedStatement stmt = this.conn.prepareStatement(query);
			ResultSet rs = stmt.executeQuery();
			
			while(rs.next()) {
				Place place = new Place();
				place.setPlaceId(rs.getLong("placeId"));
				place.setCity(rs.getString("city"));
				place.setCountry(rs.getString("country"));
				place.setDescription(rs.getString("description"));
				place.setOwnerId(rs.getLong("ownerId"));
				
				places.add(place);
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
		return places;
	}
}
