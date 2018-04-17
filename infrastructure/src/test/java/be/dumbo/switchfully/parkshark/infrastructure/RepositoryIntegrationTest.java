package be.dumbo.switchfully.parkshark.infrastructure;

import be.dumbo.switchfully.parkshark.TestApplication;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.transaction.Transactional;

@Transactional
@RunWith(SpringRunner.class)
@SpringBootTest(classes=TestApplication.class)
public abstract class RepositoryIntegrationTest {
}
