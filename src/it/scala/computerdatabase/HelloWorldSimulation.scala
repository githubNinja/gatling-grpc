package computerdatabase

import com.example.helloworld.grpc.hellogrpc.{HelloWorldGrpcServiceGrpc, HelloWorldReq}
import com.github.phisgr.gatling.grpc.Predef.{grpc, managedChannelBuilder, _}
import io.gatling.core.Predef._
import io.grpc.Status

import scala.concurrent.duration.DurationInt

class HelloWorldSimulation extends Simulation {

  val helloWorldResp = new HelloWorldReq().withName("Hello this is awesome !!")
  val helloWorldRequest = HelloWorldReq.defaultInstance
  val grpcConf = grpc(managedChannelBuilder("localhost", 8081).usePlaintext())

  val scn = scenario("GRPC-hello-World-Scenario") // A scenario is a chain of requests and pauses
    .exec(grpc("Grpc New Hello world Request")
      .rpc(HelloWorldGrpcServiceGrpc.METHOD_SAY_HELLO)
      .payload(HelloWorldReq(name = "Hey This is is a test from Gatling Grpc"))
      .check(statusCode is Status.Code.OK))

  setUp(scn.inject(rampUsersPerSec(1) to (2) during (20 seconds)).protocols(grpcConf))


}


/*
Used for other scenario
  val helloWorldResp = new HelloWorldResponse().withGreeting("Hello this is awesome !!")
  val helloWorldRequest = HelloWorldRequest.defaultInstance
  val grpcConf = grpc(managedChannelBuilder("localhost", 8081).usePlaintext())

  val scn = scenario("GRPC Hello world Scenario Name") // A scenario is a chain of requests and pauses
    .exec(grpc("Grpc New Hello world Request")
      .rpc(HelloWorldServiceGrpc.METHOD_SAY_HELLO)
      .payload(HelloWorldRequest(name = "Hey This is is a test from Gatling Grpc"))
      //.check(statusCode)) // is Status.Code.UNAUTHENTICATED))
      .check(statusCode is Status.Code.OK))
*/
