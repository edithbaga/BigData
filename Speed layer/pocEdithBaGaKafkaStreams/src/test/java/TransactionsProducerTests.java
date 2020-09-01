


import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.poc.edithbaga.kafka.streams.ProducerBankTransactions;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.junit.Test;

import java.io.IOException;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class TransactionsProducerTests {

    @Test
    public void newRandomTransactionsTest(){
        ProducerRecord<String, String> record = ProducerBankTransactions.newRandomTransaction("edithBaGa");
        String key = record.key();
        String value = record.value();

        assertEquals(key, "edithBaGa");

        ObjectMapper mapper = new ObjectMapper();
        try {
            JsonNode node = mapper.readTree(value);
            assertEquals(node.get("name").asText(), "edthBaGa");
            assertTrue("Amount should be less than 100", node.get("amount").asInt() < 100);
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println(value);

    }


}