package com.imindloop.kafkaseries.tutorial1;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.common.serialization.StringSerializer;

import java.util.Properties;

public class ProducerDemo {

    public static void main(String[] args) {

        String bootstrapServersAddress = "127.0.0.1";
        String bootstrapServersPort = "9092";

        //Create producer properties
        Properties properties =  new Properties();
        properties.setProperty(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG,
                bootstrapServersAddress + ":" + bootstrapServersPort);
        properties.setProperty(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG,
                StringSerializer.class.getName());
        properties.setProperty(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG,
                StringSerializer.class.getName());

        //Create the Producer
        KafkaProducer<String, String> producer = new KafkaProducer<String, String>(properties);

        //Create a record for the Kafka Producer
        ProducerRecord<String, String> record = new ProducerRecord<String, String>("firstTopic", "Hello World Topic!");

        //Send data - IMPORTANT NOTE: This is asynchronous, so you need to force the data production
        producer.send(record);

        //Force the data to be produced
        producer.flush();

        //Or you can flush an close the producer
        producer.close();




    }
}