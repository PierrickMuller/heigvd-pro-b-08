/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package controllers.BDDpackage;



import java.awt.*;
import java.util.ArrayList;

/*
 *
 * @author spine
 */
public class Utilisateur {

    public int id;
    public String prenom;
    public String nom;
    public String email;
    public String pseudo;
    public String genre;
    public String anniversaire;
    public String cree_a;
    public String droit;
    public String statut;
    public String pays;
    public ArrayList<Boolean> options;

    Utilisateur() {

    }

    public Utilisateur(int id, String prenom, String nom, String email, String pseudo, String genre, String anniversaire, String cree_a, String droit, String statut, String pays, ArrayList<Boolean> options) {
        this.id = id;
        this.prenom = prenom;
        this.nom = nom;
        this.email = email;
        this.pseudo = pseudo;
        this.genre = genre;
        this.anniversaire = anniversaire;
        this.cree_a = cree_a;
        this.droit = droit;
        this.statut = statut;
        this.pays = pays;
        this.options = options;
    }
}
