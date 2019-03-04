# PRO : Charte
---
  1. *Github, gestion et rôles*
  2. *Tests*
  3. *Convention de code*
  4. *Deroulement des séances*
---
### 1 : Github et gestion
#### 1.1 Workflow Git/Github
Un repository existe à l'adresse (Inserer adresse). Les membres du groupe de projet travaille de la manière suivante (Les lignes 1 et 2 s'effecuent une seule fois) :
1. Ils fork le repo de base sur leur compte (Depuis github -> fork)
2. Ils le clone en local, en ssh (`git clone *lienssh*` )
3. Lors de l'ajout d'une fonctionalité, ils remplissent une issue sur le dépot de base (inserer adresse) expliquant ce qu'il vont faire et précisant sur quel fichiers ils vont travailler.Ils s'assurent que personne ne travaille déja sur le fichier.
4. Ils créent une branche local (`git checkout -b fb-nomDeLaFeature`)
5. Ils créent leur fonctionalité
6. Ils ajoutent et commit leurs fichiers dans la branche (`git add nomFichierOuDossier, git commit -m "Message de l'ajout"`)
7. Ils utilisent la commande "git push origin fb-*nomDeLaFeature*" afin de pusher leur modifications sur leur dépot local.
8. Ils créent une pull request sur Github en précisant quelle issue ils veulent fermer.
9. Le/les maintener du dépot principal s'assure que tout fonctionne et ajoutent la fonctionalité au dépot.

Les membres du projet s'assurent d'avoir leur repository a jour en utilisant les commandes existantes. La démarche est la suivante (Les lignes 1 et 2 s'effecuent une seule fois):
1. `git remote add upstream https://github.com/ORIGINAL_OWNER/ORIGINAL_REPOSITORY.git (Ajoute un "remote" qui pointe sur le repo de base)`
2. `git remote -v (Utiliser pour vérifier que le remote à été ajouter)`
3. `git pull upstream master`

Le point 3 doit être effectué à chaque début de travail. Attention, si vous travailler sur une branch et que le depot principal à été mis a jour, finissez le travail sur votre branch avant de récuperer les modifications principales,
a moins que vous vous sentiez assez a l'aise avec les merge pour ajouter les modifications dans votre branch.

#### 1.2 Gestion et rôles
Le/Les maintener du repo principal sont garant du bon fonctionnement des ajouts au repo principal. Il/Ils doivent absolument tester toutes les modifications qui veulent être ajoutées au repo principal.
Le rôle du chef de projet est (A définir)
Tous les membres du projet s'engage à tenir leur journal de travail à jour, et à communiquer leurs problèmes le plus rapidement possible, afin de s'assurer que tout le monde soit au courant des problèmes rencontrés et puisse réfléchir à comment les résoudres. Les problèmes rencontrés sont expliqués au travers d'issues sur github. Les membres consultent les issues lors du début de leur séance de travail, et aussi souvent que nécéssaire, afin de se tenir a jour sur l'avancement du projet et des différents membres du projet.

### 2 : Tests
Les membres commencent par créer des tests avant d'implémenter leur fonctionnalité. Les tests sont situés dans un dossier différent du dossier contenant les sources du programme. Les tests sont effectués majoritairement a l'aide d'assert. Les tests utilisent JUnit. Un exemple du fonctionnement des tests peut être trouvé dans projet "Lab00" de RES.

### 3 : Convention de code
La convention suivante est basée sur la convention officielle d'Oracle. Cette convention peut être trouvée ici:
https://www.oracle.com/technetwork/java/codeconvtoc-136057.html
Elle est aussi fortement inspiré de la convention suivante :
http://www2.hawaii.edu/~tp_200/ics111/material/codingStandards.html
#### 3.1 Commentaire
Chaque fichier contient une entete dont voici le template :
```
/* ---------------------------
   Projet : NomDuProjet
   Package : NomDuPackage
   Fichier : NomDufichier.java
   Auteur(s) : Membre(s) du groupe crateur du fichier.
   Date : Date de cration du fichier

   But : But du fichier

   Remarque(s) : Remarque sur le fichier (Trucs à savoir, etc...)

   Compilateur : version du compilateur

   Auteur(s) modifications : Nom de la personne qui à effectué la dernière modifications
   Date modifications : Date de la dernière modification.

   --------------------------- */
```

Le projet utilisera une convention javadoc pour les fonctions et les classes :
**Classe :**
```
/**
 * <b>But : but de la classe</b>
 * <p>
 * Description : Petite Description de la classe
 * </p>
 *
 * @author Votre nom
 * @version 1.0
 */
```
**Constructeur :**
```
/**
* Constructeur NomDeLaClasse.
* <p>
* Description : Description de ce que fais le constructeur (Initialisaion, fonctions...)
* </p>
*
* @param {Type} NomParam - Description Param.
*
*(Eventuellement si nécéssaire)
* @throws NomException Description du cas ou nécéssaire
*/
```
**Fonctions :**
```
/**
 * But : But de la fonction
 * <p>
 * Description : Description de la fonction
 * </p>
 *
 * @param {Type} NomParam - Description Param.
 *
 * @return {Type} Description return.
 *
 *(Eventuellement si nécéssaire)
 * @throws NomException Description du cas ou nécéssaire
 */
```
Si les variables ne sont pas explicites, elle doivent être expliquées en une ligne à l'aide d'un commentaire `//`

#### 3.2 Convention de nommage
Les noms des classes, des variables et des fonctions doivent avoir du sens, être cohérents  et suivre la convention suivante:
- N'utilisez pas de noms trop longs.
- Les variables et les fonctions utilise la pratique *Lower camel case*. Ainsi, chaque variable est une suite sans espace de mot avec chacune des première lettres des mots en majuscule sauf la première lettre de la variable.
`int lowerCamelCase;`
- Les noms des classes utilisent la pratique *Upper camel case*. C'est la même chose que *Lower camel case*, sauf que la première classe est aussi en majuscule.
`public class UpperCamelCase`
- Les constantes sont écrite en majuscule et chaque mot les composant sont séparé par un caractère "_"
`final int TAILLE_DE_MA_CHAUSSURE = 42;`

### 4 : Déroulement des séances
Les membres du projet se réunissent lors des périodes de projet pour discuter de leur avancée respective. De plus, les choix d'implémentation sont décidés en groupe, lors de discussions.

Si les membres du groupe n'arrivent pas s'accorder sur un choix d'implémentation ou sur une question concernant le projet, un vote à main levée à lieu. En cas d'égalité pendant le vote, le choix ou la question est rediscuté.

Si les membres du projet n'arrivent pas à se mettre d'accord, c'est le chef de projet qui tranche. Si le sujet est jugé trop sensible, le choix final est tiré à pile ou face.

Lors des discussions, les membres du projet respectent les autres et ne se coupent pas la parole. Tous les points de vues sont les bienvenus, et toutes les idées sont bénéfiques pour le projet. Les membres sont garants du bon déroulement de ces discussions, et s'assurent que tout le monde puisse parler.

En cas de besoin, un système de main levée pour les prises de parole peut être mis en place et géré par un ou plusieurs des membres du projet (Le chef de projet, par exemple.)
