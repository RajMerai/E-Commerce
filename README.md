
# E-Commerce System Project

This project is a simplified e-commerce system that handles users, products, orders, and payments. It includes system design, business logic implementation for inventory management, and database query handling for an online bookstore.


## Project Structure

 ``com.ecommerce.db:`` Contains the database connection and query execution classes.

 ``com.ecommerce.model:`` Contains models for entities such as User, Product, Order, and Payment.

``com.ecommerce.service:`` Contains business logic like inventory management.

``com.ecommerce.main.Main:`` The main class used to run the project.

## Prerequisites

``Java Development Kit (JDK):`` Ensure JDK 8 or higher is installed.

``MySQL:`` Ensure MySQL Server and MySQL Workbench are installed.

``Eclipse IDE:`` Recommended IDE for this project.

## Setting Up the Project

### Step 1: Clone the Project

If the project is on a repository (GitHub, etc.), clone it:

git clone https://github.com/your-username/ecommerce-system.git

### Step 2: Open in Eclipse IDE

1. Open Eclipse IDE

2. Select "Open or Import" and navigate to the cloned repository.

3. Open the project.

### Step 3: Set Up the Database

1. Open MySQL Workbench

2. Connect to your MySQL server.

3. Run the following SQL script to create the database and tables:

```Sql

CREATE DATABASE bookstore_db;
USE bookstore_db;

CREATE TABLE Customers (
    customer_id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(100),
    email VARCHAR(100)
);

CREATE TABLE Books (
    book_id INT AUTO_INCREMENT PRIMARY KEY,
    title VARCHAR(255),
    author VARCHAR(255),
    price DECIMAL(10, 2)
);

CREATE TABLE Orders (
    order_id INT AUTO_INCREMENT PRIMARY KEY,
    customer_id INT,
    order_date DATE,
    FOREIGN KEY (customer_id) REFERENCES Customers(customer_id)
);

CREATE TABLE OrderDetails (
    order_detail_id INT AUTO_INCREMENT PRIMARY KEY,
    order_id INT,
    book_id INT,
    quantity INT,
    FOREIGN KEY (order_id) REFERENCES Orders(order_id),
    FOREIGN KEY (book_id) REFERENCES Books(book_id)
);

CREATE TABLE Payments (
    payment_id INT AUTO_INCREMENT PRIMARY KEY,
    order_id INT,
    amount DECIMAL(10, 2),
    payment_method VARCHAR(50),
    FOREIGN KEY (order_id) REFERENCES Orders(order_id)
);


```

### Step 4: Insert Sample Data

Run the following SQL script to insert sample data:

```Sql

INSERT INTO Customers (name, email) VALUES ('Alice Smith', 'alice@example.com');
INSERT INTO Customers (name, email) VALUES ('Bob Johnson', 'bob@example.com');

INSERT INTO Books (title, author, price) VALUES ('The Great Gatsby', 'F. Scott Fitzgerald', 10.99);
INSERT INTO Books (title, author, price) VALUES ('1984', 'George Orwell', 8.99);

INSERT INTO Orders (customer_id, order_date) VALUES (1, '2023-04-18');
INSERT INTO Orders (customer_id, order_date) VALUES (2, '2023-06-24');

INSERT INTO OrderDetails (order_id, book_id, quantity) VALUES (1, 1, 2);
INSERT INTO OrderDetails (order_id, book_id, quantity) VALUES (2, 2, 1);


```

### Step 5: Configure Database Connection

Open `DatabaseConnection.java` and update the URL, USER, and PASSWORD fields with your database credentials.

```Java

private static final String URL = "jdbc:mysql://localhost:3306/bookstore_db";
private static final String USER = "root";
private static final String PASSWORD = "password";


```

### Usage

### Build and Run

1. Build the project in Eclipse IDE.

2. Run the  `Main.java` file to execute the application.

### Query Methods

#### 1. Top Customers:

   Call `executor.getTopCustomers()` to fetch and display the top customers based on book orders.

#### 2. Total Revenue by Author:

  Call `executor.getTotalRevenueByAuthor()` to display the total revenue generated by each author.

#### 3. Books Ordered More Than 10 Times:

  Call `executor.getBooksOrderedMoreThanTenTimes()` to display books ordered more than 10 times.
  
#### 4. Customers With Recent Orders:

  Call `executor.getCustomersWithRecentOrders()` to display customers who have placed orders in the last month.

### Assumptions

  The database schema provided in the `database-scripts` directory is assumed to be used.

  Sample data is inserted to test the application functionality.

  Database connection details are updated in the `DatabaseConnection.java` file.

### Contact

  For any queries, please contact [rajmerai3322@gmail.com].


  ### NOTE:-

  I Can Ceate a `database-scripts`.
