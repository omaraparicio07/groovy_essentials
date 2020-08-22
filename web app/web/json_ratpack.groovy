@GrabResolver("http://oss.jfrog.org/artifactory/libs-snapshot")
@Grapes([
  @Grab(group='io.ratpack', module='ratpack-groovy', version='0.9.0-SNAPSHOT'),
  @Grab(group='io.ratpack', module='ratpack-jackson', version='0.9.0-SNAPSHOT')
])

import static ratpack.groovy.Groovy.*
import ratpack.jackson.JacksonModule
import static ratpack.jackson.Jackson.json

ratpack {
  modules {
    register new JacksonModule()
  }
  handlers {
    get("some-json") {
      render json(user: 1,lista:[1,2,3,4,5],mapa:[uno:1,dos:2,tres:3])
    }
  }
}