package com.pavan.core.schedulers;

import org.apache.sling.commons.scheduler.ScheduleOptions;
import org.apache.sling.commons.scheduler.Scheduler;
import org.osgi.service.component.annotations.*;
import org.osgi.service.metatype.annotations.Designate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Component(service = PracticeScheduledTask.class, immediate = true)
@Designate(ocd = SimpleSchedulerConfiguration.class)
public class PracticeScheduledTask implements Runnable {

    private final Logger logger = LoggerFactory.getLogger(getClass());

    @Reference
    private Scheduler scheduler;

    private String schedulerName;
    private String cronExpression;
    private boolean enableScheduler;
    private boolean concurrentScheduler;

    @Activate
    protected void activate(final SimpleSchedulerConfiguration config) {
        logger.error("PracticeScheduledTask activate method called");

        // Initialize configuration values
        this.schedulerName = config.scheduler_name();
        this.cronExpression = config.scheduler_expression();
        this.enableScheduler = config.enable_scheduler();
        this.concurrentScheduler = config.concurrent_scheduler();

        // Execute this method to add the scheduler.
        if (enableScheduler) {
            addScheduler(config);
        } else {
            logger.error("Scheduler is disabled.");
        }
    }

    // Add all configurations to schedule a scheduler depending on name and expression.
    public void addScheduler(SimpleSchedulerConfiguration config) {
        logger.error("Scheduler added successfully >>>>>>>");
        ScheduleOptions options = scheduler.EXPR(config.scheduler_expression());
        options.name(config.scheduler_name());
        options.canRunConcurrently(config.concurrent_scheduler());

        // Add scheduler to call depending on option passed.
        scheduler.schedule(this, options);
        logger.error("Scheduler added successfully name='{}'", config.scheduler_name());
    }

    // Custom method to deactivate or unschedule the scheduler
    public void removeScheduler(SimpleSchedulerConfiguration config) {
        scheduler.unschedule(config.scheduler_name());
    }

    // On deactivate component, it will unschedule the scheduler
    @Deactivate
    protected void deactivate(SimpleSchedulerConfiguration config) {
        removeScheduler(config);
    }

    // On component modification change status will remove and add scheduler
    @Modified
    protected void modified(SimpleSchedulerConfiguration config) {
        removeScheduler(config);
        addScheduler(config);
    }

    // run() method will get called according to the cron expression
    @Override
    public void run() {
        logger.error("PracticeScheduledTask run >>>>>>>>>>>");
    }
}
