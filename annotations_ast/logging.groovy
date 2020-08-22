import groovy.util.logging.*

@Log
class Servicio{
  def metodo(){
    log.info("Mexican Debugger")
  }
  def metodo2(){
    log.warning("Algo no esta bien")
  }
  def metodo3(){
    log.config("Ah ocurrido un error!! ")
  }
}

new Servicio().metodo()

new Servicio().metodo2()

new Servicio().metodo3()

// @groovy.util.logging.Log == static final java.util.logging.Logger = Logger.getLogger(class.name)
// @groovy.util.logging.Commons == static final org.apache.commons.logging.Log = LogFactory.getLog(class)
// @groovy.util.logging.Log4j == static final org.apache.log4j.Logger = Logger.getLogger(class)
// @groovy.util.logging.Slf4j == static final org.slf4j.Logger = org.slf4j.LoggerFactory.getLogger(class)