name := """pro_play_java"""
organization := "com.heigvd-pro-b-08"

version := "1.0-SNAPSHOT"

lazy val root = (project in file(".")).enablePlugins(PlayJava)

scalaVersion := "2.12.8"

libraryDependencies += guice
libraryDependencies += "junit" % "junit" % "4.12" % "test"
