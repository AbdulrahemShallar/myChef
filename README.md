# **Project: MyChef - Recipe Management System** #

The goal of this project is to manage user interactions, recipes, and chefs using a Java Spring Boot application. In order to manage tasks like adding, editing, and retrieving data for chefs, image categories, video recipes, and user histories, it offers a comprehensive RESTful API. To protect critical endpoints, the API employs role-based access control and offers JWT-based authentication. The application also leverages Spring Data JPA for data persistence and the DTO pattern to guarantee clean and effective API responses. Mockito was used for dependability and JUnit was used to construct unit tests.

## **Technologies Used:** ##

> * Java Spring Boot: For developing the backend API.

> * JWT & Spring Security: To secure endpoints and implement role-based access.

> * Spring Data JPA: For database interactions.

> * Postman: For testing API endpoints.

> * ModelMapper: For converting entities and DTOs.

> * JUnit & Mockito: For unit testing and mocking dependencies.

## **API Endpoints:** ##

/api/chef - Manage chef-related operations.

/api/imageCategories - Manage image categories.

/api/imagerecipe - Manage image recipes.

/api/imageUserHistory - Track user interactions with image recipes.

/api/videoRecipe - Manage video recipes and ratings.

/api/user - Manage user profiles and data.
