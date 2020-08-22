import groovy.json.*

class BuscadorDeCervecerias {
  static metodoApi = "search/beer"

  static findByPais(String pais){
    def cerveceras = []
    def jsonSlurper = new JsonSlurper()
    def httpConnection = new URL(ApiSystem.instance.getApiUrlRequest(metodoApi,[q:pais]))
    //println httpConnection
    def queryResult = jsonSlurper.parseText(httpConnection.text)
    // cerveceras = queryResult.response.breweries.items.collect { c -> Cerveceria.createWithParams(c.brewery) }
    // Actualización parseo del resultado de la consulta, 06-2019
    cerveceras = queryResult.response.beers.items.collect { c -> Cerveceria.createWithParams(c.brewery) }
    cerveceras
  }
  
}