package co.simplon.entities;

public class Client {
	private int CodeCli;
	private String nom;
	private String prenom;
	
	public Client(int codeCli, String nom, String prenom) {
		this.CodeCli = codeCli;
		this.nom = nom;
		this.prenom = prenom;
	}

	@Override
	public String toString() {
		return "Client [CodeCli=" + CodeCli + ", nom=" + nom + ", prenom=" + prenom + "]";
	}

	public int getCodeCli() {
		return CodeCli;
	}

	public void setCodeCli(int codeCli) {
		this.CodeCli = codeCli;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}	
}
