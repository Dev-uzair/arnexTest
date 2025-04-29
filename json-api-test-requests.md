# JSON API Test Requests

This document contains sample requests for testing the JSON CRUD operations.

## Prerequisites
- The Spring Boot application is running
- Default base URL: `http://localhost:8080`

## 1. Create a JSON Record (POST)

### Using cURL
```bash
curl -X POST \
  http://localhost:8080/json \
  -H 'Content-Type: application/json' \
  -d '{
    "jsonData": "{\"name\":\"John Doe\",\"age\":30,\"email\":\"john.doe@example.com\",\"address\":{\"street\":\"123 Main St\",\"city\":\"Boston\",\"state\":\"MA\",\"zipCode\":\"02108\"}}"
}'
```

### Using Postman
- Method: POST
- URL: http://localhost:8080/json
- Headers: Content-Type: application/json
- Body (raw JSON):
```json
{
  "jsonData": "{\"name\":\"John Doe\",\"age\":30,\"email\":\"john.doe@example.com\",\"address\":{\"street\":\"123 Main St\",\"city\":\"Boston\",\"state\":\"MA\",\"zipCode\":\"02108\"}}"
}
```

## 2. Get All JSON Records (GET)

### Using cURL
```bash
curl -X GET http://localhost:8080/json
```

### Using Postman
- Method: GET
- URL: http://localhost:8080/json

## 3. Get JSON Record by ID (GET)

### Using cURL
```bash
curl -X GET http://localhost:8080/json/1
```

### Using Postman
- Method: GET
- URL: http://localhost:8080/json/1

## 4. Update a JSON Record (PUT)

### Using cURL
```bash
curl -X PUT \
  http://localhost:8080/json/1 \
  -H 'Content-Type: application/json' \
  -d '{
    "jsonData": "{\"name\":\"John Doe\",\"age\":31,\"email\":\"john.updated@example.com\",\"address\":{\"street\":\"456 Oak Ave\",\"city\":\"Cambridge\",\"state\":\"MA\",\"zipCode\":\"02139\"}}"
}'
```

### Using Postman
- Method: PUT
- URL: http://localhost:8080/json/1
- Headers: Content-Type: application/json
- Body (raw JSON):
```json
{
  "jsonData": "{\"name\":\"John Doe\",\"age\":31,\"email\":\"john.updated@example.com\",\"address\":{\"street\":\"456 Oak Ave\",\"city\":\"Cambridge\",\"state\":\"MA\",\"zipCode\":\"02139\"}}"
}
```

## 5. Delete a JSON Record (DELETE)

### Using cURL
```bash
curl -X DELETE http://localhost:8080/json/1
```

### Using Postman
- Method: DELETE
- URL: http://localhost:8080/json/1

## Additional Examples

### Create a JSON Record with Array Data

```bash
curl -X POST \
  http://localhost:8080/json \
  -H 'Content-Type: application/json' \
  -d '{
    "jsonData": "{\"name\":\"Jane Smith\",\"skills\":[\"Java\",\"Spring Boot\",\"MySQL\",\"REST API\"],\"projects\":[{\"name\":\"Project A\",\"year\":2022},{\"name\":\"Project B\",\"year\":2023}]}"
}'
```

### Create a JSON Record with Nested Objects

```bash
curl -X POST \
  http://localhost:8080/json \
  -H 'Content-Type: application/json' \
  -d '{
    "jsonData": "{\"company\":{\"name\":\"Tech Solutions Inc.\",\"founded\":2010,\"location\":{\"city\":\"San Francisco\",\"country\":\"USA\"},\"departments\":[\"Engineering\",\"Marketing\",\"Sales\"]},\"active\":true}"
}'
```
