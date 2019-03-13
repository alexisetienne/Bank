package co.simplon.testDao;

import co.simplon.dao.CompteDao;
import co.simplon.entities.Compte;

public class TestDaoCompte {
	
	public static void lancerTests() {
		// le principe de base d'un programme de tests, 
		// c'est qu'on doit passer par tous les chemins pour valider
		// Comment faire ici ?
		
		Compte cpt1 = new Compte(123456,2500,1);
			
		CompteDao cod = new CompteDao();
		
		if(cod.create(cpt1))	System.out.println("creation de compte ok " + cpt1);
		else System.out.println("création impossible ");
		
		Compte cpt2 = cod.find(cpt1.getNumCpte());
		if(cpt2 == null)	System.out.println("Compte inexistant en base ");
		else System.out.println("Compte trouvé " + cpt2);
		
		cpt1.setSolde(cpt1.getSolde() + 5000);
		if(cod.update(cpt1))	System.out.println("mise à jour " + cpt1);
		else System.out.println("mise à jour impossible ");
		
		if(cod.delete(cpt1))	System.out.println("suppression ok de " + cpt1);
		else System.out.println("suppression impossible ! ");
	}
}
