lazy val root = (project in file(".")).
  settings(
    inThisBuild(List(
      organization := "com.example",
      scalaVersion := "2.12.12"
    )),
    name := "scalatest-example"
  )

libraryDependencies ++= Seq(
  "org.scalatest" %% "scalatest" % "3.2.2" % Test,
  "org.apache.parquet" % "parquet-hadoop" % "1.11.0",
  "org.apache.hadoop" % "hadoop-core" % "1.2.1")
