# Makersharks Supplier Search API

## Project Overview

This project is a proof of concept for the Makersharks supplier search API, developed using Spring Boot. The API allows buyers to search for manufacturers based on location, nature of business, and manufacturing processes.

## Technology Stack

- Java
- Spring Boot
- Spring Data JPA
- Oracle DB

## Setup Instructions

##### Clone source code from git
```bash
$ git clone 
```

##### Navigate to the project directory:

```bash
$ cd makersharks-supplier-search-api .
```

##### Build the project using Maven:

```bash
$ mvn clean install
```
##### Connect DB in src/main/resources/application.properties:

```bash
$ spring.application.name=searchApi
spring.datasource.url=jdbc:oracle:thin:@localhost:1521/xe //No changes required for Oracle DB, other databases need to be configured. 
spring.datasource.username=your_username
spring.datasource.password=your_password
server.port=8082 
```

##### Run the application:

```bash
$ mvn spring-boot:run
```
## API Usage

##### Endpoint: '/api/supplier/query'

##### Method: 'POST'

##### Request Body:
```bash
$ {
  "location": "Ooty",
  "natureOfBusiness": "medium_scale",
  "manufacturingProcess": "casting",
  "page": 1, (optional)
  "size":10  (optional)
}

```

##### Response:
```bash
$ {
    "data": {
        "content": [
            {
                "supplierId": 5,
                "companyName": "E",
                "website": "e.com",
                "location": "Ooty",
                "natureOfBusiness": "medium_scale",
                "manufacturingProcesses": "casting"
            }
        ],
        "pageable": {
            "pageNumber": 0,
            "pageSize": 10,
            "sort": {
                "empty": true,
                "sorted": false,
                "unsorted": true
            },
            "offset": 0,
            "paged": true,
            "unpaged": false
        },
        "last": true,
        "totalPages": 1,
        "totalElements": 1,
        "size": 10,
        "number": 0,
        "sort": {
            "empty": true,
            "sorted": false,
            "unsorted": true
        },
        "first": true,
        "numberOfElements": 1,
        "empty": false
    },
    "status": "OK"
}

```

## Curl Commands

```bash
$ curl -X POST http://localhost:8080/api/supplier/query \
-H "Content-Type: application/json" \
-D '{
      "location": "India",
      "natureOfBusiness": "small_scale",
      "manufacturingProcess": "3d_printing"
    }'


```

## Troubleshooting
##### Ensure you have Java and Maven installed.
##### If you face issues with database connections, check the application.properties configuration.
##### Connect your database to start with API. Oracle DB dosesn't need any configuration, other databases need to be configured. 