Coverage: 94% 
	

# ToDo List Project by Mohamud Mussa

This Projected is a full-stack web application which allows users to Create, Update and Delete their Tasks. The project was created with the three-tier architecture in mind in order to prevent coupling. The frontend of the website was coded in JavaScript, HTML & CSS, Using Visual Studio Code as an IDE. The backend was coded using Spring (Java) alongside with SQL for the database layer. An API was developed using Spring in order to communicate between the frontend and the backend components. This project is fully tested with Unit, Automated and Integration testing. Agile methodology was used throughout this project alongside Kanban boards to ensure all the criteria were met and finished on schedule. 


## Table of contents
* [Prerequisite](#Prerequisite)
* [Installing](#Installing)
* [Testing](#Testing)
* [Creating JAR file](#Creating_JAR_file)
* [Deployment](#Deployment)
* [Built With](#Built_With)
* [Versioning](#Versioning)
* [Authors](#Authors)
* [License](#License)
* [Acknowledgments](#Acknowledgments)



## Getting Started

These instructions will get you a copy of the project up and running on your local machine for development and testing purposes.


### Prerequisite
* [Visual Studio Code](https://code.visualstudio.com/download)
* [Java 14.1](https://www.eclipse.org/downloads/)
* [Git](https://git-scm.com/downloads)
* [Spring Boot](https://spring.io/guides/gs/spring-boot/)
* [MySQL](https://www.mysql.com/downloads/)
* [Maven](http://maven.apache.org/download.cgi)


### Installing

1. You will need to clone down the repo, here is a link to the repo [GitHub](https://github.com/MohamudMussa/ToDoList-Project)
* To do this, Git Bash in the desired folder you'd like to clone to.
* Once Git opens, you will need to initialise git, do this with the following command;
```
Git init
```
2. After this, write 
```
Git clone
```
and copy and paste the link you wanted to clone, here it is again - [GitHub](https://github.com/MohamudMussa/ToDoList-Project)

3. Navigate to the /targer folder. Right click and select

```
GIT BASH 	
```
```
java -jar ToDoList-1.0.0-SNAPSHOT
```

5. Now open your web browser and type in *http://localhost:8080/*  
6. For the database, type in *http://localhost:8080/h2*
7. For Swagger (Understanding how the API functions) type in *http://localhost:8080/swagger-ui/index.html*


## Testing

This project has been fully tested using *Unit*, *Integration* and *Automated Testing (Selenium)*. This was done in order to cover all testing aspects of this Full Stack Application. The testing ranges from the individual unit testing and system integration testing which was done to cover the backend, all the way to frontend automated testing. This was done by using Selenium in order to ensure the website met the user acceptance criteria.

1. Unit Testing
```
In order to test and check coverage right click on the project while its open in Spring and click coverage as Junit Test.

```
2. Integration Testing
```
In order to test the Integration Testing right click on any of the two Integration Tests and click on  coverage as Junit Test.

```
1. Automated Testing
```
In order to test the user acceptance criteria test via selenium, select the selenium folder in test, right click and run the test. Chrome drivers will be running in the background and testing all user stories.

```


#### Creating JAR file:


1. Right Click on the folder of the directory containing the repository
2. Select Git Bash or open CMD
3. Write the following

```
mvn clean package
```

4. This will now run all testing, ensuring it all passes, you'll get JAR file in the target folder.

## Deployment


## Built With

* [Jira](https://code.visualstudio.com/download)
* [Visual Studio Code](https://code.visualstudio.com/download)
* [Spring Boot](https://spring.io/guides/gs/spring-boot/)

## Versioning

* Version Control System: Git
* Source Code Management: GitHub
* Database Management System: LOCAL H2

[Maven Versioning](http://maven.apache.org/download.cgi)  incremental, Minor & Major was used to update the version.


## Authors

Mohamud Mussa - Sole Developer - [MohamudMussa](https://github.com/MohamudMussa)

## License

[BootStrap](https://github.com/twbs/bootstrap/blob/v4.0.0/LICENSE)


## Acknowledgments
Savannah Vaithilingam - For teaching me JavaScript, HTML and CSS
Alan Davis - For teaching me Spring Development, Testing and all the help!


