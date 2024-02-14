package com.sistemasactivos.apirest.bff.config;

import io.netty.channel.ChannelOption;
import io.netty.handler.timeout.ReadTimeoutHandler;
import io.netty.handler.timeout.WriteTimeoutHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.client.reactive.ClientHttpConnector;
import org.springframework.http.client.reactive.ReactorClientHttpConnector;
import org.springframework.web.reactive.config.EnableWebFlux;
import org.springframework.web.reactive.config.WebFluxConfigurer;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.netty.http.client.HttpClient;

@Configuration
@EnableWebFlux
public class WebFluxConfig implements WebFluxConfigurer  {
    
    
    @Bean
    public WebClient getWebClient(){
        return createWebClient("http://localhost:8082/api/v1/customers", "admin", "12345");
    }
    
    private WebClient createWebClient (String url, String user, String password){
        HttpClient httpClient = HttpClient.create()
                .tcpConfiguration(topClient ->
                        topClient.option(ChannelOption.CONNECT_TIMEOUT_MILLIS, 10000)
                                .doOnConnected(connection ->
                                        connection.addHandlerLast(new ReadTimeoutHandler(10))
                                            .addHandlerLast(new WriteTimeoutHandler(10))));
        ClientHttpConnector connector = new ReactorClientHttpConnector(httpClient.wiretap(true));
        return WebClient.builder()
                .baseUrl(url)
                .defaultHeaders(headers -> headers.setBasicAuth(user, password))
                .clientConnector(connector)
                .defaultCookie(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
                .build();
    }
}
