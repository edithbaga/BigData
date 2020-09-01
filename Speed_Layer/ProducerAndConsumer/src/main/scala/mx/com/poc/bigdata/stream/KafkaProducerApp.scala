package mx.com.poc.bigdata.stream

import java.util.Properties
import org.apache.kafka.clients.producer.{KafkaProducer, ProducerRecord}

/*
* @edithbaga
*
* note: It is a PoC of Producer and Consumer with Scala, an evolution is contemplated to incorporate good practices,
*       in design time and in implementation time.
*
* */

object KafkaProducerApp extends App {

  val props:Properties = new Properties()
  props.put("bootstrap.servers","localhost:9092")
  props.put("key.serializer",
    "org.apache.kafka.common.serialization.StringSerializer")
  props.put("value.serializer",
    "org.apache.kafka.common.serialization.StringSerializer")
  props.put("·","all")
  val producer = new KafkaProducer[String, String](props)
  val topic = "testTopic"
  try {
    for (i <- 0 to 500) {
      val record = new ProducerRecord[String, String](topic, i.toString, "PoC-------Producer-Kafka-Scala******** edithBaGa ******" + i)
      val metadata = producer.send(record)
      printf(s"sent record(key=%s value=%s) " +
        "meta(partition=%d, offset=%d)\n",
        record.key(), record.value(),
        metadata.get().partition(),
        metadata.get().offset())
    }
  }catch{
    case e:Exception => e.printStackTrace()
  }finally {
    producer.close()
  }
}
