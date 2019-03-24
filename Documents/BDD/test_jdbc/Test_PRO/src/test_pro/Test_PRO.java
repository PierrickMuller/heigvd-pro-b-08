/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test_pro;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;



/*
 *
 * @author spine
 */
public class Test_PRO {
    // Pour te connecter utilise un Login/Group roles admin (par default : postgres et ton mot de passe)
                                                               // Test
    private final String url = "jdbc:postgresql://127.0.0.1:5432/Test_roles"; // http://127.0.0.1:50165/browser/ ou  "jdbc:postgresql://localhost/dvdrental"
    private final String user = "user_files";       // postgres   user_files (droit uniquement de selection)
    private final String password = "123";          // 123456789     123
    
     public Connection connect() {
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(url, user, password);
            System.out.println("Connected to the PostgreSQL server successfully.");
            
            
            Statement st = conn.createStatement();
            // ResultSet rs = st.executeQuery("SELECT * FROM public.\"Categorie\"");
            ResultSet rs = st.executeQuery("SELECT * FROM public.\"Sous_categorie\" WHERE categorie_id = 2");
            
            while (rs.next())
            {
                System.out.println("id : " + rs.getString(1) + " nom : " + rs.getString(2));
            }
            
            int categoire_id = 2;
            PreparedStatement st2 = conn.prepareStatement("SELECT * FROM public.\"Sous_categorie\" WHERE categorie_id = ?");
            st2.setInt(1, categoire_id);
            ResultSet rs2 = st2.executeQuery();
            
            while (rs2.next())
            {
                System.out.println("id : " + rs2.getString(1)  + " nom : " + rs2.getString(2));
            }
            
            // Pour limiter le nombre de réponse :
            /* make sure autocommit is off
                 conn.setAutoCommit(false);
                st.setFetchSize(50);
            */
            
            rs.close();
            st.close();
            
            
        } catch (SQLException e) {
            System.out.println("Noo.");
            System.out.println(e.getMessage());
        }
 
        return conn;
    }
     
     /**
     * Find actor by his/her ID
     *
     * @param actorID
     */
    public void findActorByID(int actorID) {
        String SQL = "SELECT actor_id,first_name,last_name "
                + "FROM actor "
                + "WHERE actor_id = ?";
 
        try (Connection conn = connect();
                PreparedStatement pstmt = conn.prepareStatement(SQL)) {
 
            pstmt.setInt(1, actorID);
            ResultSet rs = pstmt.executeQuery();
            displayActor(rs);
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }
    /**
     * Display actor
     *
     * @param rs
     * @throws SQLException
     */
    private void displayActor(ResultSet rs) throws SQLException {
        while (rs.next()) {
            System.out.println(rs.getString("actor_id") + "\t"
                    + rs.getString("first_name") + "\t"
                    + rs.getString("last_name"));
 
        }
    }
        
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        Test_PRO app = new Test_PRO();
        app.connect();


    }
    
}
