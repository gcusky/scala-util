import sbt._
/**
  * Created by lizhy on 2018/5/14.
  */
object CommonConf {
  val scalaV =  "2.12.6"
  val akkaV  = "2.5.12"
  val guavaV = "24.1-jre"
  val reflectV = "0.9.11"

  val commonDependencies = Seq(
    // reflect
    "org.scala-lang" % "scala-reflect" % scalaV, // https://mvnrepository.com/artifact/org.scala-lang/scala-reflect
    "com.google.guava" % "guava" % guavaV, // https://mvnrepository.com/artifact/com.google.guava/guava
    "org.reflections" % "reflections" % reflectV, // https://mvnrepository.com/artifact/org.reflections/reflections

    // akka
    "com.typesafe.akka" %% "akka-actor" % akkaV // https://akka.io/
  )

}
