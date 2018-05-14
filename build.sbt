name := "scala-util"

lazy val commonSetting = Seq(
  version := "1.0-SNAPSHOT",
  scalaVersion := CommonConf.scalaV
)

libraryDependencies ++= CommonConf.commonDependencies

resolvers += Resolver.sonatypeRepo("snapshots")

lazy val util = (project in file("modules/util")).settings(commonSetting)

lazy val akka = (project in file("modules/akka")).settings(commonSetting).dependsOn(util)

lazy val root = (project in file(".")).aggregate(util, akka).dependsOn(util, akka)