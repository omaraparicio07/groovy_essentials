@GrabConfig(systemClassLoader=true)
    @Grapes([
    //@Grab(group='org.springframework', module='spring-jdbc', version='3.0.5.RELEASE'),
    @Grab(group='mysql', module='mysql-connector-java', version='8.0.16')
    ])
// Añadiendo categoria a la DB sakila
import groovy.sql.Sql
def db = [
    url:'jdbc:mysql://localhost/sakila',
    user:'root',
    password:'root',
    driver:'com.mysql.cj.jdbc.Driver'
]
def sql = Sql.newInstance(db.url, db.user, db.password, db.driver)

def params = ["No se muestra el listado",2,new Date()-10]

def insertSql = "insert into category(name) values( ?);"

// sql.execute insertSql, params // PreparedStatement

//Ahora usemos dataset y dejemos que haga el trabajo por nosotros...
dataset = sql.dataSet('category')
//busquemos solo unos clientes bajo el id
filterIssues = dataset.findAll{
    it.category_id >= 3 && it.category_id<=10
}

println "Mostrando las categorias con el ID entre 3 y 10"

filterIssues.each{ 
    printf "%-10s %-40s %-15s \n",it.category_id,it.name,it[2]
}

println "SQL: " + filterIssues.sql
//Solo los siguientes parametros son validos dentro de la busqueda en un dataset
// && and
// || or
// == =
// it.propiedad propiedad
// contante ?

def counter = sql.firstRow("SELECT count(*) as counter FROM category;")['counter']

println "La cantidad de categorias actual es: $counter"
println "Agregando un nueva cateforia"

dataset.add(
    name:"Fantasy",    
)

println "La cantidad de categorias actual es: ${sql.rows('SELECT * FROM category').size()}"