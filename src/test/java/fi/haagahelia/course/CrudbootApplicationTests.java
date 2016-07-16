package fi.haagahelia.course;

import org.junit.runner.*;

import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;


@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = {CrudbootApplication.class, WebSecurityConfig.class })
@WebAppConfiguration
public class CrudbootApplicationTests {

    

}
