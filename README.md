
# CALCULADORA SANITAS

Proyecto desarrollado con Java11, Sprong Boot y Maven que consiste en la creación de un API Rest para operaciones de suma y resta entre dos números.

<br>

### Dependencias 

Se incluyen los starters de Spring web, test y validation

Se incluyen las dependencias de la librería añadida Tracer

Se incluyen dependencias de mockito-inline para facilitar PU de metodos estáticos.

Se incluyen dependencias de OpenAPI para documentación

<br>

### Microservicio 

Ha sido creado basandose en el patrón Factory, para favorecer la escalabilidad.

Tiene disponible un método POST en el cual se pueden hacer operaciones de suma y resta.

Control de excepciones centralizado.

Pruebas unitarias con Junit y Mockito

 <br>

### Compilación y ejecución  

- Clonar repositorio: https://github.com/jordimar/calculator.git

- En la raiz del proyecto hacer install : mvnw clean install

- Desde la raiz del proyecto ejecutar con: mvnw spring-boot:run

API disponible en: http://localhost:8080/api/calculadora/v1/calcular

La petición debe hacerse via HTTP POST y cuerpo JSON que contenga:

Petición para sumar:

http://localhost:8080/api/calculadora/v1/calcular

   {
         "num1": 3.0 , 
         "num2": 33.0,
         "operador": "suma"
    }

Petición para restar:

http://localhost:8080/api/calculadora/v1/calcular

   {
         "num1": 20.0 , 
         "num2":  5.0,
         "operador": "resta"
    }
    
 <br>
     
### Documentación 
 
 Documentación con Swagger disponible en :
 
 http://localhost:8080/swagger-ui.html
