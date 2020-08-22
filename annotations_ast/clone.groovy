@groovy.transform.AutoClone
class Persona {
  String nombre, apellidoPaterno, apellidoMaterno
  List preferencias
  Date fechaDeNacimiento
}


/* class Persona implements Cloneable {
  //  ...
   public Object clone() throws CloneNotSupportedException {
     Object result = super.clone()
     result.preferencias = preferencias.clone()
     result.fechaDeNacimiento = fechaDeNacimiento.clone()
     return result
   }
  //  ...
 } */


def persona = new Persona(nombre:"Making",apellidoPaterno:"Devs",preferencias:['programar','cerveza'],fechaDeNacimiento: new Date() - (365*30))
def persona2 = persona.clone()
persona2.apellidoMaterno="Corp."

println persona
println persona.properties

println persona2
println persona2.properties

assert persona instanceof Cloneable
assert persona.preferencias instanceof Cloneable
assert persona.fechaDeNacimiento instanceof Cloneable
assert !(persona.nombre instanceof Cloneable)

assert !persona.is(persona2)
assert !persona.preferencias.is(persona2.preferencias)
assert !persona.fechaDeNacimiento.is(persona2.fechaDeNacimiento)
assert persona.nombre.is(persona2.nombre)