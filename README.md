# rest-calculator
Rest Service for Calculator using Jersey (JAX-RS) + Swagger

## Steps

Build and run locally:
```
gradle clean jettyRunWar
```

Swagger UI at [http://localhost:8080/swagger-ui/](http://localhost:8080/swagger-ui/)

API engpoints:
* GET /api/calculator/square?input=4
* GET /api/calculator/squareroot?input=4
* GET, POST /api/file


## References
* [Jersey: RESTful Web Services in Java.](https://jersey.java.net/) [github](https://github.com/jersey/jersey/)
* [Swagger](http://swagger.io/)
* [Swagger Annotations](https://github.com/swagger-api/swagger-core/wiki/Annotations-1.5.X)
* [Jersey2.x + Swagger Setup](https://github.com/swagger-api/swagger-core/wiki/Swagger-Core-Jersey-2.X-Project-Setup-1.5)
