@Singleton // Implementa el modelo de instanciación Singleton
class Servicio{}

assert Servicio.instance
try{
  new Servicio()
}catch(RuntimeException e){
  println e.message
}

def s1 = Servicio.instance
def s2 = Servicio.instance

assert s1 == s2
println "S1:$s1 y S2:$s2"

// ========================================================== //

class MiPropioSet implements Set {
  @Delegate
  Set delegate = new HashSet()
  @Override
  boolean add(i) {
    println "adding $i"
    delegate.add(i)
  }
  @Override
  boolean addAll(Collection i) {
    for(def x : i) { println "adding $x" }
    delegate.addAll(i)
  }
}

def set = new MiPropioSet()
println set
set.add(3)
set.addAll([4,5,6,7])

println set