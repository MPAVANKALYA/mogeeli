package com.pavan.core.schedulers;

import org.osgi.service.metatype.annotations.AttributeDefinition;
import org.osgi.service.metatype.annotations.AttributeType;
import org.osgi.service.metatype.annotations.ObjectClassDefinition;

@ObjectClassDefinition(name = "SimpleSchedulerConfiguration OCD",
                       description = "SimpleSchedulerConfiguration OCD description")
public @interface SimpleSchedulerConfiguration {

    @AttributeDefinition(name = "Scheduler name", 
                         description = "Scheduler name", 
                         type = AttributeType.STRING)
    String scheduler_name() default "practice";

    @AttributeDefinition(name = "Cron job expression", 
                         description = "Cron job expression", 
                         type = AttributeType.STRING)
    String scheduler_expression() default "0 * * * * ?"; // Runs every minute

    @AttributeDefinition(name = "Enable Scheduler", 
                         description = "Enable Scheduler", 
                         type = AttributeType.BOOLEAN)
    boolean enable_scheduler() default true;

    @AttributeDefinition(name = "Concurrent Scheduler", 
                         description = "Concurrent Scheduler", 
                         type = AttributeType.BOOLEAN)
    boolean concurrent_scheduler() default false;

    @AttributeDefinition(name = "Custom Property", 
                         description = "Custom Property", 
                         type = AttributeType.STRING)
    String customProperty() default "Test";
}
