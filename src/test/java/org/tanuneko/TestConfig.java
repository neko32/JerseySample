package org.tanuneko;

import org.springframework.context.annotation.Bean;

/**
 * Created by neko32 on 2016/02/16.
 */
public class TestConfig extends TanuConfiguration {

    @Bean
    @Override
    public DBAccessor dbAccessor() {
        System.out.println("UNITDB Accessor@TanuConfig ");
        return new UnitTestDBAccessor();
    }

    class UnitTestDBAccessor implements DBAccessor {

        @Override
        public void init() {
            // no op
        }

        @Override
        public void exec(String query) {
            // no op
        }

        @Override
        public String getCode() {
            return "UNIT TEST";
        }
    }
}
