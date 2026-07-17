# CRCEact2 - Actividad 2: Spring Boot Controllers

---

<table>
  <tr>
    <td><img src="https://img.shields.io/badge/Spring%20Boot-4.1.0-brightgreen?logo=springboot" alt="Spring Boot"/></td>
    <td><img src="https://img.shields.io/badge/Java-25-orange?logo=openjdk" alt="Java"/></td>
    <td><img src="https://img.shields.io/badge/Thymeleaf-HTML-blue?logo=thymeleaf" alt="Thymeleaf"/></td>
    <td><img src="https://img.shields.io/badge/Lombok-Red?logo=lombok" alt="Lombok"/></td>
  </tr>
</table>

---

## Portada

| Campo           | Detalle                                             |
|-----------------|-----------------------------------------------------|
| **Alumno**      | Castellanos Rios Carlos Eduardo                     |
| **Materia**     | Programacion Web                                    |
| **Semestre**    | 4                                                   |
| **Actividad**   | 2 - Controllers, Model y Templates                  |
| **Universidad** | Instituto Tecnologico de Oaxaca                     |
| **Carrera**     | Ingenieria en Sistemas Computacionales              |
| **Repositorio** | [CRCEact2_t4](https://github.com/cecDev-X/CRCEact2_t4) |
| **Deploy**      | https://chatsito.com.mx                             |

---

## Descripcion del Proyecto

Aplicacion web desarrollada con **Spring Boot** que demuestra el uso de diferentes tipos de controladores (`@Controller` y `@RestController`), manejo de rutas con `@PathVariable`, `@RequestParam`, `@RequestBody`, `@ModelAttribute`, renderizado de vistas con **Thymeleaf** y una API REST para el registro de libros.

---

## Tecnologias Utilizadas

| Tecnologia     | Uso                                       |
|----------------|-------------------------------------------|
| Spring Boot    | Framework principal de la aplicacion      |
| Spring MVC     | Manejo de peticiones HTTP                 |
| Thymeleaf      | Motor de plantillas HTML                  |
| Lombok         | Generacion automatica de Getters/Setters  |
| Java 25        | Lenguaje de programacion                  |
| Maven          | Sistema de construccion y dependencias    |

---

## Endpoints

### Endpoints REST (JSON)

| Metodo | URL | Descripcion | Retorno |
|--------|-----|-------------|---------|
| `GET` | `/api/detalles_info2` | Informacion del empleado en JSON | `Map<String, Object>` |
| `GET` | `/api/variable/pagina1/{mensaje}` | Recibe parametro de ruta | `ParametroDTO` |
| `POST` | `/api/variable/solicitud` | Registra un empleado nuevo | `Empleado` |
| `GET` | `/api/variable/valores` | Lee valores de `application.properties` | `Map<String, Object>` |
| `GET` | `/api/parametros/detalle?informacion=...` | Recibe parametros por URL | `ParametroDTO` |
| `POST` | `/api/libros` | Registra un libro nuevo (REST) | `ResponseEntity<Map>` (201) |

---

### Endpoints MVC (HTML - Thymeleaf)

| Metodo | URL | Descripcion | Vista |
|--------|-----|-------------|-------|
| `GET` | `/detalles_info` | Muestra ficha del empleado | `detalles_info.html` |
| `GET` | `/libros/lista` | Lista todos los libros de la biblioteca | `lista-libros.html` |
| `GET` | `/libros/nuevo` | Formulario para registrar un libro nuevo | `formulario-libro.html` |
| `POST` | `/libros/guardar` | Guarda el libro y redirige a `/libros/lista` | Redirect |

---

### Endpoints en Produccion

> Base URL: `https://chatsito.com.mx`

| Nombre | Metodo | URL | Descripcion |
|--------|--------|-----|-------------|
| **Formulario** | `GET` | [/libros/nuevo](https://chatsito.com.mx/libros/nuevo) | Formulario para registrar un nuevo libro |
| **DetalleLibro** | `GET` | [/libros/detalle/ISBN](https://chatsito.com.mx/libros/detalle/ISBN) | Consulta los detalles de un libro por su ISBN |
| **FiltroParametro** | `GET` | [/libros/lista/filtrar?autor=NombreDelAutor](https://chatsito.com.mx/libros/lista/filtrar?autor=NombreDelAutor) | Filtra la lista de libros por autor |
| **Registrar Libro** | `POST` | [/api3/api/libros](https://chatsito.com.mx/api3/api/libros) | Registra un libro nuevo via API REST |

---

## Peticion POST - Registrar Libro

**URL:** `https://chatsito.com.mx/api3/api/libros`

**Metodo:** `POST`

**Content-Type:** `application/json`

### Ejemplo de cuerpo (Body):

```json
{
    "isbn": "978-8408224716",
    "nombre": "Inteligencia Natural",
    "autor": "Javier Botia",
    "descripcion": "Domina a Agamenon, tu gigante subconsciente que lo puede todo"
}
```

### Respuesta esperada (201 Created):

```json
{
    "datosRecibidos": {
        "isbn": "978-8408224716",
        "nombre": "Inteligencia Natural",
        "autor": "Javier Botia",
        "descripcion": "Domina a Agamenon, tu gigante subconsciente que lo puede todo"
    }
}
```

### Ejemplo con cURL:

```bash
curl -X POST https://chatsito.com.mx/api3/api/libros \
  -H "Content-Type: application/json" \
  -d '{
    "isbn": "978-8408224716",
    "nombre": "Inteligencia Natural",
    "autor": "Javier Botia",
    "descripcion": "Domina a Agamenon, tu gigante subconsciente que lo puede todo"
  }'
```

---

## Estructura del Proyecto

```
springboot-application/
├── src/main/java/com/eduardo/spring/app1/springboot_application/
│   ├── SpringbootApplication.java
│   ├── controllers/
│   │   ├── EjemploController.java          // @Controller - vistas Thymeleaf
│   │   ├── EjemploRESTController.java      // @RestController - API JSON
│   │   ├── LibroController.java            // @Controller - CRUD libros (vistas)
│   │   ├── LibroRestController.java        // @RestController - API libros
│   │   ├── PathVariableController.java     // @RestController - PathVariable
│   │   └── RequestParamControllers.java    // @RestController - RequestParam
│   └── model/
│       ├── Empleado.java                   // Modelo de empleado
│       ├── Libros.java                     // Modelo de libro
│       └── dto/
│           ├── EmpleadoDTO.java
│           ├── LibrosDTO.java
│           └── ParametroDTO.java
├── src/main/resources/
│   ├── application.properties              // Configuracion de la app
│   └── templates/                          // Vistas Thymeleaf
│       ├── detalles_info.html
│       ├── detalle-libro.html
│       ├── formulario-libro.html
│       └── lista-libros.html
├── pom.xml                                 // Dependencias Maven
└── README.md
```

---

## Ejecutar el Proyecto

### Requisitos previos
- Java 25
- Maven 3.9+

### Pasos

```bash
# Clonar el repositorio
git clone https://github.com/cecDev-X/CRCEact2_t4.git

# Entrar al directorio
cd CRCEact2_t4

# Ejecutar la aplicacion
./mvnw spring-boot:run
```

### La app estara disponible en:
- **Local:** `http://localhost:9526`
- **Produccion:** `https://chatsito.com.mx`

---

## Modelos de Datos

### Libros

| Campo        | Tipo     | Descripcion                |
|--------------|----------|----------------------------|
| `isbn`       | `String` | Codigo ISBN del libro      |
| `nombre`     | `String` | Titulo del libro           |
| `autor`      | `String` | Autor del libro            |
| `descripcion`| `String` | Descripcion del libro      |
| `stock`      | `int`    | Cantidad disponible        |
| `precio`     | `double` | Precio del libro           |

### Empleado

| Campo      | Tipo     | Descripcion          |
|------------|----------|----------------------|
| `id`       | `int`    | Identificador unico  |
| `nombre`   | `String` | Nombre del empleado  |
| `apellido` | `String` | Apellido             |
| `email`    | `String` | Correo electronico   |
| `puesto`   | `String` | Cargo o rol          |
| `edad`     | `int`    | Edad                 |
| `salario`  | `int`    | Salario              |

---

## Licencia

Proyecto realizado como parte de la materia de **Programacion Web** - Instituto Tecnologico de Oaxaca.
