package com.pavan.core.schedulers;



import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class SimpleSchedulerConfigurationTest {

    @Test
    void testDefaultValues() {
        SimpleSchedulerConfiguration config = new SimpleSchedulerConfiguration() {
            @Override
            public Class<? extends java.lang.annotation.Annotation> annotationType() {
                return SimpleSchedulerConfiguration.class;
            }

            @Override
            public String scheduler_name() {
                return "practice";
            }

            @Override
            public String scheduler_expression() {
                return "0 * * * * ?";
            }

            @Override
            public boolean enable_scheduler() {
                return true;
            }

            @Override
            public boolean concurrent_scheduler() {
                return false;
            }

            @Override
            public String customProperty() {
                return "Test";
            }
        };

        assertEquals("practice", config.scheduler_name());
        assertEquals("0 * * * * ?", config.scheduler_expression());
        assertTrue(config.enable_scheduler());
        assertFalse(config.concurrent_scheduler());
        assertEquals("Test", config.customProperty());
    }
}
