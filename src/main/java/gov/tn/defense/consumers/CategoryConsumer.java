package gov.tn.defense.consumers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.Acknowledgment;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

@Component
public class CategoryConsumer {

	@Autowired
	private KafkaTemplate<String, String> kafkaTemplate;
	
	@KafkaListener(topics = "categories", groupId = "cat-group")
	public void onCategoryCreated(@Payload String CatId, Acknowledgment ack)
	{
		System.out.println(Integer.parseInt(CatId));
		ack.acknowledge();
	}
}
