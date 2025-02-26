# TM30 Product and Order Management API

This project implements a Product and Order Management API using Spring Boot. It allows users to create, retrieve, update, and delete products, as well as create and retrieve orders.

## Table of Contents

- [Features](#features)
- [Technologies](#technologies)
- [Getting Started](#getting-started)
    - [Prerequisites](#prerequisites)
    - [Installation](#installation)
    - [Running the Application](#running-the-application)
- [API Endpoints](#api-endpoints)
    - [Product Endpoints](#product-endpoints)
    - [Order Endpoints](#order-endpoints)
    - [Home Endpoint](#home-endpoint)
- [Entities](#entities)
    - [Product](#product)
    - [Order](#order)
- [DTOs](#dtos)
    - [Product DTOs](#product-dtos)
    - [Order DTOs](#order-dtos)
- [Services](#services)
    - [Product Services](#product-services)
    - [Order Services](#order-services)
- [Repositories](#repositories)
    - [Product Repository](#product-repository)
    - [Order Repository](#order-repository)
- [Utilities](#utilities)
    - [Product Utilities](#product-utilities)
    - [Order Utilities](#order-utilities)
- [Error Handling](#error-handling)
- [Testing](#testing)
- [Contributing](#contributing)
- [License](#license)

## Features

- **Product Management:**
    - Create, retrieve, update, and delete products.
- **Order Management:**
    - Create new orders.
    - Retrieve all orders.
- **Home Endpoint:**
    - Simple welcome endpoint.

## Technologies

- Spring Boot
- Java
- JPA/Hibernate
- Lombok
- Maven
- H2 Database (for development)
- Logback (for logging)

## Getting Started

### Prerequisites

- Java Development Kit (JDK) 17 or higher
- Maven
- An IDE (IntelliJ IDEA, Eclipse, etc.)

### Installation

1. Clone the repository:

   ```bash
   git clone https://github.com/chijay69/TM30.git
   
## notes:
### comment out the eureka service in the pom.xml file to test without eureka
### comment out eureka settings in application.properties file to test without eureka
### use H2 database, it is an inmemory db as instructed.
### thank you.