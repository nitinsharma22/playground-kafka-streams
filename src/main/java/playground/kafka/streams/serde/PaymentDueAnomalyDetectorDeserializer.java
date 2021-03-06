package playground.kafka.streams.serde;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.kafka.common.serialization.Deserializer;
import playground.kafka.streams.PaymentDueAnomalyDetector;

import java.io.IOException;
import java.util.Map;

public class PaymentDueAnomalyDetectorDeserializer implements Deserializer<PaymentDueAnomalyDetector> {

    private ObjectMapper mapper = new ObjectMapper();

    public void configure(Map<String, ?> map, boolean b) {

    }

    public PaymentDueAnomalyDetector deserialize(String topic, byte[] bytes) {

        try {
            if (bytes == null || bytes.length == 0) {
                return null;
            }
            return mapper.readValue(bytes, PaymentDueAnomalyDetector.class);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void close() {

    }
}
