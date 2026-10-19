# Achat : TP DevOps (Spring Boot, MySQL, Docker, Jenkins)

Application d'exemple pour la partie « Docker et Jenkins » du cours.

- `backend/` : API Spring Boot 3.5 (Java 17) + MySQL, `GET` et `POST` sur `/api/produits`
- `frontend/` : page web servie par Nginx, qui appelle le backend via `/api/`
- `docker-compose.yml` : 3 services (`db`, `backend`, `frontend`)
- `Jenkinsfile` : build Maven, build des images, push sur Docker Hub, déploiement avec Compose

## Lancer à la main

```bash
mvn -B -f backend/pom.xml clean package
docker compose up -d --build
```

Puis ouvrir `http://IP_DE_LA_VM:8088`.

## Arrêter

```bash
docker compose down        # ajouter -v pour supprimer aussi les données MySQL
```
