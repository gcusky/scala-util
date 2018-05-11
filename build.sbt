
name := "scala-util"

version := "0.1"

scalaVersion := "2.12.6"

libraryDependencies ++= Seq(
  // https://mvnrepository.com/artifact/org.scala-lang/scala-reflect
  "org.scala-lang" % "scala-reflect" % "2.12.6",
  // https://mvnrepository.com/artifact/com.google.guava/guava
  "com.google.guava" % "guava" % "24.1-jre",
  // https://mvnrepository.com/artifact/org.reflections/reflections
  "org.reflections" % "reflections" % "0.9.11"
)
