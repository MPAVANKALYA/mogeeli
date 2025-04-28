package com.pavan.core.models;

import org.apache.sling.api.resource.Resource;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.injectorspecific.ValueMapValue;

@Model(
    adaptables = Resource.class,
    defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL
)
public class AuthorInfoModel2 {

    @ValueMapValue
    private String text;

    @ValueMapValue
    private String lname;

    @ValueMapValue
    private String path;

    public String getText() {
        return text;
    }

    public String getLname() {
        return lname;
    }

    public String getPath() {
        return path;
    }
}
