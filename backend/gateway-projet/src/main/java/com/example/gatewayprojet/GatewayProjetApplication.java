package com.example.gatewayprojet;

import com.netflix.discovery.DiscoveryClient;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.ReactiveDiscoveryClient;
import org.springframework.cloud.gateway.discovery.DiscoveryClientRouteDefinitionLocator;
import org.springframework.cloud.gateway.discovery.DiscoveryLocatorProperties;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class GatewayProjetApplication {

	public static void main(String[] args) {
		SpringApplication.run(GatewayProjetApplication.class, args);
	}
	@Bean
	RouteLocator routeLocator(RouteLocatorBuilder builder){
		return builder.routes()
				.route((r)->r.path("/proprietaires/**").uri("http://localhost:8080/"))
				.route((r)->r.path("/vehicules/**").uri("http://localhost:8080/"))
				.route((r)->r.path("/infractions/**").uri("http://localhost:8081/"))
				.route((r)->r.path("/radars/**").uri("http://localhost:8082/"))
//				.route((r)->r.path("/proprietaires/**").uri("lb://IMMATRICULATION-SERVICE"))
//				.route((r)->r.path("/vehicules/**").uri("lb://INFRACTION-SERVICE"))
//				.route((r)->r.path("/infractions/**").uri("lb://IMMATRICULATION-SERVICE"))
				.build();
	}

//	@Bean
//	DiscoveryClientRouteDefinitionLocator definitionLocator(
//			ReactiveDiscoveryClient rdc,
//			DiscoveryLocatorProperties properties){
//		return new  DiscoveryClientRouteDefinitionLocator(rdc,properties);
//	}

}
