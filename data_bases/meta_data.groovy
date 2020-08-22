@GrabConfig(systemClassLoader=true)
    @Grapes([
    //@Grab(group='org.springframework', module='spring-jdbc', version='3.0.5.RELEASE'),
    @Grab(group='mysql', module='mysql-connector-java', version='8.0.16')
    ])

// Pruebas realizadas con la base de datos de prueba sakila proporcionada por mysql en su documentación oficial.
import groovy.sql.Sql
def db = [
    url:'jdbc:mysql://localhost/sakila',
    user:'root',
    password:'root',
    driver:'com.mysql.cj.jdbc.Driver'
]

def sql = Sql.newInstance(db.url, db.user, db.password, db.driver)

processMeta = { metaData ->
    printf "%-10s %-40s %-15s \n",metaData.getColumnLabel(1),metaData.getColumnLabel(2),metaData.getColumnLabel(3)
}

consulta = "SELECT * FROM category"

sql.eachRow(consulta,processMeta){
    printf "%-10s %-40s %-15s \n",it.category_id,it.name,it[2]
}