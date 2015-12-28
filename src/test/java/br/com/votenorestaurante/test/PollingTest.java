package br.com.votenorestaurante.test;

import br.com.votenorestaurante.model.Poll;
import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;


public class PollingTest extends TestCase {

    public PollingTest(String testName) {
        super(testName);
    }

    public static Test suite() {
        return new TestSuite(PollingTest.class);
    }

    public void testApp() {
        Poll poll = new PollBuilder()
                .withRestaurant("Mc Donald's", "hamburgueres")
                .withRestaurant("Burger King", "hamburgueres")
                .withUser("Teste", "teste@teste.com.br")
                .building();

        Boolean isPolled = poll.isPolled(poll.getRestaurant(), poll.getOtherRestaurant());

        assertNotSame(isPolled, true);
    }

}
