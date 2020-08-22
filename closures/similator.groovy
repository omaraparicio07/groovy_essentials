class Calculadora {
        def operacion
        Calculadora(_operacion_) { operacion = _operacion_ } 
        def operar(){
          println "Ejecutanto operación..."
          println operacion.class
          operacion()
        }
      }
  def calculadora_1 = new Calculadora({ println "suma" })
  def operacion_desacoplada = { println "multiplica" }
  def calculadora_2 = new Calculadora(operacion_desacoplada)

  calculadora_1.operar()
  calculadora_2.operar()