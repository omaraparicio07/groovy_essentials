@ConditionalInterrupt({ errorCount >= 10})
import groovy.transform.ConditionalInterrupt

errorCount = 0

1000.times {
  try {
    // do some work
    // println it
    if(it == 500){
      Thread.sleep(2000)
      errorCount = 11
    }
  } catch (Throwable t) {
    errorCount++
  }
}