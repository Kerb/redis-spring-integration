package net.kerba.demo.redis.main;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.data.redis.RedisAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;

/**
 * @user: kerb
 * @created: 04/06/2017.
 */
@Configuration
@ComponentScan("net.kerba.demo")
@EnableAutoConfiguration(exclude = {
    RedisAutoConfiguration.class
})
public class RedisAppConfiguration {

    @Bean
    public JedisConnectionFactory jedisConnectionFactory() {
        final JedisConnectionFactory cf = new JedisConnectionFactory();
        cf.setHostName("localhost");
        cf.setPort(6379);
        return cf;
    }

    @Bean
    public RedisTemplate<String,Object> redisTemplate() {
        final RedisTemplate<String,Object> template = new RedisTemplate<String,Object>();
        template.setConnectionFactory(jedisConnectionFactory());
        return template;
    }

    public static void main(String[] args) throws Exception {
        SpringApplication.run(RedisAppConfiguration.class, args);
    }
}
