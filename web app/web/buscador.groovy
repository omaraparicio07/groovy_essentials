def engine   = new groovy.text.SimpleTemplateEngine()
def source   = getClass().classLoader.getResource('buscador.template.html')
def template = engine.createTemplate(source)
def result = []
if(params.q)

  result = com.makingdevs.BuscadorDeCervezas.findAllByCervecera(params.q)
out << template.make(result:result)