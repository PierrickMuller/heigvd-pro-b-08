/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package controllers.BDDpackage;

import java.awt.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;




/*
 *
 * @author spine
 */
public class BDD {
    // Pour te connecter utilise un Login/Group roles admin (par default : postgres et ton mot de passe)
                                                               // Test
    private String url = "jdbc:postgresql://127.0.0.1:5432/BD_Budget"; // http://127.0.0.1:50165/browser/ ou  "jdbc:postgresql://localhost/dvdrental"
    private String user = "postgres";       // postgres   user_files (droit uniquement de selection)
    private String password = "123456789";          // 123456789     123
    private Connection conn = null;
    
    
    public BDD(){
         try {
            conn = DriverManager.getConnection(url, user, password);
            System.out.println("Connected to the PostgreSQL server successfully.");
        } catch (SQLException e) {
            System.out.println("Noo.");
            System.out.println(e.getMessage());
        }
    }
    
    public BDD(String url, String user, String password){
        this.url = url;
        this.user = user;
        this.password = password;
    }
    
    /**
     * Permet de convertir le nom d'une table simple avec le nom exacte
     *
     * @param TableName
     */
    private String table(String TableName) {
        return "Public.\"" + TableName + "\" ";   
    }
    /**
     * Permet de convertir l'id d'un pays en string
     *
     * @param PaysID
     */
    private String paysString(int PaysID) {
        String pays = "";
        
        try {
            String SQL = "SELECT * "
                    + "FROM " + table("Pays")
                    + "WHERE pays_id = ?";
            
            PreparedStatement pstmt = conn.prepareStatement(SQL);
            
            pstmt.setInt(1, PaysID);
            ResultSet rs = pstmt.executeQuery();
            rs.next();
            pays = rs.getString("nom");
    
        } catch (SQLException ex) {
            Logger.getLogger(BDD.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return pays;
        
    }
    
    /**
     * Permet de convertir l'id des options en string
     *
     * @param OptionsID
     */
    private ArrayList<Boolean> optionsString(int OptionsID) {
        ArrayList<Boolean> options = new ArrayList<>();
        
        try {
            String SQL = "SELECT * "
                    + "FROM " + table("Options")
                    + "WHERE options_id = ?";
            
            PreparedStatement pstmt = conn.prepareStatement(SQL);
            
            pstmt.setInt(1, OptionsID);
            ResultSet rs = pstmt.executeQuery();

            int i = 1;

            while (rs.next()) {
                options.add( rs.getBoolean(i++) );
            }
    
        } catch (SQLException ex) {
            Logger.getLogger(BDD.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return options;
        
    }
    
    /**
     * Permet de convertir le boolean du genre en String
     *
     * @param genre
     */
    private String genreString(String genre) {
         if (genre == null)
            return "Pas renseigné" ;
        else if(genre.equals("t"))
            return "Homme";
        else
            return "Femme";
        
    }
    
    /**
     * Permet de convertir l'id du statut en string
     *
     * @param statutID
     */
    private String statutString(int statutID) {
         String Statut = "";
        
        try {
            String SQL = "SELECT * "
                    + "FROM " + table("Statut")
                    + "WHERE statut_id = ?";
            
            PreparedStatement pstmt = conn.prepareStatement(SQL);
            
            pstmt.setInt(1, statutID);
            ResultSet rs = pstmt.executeQuery();
            rs.next();
            Statut = rs.getString("nom");
    
        } catch (SQLException ex) {
            Logger.getLogger(BDD.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return Statut;
        
    }
     
     /**
     * Find users by his/her ID
     *
     * @param UtilisateurID
     */
    public Utilisateur UtilisateurByID(int UtilisateurID) {

        Utilisateur user = null;
        try {
            String SQL = "SELECT * "
                    + "FROM " + table("Utilisateur")
                    + "WHERE utilisateur_id = ?";
            
            PreparedStatement pstmt = conn.prepareStatement(SQL);
            
            pstmt.setInt(1, UtilisateurID);
            ResultSet rs = pstmt.executeQuery();
            
            while (rs.next()) {
                user = new Utilisateur( rs.getInt("utilisateur_id"),
                        rs.getString("prenom"),
                        rs.getString("nom"),
                        rs.getString("email"),
                        rs.getString("pseudo"),
                        genreString(rs.getString("genre")),
                        rs.getString("anniversaire"),
                        rs.getString("cree_a"),
                        rs.getString("droit_id"),
                        statutString(rs.getInt("statut_id")),
                        paysString(rs.getInt("pays_id")),
                        optionsString(rs.getInt("options_id")) );

                System.out.println(rs.getString("utilisateur_id") + "\t"
                        + rs.getString("prenom") + "\t"
                        + rs.getString("nom") + "\t"
                        + rs.getString("email") + "\t"
                        + rs.getString("pseudo") + "\t"
                        + genreString(rs.getString("genre")) + "\t"
                        + rs.getString("anniversaire") + "\t"
                        + statutString(rs.getInt("statut_id")) + "\t"
                        + paysString(rs.getInt("pays_id"))  + "\t"
                        + optionsString(rs.getInt("options_id"))       
                ) ;
                
            }
        } catch (SQLException ex) {
            Logger.getLogger(BDD.class.getName()).log(Level.SEVERE, null, ex);
        }

        return user;
        
    }
    /**
     * Display users
     *
     * @param
     * @throws SQLException
     */
    private ArrayList<String> display_Utilisateurs(){
        
        // HashMap<String, String> users = new HashMap();
        // users.put(url, url)
        
        ArrayList<String> uniqueValues = new ArrayList<>(); 
        
        
        try {
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM " + table("Utilisateur") );

            
            while (rs.next()) {
                uniqueValues.add(rs.getString("pseudo"));
                uniqueValues.add(rs.getString("email"));
                System.out.println(rs.getString("utilisateur_id") + "\t"
                        + rs.getString("prenom") + "\t"
                        + rs.getString("nom") + "\t"
                        + rs.getString("email") + "\t"
                        + rs.getString("pseudo")) ;
                
            }
        } catch (SQLException ex) {
            Logger.getLogger(BDD.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return uniqueValues;
    }
    
    /**
     * Permet de verifier la validiter du nouveau utilisateur
     *
     * @params email,pseudo
     * @throws 
     */
    private boolean checkUniqueUser(String email, String pseudo){
        
        ArrayList<String> uniqueValues = display_Utilisateurs();
        
        if (uniqueValues.contains(email) || uniqueValues.contains(pseudo))
            return false;
        
        return true;
    }
    
    /**
     * Permet d'insérer un nouveau utilisateur à la BDD
     *
     * @params ...
     * @throws 
     */
    private boolean insert_Utilisateurs(String prenom, String nom,String email,String pseudo,String mdp,Boolean genre,String anniversaire,int statut_id, int pays_id, int options_id){
        int droit_id = 2;
        boolean ok = false;
        
        try {
            
            if ( !checkUniqueUser(email,pseudo))
                return ok;
            
            
            String SQL = "INSERT INTO "
                    + table("Utilisateur")
                    + "(prenom, nom, email, pseudo, mdp, genre, anniversaire, droit_id, statut_id, pays_id, options_id) "
                    + "VALUES "
                    + "('" + prenom +"','"+ nom +"','"+ email +"','"+ pseudo +"','"+ mdp +"',"
                    + genre.toString() +",'"+ anniversaire +"',"+ droit_id +","+ statut_id +","+ pays_id +","+ options_id + ");";
            
            Statement st = conn.createStatement();
            st.executeUpdate(SQL);
            ok = true;
            
        } catch (SQLException ex) {
            Logger.getLogger(BDD.class.getName()).log(Level.SEVERE, null, ex);
        }
        return ok;
    }
    
     /**
     * Display Categorie
     *
     * @param
     * @throws SQLException
     */
    public ArrayList<Categorie> display_Categories(){

        ArrayList<Categorie> listCategorie = new ArrayList<>();
        
        try {
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM " + table("Categorie") );
            
            while (rs.next()) {
                // Gère pas encore la couleur a voir !!
                Categorie categorie = new Categorie( rs.getInt("categorie_id"),rs.getString("nom") );
                listCategorie.add(categorie);
                System.out.println(rs.getString("categorie_id") + "\t"
                        + rs.getString("nom") + "\t"
                        + rs.getString("couleur")) ;
            }
            
            rs.close();
            st.close();
        } catch (SQLException ex) {
            Logger.getLogger(BDD.class.getName()).log(Level.SEVERE, null, ex);
        }

        return listCategorie;
    }

    /**
     * Find categorie by his/her ID
     *
     * @param CategorieID
     */
    public Categorie CategorieByID(int CategorieID) {
        Categorie categorie = null;
        try {
            String SQL = "SELECT * "
                    + "FROM " + table("Categorie")
                    + "WHERE categoire_id = ?";

            PreparedStatement pstmt = conn.prepareStatement(SQL);

            pstmt.setInt(1, CategorieID);
            ResultSet rs = pstmt.executeQuery();

            while (rs.next()) {
                // Gérer la couleur !!!!!!!
                //Color color = Color.decode( rs.getString("couleur") );
                //Color color2 = Color.getColor( rs.getString("couleur") );

                categorie = new Categorie( rs.getInt(1),rs.getString("nom"));

            }
        } catch (SQLException ex) {
            Logger.getLogger(BDD.class.getName()).log(Level.SEVERE, null, ex);
        }

        return categorie;

    }


    /**
     * Display Sous_categorie
     *
     * @param
     * @throws SQLException
     */
    public ArrayList<SousCategorie> display_Sous_categorie(int categoire_id) {
        
        ArrayList<SousCategorie> listSousCategorie = new ArrayList<>();
        
        try {
            PreparedStatement st = conn.prepareStatement("SELECT * FROM " + table("Sous_categorie") + " WHERE categorie_id = ?");
            st.setInt(1, categoire_id);
            ResultSet rs = st.executeQuery();
            
            while (rs.next())
            {
                Categorie categorie = CategorieByID(rs.getInt( "categorie_id" ));
                SousCategorie sousCat = new SousCategorie(rs.getInt(1),rs.getString("nom"),categorie);
                listSousCategorie.add(sousCat);
                System.out.println("id : " + rs.getString(1)  + " nom : " + rs.getString(2));
            }
            
            rs.close();
            st.close();
        } catch (SQLException ex) {
            Logger.getLogger(BDD.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return listSousCategorie;
    }
    
    /**
     * Permet de verifier la validiter d'une nouvelle sous categorie
     *
     * @params email,pseudo
     * @throws 
     */
    private boolean checkUniqueSousCategorie(String nom, int categorie_id){
        
        ArrayList<SousCategorie> uniqueValues = display_Sous_categorie(categorie_id);

        for(SousCategorie sousCat : uniqueValues){
            if (sousCat.nom == nom)
                return false;
        }

        
        return true;
    }
    
    /**
     * Permet d'insérer une nouvelle Sous_categorie à la BDD
     *
     * @params ...
     * @throws 
     */
    private boolean insert_Sous_categorie(String nom, int categorie_id){
        boolean ok = false;
        
        try {
            
            if ( !checkUniqueSousCategorie(nom, categorie_id ))
                return ok;
            
            
            String SQL = "INSERT INTO "
                    + table("Sous_categorie")
                    + "(nom, categorie_id) "
                    + "VALUES "
                    + "('" + nom +"'," + categorie_id + ");";
            
            Statement st = conn.createStatement();
            st.executeUpdate(SQL);
            ok = true;
            
        } catch (SQLException ex) {
            Logger.getLogger(BDD.class.getName()).log(Level.SEVERE, null, ex);
        }
        return ok;
    }
        
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws SQLException {

        BDD app = new BDD();
        System.out.println("------------------Utilisateurs------------------------------------------------");
        app.display_Utilisateurs();
        System.out.println("------------------Categorie------------------------------------------------");
        app.display_Categories();
        System.out.println("------------------Sous categorie------------------------------------------------");
        app.display_Sous_categorie(4);
        System.out.println("------------------Utilisateurs 1------------------------------------------------");
        app.UtilisateurByID(1);
        System.out.println("------------------Utilisateurs 2------------------------------------------------");
        app.UtilisateurByID(2);
        System.out.println("------------------Utilisateurs 3------------------------------------------------");
        app.UtilisateurByID(3);
        
        System.out.println("------------------Insert Utilisateurs ------------------------------------------------");
        if (!app.insert_Utilisateurs( "prenom1",  "nom2", "email2", "pseudo1", "mdp_evadvservsrevervrev_vdfvdfvdF_vfdvdf_lol", true, "1950-03-11", 2,  23,  1))
            System.out.println("erreur !");
        
        System.out.println("------------------Insert Sous_categorie------------------------------------------------");
        if (!app.insert_Sous_categorie( "new_cat",  1))
            System.out.println("erreur !");
        


    }
    
}
