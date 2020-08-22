@Category(String)
class FormatUtil{
  def static toFormat(numero){
    if(numero.size()==10){
      return "${numero[0..2]}-${numero[3..5]}-${numero[6..9]}"
    }
  }
}

use(FormatUtil){
  println "5518503078".toFormat()
  println new StringBuffer("5512345678").toFormat()
}