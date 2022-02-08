package cn.printf.demos.batch;

import cn.printf.demos.batch.configuration.BatchConfiguration;
import org.junit.Assert;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.test.JobLauncherTestUtils;
import org.springframework.batch.test.JobRepositoryTestUtils;
import org.springframework.batch.test.context.SpringBatchTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.jdbc.JdbcTestUtils;

@SpringBatchTest
@ContextConfiguration(classes = {
        BatchConfiguration.class
})
@EnableAutoConfiguration
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_CLASS)
public class BatchStepTest {
    @Autowired
    private JobLauncherTestUtils jobLauncherTestUtils;

    @Autowired
    private JobRepositoryTestUtils jobRepositoryTestUtils;

    @AfterEach
    public void tearDown() throws Exception {
        jobRepositoryTestUtils.removeJobExecutions();
    }

    @Autowired
    public JdbcTemplate jdbcTemplate;

    @Test
    public void testStep() throws Exception {

        JobExecution jobExecution = jobLauncherTestUtils.launchStep("step1");
        jobExecution.getStepExecutions().forEach(stepExecution -> {
            Assert.assertEquals(4, stepExecution.getWriteCount());
            Assert.assertEquals(4, stepExecution.getReadCount());
            Assert.assertEquals(0, stepExecution.getSkipCount());

            Assert.assertEquals(4, JdbcTestUtils.countRowsInTable(jdbcTemplate, "people"));
        });
        Assert.assertEquals("COMPLETED", jobExecution.getExitStatus().getExitCode());
    }
}
