List City ATMs
==============

This project is a Java Web application that exposes a REST/JSON web service. The exposed API from this Web application is used to create a list of ATMs
in a given Dutch city.

The Web application invokes an external service API from the URL: ```https://www.ing.nl/api/locator/atms/``` in order to gather a super set of the data.
The gathered data is then processed by the Web application and returned as a well formed JSON Response.

Building The Project
====================

This project compiles with ```JDK >= 1.7``` and uses ```Maven >= 3.1.1``` as the build tool and also to manage the project dependencies.

To run a full Maven build, execute the following from a console/command prompt with the project root directory as the top level directory:

```mvn clean package```

To run a Maven build that skips executing Unit Tests, execute the following from a console/command prompt with the project root directory as the top level directory:

```mvn clean package -DskipTests -Dinvoker.skip=true```

This will create a distributable and deployable WAR file for the web application. This WAR file can be deployed on the latest versions of web servers/containers e.g Jetty, Tomcat, WildFly, TomEE etc.

This project includes some plug-ins it's the Maven Build file for deploying into various commonly used JavaEE Server's.

In order to build and deploy it to the Apache TomEE Server, execute the following command:

```mvn clean package tomee:run -DskipTests -Dinvoker.skip=true```

In order to build and deploy it to the WildFly X.X.X.Final Server, execute the following command:

```mvn clean package antrun:run -Pdeploy-war -DskipTests -Dinvoker.skip=true```

In order to build and deploy it to either Tomcat or Jetty Server, execute only one of the following commands:

```mvn jetty:run-war```

```mvn jetty:run-war -DskipTests -Dinvoker.skip=true```

```mvn tomcat7:run-war```

```mvn tomcat7:run-war -DskipTests -Dinvoker.skip=true```

This will create a distributable WAR file and deploy it in the respective embedded Tomcat or Jetty Server.

- To view all the ATMs that are listed by this web application, open the following URL in a web browser:

  `http://localhost:8080/ListCityATM/listATMs`

- To view only those ATMs that are listed for a particular city, open the following URL in a web browser:

  `http://localhost:8080/ListCityATM/listATMsByCity?city=CITY_NAME`

  and then substitute the parameter value (CITY_NAME) with the actual city name e.g 

  ```MAASTRICHT``` , ```AMSTERDAM``` , ```ROTTERDAM``` , ```EINDHOVEN``` , ```MIDDELBURG```, ```ZOETERMEER```, ```SYDNEY```, ```BERLIN``` e.t.c

- To view the home page of this web application, open the following URL in a web browser:

  `http://localhost:8080/ListCityATM/`

  and then enter the required ```username``` and ```password``` credentials in order to log in to the Web application.

To run Unit tests for this project, execute the following:

```mvn clean test```

### Instructions

Eclipse users may run the command: `mvn eclipse:clean eclipse:eclipse` and then import the whole project with it's source code as a Maven project into the Eclipse IDE.

To generate project documentation of Java source files (Javadoc), run: ```mvn javadoc:javadoc```