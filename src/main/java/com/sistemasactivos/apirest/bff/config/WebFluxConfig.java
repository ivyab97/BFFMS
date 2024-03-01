package com.sistemasactivos.apirest.bff.config;

import io.netty.channel.ChannelOption;
import io.netty.handler.timeout.ReadTimeoutHandler;
import io.netty.handler.timeout.WriteTimeoutHandler;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.client.reactive.ClientHttpConnector;
import org.springframework.http.client.reactive.ReactorClientHttpConnector;
import org.springframework.web.reactive.config.WebFluxConfigurer;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.netty.http.client.HttpClient;

@Configuration
public class WebFluxConfig implements WebFluxConfigurer  {
    
    @Value("${firstUrlBase}")
    String firstUrlBase;
    
    @Value("${secondUrlBase}")
    String secondUrlBase;
    
    @Value("${thirdUrlBase}")
    String thirdUrlBase;
    
    @Value("${ms.first.user}")
    String msFirstUser;
    
    @Value("${ms.second.user}")
    String msSecondUser;
    
    @Value("${ms.first.pass}")
    String firstPass;
    
    @Value("${ms.second.pass}")
    String secondPass;
    
    @Bean
    public WebClient getWebClientCustomer(){
        return createWebClient(firstUrlBase, msFirstUser, firstPass);
    }
    
    @Bean
    public WebClient getWebClientAccount(){
        return createWebClient(secondUrlBase, msSecondUser, secondPass);
    }
    
    @Bean
    public WebClient getWebClientCreditCard(){
        return createWebClient(thirdUrlBase, msSecondUser, secondPass);
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
