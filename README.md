# integrador5_heroku

# Consigna
> Ejercicio Integrador
> 
>1) Considere el diseño de un registro de estudiantes, con la siguiente información: nombres, 
>universitaria, carrera(s) en la que está inscripto, antigüedad en cada una de esas carreras, y 
>si se graduó o no. Diseñar el diagrama de objetos y el diagrama DER correspondiente.
>
>2) Implementar consultas para:
>   
>     a) dar de alta un estudiante
> 
>     b) matricular un estudiante en una carrera
> 
>     c) recuperar todos los estudiantes, y especificar algún criterio de ordenamiento simple.
> 
>     d) recuperar un estudiante, en base a su número de libreta universitaria.
> 
>     e) recuperar todos los estudiantes, en base a su género.
> 
>     f) recuperar las carreras con estudiantes inscriptos, y ordenar por cantidad de inscriptos.
> 
>     g) recuperar los estudiantes de una determinada carrera, filtrado por ciudad de residencia.
>
> 3) Generar un reporte de las carreras, que para cada carrera incluya información de los 
>inscriptos y egresados por año. Se deben ordenar las carreras alfabéticamente, y presentar
>los años de manera cronológica.]

### Despliegue la aplicación en el sistema Heroku

link donde corre la API dentro del sistema Heroku
	[https://integrador5marina.herokuapp.com](https://integrador5marina.herokuapp.com)

## Testing
La documentación sobre el testeo de la aplicación corriendo en Heroku se realizó usando Postman. 

A continuación se adjunta un link de descarga del archivo donde se encuentran las pruebas realizadas, para su descarga e importación en Postman.

[testeo_de_aplicacion_corriendo_en_heroku.postman_collection.json](https://drive.google.com/file/d/1vZlEUrpOQ5i-Y0oWy6GUIroo9WKyb6Lx/view?usp=share_link)

Una vez importado en Postman el archivo .json se recomienda ejecutar la colección como se muestra a continuación.

Abrir pantalla para correr tests sobre endpoints.

![image](https://github.com/01Marina/integrador5_heroku/assets/70240661/723fdad3-a0d0-4f01-b236-374887484910)



## Documentación de endpoints REST

### Swagger (OpenAPI)

Se realizó la documentación de endpoints REST de las siguientes Apis, “Students”, “Carrers” y “Enrollmentstudents”.

El siguiente link redirige a la página Swagger autogenerada a partir del código de las API REST.

[https://integrador5marina.herokuapp.com/swagger-ui/#/](https://integrador5marina.herokuapp.com/swagger-ui/#/)

Vistas previas de interfaz Swagger

![image](https://github.com/01Marina/integrador5_heroku/assets/70240661/a431e767-b819-4bb0-b9d6-1a8813275c2c)

