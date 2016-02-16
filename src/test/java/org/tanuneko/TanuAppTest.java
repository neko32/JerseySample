package org.tanuneko;

import org.glassfish.jersey.client.ClientConfig;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.boot.test.WebIntegrationTest;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.inject.Inject;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

/**
 * Created by neko32 on 2016/02/16.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(TestContextConfiguration.class)
@WebIntegrationTest({"server.port=9099"})
public class TanuAppTest {

    @Inject
    BeanMgr mgr;

    @BeforeClass
    public static void beforeTest() {
        System.out.println("Starting app..");
        ApplicationContext ctx = new AnnotationConfigApplicationContext(TestConfig.class);
    }

    @Test
    public void testTanuApp() {
        Client client = ClientBuilder.newClient();
        WebTarget target = client.target("http://localhost:9099")
                .path("beanmgr/tanubean/1");
        TanuBean t = target.request(MediaType.APPLICATION_JSON_TYPE)
                .get(TanuBean.class);
        System.out.println("\n");
        assertThat(t.getId(), is(1));
        assertThat(t.getName(), is("Tanuchan"));
    }
}
