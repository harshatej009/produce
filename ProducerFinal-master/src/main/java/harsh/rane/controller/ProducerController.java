package harsh.rane.controller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import harsh.rane.model.Address;
import harsh.rane.model.Patient;
import harsh.rane.service.JsonParse;

@RestController
public class ProducerController {

	@Autowired
	private KafkaTemplate<String, Object> kafkaTemplate;

	@Autowired
	private KafkaTemplate<String, String> kafkaTemplateString;
	@Autowired
	private Address address;
	@Autowired
	private Patient patient;
	@Autowired
	private JsonParse jsonparse;

	private static final Logger LOGGER = LogManager.getLogger(ProducerController.class);

//	@GetMapping("/produceJson")       
//	public void Read()
//	{
//			kafkaTemplate.send("topic2",jsonparse.getLocalJson()); 
//			LOGGER.info("json message1 has been sent");
//			kafkaTemplate.send("topic3",jsonparse.getLocalJson()); 
//			LOGGER.info("json message2 has been sent");
//	} 
//	
	@GetMapping("/produceString") // 8085 port
	public void ProduceString() {
		
		patient.setId("PT12");
		patient.setEmail("harshatej.rane@gmail.com");
		address.setCity("Pune");
		address.setPatientid(12);

		
		kafkaTemplate.send("topic2", "harsh", patient);
		kafkaTemplate.send("topic3", "harsh", address);

		LOGGER.info("StringMessage has been sent");
	}

}
