# springboot-cloud-demo-one
Java application for Spring Cloud training

## Installation
To run that project you have to install JDK, Maven...

In your favorite IDE you have to install Lombook plugin that generates getters & setters for pojo.

See detailed instructions at https://github.com/vlytsus/springboot-cloud-demo-one/wiki/Prepare-development-environment


## Usage
To run service call 

```bash
gradle bootRun
or
mvn spring-boot:run
```

To create new user you make HTTP POST request to: http://localhost:8081/users/
With body
```
{ "username":"testy_testerson", "password":"pa$$W0rd", "firstName":"Testy", "lastName":"Testerson" }
```
To list all users make HTTP GET request to http://localhost:8081/users/
And you should see response like:
```
[{"userId":"f0525226-2ad3-4250-b793-9374b363e60e","username":"testy_testerson","password":"pa$$W0rd","firstName":"Testy","lastName":"Testerson","active":null}]
```


## Contributing
Pull requests are welcome. For major changes, please open an issue first to discuss what you would like to change.

Please make sure to update tests as appropriate.

## License
[MIT](https://choosealicense.com/licenses/mit/)
