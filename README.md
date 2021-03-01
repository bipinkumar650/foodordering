## Online food ordering system

#### Use case diagram
![use case diagram](https://github.com/bipinkumar650/foodordering/blob/master/restaurentManagement.png)

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
https://github.com/bipinkumar650/foodordering/blob/master/restaurentManagementSystem.postman_collection.json  
3. Create dummy data. endpoint is provided with postman collection.
```
curl --request POST 'localhost:8080/admin/initializeData'
```
