html.html{
  head {
    title "Propiedades de los Groovlets"
  }
  title 'Propiedades de los Groovlets'
  body {
    h1 'Variables atadas(Binding) al servlet:'
    table(summary:'binding') {
      tbody {
        binding.variables.each { key, value ->
          tr {td key.toString()
            td key.toString()
            td(value ? value.toString() : 'null')
          }
        }
      }
    }
  }
}