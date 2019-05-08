/**
 * 
 */
package com.springbootweb.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author glnaresh
 *
 */
@RestController
public class HomeController {
	
	@RequestMapping("/home")
	public String home()
	{
		return "Welcome Home!";
	}

}
