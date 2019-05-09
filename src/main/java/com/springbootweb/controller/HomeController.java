/**
 * 
 */
package com.springbootweb.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @author glnaresh
 *
 */
@RestController
public class HomeController {
	
	@Autowired
	protected RestTemplate restTemplate;
	
	@RequestMapping("/home")
	public String home()
	{
		return "Welcome Home!";
	}
	
	@RequestMapping("/date")
	public String currentDate()
	{
		String returnedDate = restTemplate.getForObject("http://hidden-service/date", String.class);
		if (returnedDate != null)
		{
			return "date From Hidden-Service : " + returnedDate;
		}
		else
		{
			return "No Date Yet";
		}
	}
	
	@Bean
    @LoadBalanced
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }

}
