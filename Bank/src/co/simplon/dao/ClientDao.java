package co.simplon.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import co.simplon.entities.Client;

public class ClientDao extends Dao<Client> {

	@Override
	public Client find(int id) {
		String str = "select * from T_Clients where CodeCli=?";
		PreparedStatement ps;
		Client client = null;
		try {
			ps = connection.prepareStatement(str);
			ps.setInt(1,id);
			ResultSet resultSet = ps.executeQuery();
			if(resultSet.next()){				
				client = new Client(resultSet.getInt(1),resultSet.getString(2),resultSet.getString(3));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}		
		return client;
	}

	@Override
	public boolean create(Client obj) {
		String str = "INSERT INTO T_Clients (CodeCli,Nom, Prenom) VALUES (?, ? ,? );";
		PreparedStatement ps;
		boolean ok = false;
		try {
			ps = connection.prepareStatement(str);
			ps.setInt(1, obj.getCodeCli());
			ps.setString(2,obj.getNom());
			ps.setString(3,obj.getPrenom());
			ps.executeQuery();
			ok = true;

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return ok;
	}

	@Override
	public boolean update(Client obj) {		
		String str = " update T_Clients set Nom=?,Prenom=? where CodeCli=?;";		
		PreparedStatement ps;
		boolean ok = false;
		try {
			ps = connection.prepareStatement(str);
			ps.setString(1,obj.getNom());
			ps.setString(2,obj.getPrenom());
			ps.setInt(3,obj.getCodeCli());
			int row = ps.executeUpdate();
			if(row > 0)	ok = true;			
		} catch (SQLException e) {
			e.printStackTrace();
		}		
		return ok;
	}

	@Override
	public boolean delete(Client obj) {
		String str = "delete from T_Clients where CodeCli=?;";	
		PreparedStatement ps;
		boolean ok = false;
		try {
			ps = connection.prepareStatement(str);
			ps.setInt(1,obj.getCodeCli());
			int row = ps.executeUpdate();
			if(row > 0)	ok = true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return ok;
	}
}
