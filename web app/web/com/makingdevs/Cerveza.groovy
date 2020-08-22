package com.makingdevs

@groovy.transform.Canonical
class Cerveza {
  Long id
  String nombre
  String estilo
  String urlDeImagen

  static createWithParams(params){
    new Cerveza(
      id:params.'bid',
      nombre:params.'beer_name',
      estilo:params.'beer_style',
      urlDeImagen:params.'beer_label'
    )
  }
}