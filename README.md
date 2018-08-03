# APIs-Microservices
API and Microservice Projects from FreeCodeCamp

## Timestamp Microservice
Reads a user-input date string from a URL endpoint, validates it, and returns a JSON response containing more data about the date if valid or an error response if invalid.

[Specifications can be found here.](https://curse-arrow.glitch.me/)

### Endpoint
```
/timestampservice/api/timestamp/{date_string}
```
HTTP GET request. Valid input is an ISO-8601 formatted (YYYY-MM-DD) date or milliseconds from start of current era (1970-01-01).

## Request Header Parser Microservice
Displays the IP address, language, and operating system and browser of the user's device.

[Specifications can be found here.](https://dandelion-roar.glitch.me/)

### Endpoint
```
/requestheaderparserservice/api/whoami
```
HTTP GET request.

## Tech Stack
* Java 8
* Spring Boot
* Maven
