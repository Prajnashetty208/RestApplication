Set up the Spring Boot project with the following configuration from start.spring.io portal

Spring Version - 2.3.7.RELEASE Java Version - 8 Spring Cloud Version - Hoxton.SR9

Add the following dependencies

 <dependency>
        <groupId>org.springframework.cloud</groupId>
        <artifactId>spring-cloud-config-server</artifactId>
    </dependency>
Create a file called bootstrap.yaml under src/main/resources directory

Add the following code under the bootstrap.yaml file

spring: application: name: configserver

Create a directory called config under src/main/resources directory

Create two directories called inventoryservice and orderservice under the src/main/resources/config directory

In the orderservice directories create three files namely

orderservice.properties orderservice-dev.properties orderservice-qa.properties

In the application.yaml file add the below configuration

spring: profiles: # native is the way to define the location of file system active: native cloud: config: server: native: # configuring the inventoryservice and orderservice search-locations: classpath:/config/responseservice, classpath:/config/orderservice #server port for the spring cloud config server server: port: 8888

Add the @EnableConfigServer annotation on the main class

Start the server and verify the configuration for inventoryservice and orderservice for default, dev and qa profile

URL to verify the inventoryservice configuraion - http://localhost:8888/orderservice/dev

Lab 2 - Private Git repo

Create a branch from 2.0.0-private-git-repo-start tag Open the application.yaml file Configure the spring.profiles.active to git

Configure the git repo for orderservice

cloud: config: server: git: uri: git@gitlab.com:Prajnashetty208/Configservice.git

Configure the responseservice git repo

spring: profiles: active: git cloud: config: server: git: uri: git@gitlab.com:Prajnashetty208/Configservice.git repos: responseservice: uri: git@gitlab.com:Prajnashetty208/Configservice.git clone-on-startup: true

Lab 3 - Encrypting sensitive information

Add the encrypt.key property in bootstrap.properties file