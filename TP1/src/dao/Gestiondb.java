package dao;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.Etudiant;

public class Gestiondb implements IGestion {
	
	static String URL = "jdbc:mysql://localhost:3306/etudiant?serverTimezone=UTC";
    static String Username ="Ahlem";
    static String Password = "ivanhoe";
    
    
    
    public static String INSERT_ETUDIANT = "INSERT INTO etudiant  (num,nom,prenom,tel) VALUES  (?, ?, ?,?);";
    public static String INSERT_USER = "INSERT INTO compte  (user,mp) VALUES  (?, ?);";
    public static String SELECT_ALL_ETUDIANT = "select * from etudiant";
	public static String DELETE_ETUDIANT = "delete from etudiant where num= ?;";
    public static String SELECT_USER = "select * from compte where user=? and mp=?";


	
	public static Connection getConnection() {
		Connection connection = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			connection = DriverManager.getConnection(URL, Username, Password);
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return connection;
	}
	
	
	
   public List<Etudiant> getAllEtudiants(){
		List<Etudiant> le = new ArrayList<Etudiant>();
		try (Connection connection = getConnection();
		PreparedStatement ps = connection.prepareStatement(SELECT_ALL_ETUDIANT)){
		ResultSet rs = ps.executeQuery();
		while (rs.next()){								
		Etudiant p = new Etudiant(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4));
		le.add(p) ;}
		}catch (SQLException e) {
		e.printStackTrace(); }		
	    return le;	
			}
	

	
	public void addEtudiant(Etudiant p) {
		try (Connection connection = getConnection();
			PreparedStatement ps = connection.prepareStatement(INSERT_ETUDIANT)) {
			ps.setInt(1, p.getNum());
			ps.setString(2, p.getNom());
			ps.setString(3, p.getPrenom());
			ps.setString(4, p.getTel());
			ps.executeUpdate();
		} catch (SQLException se) {
		
		}
	}
	
	public void deletEtudiant(int num) {
	try ( Connection connection =getConnection();
			PreparedStatement ps = connection.prepareStatement(DELETE_ETUDIANT)){
		    ps.setInt(1,num);
            ps.executeUpdate();
	} catch (SQLException se) {
	}}
	
	
	
	
	public boolean verif(String user , String mp) {
		String req = "select * from compte";
		try {Connection connection =getConnection() ;
        PreparedStatement ps=connection.prepareStatement(req);
       
        ResultSet res=ps.executeQuery();
        while(res.next()){
        	if(res.getString(2).equals(user) && res.getString(3).equals(mp))
        		return true ;
        }
       
        }
    catch (Exception e){
    e.printStackTrace();
	return false;
	}
	return false ;
}
	
}

		

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

