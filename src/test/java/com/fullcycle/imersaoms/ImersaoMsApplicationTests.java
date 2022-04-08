package com.fullcycle.imersaoms;

import java.time.Duration;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import reactor.core.publisher.Mono;
import reactor.core.scheduler.Schedulers;
import reactor.test.StepVerifier;

@SpringBootTest
class ImersaoMsApplicationTests {

	@Test
	void contextLoads() {
	}

	@Test
	public void test() {

		Mono<String> stringMono = Mono.fromCallable(() -> "OI")
				.subscribeOn(Schedulers.parallel());

		StepVerifier.create(stringMono)
				.expectNext("OI")
				.expectComplete();
	}

	@Test
	public void test2() {

		final String resultado = Mono.fromCallable(() -> "OI")
				.subscribeOn(Schedulers.parallel())
				.block(Duration.ofSeconds(2));

		Assertions.assertEquals("OI", resultado);
	}
}
