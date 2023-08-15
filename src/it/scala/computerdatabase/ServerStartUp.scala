/*
package computerdatabase

import io.grpc.Server

import ch.qos.logback.classic.Level
import com.google.common.collect.Sets
import com.google.protobuf.empty.Empty
import com.typesafe.scalalogging.StrictLogging
import io.grpc._
import io.grpc.health.v1.health.HealthCheckResponse.ServingStatus.SERVING
import io.grpc.health.v1.health.HealthGrpc.Health
import io.grpc.health.v1.health.{HealthCheckRequest, HealthCheckResponse, HealthGrpc}
import io.grpc.stub.{ServerCallStreamObserver, StreamObserver}

import java.security.KeyStore
import java.security.SecureRandom
import java.security.cert.Certificate
import java.security.cert.CertificateFactory

import scala.io.Source

import akka.actor.typed.ActorSystem
import akka.actor.typed.scaladsl.Behaviors
import akka.http.scaladsl.ConnectionContext
import akka.http.scaladsl.Http
import akka.http.scaladsl.HttpsConnectionContext
import akka.http.scaladsl.model.HttpRequest
import akka.http.scaladsl.model.HttpResponse
import akka.pki.pem.DERPrivateKeyLoader
import akka.pki.pem.PEMDecoder
import com.typesafe.config.ConfigFactory
import javax.net.ssl.KeyManagerFactory
import javax.net.ssl.SSLContext

import scala.concurrent.ExecutionContext
import scala.concurrent.Future
import scala.util.Failure
import scala.util.Success
import scala.concurrent.duration._
object ServerStartUp extends App {

  import scala.concurrent.ExecutionContext

  // start server
  val server = ServerBuilder
    .forPort(8080)
    .addService(ProtoReflectionService.newInstance())
    .addService(DocumentServiceGrpc.bindService(new DocumentServiceImpl, ExecutionContext.global))
    .build()
    .start()

  // block until shutdown
  if (server != null) {
    server.awaitTermination()
  }
}


*/
