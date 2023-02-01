### 1. Install Docker compose.
run commands :
```
docker run --name postgres-db -p 5432:5432 -e POSTGRES_PASSWORD=postgres -d postgres
docker run -p 9000:9000 -p 9001:9001 \
  quay.io/minio/minio server /data --console-address ":9001"
  ```
  
### 2. Connect to Postgres and run command :
```
create database victor_db
```

### 3. Run app by command 
```
mvn spring:boot run
```
(Or do it from your IDE ui)

### 4. 
```
curl --location --request POST 'localhost:8080/api/v1/fs/upload' \
--form 'file=@"location/to/photo"'
```

### 5. 
```
curl --location --request POST 'localhost:8080/api/v1/product' \
--header 'Content-Type: application/json' \
--data-raw '{
    "name" : "my-name",
    "description" : "my-description",
    "amount" : 26,
    "price" : 435,
    "photo" : {
        "id" : 1
    }
}'
```
