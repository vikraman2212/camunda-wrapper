package org.abbf.springcamundamiddleware;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.Assert;

@SpringBootTest
class SpringCamundaMiddlewareApplicationTests {

	@Test
	void contextLoads() {
		Assert.hasText("test","test");
	}

}
