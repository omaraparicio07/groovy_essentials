@GrabResolver("http://oss.jfrog.org/artifactory/libs-snapshot")
@Grab("io.ratpack:ratpack-groovy:0.9.0-SNAPSHOT")
import static ratpack.groovy.Groovy.*

ratpack {
  handlers {
    handler{
      if(request.path.empty)
      response.headers.set "X-UAT-Compatible", "IE=Edge,chrome=1"
      next()
    }
    get {
      response.send "text/html","""<!DOCTYPE>
      <html>
      <head>
      <title></title>
      </head>
      <body>
      Hola Ratpack!
      </body>
      </html>"""
    }
    post("api"){
      reponse.send "text/html", "mandaste post"
    }
    assets "public", [] as String[]
  }
}