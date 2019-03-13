package co.simplon.entities;

public class Compte {
	private int numCpte;
	private double solde;
	private int codeCli;
	
	public Compte(int numCpte, double solde, int codeCli) {
		this.numCpte = numCpte;
		this.solde = solde;
		this.codeCli = codeCli;
	}

	public int getNumCpte() {
		return numCpte;
	}
	public void setNumCpte(int numCpte) {
		this.numCpte = numCpte;
	}
	public double getSolde() {
		return solde;
	}
	public void setSolde(double solde) {
		this.solde = solde;
	}
	public int getCodeCli() {
		return codeCli;
	}
	public void setCodeCli(int codeCli) {
		this.codeCli = codeCli;
	}

	@Override
	public String toString() {
		return "Compte [numCpte=" + numCpte + ", solde=" + solde + ", codeCli=" + codeCli + "]";
	}
}
