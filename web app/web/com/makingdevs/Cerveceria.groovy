package com.makingdevs

@groovy.transform.Canonical
class Cerveceria {
  Long id
  Integer numeroDeCervezas
  String nombre
  String urlDeImagen
  String pais

  static createWithParams(params){
    new Cerveceria(
      id:params.'brewery_id',
      numeroDeCervezas:params.'beer_count',
      nombre:params.'brewery_name',
      urlDeImagen:params.'brewery_label',
      pais:params.'country_name'
    )
  }
}