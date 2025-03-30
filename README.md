# 🐾 FindMyDog - Application de Signalement de Chiens Perdus 🐾

## 📋 Participants

- Jacques MUDOY
- Louise HORTER

## 📌 Description du projet

FindMyDog est une application web Java EE qui permet aux utilisateurs de signaler des chiens perdus ou trouvés afin de faciliter les retrouvailles entre les animaux et leurs propriétaires.

## 🏗️ Architecture du projet

Le projet est organisé en trois modules principaux :

### 1. projet-core

Contient les entités, les services et la logique métier de l'application.

### 2. projet-data

Gère la persistance des données et la communication avec la base de données.

### 3. projet-web

Contient les contrôleurs Spring et les vues Thymeleaf pour l'interface utilisateur.

## 🗄️ Structure de la base de données

Le modèle de données comprend les entités suivantes :

### 🐕 Entité `Dog`

Stocke les informations sur les chiens signalés.

#### Attributs :

- `id` : Identifiant unique (hérité de GenericEntity)
- `name` : Nom du chien
- `breed` : Race du chien
- `color` : Couleur(s) du chien
- `size` : Taille du chien (petit, moyen, grand)
- `description` : Description détaillée du chien
- `photoUrl` : URL de la photo du chien
- `reports` : Liste des signalements associés à ce chien

### 📝 Entité `Report`

Représente un signalement de chien perdu ou trouvé.

#### Attributs :

- `id` : Identifiant unique (hérité de GenericEntity)
- `reporterName` : Nom de la personne qui signale
- `phone` : Numéro de téléphone du signaleur
- `email` : Email du signaleur
- `location` : Lieu où le chien a été perdu/trouvé
- `description` : Informations supplémentaires sur le signalement
- `reportDate` : Date du signalement
- `dog` : Référence vers l'entité Dog correspondante
- `comments` : Liste des commentaires associés à ce signalement
- `status` : Statut du signalement (Perdu ou Trouvé)

### 💬 Entité `Comment`

Stocke les commentaires associés aux signalements.

#### Attributs :

- `id` : Identifiant unique (hérité de GenericEntity)
- `authorName` : Nom de l'auteur du commentaire
- `description` : Contenu du commentaire
- `publishDate` : Date de publication du commentaire
- `report` : Référence vers le signalement auquel le commentaire est associé

## 🌐 Endpoints de l'application

### Endpoints pour les signalements (ReportsController)

| Méthode | URL                     | Description                                  | Paramètres                         | Retourne                                         |
| ------- | ----------------------- | -------------------------------------------- | ---------------------------------- | ------------------------------------------------ |
| GET     | `/reports/add`          | Affiche le formulaire d'ajout de signalement | -                                  | Vue "ReportForm"                                 |
| POST    | `/reports/save`         | Enregistre un nouveau signalement            | `Report report`, `long dogId`      | Redirection vers la liste des signalements       |
| GET     | `/reports/list`         | Affiche la liste de tous les signalements    | -                                  | Vue "ReportsList" avec la liste des signalements |
| POST    | `/reports/{id}/comment` | Ajoute un commentaire à un signalement       | `long reportId`, `Comment comment` | Redirection vers la liste des signalements       |
| GET     | `/reports/delete/{id}`  | Supprime un signalement                      | `long id`                          | Redirection vers la liste des signalements       |

## 🚀 Configuration et lancement

### Prérequis

- Java 17 ou supérieur
- Maven
- Docker (pour la base de données MySQL)

### Configuration de la base de données

La base de données est configurée dans le fichier docker-compose.yaml :

```yaml
version: "8.4"

services:
  db:
    image: mysql
    environment:
      MYSQL_ROOT_PASSWORD: root
      MYSQL_USER: user
      MYSQL_PASSWORD: password
      MYSQL_DATABASE: javaee-mysql
    ports:
      - "3306:3306"
```

### Configuration de la connexion

La connexion à la base de données est configurée dans les fichiers application.properties :

```properties
spring.datasource.url=jdbc:mysql://localhost:3306/javaee-mysql?serverTimezone=UTC
spring.datasource.username=user
spring.datasource.password=password
spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver

spring.jpa.show-sql=true
spring.jpa.generate-ddl=true

spring.thymeleaf.cache=false

spring.jpa.open-in-view=false
```

### Lancement de l'application

1. Démarrer la base de données MySQL avec Docker :

   ```bash
   docker-compose up -d
   ```

2. Compiler et lancer l'application avec Maven :

   ```bash
   mvn clean install
   mvn spring-boot:run -pl projet-web
   ```

3. Accéder à l'application dans un navigateur web :
   ```
   http://localhost:8080/reports/list
   ```

## 📱 Pages de l'application

### 1. Liste des signalements

- URL: `/reports/list`
- Affiche tous les signalements de chiens perdus ou trouvés
- Permet d'accéder aux détails d'un signalement
- Offre la possibilité d'ajouter un nouveau signalement ou de supprimer un signalement existant

### 2. Formulaire d'ajout de signalement

- URL: `/reports/add`
- Permet de saisir les informations d'un chien perdu ou trouvé
- Collecte les informations du chien (nom, race, taille, etc.)
- Collecte les coordonnées du signaleur
- Permet d'uploader une photo du chien

### 3. Détails d'un signalement

- URL: `/reports/{id}`
- Affiche les informations détaillées d'un signalement
- Montre la photo du chien et ses caractéristiques
- Affiche les commentaires associés au signalement
- Permet d'ajouter un nouveau commentaire

## 🛠️ Technologies utilisées

- Spring Boot
- Spring MVC
- Spring Data JPA
- Thymeleaf
- MySQL
- Bootstrap 5
- Docker

