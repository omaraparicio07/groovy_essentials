import groovy.text.SimpleTemplateEngine

def text = '''\
  Estimado "$nombre $apellidos",
  Fue muy bueno que vinieras al entrenamiento de <% if(organizacion) organizacion else "MakingDevs"  %>.
  Nos vemos en ${mes},
  ${firma}
'''

def binding = ["nombre":"Desarrollador", "apellidos":"de Software", "organizacion":"MakingDevs", "mes":"Diciembre", "firma":"José Juan Reyes Zuñiga"]

def engine = new SimpleTemplateEngine()
template = engine.createTemplate(text).make(binding) // Incluso puedes user un archivo

println template.toString()