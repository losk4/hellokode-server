# Hellokode Server
API REST simple para la búsqueda de películas.

Se ha utilizado:
- Spring Boot 3.0.4
  - Starter WebFlux (API reactiva con anotaciones anidadas)
  - Starter Security (autenticación básica)
- Maven 4.0.0
- API TMDB -> https://developers.themoviedb.org/3/getting-started/introduction

## Ejecución 
### Requisitos: 
- Java 17+

Ejecutar el JAR ya proporcionado con el proyecto:

`java -jar hellokode.jar`

O bien compilar y construir uno nuevo con el wrapper de Maven (se encontrará en la carpeta **target**):

`./mvnw clean package`

El servidor Netty se lanzará en http://localhost:8080

Para acceder a la API se necesitarán las siguientes credenciales:
- Username: user
- Password: user

## Endpoint

`GET /api/v1/search/movie`

### Descripción

Obtener películas por nombre y página, en orden de relevancia descendiente.

### Parámetros

- query (valor por defecto "")
- page (valor por defecto "1")

### Retorno (en caso de éxito):

Cuerpo JSON con los siguientes campos:
- page: nº de página
- results: array con las películas encontradas junto a sus detalles
- total_results: nº de películas totales
- total_pages: nº de páginas totales

### Ejemplo 

Se pueden realizar peticiones HTTP mediante cualquier cliente (Navegador, Postman, Curl...):

p. ej. `curl -u "user:user" "http://localhost:8080/api/v1/search/movie?query=Gato&page=1"`

También se admiten peticiones XHR (CORS establecido para cualquier dominio).

