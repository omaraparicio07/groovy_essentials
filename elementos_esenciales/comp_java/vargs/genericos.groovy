class Genericos{
        def usaLista(){
          ArrayList<Integer> list = new ArrayList<Integer>();
          list.add(1);
          list.add(2.0); // ????
          list.add("hello"); // ???
          list
        }
      }
     

def g = new Genericos()
g.usaLista()


import groovy.sql.*
import com.mchange.v2.c3p0.ComboPooledDataSource
  
class DB {

  def sqlMySQL

  private DB() {

    ComboPooledDataSource mysql = new ComboPooledDataSource(
      driverClass:DBParameters.MYSQL_PARAMS.driver,
      jdbcUrl:DBParameters.MYSQL_PARAMS.url,
      user:DBParameters.MYSQL_PARAMS.user,
      password:DBParameters.MYSQL_PARAMS.password,
      minPoolSize: 5,
      maxPoolSize: 80,
      acquireIncrement: 10,
      numHelperThreads:40
      );

    sqlMySQL = Sql.newInstance(mysql)
  
  }

  def withMySQLInstance(closure){
    closure(sqlMySQL)
  }

}

def query = "select 2+2 as SUMA"

DB.instance.withMySQLInstance { sql ->
  assert sql.firstRow(query)[0] == 4
}

// def factorial(BigInteger number) {
//     number == 1 ? 1 : number * factorial(number - 1)
//   }
// try {
// println "factorial of 5 is ${factorial(5)}"
// println "Number of bits in the result is ${factorial(5000).bitCount()}"
// } catch(Throwable ex) {
//   println "Caught ${ex.class.name}"
// }

⁄

def factorial
      factorial = { int number, BigInteger theFactorial -> 
          number == 1 ? 
              theFactorial : 
              factorial.trampoline(number - 1, number * theFactorial)
      }.trampoline()
println "factorial of 5 is ${factorial(5, 1)}"
println "Number of bits in the result is ${factorial(5000, 1)}"