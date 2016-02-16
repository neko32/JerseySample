package org.tanuneko;

import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by neko32 on 2016/02/16.
 */
@Configuration
public class TanuConfiguration extends ResourceConfig {

    public TanuConfiguration() {
        register(TanuWebInterface.class);
    }

    @Bean
    public DBAccessor dbAccessor() {
        System.out.println("NOOP Accessor@TanuConfig ");
        return new NoOpAccessor();
    }
}
