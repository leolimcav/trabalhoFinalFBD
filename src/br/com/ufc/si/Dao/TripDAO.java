package br.com.ufc.si.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.ufc.si.Connection.ConnectionPostgres;
import br.com.ufc.si.Entity.Trip;

public class TripDAO {
	
	private Connection conn;
	private ConnectionPostgres connPostgres;
	
	public TripDAO(ConnectionPostgres connPostgres) {
		this.connPostgres = connPostgres;
	}
	
	public void create (Trip trip) {
		String query = "INSERT INTO trip (departureDate, returnDate, price, userId, placeId) VALUES (?, ?, ?, ?, ?)";
		try {
			this.conn = this.connPostgres.getConnection();
			PreparedStatement stmt = this.conn.prepareStatement(query);
			stmt.setDate(1, trip.getDepartureDate());
			stmt.setDate(2, trip.getReturnDate());
			stmt.setDouble(3, trip.getPrice());
			stmt.setLong(4, trip.getUserId());
			stmt.setLong(5, trip.getPlaceId());
			
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
	
	public Trip read (Long tripId) {
		String query = "SELECT * FROM trip WHERE tripId = ?";
		Trip trip = null;
		try {
			this.conn = this.connPostgres.getConnection();
			PreparedStatement stmt = this.conn.prepareStatement(query);
			stmt.setLong(1, tripId);
			
			ResultSet rs = stmt.executeQuery();
			if(rs.next()) {
				trip = new Trip();
				trip.setTripId(rs.getLong("tripId"));
				trip.setDepartureDate(rs.getDate("departureDate"));
				trip.setReturnDate(rs.getDate("returnDate"));
				trip.setPrice(rs.getDouble("price"));
				trip.setUserId(rs.getLong("userId"));
				trip.setPlaceId(rs.getLong("placeId"));
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
		return trip;
	}
	
	public void update (Trip trip) {
		String query = "UPDATE trip SET tripId = ?, departureDate = ?, returnDate = ?, price = ?, userId = ?, placeId = ?";
		try {
			this.conn = this.connPostgres.getConnection();
			PreparedStatement stmt = this.conn.prepareStatement(query);
			
			stmt.setLong(1, trip.getTripId());
			stmt.setDate(2, trip.getDepartureDate());
			stmt.setDate(3, trip.getReturnDate());
			stmt.setDouble(4, trip.getPrice());
			stmt.setLong(5, trip.getUserId());
			stmt.setLong(6, trip.getPlaceId());
			
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
	
	public void delete (Long tripId) {
		String query = "DELETE FROM trip WHERE tripId = ?";
		try {
			this.conn = this.connPostgres.getConnection();
			PreparedStatement stmt = this.conn.prepareStatement(query);
			stmt.setLong(1, tripId);
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
	
	public List<Trip> getUserTrips(Long userId){
		String query = "SELECT * FROM trip t WHERE t.userId = ?";
		List<Trip> trips = new ArrayList<Trip>();
		try {
			this.conn = this.connPostgres.getConnection();
			PreparedStatement stmt = this.conn.prepareStatement(query);
			stmt.setLong(1, userId);
			ResultSet rs = stmt.executeQuery();
			
			while(rs.next()) {
				Trip trip = new Trip();
				trip.setTripId(rs.getLong("tripId"));
				trip.setDepartureDate(rs.getDate("departureDate"));
				trip.setReturnDate(rs.getDate("returnDate"));
				trip.setPrice(rs.getDouble("price"));
				trip.setUserId(rs.getLong("userId"));
				trip.setPlaceId(rs.getLong("placeId"));
				
				trips.add(trip);
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
		return trips;
	}
	
	public List<Trip> getAllTrips(){
		String query = "SELECT * FROM trip";
		List<Trip> trips = new ArrayList<Trip>();
		try {
			this.conn = this.connPostgres.getConnection();
			PreparedStatement stmt = this.conn.prepareStatement(query);
			ResultSet rs = stmt.executeQuery();
			
			while(rs.next()) {
				Trip trip = new Trip();
				trip.setTripId(rs.getLong("tripId"));
				trip.setDepartureDate(rs.getDate("departureDate"));
				trip.setReturnDate(rs.getDate("returnDate"));
				trip.setPrice(rs.getDouble("price"));
				trip.setUserId(rs.getLong("userId"));
				trip.setPlaceId(rs.getLong("placeId"));
				
				trips.add(trip);
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
		return trips;
	}
	
}