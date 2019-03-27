/**
 * <b>But : Classe représentant un utilisateur</b>
 * <p>
 * Description : Classe modélisant un utilisateur
 * </p>
 * source : https://examples.javacodegeeks.com/enterprise-java/play-framework-security-example/
 * @author Muller Pierrick
 * @version 1.0
 */


package model;

public class User {
	 private final String name;
	 private final String password;
	 
	 /**
	 * Constructeur User.
	 * <p>
	 * Description : Initialisation des attributss de la classe
	 * </p>
	 *
	 * @param {String} name - Nom de l'utilisateur.
	 * @param {String} password - MDP de l'utilisateur
 	 */

	 public User(String name, String password) {
		 this.name = name;
		 this.password = password;
	 }
	 
	 /**
	  * But : Récupération du nom
	  * <p>
	  * Description : Récupération du nom de l'utilisateur
	  * </p>
	  * @return {String} Le nom de l'utilisateur.
	  *
	  */
	 public String getName() {
	     return name;
	 }
	 
	 /**
	  * But : Récupération du pass
	  * <p>
	  * Description : Récupération du pass de l'utilisateur
	  * </p>
	  * @return {String} Le pass de l'utilisateur.
	  *
	  */
	 public String getPassword() {
	     return password;
	 }
}
