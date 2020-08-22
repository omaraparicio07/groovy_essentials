println "he said 'cheese' once"
      println 'he said "cheese!" again'
  //Concatenacion
  a = "world"
  print "hello " + a + "\n"

  //Uso de Strings con triples comillas
  def name = "MakingDevs"
  def text = """\
  Hola $name
  como estas?
  """

  assert text != null
  println(text)

  //Uso de GStrings
  println new Date()
  x = "Actualmente es ${ new Date() }"
  assert x.values[0] instanceof Date
  println x

  def s = "String "
  def g = "GString creado a las ${new Date()}"
  def x = s + g
  assert s instanceof String
  assert g instanceof GString
  assert x instanceof String

  println s + "\n"+g+"\n" + x 