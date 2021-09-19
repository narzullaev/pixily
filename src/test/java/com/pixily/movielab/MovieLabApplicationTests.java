package com.pixily.movielab;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
class MovieLabApplicationTests {

	@Test
	public void testStartup() throws Exception {
		MovieLabApplication.main(new String[]{});
	}

}
