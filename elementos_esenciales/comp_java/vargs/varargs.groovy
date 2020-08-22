def varargsJava(int a, int... b){
        println "Pasaste $a y $b"
      }
  def metodoConArray(int a, int[] b){
    println "Pasaste $a y $b"
  }

  varargsJava(1,2,3,4,5)
  metodoConArray(1,2,3,4,5)
