package com.github.igmfilho.challenge.itlean;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Rule;
import org.junit.Test;
import org.springframework.boot.test.rule.OutputCapture;

public class SpringBootRestApiApplicationTest {

	@Rule
    public OutputCapture output = new OutputCapture();

    private static final String SPRING_INIT = "root of context hierarchy";

    @Test
    public void shouldInitApplication() throws Exception {
        SpringBootRestApiApplication.main(new String[0]);
        assertThat(output.toString()).contains(SPRING_INIT);
    }
}