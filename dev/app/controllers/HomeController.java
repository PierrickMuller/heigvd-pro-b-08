package controllers;

import controllers.BDDpackage.BDD;

import controllers.BDDpackage.Categorie;
import controllers.BDDpackage.SousCategorie;
import controllers.BDDpackage.Utilisateur;
import play.mvc.*;

import java.sql.SQLException;
import java.util.ArrayList;

/**
 * This controller contains an action to handleHTTP requests
 *  to the application's home page.
 */
public class HomeController extends Controller {

    BDD DB = new BDD();

    /**
     * An action that renders an HTML page with a welcome message.
     * The configuration in the <code>routes</code> file means that
     * this method will be called when the application receives a
     * <code>GET</code> request with a path of <code>/</code>.
     */
    public Result index()  throws SQLException {

        //DB.display_Categories();

        //DB.display_Sous_categorie(2);

        //DB.UtilisateurByID(1);


        return ok(views.html.index.render("Timmy-kun"));
    }

    public Result test() {

        return ok(views.html.test.render());
    }

    public Result Profil() {

        // Get user_id
        Utilisateur user = DB.UtilisateurByID( 3 );

        return ok( views.html.utilisateur.render( user) );
    }

    public Result Categorie() {

        ArrayList<Categorie> listCategorie = new ArrayList<Categorie>();
        listCategorie = DB.display_Categories();

        return ok( views.html.Categorie.render( listCategorie) );
    }

   public Result sousCategorie() {

       ArrayList<SousCategorie> listSousCategorie = new ArrayList<SousCategorie>();
       listSousCategorie = DB.display_Sous_categorie(1);

        return ok( views.html.sousCategorie.render( listSousCategorie) );
    }



}
