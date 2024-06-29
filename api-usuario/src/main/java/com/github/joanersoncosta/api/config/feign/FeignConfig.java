package com.github.joanersoncosta.api.config.feign;


import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;

import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocketFactory;

import org.apache.http.conn.ssl.NoopHostnameVerifier;
import org.apache.http.conn.ssl.TrustStrategy;
import org.apache.http.ssl.SSLContexts;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.ImportAutoConfiguration;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.cloud.openfeign.FeignAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import feign.Client;
import feign.Logger;
import feign.Request;
import feign.slf4j.Slf4jLogger;

@Configuration
@EnableFeignClients(basePackages = {"com.github.joanersoncosta.api"})
@EnableDiscoveryClient
@ImportAutoConfiguration({FeignAutoConfiguration.class})
public class FeignConfig {
    @Value("${feign.connectTimeout:30000}")
    private int connectTimeout;
    @Value("${feign.readTimeOut:300000}")
    private int readTimeout;

    @Bean
    Logger.Level feignLoggerLevel() {
        return Logger.Level.FULL;
    }

    @Bean
    Logger logger() {
        return new Slf4jLogger(FeignConfig.class);
    }

    @Bean
    public Request.Options options() {
        return new Request.Options(connectTimeout, readTimeout);
    }

    @Bean
    public FeignErrorDecoder errorDecoder() {
        return new FeignErrorDecoder();
    }

    @Bean
    public Client feignClient() {
        Client trustSSLSockets = new Client.Default(getSSLSocketFactory(), new NoopHostnameVerifier());
        return trustSSLSockets;
    }

    private SSLSocketFactory getSSLSocketFactory() {
        try {
            TrustStrategy acceptingTrustStrategy = new TrustStrategy() {
                @Override
                public boolean isTrusted(X509Certificate[] chain, String authType) throws CertificateException {
                    return true;
                }
            };
            SSLContext sslContext = SSLContexts.custom().loadTrustMaterial(null, acceptingTrustStrategy).build();
            return sslContext.getSocketFactory();
        } catch (Exception exception) {
            throw new RuntimeException(exception);
        }
    }
}