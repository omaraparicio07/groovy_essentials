package com.makingdevs

@Grab('org.codehaus.groovy.modules.http-builder:http-builder:0.6') 
import groovyx.net.http.RESTClient
import static groovyx.net.http.ContentType.URLENC

class BuscadorDeCervezas {

  static metodoApi = "search/beer"

  static findAllByCervecera(String cervecera) {
    def cervezas = []
    def apiSystem = ApiSystem.instance
    def buscador = new RESTClient(apiSystem.untappdApiUrl)
    def params = [client_id:apiSystem.clientId,client_secret:apiSystem.clientSecret,q:cervecera]
    buscador.get(path:"${metodoApi}",query:params){ response, data ->
      assert response.status == 200
      cervezas = data.response.beers.items.collect { c -> Cerveza.createWithParams(c.beer) }
    }
    cervezas
  }

}