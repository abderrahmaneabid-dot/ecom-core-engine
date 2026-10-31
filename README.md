# E-Commerce Core Engine

A robust, in-memory core processing engine for e-commerce applications built with modern Java. This project emphasizes clean architecture, design patterns, functional programming paradigms, and bulletproof error handling without heavy framework overhead.

## 🚀 Key Features & Architectural Highlights

- **Object-Oriented Architecture**: Clean domain model leveraging abstract classes (`Product`), specialized polymorphic implementations (`PhysicalProduct`, `DigitalProduct`), and immutability via final value objects (`OrderId`).
- **Generic Repository Pattern**: Decoupled data-access abstraction (`CrudRepository<T, ID>`) implemented with thread-safe principles in `InMemoryRepository<T, ID>` utilizing hash maps and dynamic key extraction (`Function<T, ID>`).
- **Functional Programming & Streams API**:
    - Declarative business rules using built-in functional interfaces (`Predicate`, `Consumer`, `Function`).
    - Dynamic discount engine powered by custom functional strategies (`@FunctionalInterface DiscountStrategy`).
    - Complex aggregation, revenue reporting, and top-order metrics via Java Streams (`filter`, `sorted`, `mapToDouble`, `collect`).
- **Fault-Tolerant Exception Handling**: Distinct handling between recoverable business exceptions (`OrderProcessingException`) and runtime lookups (`ProductNotFoundException`) with modern `Optional<T>` unwrapping.
- **Data Persistence**: JSON serialization and deserialization via Jackson (`ObjectMapper`) with polymorphic type handling.

## 📁 Project Structure

```text
com.abdo/
├── model/         # Domain entities, enums, and immutable value objects
├── repository/    # Generic CRUD abstractions and in-memory persistence
├── service/       # Business logic, stream aggregations, and discount engine
├── exception/     # Custom checked and unchecked exceptions
└── Main.java      # Application bootstrap and pipeline runner