## Restaurent management system 

#### Use case diagram
![alt text](restaurentmanagement.png)

####Tech stack used:
language: Java  
DB: Mongo  
Framwork: Spring Boot  

#### How to run and test the application
1. Install mongoDb on the system. You can use the docker-compose file to run it locally as well  
```
docker-compose up -d
```
2. Download Postman collection.
```
restaurentManagementSystem.postman_collection.json
```
3. Create dummy data. endpoint is provided with postman collection.
```
curl --request POST 'localhost:8080/admin/initializeData'
```