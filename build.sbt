name := "accumulo-scala-simple-example"

version := "1.0"

scalaVersion := "2.10.1"

fork in run := true

libraryDependencies ++= Seq( 
	"org.apache.accumulo" % "accumulo-core" % "1.5.0",
	"org.apache.hadoop" % "hadoop-core" % "1.0.4",
	"org.apache.zookeeper" % "zookeeper" % "3.4.5" excludeAll(
    	ExclusionRule(organization = "log4j")
  	),
	"commons-io" % "commons-io" % "2.4",
	"log4j" % "log4j" % "1.2.15" excludeAll(
    	ExclusionRule(organization = "com.sun.jdmk"),
    	ExclusionRule(organization = "com.sun.jmx"),
    	ExclusionRule(organization = "javax.jms")
  	)
)
