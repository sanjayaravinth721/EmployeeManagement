# Employee Management System

## Overview

This repository contains a simple Employee Management System, a web application built with Angular (Frontend) and Spring Boot (Backend). The system allows you to perform basic CRUD (Create, Read, Update, Delete) operations for employee records.

## Prerequisites

Before running the application, make sure you have the following prerequisites installed:
- Angular (latest version)
- Spring Boot 3
- Docker
- Docker Compose
- PostgreSQL (or use the provided Docker container)

## Getting Started

1. Clone this repository to your local machine.
   ```bash
   git clone https://github.com/sanjayaravinth721/employee-management-system.git

2. Navigate to the project's root directory.
3. Start the Docker container for PostgreSQL. This will create a container for the application.
   ```bash
   docker-compose up -d
   The PostgreSQL container is named "employee_postgres". The database created is named "employee_management_system"

4. Run the Spring Boot backend server -> "http://localhost:8080"
5. Run the Angular frontend application -> "http://localhost:4200"

## Usage

Once the application is running, you can perform CRUD operations to manage employee records.

## Docker Compose

The provided Docker Compose configuration simplifies the setup process by running a PostgreSQL container with the required database.

## Database Configuration

The application uses a PostgreSQL database named employee_management_system. If you want to change the database settings, you can modify the docker-compose.yml file and the Spring Boot application's application.yml file.
