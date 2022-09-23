# Calculadora
Microservicio "calculadora", usando maven + spring-boot, con funcionalidades básicas de sumar y restar.


## Requisitos previos
1. Maven 3.3.9
2. Java 1.17

## Instalación

Generar el JAR a ejecutar, con las instrucciones: 
```
mvn clean package
```
Al finalizar, tendremos el JAR calculadora.jar  en /target.

## Ejecución

ava -jar target/test-0.0.1-SNAPSHOT.jar

## Pruebas

### Swager
http://localhost:8080/swagger-ui/index.html

### API REST
Petición http://localhost:8080/api/math/?operador=SUMA&primero=3&segundo=2
Petición http://localhost:8080/api/math/?operador=RESTA&primero=3&segundo=2

### TEST

mvn clean test







