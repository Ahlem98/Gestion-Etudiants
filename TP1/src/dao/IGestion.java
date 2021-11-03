
package dao;
import java.util.List;
import model.Etudiant;
public interface IGestion {
	
	public List<Etudiant> getAllEtudiants();
	public void addEtudiant(Etudiant p);
	public void deletEtudiant(int num);
	public boolean verif(String user , String mp);
	
}
