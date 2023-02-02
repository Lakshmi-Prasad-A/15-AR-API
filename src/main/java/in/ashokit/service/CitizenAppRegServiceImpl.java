package in.ashokit.service;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import in.ashokit.binding.CitizenApp;
import in.ashokit.entity.CitizenAppEntity;
import in.ashokit.repository.CitizenAppRepo;

@Service
public class CitizenAppRegServiceImpl implements CitizenAppRegService {
	
	@Autowired
	private CitizenAppRepo citizenAppRepo;

	private static final String Rest_Url= "http://ssawebapi-env.eba-k88bsahp.ap-south-1.elasticbeanstalk.com/ssn/{ssn}";
	public String registerCitzenApp(CitizenApp app) {
		
		Long ssn = app.getSsn();
		
		WebClient webClient =  WebClient.create();
		
		String stateName = webClient.get()
				.uri(Rest_Url, ssn)
				.retrieve()
				.bodyToMono(String.class)
				.block();
		
		if("Rhode Island".equals(stateName)) {
			
			CitizenAppEntity entity = new CitizenAppEntity();
			
			BeanUtils.copyProperties(app, entity);
			
			citizenAppRepo.save(entity);
			
			return "Citizen App Created, App Id : "+entity.getAppId();
		}
		
		return "Citizen not belongs to RI...";
	}

}
