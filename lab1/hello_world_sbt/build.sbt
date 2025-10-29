ThisBuild / scalaVersion := "3.7.3"
ThisBuild / organization := "mtuci"

lazy val hello = (project in file("."))
  .settings(
    name := "Hello"
  )
