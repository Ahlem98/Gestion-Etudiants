package dao;

import java.util.List;

import model.Etudiant;

public class main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Gestiondb dao = new Gestiondb();
		List<Etudiant> list =dao.getAllEtudiants();
		for(Etudiant e:list){
			System.out.println(e.getNom()) ;
		}
	}

}
