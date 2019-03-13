package co.simplon.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import co.simplon.entities.Compte;

public class CompteDao extends Dao<Compte> {
	@Override
	public Compte find(int id) {
		String str = "select * from T_Comptes where NumCpte=?";
		PreparedStatement ps;
		Compte compte = null;
		try {
			ps = connection.prepareStatement(str);
			ps.setInt(1,id);
			ResultSet resultSet = ps.executeQuery();
			if(resultSet.next()){
				compte = new Compte(resultSet.getInt(1),resultSet.getDouble(2),resultSet.getInt(3));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}		
		return compte;
	}

	@Override
	public boolean create(Compte obj) {
		String str = "INSERT INTO T_Comptes (NumCpte,Solde,CodeCli) VALUES (?, ? ,? );";
		PreparedStatement ps;
		boolean ok = false;
		try {
			ps = connection.prepareStatement(str);
			ps.setInt(1, obj.getNumCpte());
			ps.setDouble(2,obj.getSolde());
			ps.setInt(3,obj.getCodeCli());
			ps.executeQuery();
			ok = true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return ok;
	}

	@Override
	public boolean update(Compte obj) {		
		String str = " update T_Comptes set Solde=? where NumCpte=?;";		
		PreparedStatement ps;
		boolean ok = false;
		try {
			ps = connection.prepareStatement(str);
			ps.setDouble(1,obj.getSolde());
			ps.setInt(2,obj.getNumCpte());
			int row = ps.executeUpdate();
			if(row > 0)	ok = true;			
		} catch (SQLException e) {
			e.printStackTrace();
		}		
		return ok;
	}

	@Override
	public boolean delete(Compte obj) {
		String str = "delete from T_Comptes where NumCpte=?;";	
		PreparedStatement ps;
		boolean ok = false;
		try {
			ps = connection.prepareStatement(str);
			ps.setInt(1,obj.getNumCpte());
			int row = ps.executeUpdate();
			if(row > 0)	ok = true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return ok;
	}
}
