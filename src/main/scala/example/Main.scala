package example

import org.apache.accumulo.core.client.BatchWriterConfig
import org.apache.accumulo.core.client.ZooKeeperInstance
import org.apache.accumulo.core.client.security.tokens.PasswordToken
import org.apache.accumulo.core.data.Mutation
import org.apache.accumulo.core.data.Value;

object Main {
  
	def main(args: Array[String]) {
	  
	  val usage = "run <instanceName> <zookeepers> <username> <password> <table>"
	    
	  args.length match {
	    case 5 => println("Using args:" + args.mkString(" "))
	    case _ => {
	      println(usage)
	      return
	    }	     
	  }
	  val instanceName = args(0)
	  val zookeepers = args(1)
	  val username = args(2)
	  val password = args(3)
	  val table = args(4)
	  
	  val instance = new ZooKeeperInstance(instanceName, zookeepers)    
	  val connector = instance.getConnector("root", new PasswordToken("root"))
	  val batchWriter = connector.createBatchWriter("test", new BatchWriterConfig())
	  val mutation = new Mutation("row")
	  mutation.put("CF", "CQ", new Value("1".getBytes()))
	  batchWriter.addMutation(mutation);
	  batchWriter.flush()
	  batchWriter.close()
	 
	  println("done writing");
	}
}