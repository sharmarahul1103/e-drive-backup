package net.javaguides.springboot;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import net.javaguides.springboot.entity.WikiMediaData;
import net.javaguides.springboot.repository.WikiDataRepo;

@Service
public class KafkaDataBaseConsumer {
	
	private static final Logger LOGGER=LoggerFactory.getLogger(KafkaDataBaseConsumer.class);
    private WikiDataRepo wikiDataRepo;
	
	public KafkaDataBaseConsumer(WikiDataRepo wikiDataRepo) {
		super();
		this.wikiDataRepo = wikiDataRepo;
	}

	@KafkaListener(topics = "wikimedia",groupId = "wikimedia")
	public void consume(String eventMessage) {
		LOGGER.info(String.format("message received-> %s",eventMessage ));
	WikiMediaData wikiMediaData=new WikiMediaData();
	wikiMediaData.setWikiEventData(eventMessage);
	wikiDataRepo.save(wikiMediaData);
	}
}
