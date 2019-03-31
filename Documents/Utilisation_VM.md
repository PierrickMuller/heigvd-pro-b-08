# Utilisation de la machine virtuelle de développement 1.2

## Configuration de la VM
Assurez vous d'avoir accorder suffisament de ressources à la machine virtuelle avant de la lancer. Pour se faire , modifiez la configuration de la machine virtuelle si nécéssaire.

## Connection a la VM
Le mot de passe de la machine virtuelle est : reds.

## Lancement de pgAdmin4
Un script à été créer afin de faciliter le lancement de pgAdmin4:
  - Ouvrez un terminal.
  - Déplacer vous dans le dossier pgAdmin4 (cd /home/reds/pgAdmin4/pgAdmin4).
  - Entrez "pgAdmin4" et appuyer sur enter.
  - pgAdmin4 est lancé est accessible en local (Le terminal vous indique le numéro de port corresponfant, copiez le lien pour ouvrir pgAdmin4 dans votre navigateur)

## Connection à pgAdmin4
Les identifiants de connexion pour pgAdmin4 sont les suivants :
  - Username : pierrick.muller@heig-vd.ch
  - MDP :  **redsqq**

Les informations relatives à l'utilisation de la base de donnée se trouvent dans le dossier BDD dédié.

## Utilisation de la VM
*Conseil d'utilisation* : Arrangez vous pour toujours avoir un terminal ouvert utilisé comme console SBT, un autre permettant de faire tourner pgAdmin4 et un ou deux autres utiles pour git ou pour autre chose.

L'utilisation basique de la machine virtuelle est la suivante :
  - Connectez vous a la VM.
  - Ouvrez un terminal, rendez-vous dans le dossier du projet (`cd /home/reds/pro/play-java-seed`) et lancer la commande `sbt shell` permettant de lancer des commandes plus rapidement et sans devoir préciser le mot clé `sbt` avant chaque commande.
  - Lancez eclipse, laissez le workplace tel quel.
  - Pour lancer le site , utiliser la commande `run` dans le terminal SBT
  - Normalement, la plupart des fichiers modifiés impactent directement le site sans avoir besoin d'utiliser run à nouveau, juste en raffraichissant la page.
  - Si vous souhaitez vous assurez que votre projet compile bien, utilisez la commande `clean` suivit de `compile`
  - Une commande importante est `eclipse`. Elle permet de mettre a jour le "ClassPath" d'eclipse et donc de s'assurer que le projet fonctionne bien. Souvent, durant vos différents écrits de codes, vous risquez de vous retrouver avec des erreurs étranges que vous n'arriverez pas à réglé. Vous devez toujours essayer de lancer la commande `eclipse` et de raffraichir votre projet (clic droit sur le projet -> raffraichir).
  - Afin de voir votre projet en fonctionnement, vous pouvez acceder a la page *localhost:9000*. Vous verrez le résultat de votre `run` et des modifications en temps réel. Des infos sur les problèmes s'afficheront aussi si le code ne fonctionne pas.
  - Si vous souhaitez lancer les tests de play, utilisez simplement la commande test.
  - Une notion intéréssante est l'utilisation des "triggered execution", qui permettent d'effectuer une commande sbt a chaque changement de fichier source. Les commandes sont les mêmes, avec `~` ajouter avant (`~ test` par exemple, pour tester le projet en permanence).

## Play 2.X , Principes de bases
*Documentation code* : https://www.playframework.com/documentation/2.6.x/api/java/index.html

*Documentation principes* : https://www.playframework.com/documentation/2.6.x/Home

*Tutos play* : https://www.playframework.com/documentation/2.6.x/Tutorials

Nous utilisons la version 2.6 de play.

Play 2 est un framework java nous permettant de mettre en place une infrastructure web avec java. Play 2 est basé sur un motif d'architecture logiciel MVC : Models-Views-Controllers.
L'idée est assez simple :
 - Les fichiers "Models" contiennent les données de l'application (User, sessions, soldes ...)
 - Les fichiers "Views" contiennent l'interface graphique (Dans notre cas, les pages et le style de ces pages de notre projet)
 -  Les fichiers "Controllers" contiennent la logique en rapport avec les actions de l'utilisateur (La redirection, le controle de la connection, les maths pour les calculs de budget, etc...)


 Play 2.0 contient beaucoup de principes, voici une séléction de base:
#### Les templates et Scala
Play utilise des templates pour ses vues (views). En effet, les données sont affichés à l'aide de templates utilisant le langage Scala. Pour plus d'informations sur les templates et leur fonctionnement, vous pouvez suivre les liens suivants :
-  https://www.playframework.com/documentation/2.6.x/HelloWorldTutorial (Fournit une bonne base sur les principes de Play. Tous le monde devrait au moins le parcourir)
-  https://www.playframework.com/documentation/2.6.x/JavaTemplates (Explication complète, disponible sur 4 pages)

#### Actions, controllers et results :
Les actions sont des fonctions java qui traitent les paramètres des requetes (Et donc, les requetes, GET et POST), et renvoient un resultat au client , donnant des data à nos views en fait. Une action renvoie un `play.mvc.Result` qui est une reponse http.
Les controlleurs sont des classe qui extends play.mvc.Controller et qui regroupent les actions.
Les results sont les réponses crées par les actions.
- lien : https://www.playframework.com/documentation/2.6.x/JavaActions

#### le routing
La , il y a beaucoup à dire, et je préfère vous laisser le lien pour que vous puissiez vous faire votre propre ideé
- lien : https://www.playframework.com/documentation/2.6.x/JavaRouting
