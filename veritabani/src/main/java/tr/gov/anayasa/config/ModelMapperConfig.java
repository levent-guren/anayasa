package tr.gov.anayasa.config;

import javax.inject.Named;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;

@Named
public class ModelMapperConfig {
	@Bean
	public ModelMapper getModelMapper() {
		ModelMapper mapper = new ModelMapper();
		// mapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
		return mapper;
	}
}
