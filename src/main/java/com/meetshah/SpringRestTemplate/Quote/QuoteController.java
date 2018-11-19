package com.meetshah.SpringRestTemplate.Quote;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.meetshah.SpringRestTemplate.Quote.models.Quote;

@RestController
public class QuoteController {

	private RestTemplate restTemplate;

	public QuoteController() {
		this.restTemplate = new RestTemplate();
	}

	@GetMapping("getQuote")
	public String getQuote() {
		Quote quote = restTemplate.getForObject("https://gturnquist-quoters.cfapps.io/api/random", Quote.class);

		if (quote != null) {
			return quote.getValue().getQuote();
		} else {
			return "";
		}
	}
}
