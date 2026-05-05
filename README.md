Streetwear Backend

REST API built with Java and Spring Boot that simulates an e-commerce backend with users, products, and shopping cart functionality.

🚀 Features
User management (create and retrieve users)
Product management (CRUD operations and search by name)
Shopping cart system:
Add products to cart
Update quantities
Remove items
Calculate total price
📡 API Endpoints
➕ Add product to cart

POST /cart/{cedula}/add

{
  "productId": 1,
  "quantity": 2
}
🛒 Get user cart

GET /cart/{cedula}

❌ Remove item from cart

DELETE /cart/{cedula}/item/{itemId}

💰 Get total price

GET /cart/{cedula}/total

🔍 Search product

GET /products/search?name=shirt

🌐 Frontend (Work in Progress)

A basic frontend is being developed using HTML and CSS, with plans to integrate React.

🧠 Technical Details
Layered architecture (Controller, Service, Repository)
Business logic handled in service layer
JPA relationships between entities
Java Streams for data processing
Transaction management with @Transactional
Logging with SLF4J
⚠️ Limitations
No authentication/authorization
Basic validation
No concurrency handling
🛠️ Tech Stack
Java
Spring Boot
Jakarta Persistence (JPA)
Lombok
HTML & CSS
Maven
▶️ How to Run
git clone https://github.com/NlCOl4S/StreetWear.git
cd StreetWear
./mvnw spring-boot:run
📌 Future Improvements
Add authentication (JWT)
Improve validation and error handling
Integrate full frontend (React)
Deploy application
