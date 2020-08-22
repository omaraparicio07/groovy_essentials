@GrabConfig(systemClassLoader=true)
    @Grapes([
    @Grab(group='org.springframework', module='spring-jdbc', version='3.0.5.RELEASE'),
    @Grab(group='mysql', module='mysql-connector-java', version='8.0.16')
    ])

import org.springframework.jdbc.core.JdbcTemplate
import org.springframework.jdbc.datasource.DriverManagerDataSource
import org.springframework.jdbc.core.RowMapper
import groovy.transform.*

class Issue{
Long id
String description
Integer priority
Date dateCreated
}

def dataSource = new DriverManagerDataSource("com.mysql.cj.jdbc.Driver", "jdbc:mysql://localhost/sakila", "root", "root") 
def jt = new JdbcTemplate(dataSource:dataSource)
int contador = jt.queryForInt("select count(*) from film")
println "Existen ${contador} films"

def lista = jt.query("Select * from film",{ resultset,rownum -> 
new Issue(id:resultset.getLong(1)) } as RowMapper
)

lista.each { println it.id }