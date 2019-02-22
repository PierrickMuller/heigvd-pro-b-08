# PRO : Charte
---
  1. *Github, gestion et rôles*
  3. *Tests*
  2. *Convention de code*
  3. *Deroulement des séances*
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
3. `git fetch upstream (Recupération)`
4. `git checkout master (On revient dans master)`
5. `git merge upstream/master (On merge master et upstream/master, qui correspond au repo principal)`

Les points 3,4 et 5 doivent être effectué à chaque début de travail. Attention, si vous travailler sur une branch et que le depot principal à été mis a jour, finissez le travail sur votre branch avant de récuperer les modifications principales,
a moins que vous vous sentiez assez a l'aise avec les merge pour ajouter les modifications dans votre branch.

#### 1.2 Gestion et rôles
Le/Les maintener du repo principal sont garant du bon fonctionnement des ajouts au repo principal. Il/Ils doivent absolument tester toutes les modifications qui veulent être ajoutées au repo principal.
Le rôle du chef de projet est (A définir)
