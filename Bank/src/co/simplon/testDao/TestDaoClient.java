package co.simplon.testDao;

import co.simplon.dao.ClientDao;
import co.simplon.entities.Client;

public class TestDaoClient {

	public static void lancerTests() {
		// le principe de base d'un programme de tests, 
		// c'est qu'on doit passer par tous les chemins pour valider 
		// Comment faire ici ?
		
		ClientDao cd = new ClientDao();		
				
		Client c1 = new Client(20,"Hanakin","Skywalker");
		
		if(cd.create(c1))	System.out.println("insertion ok de " + c1);
		else System.out.println("insertion impossible, client avec cet id existe déjà ");
				
		Client c2 = cd.find(c1.getCodeCli()); 		
		if(c2 == null)	System.out.println("ce client n'est pas contenu en base ");
		else System.out.println("client trouvé en base : " + c2);
		
		c1.setPrenom("Vador");
		if(cd.update(c1)) System.out.println("ok mise à jour " + c1);
		else System.out.println("mise à jour impossible ");
		
		if(cd.delete(c1))	System.out.println("delete ok " + c1);
		else System.out.println("delete impossible ");				
	}
}
