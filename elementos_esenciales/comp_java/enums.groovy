enum issuePriority{
        URGENT,HIGH,MEDIUM,LOW,PLEASE,NO_MATTERS
}

def issueNotifier(priority){
    print "Notificando incidencia..."
    switch(priority){
      case[IssuePriority.URGENT,IssuePriority.HIGH]:
        println "Se cayó la App, ¿es viernes?..."
        break
      case IssuePriority.PLEASE..IssuePriority.MEDIUM:
        println "Podemos dejarlo para después?..."
        break
      case IssuePriority.NO_MATTERS:
        println "Luego lo hacemos..."
        break
    }
  }


  issueNotifier(IssuePriority.URGENT)
  issueNotifier(IssuePriority.MEDIUM)
  issueNotifier(IssuePriority.NO_MATTERS)

  println "Hay que escalar una incidencia, los niveles son: "
  for(priority in IssuePriority.values()){
    print "$priority "
	}
