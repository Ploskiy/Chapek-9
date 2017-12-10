package by.ploskiy.services;

import by.ploskiy.config.TestConfigServices;
import by.ploskiy.entitys.Task;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes = TestConfigServices.class)
public class TestRobots {

    @Autowired
    private Task task;

    @Test
    public void TestRobotsFactory() {
        System.out.println(task);
    }
}
