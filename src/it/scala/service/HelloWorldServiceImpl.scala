/*package service

import com.example.helloworld.hellogrpc.{HelloWorldRequest, HelloWorldResponse}
import io.grpc.ServerServiceDefinition
import io.grpc.stub.StreamObserver


class HelloWorldServiceImpl extends io.grpc.BindableService {
  def sayHello(request: HelloWorldRequest, responseObserver: StreamObserver[HelloWorldResponse]): Unit = { // HelloRequest has toString auto-generated.
    println(request)
    // You must use a builder to construct a new Protobuffer object
    val response = HelloWorldResponse.of("Hello there, " + request.name).withGreeting("Hello here")
    // Use responseObserver to send a single response back
    responseObserver.onNext(response)
    // When you are done, you must call onCompleted.
    responseObserver.onCompleted()
  }

  override def bindService(): ServerServiceDefinition = ???
}
*/
