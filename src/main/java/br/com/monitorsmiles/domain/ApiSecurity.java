package br.com.monitorsmiles.domain;

import org.springframework.stereotype.Component;

@Component
public class ApiSecurity {
	
	public Long getSmilesId() {
		//get smilesId from token or any type of auth method
		return 1l;
	}

}
