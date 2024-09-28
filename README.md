Project: MyChef - Recipe Management System

This project is a Java Spring Boot application designed to manage chefs, recipes, and user interactions. It provides a comprehensive RESTful API to handle operations like adding, updating, and retrieving data for chefs, image categories, video recipes, and user histories. The API supports JWT-based authentication and implements role-based access control to secure sensitive endpoints. Additionally, the application uses the DTO pattern to ensure clean and efficient API responses and handles data persistence with Spring Data JPA. Unit tests were created using JUnit and Mockito for reliability.

Technologies Used:

Java Spring Boot: For developing the backend API.
JWT & Spring Security: To secure endpoints and implement role-based access.
Spring Data JPA: For database interactions.
Postman: For testing API endpoints.
ModelMapper: For converting entities and DTOs.
JUnit & Mockito: For unit testing and mocking dependencies.
API Endpoints:

/api/chef - Manage chef-related operations.
/api/imageCategories - Manage image categories.
/api/imagerecipe - Manage image recipes.
/api/imageUserHistory - Track user interactions with image recipes.
/api/videoRecipe - Manage video recipes and ratings.
/api/user - Manage user profiles and data.
