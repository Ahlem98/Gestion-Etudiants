package model;

public class Etudiant {
	
	private int num ;
	private String nom;
	private String  prenom;
	private String tel;
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
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
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	
	
	public Etudiant() {
		super();
	}
	public Etudiant(int num, String nom, String prenom, String tel) {
		super();
		this.num = num;
		this.nom = nom;
		this.prenom = prenom;
		this.tel = tel;
	}
	
	
	
	
	
	

}
