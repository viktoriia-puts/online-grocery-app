# Online Grocery Shop

A full-stack demo web application for managing an online grocery store: browse products by category, search, add to cart, and checkout.

The project is fully Dockerized: Docker Compose starts both the Spring Boot application and a MySQL database seeded with sample data.

## ✨ Key Features & Technical Highlights

- Product catalogue with product listing, category filtering and product search
- Shopping cart functionality with add/remove actions and cart counter updates
- Cart page with quantity adjustment for selected products
- Checkout flow with customer data input and order confirmation
- Persistence of products, users, cart/order data and customer details in MySQL
- User authentication and registration with Spring Security
- Server-side rendered UI with Thymeleaf, HTML, Bootstrap and JavaScript
- Layered Spring Boot architecture using Spring MVC, Spring Data JPA and MySQL
- Dockerized local setup with Docker Compose for the Spring Boot application and MySQL database
- AWS deployment comparison using IaaS, PaaS and CaaS approaches

## 🖼️ Screenshot

| Catalogue                            |
|--------------------------------------|
| ![Catalogue view](docs/img/view.png) | 

## ☁️ Cloud Deployment Context

This application was developed as part of my bachelor thesis and used as a practical case study for comparing different cloud deployment models.

Besides the local Docker Compose setup, the application was deployed and documented using different AWS-based approaches:

- **IaaS**: deployment of the application and database on EC2 instances inside a VPC
- **PaaS**: deployment of the Spring Boot application with AWS Elastic Beanstalk and Amazon RDS
- **CaaS**: container-based deployment using a Docker image, Docker Hub and AWS ECS

The diagrams below summarize the deployment architectures.

### IaaS Deployment

![IaaS deployment architecture](docs/img/iaas-deployment-v2.jpg)

### PaaS Deployment

![PaaS deployment architecture](docs/img/paas-deployment.jpg)

### CaaS Deployment

![CaaS deployment architecture](docs/img/caas-deployment-v2.jpg)

## 🚀 Quick Start

```bash
# 1 · Clone the repository
git clone https://github.com/viktoriia-puts/online-grocery-app.git
cd bachelor-thesis-valkova

# 2 · Create and fill the .env file
cp .env.example .env
# edit .env and set
# MYSQL_ROOT_PASSWORD=<your-password>

# 3 · Run everything with Docker Compose
docker compose up --build
```
Now open in your browser:

http://localhost:8080/products

Docker Compose starts both the MySQL database and the Spring Boot application. The database schema and demo data are initialized from `init.sql` when the MySQL volume is created for the first time.

## 🔐 Environment Variables
| Variable | Purpose | Example value |
|----------|---------|---------------|
| `MYSQL_ROOT_PASSWORD` | Password for the MySQL root user. The same value is passed to the Spring Boot container as `SPRING_DATASOURCE_PASSWORD`. | `your_password_here` |

For Docker Compose, only `MYSQL_ROOT_PASSWORD` has to be set manually in `.env`.

## 🛠 Tech Stack

| Layer      | Technology                                      |
|------------|-------------------------------------------------|
| Language   | Java 21                                         |
| Back-end   | Spring Boot · Spring Data JPA · Spring Security |
| Database   | MySQL                                           |
| Front-end  | Thymeleaf · HTML · Bootstrap 5 · JavaScript     |
| Build/Run  | Gradle · Docker · Docker Compose                |

## 🔁 Recreating the Database

MySQL data is stored in a Docker volume. The `init.sql` script is executed only when the volume is created for the first time.

If you change `init.sql`, change the database password, or want to recreate the database from scratch, remove the existing volume:

```bash
docker compose down -v
docker compose up --build
```

> Warning: `docker compose down -v` deletes all local database data.