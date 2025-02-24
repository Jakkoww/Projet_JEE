# Projet_JEE AP5

# Participants du projet:
  - Jacques MUDOY
  - Louise HORTER

# Principe du projet:
# 🐾 Application de Signalement de Chiens Perdus (FindMyDog) 🐾

#### 📌 **Description :**  
Une application qui permet aux utilisateurs de signaler un chien perdu ou trouvé, et d’aider à réunir les chiens avec leurs propriétaires.  

## 🚀 Fonctionnalités

- 📋 Lister tous les signalements de chiens perdus/trouvés
- 🔍 Voir les détails d'un signalement avec les commentaires associés
- 📝 Ajouter un nouveau signalement
- 💬 Ajouter un commentaire à un signalement

## 🛠️ Technologies Utilisées

- JavaEE (JPA & Swagger)
- MySQL (Base de données)
- Thymeleaf (Frontend)
- Swagger pour la documentation API

## 🗄️ Base de Données

### Tables

#### 🐕 `chiens`

Stocke les informations des chiens signalés.

```sql
CREATE TABLE chiens (
    id INT PRIMARY KEY AUTO_INCREMENT,
    nom VARCHAR(100),
    race VARCHAR(100),
    couleur VARCHAR(50),
    taille VARCHAR(50),
    description TEXT,
    photo VARCHAR(255),
    statut ENUM('Perdu', 'Trouvé') NOT NULL,
    date_signalement TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);
```

#### 📌 `signalements`

Stocke les signalements effectués par les utilisateurs.

```sql
CREATE TABLE signalements (
    id INT PRIMARY KEY AUTO_INCREMENT,
    chien_id INT NOT NULL,
    nom_signaleur VARCHAR(100),
    telephone VARCHAR(20),
    email VARCHAR(100),
    localisation VARCHAR(255),
    message TEXT,
    FOREIGN KEY (chien_id) REFERENCES chiens(id) ON DELETE CASCADE
);
```

#### 💬 `commentaires`

Stocke les commentaires liés aux signalements.

```sql
CREATE TABLE commentaires (
    id INT PRIMARY KEY AUTO_INCREMENT,
    chien_id INT NOT NULL,
    nom_auteur VARCHAR(100),
    message TEXT,
    date_publication TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    FOREIGN KEY (chien_id) REFERENCES chiens(id) ON DELETE CASCADE
);
```

## 📡 Endpoints API (Swagger intégré)

- `GET /signalements` → Récupérer tous les signalements 📋
- `GET /signalements/{id}` → Voir un signalement spécifique 🔍
- `POST /signalements` → Ajouter un signalement 📝
- `POST /signalements/{id}/commentaires` → Ajouter un commentaire 💬

L'API est documentée avec Swagger et accessible via `/swagger-ui.html`.

## 🎨 Interfaces HTML (Thymeleaf)

- **📌 Page d'accueil** → Liste de tous les signalements
- **🔍 Détails d'un signalement** → Affiche les infos du signalement + commentaires
- **📝 Formulaire d'ajout de signalement** → Permet d'ajouter un chien perdu/trouvé

## 📦 Installation

1. Clonez le repo :
   ```bash
   git clone https://github.com/votre-repo.git
   ```
2. Importez le projet dans votre IDE JavaEE (Eclipse, IntelliJ...)
3. Configurez votre base de données MySQL avec les tables ci-dessus
4. Lancez l'application avec un serveur Tomcat
5. Accédez à l'API via Swagger : `http://localhost:8080/swagger-ui.html`
6. Ouvrez votre navigateur et commencez à signaler des chiens ! 🐕🚀

---

**🐾 Aidez les chiens à retrouver leur maison !**


