package gov.tn.defense.producers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Component
public class CategoryEventProducer {
	
	@Autowired
	private KafkaTemplate<String, String> kafkaTemplate;
	
	public void sendKafkaEvent(Integer id)
	{
		kafkaTemplate.send("categories", id.toString());
	}

}
