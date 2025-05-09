package com.cba.core.models;

import org.apache.sling.api.resource.Resource;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.injectorspecific.ValueMapValue;

@Model(adaptables = Resource.class,defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL)
   
public class Hello {

    @ValueMapValue
    private String text;


    @ValueMapValue
    private String path;

    @ValueMapValue
    private String text2;


    public String getPath() {
        return path;
    }

    public String getText() {
        return text;
    }



    public String getText2() {
        return text2;
    }
}
