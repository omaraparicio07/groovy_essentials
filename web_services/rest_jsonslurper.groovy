def cerveceras = BuscadorDeCervecerias.findByPais("Mexico")
cerveceras.each{ cervecera ->
  // println "* $cervecera"
  cervezas = BuscadorDeCervezas.findAllByCervecera(cervecera.nombre)
  cervezas.each { cerveza ->
    println "\t - ${cerveza}"
  }
}
