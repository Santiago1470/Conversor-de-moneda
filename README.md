# Conversor de moneda
Este proyecto fue desarrollado para el programa educativo de Oracle ONE en la plataforma de Alura para el curso de Java Orientado a Objetos G7 - ONE, donde se aprendió el lenguaje de programación Java, programación orientada objetos, estructuras de datos y consumo de APIs. El proyecto desarrollado se encarga de realizar solicitudes a una API de tasas de cambio, a manipular datos JSON y, finalmente, a filtrar y mostrar la conversión deseada según la opción que seleccione el usuario.
## Descipción del desafío
### Pasos generales para completar el desafío
1. Consumo de la API
2. Análisis de la Respuesta JSON
3. Filtro de Monedas
4. Exibición de Resultados a los usuarios
### Funciones extra
1. Historial de Conversiones: Agrega la capacidad de rastrear y mostrar el historial de las últimas conversiones realizadas, brindando a los usuarios una visión completa de sus actividades.
2. Soporte para Más Monedas: Amplía la lista de monedas disponibles para la elección, permitiendo a los usuarios convertir entre una variedad aún mayor de opciones monetarias.
3. Registros con Marca de Tiempo: Utiliza las funciones de la biblioteca java.time para crear registros que registren las conversiones realizadas, incluyendo información sobre qué monedas se convirtieron y en qué momento.
## Prerrequisitos y recomendaciones
Antes de usar el proyecto y debido a que no está pensado para un usuario final determinado, se debe tener instalado como mínimo la versión 16 de JDK (Java Development Kit) y algún IDE o herramienta de desarrollo. Se recomienda usar el IDE IntelliJ IDEA (IDE usado para desarrollar este proyecto).
## Instrucciones de uso
Para hacer uso de este proyecto se debe seguir los siguientes pasos:
1. Clonar o descargar el repositorio del proyecto
2. Descomprimir el archivo descargado (en caso de haber descargado el repositorio)
3. Abrir el proyecto en un IDE (Entorno de Desarrollo Integrado) o herramienta de desarrollo
## Nota
Para usar la API consumida en el proyecto se debe crear una cuenta en www.exchangerate-api.com y seguir los pasos para obtener la API KEY personal. Una vez obtenida la API KEY, se debe crear un archivo llamado "config.properties" en el mismo nivel de la carpeta src, es decir, dentro de la carpeta "Conversor-de-moneda" (carpeta principal). Dentro del archivo "config.properties" se debe crear la propiedad "api.key" y asignarle el valor de la API KEY obtenida. Ejemplo: api.key=MI-API-KEY. Teniendo listo esto, no debería haber problemas para consumir la API ExchangeRate-API.
## Autor
Santiago Jair Torres Rivera
