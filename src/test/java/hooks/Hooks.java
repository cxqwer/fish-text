package hooks;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Hooks {
    private static final Logger logger = LoggerFactory.getLogger(Hooks.class);

    @Before
    public void startScenario(Scenario scenario) {
        logger.info("------------------------------------------------------------");
        logger.info("Running the Scenario - '" + scenario.getName() + "'");
        logger.info("------------------------------------------------------------");
    }

    @After
    public static void checkScenarioResult(Scenario scenario) {
        logger.info("------------------------------------------------------------");
        logger.info("Scenario was '" + scenario.getName());
        logger.info("----------" + scenario.getStatus() + "----------");
        logger.info("------------------------------------------------------------");
    }
}
