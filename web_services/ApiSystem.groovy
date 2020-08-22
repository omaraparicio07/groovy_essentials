@Singleton
class ApiSystem {
  String untappdApiUrl = "http://api.untappd.com/v4/"
  String clientId = "5D55C3F3D75BE1C982570A5FA10C32EB5527F5B2"
  String clientSecret = "2D8F9FA8F68C22512B5AFC4FA6F58810E4C2A550"
  String permanentParams = "client_id=${clientId}&client_secret=${clientSecret}"

  def getApiUrlRequest(metodo,params=[:]){
    "${untappdApiUrl}${metodo}?&${permanentParams}&${mapAsUrlParameters(params)}"
  }

  private String mapAsUrlParameters(Map params){
    params.collect{ k,v -> "${k}=${v}" }.join('&')
  }
}