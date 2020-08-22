
import javax.xml.parsers.DocumentBuilderFactory
def fac     = DocumentBuilderFactory.newInstance()
def builder = fac.newDocumentBuilder()
def doc     = builder.parse(new FileInputStream('/Users/omar/Desktop/Groovy_Essensials/XML/makingdevs.xml'))

  //document = groovy.xml.DOMBuilder.parse(new FileReader('makingdevs.xml'))
  //rootElement = document.documentElement
def document = doc.documentElement
use(groovy.xml.dom.DOMCategory){
  println "Entrenamiento en ${document.'@organization'}"
  document.roadmap.category.each{ category ->
  println "\t* ${category.'@name'}"
    for(course in category.course){
      println "\t\t- ${course.text().trim()} / Duration: ${course.'@duration'} hours in ${course.'@sessions'} sessions."
    }
  }
}