import java.sql.Connection
import static java.sql.DriverManager.*

@groovy.transform.ToString // Provee un método toString
class Curso{
  String nombre
  Integer duracion
  BigDecimal costo
}

println new Curso(nombre:"Groovy&Grails",duracion:40,costo:8000.00)

// ========================================================== //

@groovy.transform.EqualsAndHashCode // Provee una implementación por default para equals() y hashCode()
class Posicion{
  Integer x,y
}

def p1 = new Posicion(x:30,y:90)
def p2 = new Posicion(x:30,y:90)

assert p1 == p2
assert p1.hashCode() == p2.hashCode()

// ========================================================== //

@groovy.transform.TupleConstructor // Provee un constructor con todas las propiedades
class Auto{
  String modelo
  Integer anio
  BigDecimal precio
}

def a = new Auto('Dodge Challenger',2012,500000.00)

println a.dump()

// ========================================================== //

// @Canonical == @ToString + @EqualsAndHashCode + @TupleConstructor 

// ========================================================== //

class Persona {
  @Lazy // No se crea en este momento
  def connection = getConnection('jdbc:mysql://localhost/no_existe', 'sa', '')
}
assert new Persona()

// ========================================================== //

@groovy.transform.InheritConstructors
class MyPrintWriter extends PrintWriter { }
assert new MyPrintWriter(new File('out.txt'))