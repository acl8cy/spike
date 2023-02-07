package com.si.redis.producer;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.integration.annotation.IntegrationComponentScan;
import org.springframework.integration.channel.DirectChannel;
import org.springframework.integration.config.EnableIntegration;
import org.springframework.integration.redis.inbound.RedisQueueMessageDrivenEndpoint;

@Configuration
@EnableIntegration
@IntegrationComponentScan("com.si.redis")
public class IntegrationConfig {
    @Bean
    JedisConnectionFactory jedisConnectionFactory() {
        JedisConnectionFactory factory = new JedisConnectionFactory();
        return factory;
    }

    @Bean
    DirectChannel receiverChannel() {
        return new DirectChannel();
    }

    @Bean
    RedisQueueMessageDrivenEndpoint consumerEndpoint() {
        RedisQueueMessageDrivenEndpoint endpoint = new RedisQueueMessageDrivenEndpoint("Redis-Queue", 
                    jedisConnectionFactory());
        endpoint.setOutputChannelName("receiverChannel");
        return endpoint;
    }
}
