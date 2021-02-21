# spring-framework-5

Creado con Java 15 embebido en el IDE Spring Tool Suite 4
Maven apache-maven-3.6.3


spring framework
spring websocket
spring security
	
'spring mvc'
Modelo Vista Controlador
inyeccion de dependencia
orientado al uso de interfaces
clases pojo (set/get)  --hibernate,jpa
	
- es un framework web
- el controlador esta mapeado a una ruta(mapping)
- Front Controller DispatcherServlet recibe una solicitud HTTP del navegador

Clara separacion de funciones
- controlador, validador, objeto form, DispatcherServlet(selecciona controlador y ruta), handler mapping (get,post,put,delete), view resolver, etc

controlador - servicios - dao

redirect - peticion de cero, se borran parametros
cargar una vista - pasar parametros

forward - dentro del mimos httprequest va al mismo handler sin reiniciar nada.

setear JAVA_HOME , java 15
./mvnw.cmd package
cd target
java -jar spring-boot-web-0.0.1-SNAPSHOT.jar