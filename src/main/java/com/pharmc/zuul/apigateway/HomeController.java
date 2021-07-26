package com.pharmc.zuul.apigateway;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.client.WebClient;

import com.google.common.net.HttpHeaders;
import com.pharmc.zuul.apigateway.model.Order;
import com.pharmc.zuul.apigateway.model.SellerOrders;

import reactor.core.publisher.Mono;

@RestController
public class HomeController {

	private WebClient webclient=WebClient.create("http://localhost:8092");
	private WebClient webclient2=WebClient.create("http://run.mocky.io/v3/");
	@GetMapping("/{sid}/orders")
	public Mono<Object> getOrders(@PathVariable long sid){
	   Mono<ArrayList> oidList =   webclient.get()
			   .uri("/"+sid+"/orders")
			   .retrieve()
		       .bodyToMono(ArrayList.class);
	  // return oidList;
	 return webclient2.post().uri("c819098d-b4e6-46ca-aba9-a0e5f237ba52")
			 .header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
			 .body(Mono.just(oidList),ArrayList.class)
			. retrieve().bodyToMono(Object.class);	  
//		  System.out.println("Neha"+result.toString());
//		  return result;
	}
	
}
