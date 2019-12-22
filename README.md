# spring-jooq-example
An example project to learn how to use Spring Boot with JOOQ and Flyway.

## Prerequisite
- JDK 1.8 or later
- Maven 3.6.x

## Dependency
- Spring Boot - DI framework
- [JOOQ](https://www.jooq.org/) - Type safe query generator
- [Flyway](https://flywaydb.org/) - DB migration library
- [H2 Database](http://www.h2database.com/html/main.html) - Lightweight DB engine


## Quick tour

- Run spring boot application.
~~~sh
$ mvn spring-boot:run
~~~

- Execute curl command.
~~~sh 
$ curl http://localhost:8080/api/projects
~~~

- API response
~~~json
[{"id":1,"name":"project1","version":"1.0.0"},{"id":2,"name":"project2","version":"1.0.0"}]
~~~

## H2 Database command

### Run H2 shell

~~~sh
$ java -cp ~/.m2/repository/com/h2database/h2/1.4.200/h2-1.4.200.jar org.h2.tools.Shell
~~~

output

~~~
Welcome to H2 Shell 1.4.200 (2019-10-14)
Exit with Ctrl+C
[Enter]   jdbc:h2:~/spring-jooq-sample
URL       
[Enter]   org.h2.Driver
Driver    
[Enter]   sa
User      
Password  
Connected
Commands are case insensitive; SQL statements end with ';'
help or ?      Display this help
list           Toggle result list / stack trace mode
maxwidth       Set maximum column width (default is 100)
autocommit     Enable or disable autocommit
history        Show the last 20 statements
quit or exit   Close the connection and exit

sql>
~~~

## Flyway command

### 

Invoke 

~~~sh
$ flyway -user=sa -password= -url=jdbc:h2:~/spring-jooq-sample -locations=filesystem:$(pwd)/db/migration info
~~~

will output something like

~~~
Flyway Community Edition 6.0.8 by Redgate
WARNING: Skipping filesystem location:/Users/kazu/work/spring-jooq-example/db/migration (not found)
Database: jdbc:h2:~/spring-jooq-sample (H2 1.4)
Schema version: 2

+-----------+---------+-------------+------+---------------------+--------+
| Category  | Version | Description | Type | Installed On        | State  |
+-----------+---------+-------------+------+---------------------+--------+
| Versioned | 1       | schema      | SQL  | 2019-12-22 20:46:37 | Future |
| Versioned | 2       | data        | SQL  | 2019-12-22 20:46:37 | Future |
+-----------+---------+-------------+------+---------------------+--------+

~~~

You can see subcommand if no option is given.