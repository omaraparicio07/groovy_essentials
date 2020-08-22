package com.makingdevs

import groovy.json.JsonSlurper

class BuscadorDeCervecerias {
  static metodoApi = "search/beer"

  static findByPais(String pais){
    def cerveceras = []
    def jsonSlurper = new JsonSlurper()
    def httpConnection = new URL(ApiSystem.instance.getApiUrlRequest(metodoApi,[q:pais]))
    def queryResult = jsonSlurper.parseText(httpConnection.text)
    cerveceras = queryResult.response.breweries.items.collect { c -> Cerveceria.createWithParams(c.brewery) }
    cerveceras
  }
}