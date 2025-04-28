package com.pavan.core.models;



import  com.pavan.core.services.PracticeService;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.models.annotations.Default;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.Optional;
import org.apache.sling.models.annotations.injectorspecific.OSGiService;
import org.apache.sling.models.annotations.injectorspecific.ValueMapValue;

import javax.annotation.PostConstruct;
import javax.inject.Inject;
//import javax.inject.Named;

@Model(adaptables = Resource.class)
public class PracticeModel {

    @Default(values="Test")
    @Inject
    @Optional
   // @Named("title")
    //protected String heading;
    @ValueMapValue
    private String title;
    

    @OSGiService
    PracticeService practiceService;

    private String name;

    @PostConstruct
    protected void init() {
        name = practiceService.getName();
    }

    public String getName() {
        return name;
    }
    public String getTitle() {
        return title;
    }


}