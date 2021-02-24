"Services"
crud: metodos del service
Entiy, pojo

jdbc
ORM:JPA, hibernate
API REST
arquitectura microservicios
spring cloud

principio de hollywood


''Inyeccion de dependencias''
los objetos deben estar registrados en el contenedor: usando @Component por ejemplo.

El contenedor gestiona las instancias y las dependencias

@Component y derivados, es generico
@Controller  Controller
@Service  Service
@Repository DAos

Hibernate - Entity Manager

@Autowired - inyecta un objeto que este anotada en el contenedor, con cualquier anotacion estereotipo @Component, @Controller, @Repository, @Service, @Bean etc

Cualquier bean anotado con @Component bajo el package base seran instanciados y manejados por el contenedor de spring (auto scanning)

@Configuration y @Bean- es equivalente @Component