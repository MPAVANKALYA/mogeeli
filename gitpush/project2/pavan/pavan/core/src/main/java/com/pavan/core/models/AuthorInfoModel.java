package com.pavan.core.models;



import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import javax.annotation.PostConstruct;
import javax.inject.Inject;
import org.apache.commons.lang3.StringUtils;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.Optional;

@Model(adaptables = Resource.class, defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL)
public class AuthorInfoModel {

    @Inject
    @Optional
    private String fname;

    @Inject
    @Optional
    private String lname;

    @Inject
    @Optional
    private String date;

    private boolean showFields;
    private String expiryMessage;

    @PostConstruct
    protected void init() {
        showFields = false;
        expiryMessage = "";

        if (StringUtils.isNotBlank(date)) {
            try {
                // Parse the selected date
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                Date selectedDate = sdf.parse(date);

                // Get today's date with time set to 00:00:00 for accurate comparison
                Calendar today = Calendar.getInstance();
                today.set(Calendar.HOUR_OF_DAY, 0);
                today.set(Calendar.MINUTE, 0);
                today.set(Calendar.SECOND, 0);
                today.set(Calendar.MILLISECOND, 0);

                // Convert selected date to Calendar instance
                Calendar selectedCal = Calendar.getInstance();
                selectedCal.setTime(selectedDate);

                if (selectedCal.get(Calendar.YEAR) == today.get(Calendar.YEAR) &&
                    selectedCal.get(Calendar.DAY_OF_YEAR) == today.get(Calendar.DAY_OF_YEAR)) {
                    // If the selected date is today
                    showFields = true;
                } else {
                    // If the selected date is in the past or future
                    expiryMessage = "The selected date has expired or is in the future.";
                }

            } catch (ParseException e) {
                expiryMessage = "Invalid date format.";
            }
        } else {
            expiryMessage = "No date selected.";
        }
    }

    public boolean isShowFields() {
        return showFields;
    }

    public String getExpiryMessage() {
        return expiryMessage;
    }

    public String getFname() {
        return fname;
    }

    public String getLname() {
        return lname;
    }
}