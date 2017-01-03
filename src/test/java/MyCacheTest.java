
import java.util.Date;

//import org.ehcache.CacheManager;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cache.CacheManager;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.areca.my_spring_boot.MainApplication;
import com.areca.my_spring_boot.service.HelloService;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = MainApplication.class)
public class MyCacheTest {

	private Logger log = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private CacheManager cacheManager;
	@Autowired
	HelloService service;

	@Before
	public void before() {
		log.info("cacheManager {}", cacheManager);
	}

	@Test
	public void cache() throws InterruptedException {
		log.info("第一次访问 {} 接口 , 现在时间为 {} ", "service.queryHellos()", new Date());
		service.queryHellos();
		log.info("第二次访问 {} 接口 , 现在时间为 {} ", "service.queryHellos()", new Date());
		service.queryHellos();
		Thread.sleep(5000);
		log.info("第三次访问 {} 接口 , 现在时间为 {} ", "service.queryHellos()", new Date());
		service.queryHellos();
	}

}
