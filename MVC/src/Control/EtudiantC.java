package Control;
import Modele.Etudiant;
import java.lang.*;
import javax.swing.*;
import java.sql.*;
import com.mysql.cj.jdbc.result.ResultSetMetaData;
interface IEtudiant{
    public void ajouterEtudiant(Etudiant e);
    public void updateEtudiant(Etudiant e);
    public void deleteEtudiant(Etudiant e);
}

public class EtudiantC implements IEtudiant{
    public void chercherEtudiant(Etudiant e){
        conn = connect();
        try{
            ps = conn.prepareStatement("select * from etudiant where id = ?");
            ps.setInt(1,e.getId());
            rs = ps.executeQuery();
            rs.last();
            int n = rs.getRow();
            if(n>0)JOptionPane.showMessageDialog(null, "Student exist", "Information", JOptionPane.INFORMATION_MESSAGE);
            else JOptionPane.showMessageDialog(null, "Student not exist", "Information", JOptionPane.INFORMATION_MESSAGE);
            conn.close();ps.close();rs.close();
        }catch (SQLException ex){
            ex.printStackTrace();
        }
    }

    public void ajouterEtudiant(Etudiant e){
        conn = connect();
        try{
            ps = conn.prepareStatement("insert into etudiant (id,nom,prenom) values( ? , ? , ?)");
            ps.setInt(1,e.getId());
            ps.setString(2,e.getNom());
            ps.setString(3,e.getPrenom());
            ps.executeUpdate();
            JOptionPane.showMessageDialog(null,"Student adds successfuly","Information",JOptionPane.INFORMATION_MESSAGE);
            conn.close();ps.close();
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null,"Failed to add student","Erreur",JOptionPane.ERROR_MESSAGE);
        }

    }
    public void updateEtudiant(Etudiant e){
        conn = connect();
        try{
            ps = conn.prepareStatement("update etudiant set nom  = ? , prenom = ? where id = ?");
            ps.setString(1,e.getNom());
            ps.setString(2, e.getPrenom());
            ps.setInt(3,e.getId());
            ps.executeUpdate();
            JOptionPane.showMessageDialog(null,"Update is successful","Information",JOptionPane.INFORMATION_MESSAGE);
            conn.close();ps.close();
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null,"Update failed","Erreur",JOptionPane.ERROR_MESSAGE);
        }
    }
    public void deleteEtudiant(Etudiant e){
        conn = connect();
        try{
            ps = conn.prepareStatement("delete from etudiant where id = ?");
            ps.setInt(1,e.getId());
            ps.executeUpdate();
            JOptionPane.showMessageDialog(null,"Student delete successfuly","Information",JOptionPane.INFORMATION_MESSAGE);
            conn.close();ps.close();
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null,"Student delete failed","Erreur",JOptionPane.ERROR_MESSAGE);
        }
    }


    private Connection connect(){
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/2bi","root","ramibenmrad105$");
            JOptionPane.showMessageDialog(null,"La connexion est etablie avec succee","Information",JOptionPane.INFORMATION_MESSAGE);
//            System.out.println("La connexion est etablie avec succee");
            return conn;
        }catch(Exception ex){
            ex.printStackTrace();
            JOptionPane.showMessageDialog(null,"Probleme de connexion","Erreur",JOptionPane.ERROR_MESSAGE);
            return null;
        }

    }

    private Connection conn;
    private PreparedStatement ps;
    private ResultSet rs;
}
