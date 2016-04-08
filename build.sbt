name := "hello-scaloid-sbt"

import android.Keys._
android.Plugin.androidBuild

javacOptions ++= Seq("-source", "1.7", "-target", "1.7")
scalaVersion := "2.11.7"
scalacOptions in Compile += "-feature"

updateCheck in Android := {} // disable update check
proguardCache in Android ++= Seq("org.scaloid")

proguardOptions in Android ++= Seq("-dontobfuscate", "-dontoptimize", "-keepattributes Signature", "-printseeds target/seeds.txt", "-printusage target/usage.txt"
  , "-dontwarn scala.collection.**" // required from Scala 2.11.4
  , "-dontwarn org.scaloid.**" // this can be omitted if current Android Build target is android-16
  , "-dontwarn org.joda.**"
  , "-keep class org.joda.time.**"
  , "-keep class org.joda.convert.**"
  , "-keep class org.mockito.**"
)

libraryDependencies += "org.scaloid" %% "scaloid" % "4.2"

run <<= run in Android
install <<= install in Android

// Tests //////////////////////////////

libraryDependencies ++= Seq(
  "org.apache.maven" % "maven-ant-tasks" % "2.1.3" % "test",
  "org.robolectric" % "robolectric" % "3.0" % "test",
  "junit" % "junit" % "4.12" % "test",
  "com.novocode" % "junit-interface" % "0.11" % "test",
  "org.scalatest" %% "scalatest" % "2.2.1" % "test",
  "org.scalatestplus" %% "play" % "1.4.0-M3" % "test",
  "joda-time" % "joda-time" % "2.9.3",
  "org.mockito" % "mockito-core" % "1.9.5" % "test"
)

// without this, @Config throws an exception,
unmanagedClasspath in Test ++= (bootClasspath in Android).value