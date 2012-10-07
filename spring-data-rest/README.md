Spring Data REST Demo
=====================

Show Spring Data REST in action. 
It expose JPA Entities trought Spring MVC with some HATEOAS capabilities.

Build & Deploy
--------------
To build use:

    mvn clean package

To hot-deploy on jetty use:

    mvn jetty:run

Visit the links:

* http://localhost:8080/
* http://localhost:8080/rest

Inject some datas:

    ./initdatas.sh

Some REST request:

    curl -v -X POST -H 'Content-Type: application/json' -d '{"name":"John Doe"}' http://localhost:8080/accounts/rest/people 
    curl -v -X PUT -H 'Content-Type: application/json' -d '{ "name":"Agilegeeks" }' http://localhost:8080/accounts/rest/people/1
    curl -v -X DELETE -H 'Content-Type: application/json' http://localhost:8080/accounts/rest/people/1

    curl -v -X POST -H 'Content-Type: application/json' -d '{ "type":"fb" }' http://localhost:8080/accounts/rest/profile
    curl -v -X PUT -H 'Content-Type: application/json' -d '{ "type":"fb", "url":"http://google.com" }' http://localhost:8080/accounts/rest/profile/1
    curl -v -X DELETE -H 'Content-Type: application/json' http://localhost:8080/accounts/rest/profiles/1

    curl -v -X POST -H 'Content-Type: application/json' -d '{ "city":"paris" }' http://localhost:8080/accounts/rest/address
    curl -v -X PUT -H 'Content-Type: application/json' -d '{ "lines":[ "line1", "line2" ] }' http://localhost:8080/accounts/rest/address/1
    curl -v -X PUT -H 'Content-Type: application/json' -d '{ "postalCode":"75012" }' http://localhost:8080/accounts/rest/address/1

    curl -v -X POST -H 'Content-Type: application/json' -d '{"name":"John Doe", "addresses":[ { "id":1 } ] }' http://localhost:8080/accounts/rest/people

    curl -v http://localhost:8080/accounts/rest/people?limit=5
    curl -v http://localhost:8080/accounts/rest/people?page=2&limit=5
 
    curl -v http://localhost:8080/accounts/rest/people/search/nameContaining?name=am


References
----------
* https://github.com/intesar/Spring-data-rest-sample
* http://www.springsource.org/spring-data/rest
* http://www.springsource.org/spring-data/jpa
* http://xebee.xebia.in/2012/09/23/giving-rest-to-your-jpa-repositories
* http://www.brucephillips.name/blog/index.cfm/2012/9/25/Using-Spring-Data-REST-To-Easily-Create-RESTful-Endpoints-For-Data-Stored-In-A-Database
