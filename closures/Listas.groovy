  lista = []// Esencia 1 vs Ceremonia 0
  println lista.getClass().getName()

  lista = ["Uno", "Dos", "Tres"] //Inicializando la lista

  println lista

  println "Iterando la lista"
  lista.each { print "$it " }

  // Operaciones con listas
  lista += 4  //Agrego un solo elemento
  lista += ["Cuatro", "Cinco"] //Agrego una lista

  println "Iterando la lista con for"
  for(item in lista) { print "$item " }

  println "Agregando elemento a la lista con <<"
  lista << "Seis" // Agregando un elemento

  println lista

  println "Agrego Siete y Ocho"
  lista << "Siete" << "Ocho"
  println lista

  println "Remuevo siete y Ocho"
  lista = lista - ["Siete","Ocho"] //Puedo eliminar una coleccion
  println lista

  println "Remuevo el Seis"
  lista = lista - "Seis" //Puedo borrar un elemento solamente
  println lista

  println "Intento buscar un elemento que no existe"
  lista = lista - "Mil Ocho Mil" //no pasa nada si intento borrar algo que no existe
  println lista

  println "Marihuanadas, doblo la lista"
  lista = lista * 2
  println lista

  //Puedo obtener una parte de la lista
  subLista = lista[4..6]
  println subLista.dump()

  //Podemos usar un metodo de conveniencia para efectuar una operacion sobre
  //todos los elemento de la lista
  println lista.collect { "Numero ${it} Entero" }

  //Hay otro metodo de conveniencia que me sirve para buscar un elemento en la lista
  println lista.find { it == "Dos" }
  println lista.find { it == "Dos" }.getClass().name
  println lista.find { it == 4 }
  println lista.find { it == 4 }.getClass().name

  //Ahora el metodo anterior regresa la primera ocurrencia, que pasa si queremos todas?
  println lista.findAll { it == "Dos" }
  println lista.findAll { it == "Dos" }.getClass().name
  println lista.findAll { it == 4 }
  println lista.findAll { it == 4 }.getClass().name

  //Ahora juntemos todo los elementos en un solo enunciado
  println lista.join(',')
  println lista.join(',').getClass().name

  //probemos ahora a contar las letras de los objetos que sean String de la lista
  count = 0
  lista.each {
    if(it.getClass().name == "java.lang.String"){
      return count += it.size()
    }else{
      return 0
    }
  }
  println "El tamaño total es de : $count"
  //Hagámoslo más fácil
  println lista.collect {
    if(it.getClass().name == "java.lang.String"){
      it.size()
    }else{
      return 0
    }

  }.sum()