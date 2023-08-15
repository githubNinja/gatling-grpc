/*
package computerdatabase

import com.github.phisgr.gatling.grpc.Predef.{grpc, managedChannelBuilder, _}
import io.gatling.core.Predef._
import io.grpc.health.v1.health.{HealthCheckRequest, HealthGrpc}

import scala.concurrent.duration.DurationInt

class BasicItSimulation extends Simulation {

  val grpcConf = grpc(managedChannelBuilder("localhost", 8081).usePlaintext())
    .warmUpCall(HealthGrpc.METHOD_CHECK, HealthCheckRequest.defaultInstance)

  val scn = scenario("GRPC Hello world Scenario Name") // A scenario is a chain of requests and pauses
    .exec(grpc("Hello Request")
      .rpc(HealthGrpc.METHOD_CHECK)
      .payload(HealthCheckRequest.defaultInstance)
      .check(statusCode)) // is Status.Code.UNAUTHENTICATED))
  //extract(_.status.some ) ( .assertions()))


  setUp(scn.inject(rampUsersPerSec(1) to (2) during (20 seconds)).protocols(grpcConf))


}
*/
