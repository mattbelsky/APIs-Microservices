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

## Exercise Tracker Microservice
Spring Thymeleaf MVC app that records and displays the exercises performed by registered users. 

Home page is accessed via "/" or "/home".

[Specifications can be found here.](https://fuschia-custard.glitch.me/)

### Endpoints
Aside from the endpoint mapped to the home page, most endpoints are accessible only from within the forms.

```
/api/exercise/log?username={username}&from={from}&to={to}&limit={limit}
```
HTTP GET request. Returns a view containing exercises performed by the specified user between (inclusive) the from and to dates, and limits the number of records accordingly.

## File Metadata Microservice
Allows the user to upload a file and returns the file's name and size in bytes. [Specifications here.](https://purple-paladin.glitch.me/)

The root page containing the input form can be accessed from the endpoints "/" or "/home". The value of "PATH" in FileService.java should be replaced with the path to the directory where you wish to upload files.

## Tech Stack
* Java 8
* Spring Boot
* Thymeleaf
* Maven
