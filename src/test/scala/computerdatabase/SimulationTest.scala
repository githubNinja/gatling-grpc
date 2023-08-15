package computerdatabase

import io.gatling.core.Predef._
import io.gatling.http.Predef._

class SimulationTest extends Simulation {

  val httpProtocol = http
    .baseUrl("https://computer-database.gatling.io") // Here is the root for all relative URLs
    .acceptHeader("text/html,application/xhtml+xml,application/xml;q=0.9,*/*;q=0.8") // Here are the common headers
    .acceptEncodingHeader("gzip, deflate")
    .acceptLanguageHeader("en-US,en;q=0.5")
    .userAgentHeader("Mozilla/5.0 (Macintosh; Intel Mac OS X 10.8; rv:16.0) Gecko/20100101 Firefox/16.0")


  //val grpcConf = grpc(managedChannelBuilder(name = "photoslibrary.googleapis.com", port = 8080).usePlaintext())

  val scn = scenario("Scenario Name") // A scenario is a chain of requests and pauses
    .exec(http("request_1")
      .get("/"))
    .pause(7) // Note that Gatling has recorder real time pauses


  /*val scn1 = scenario("Scenario Name2") // A scenario is a chain of requests and pauses
      grpc("request_1")
        .rpc(HealthGrpc.METHOD_CHECK)
        .payload(HealthCheckRequest.defaultInstance)*/

 /* grpc("request_1")
    .rpc(HealthGrpc.METHOD_CHECK)
    .payload(HealthCheckRequest.defaultInstance)*/

  setUp(scn.inject(atOnceUsers(1)).protocols(httpProtocol))



}
