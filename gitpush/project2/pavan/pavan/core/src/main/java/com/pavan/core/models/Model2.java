package com.pavan.core.models;


import org.apache.sling.api.resource.Resource;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.injectorspecific.ValueMapValue;

import com.adobe.cq.export.json.ComponentExporter;
import com.adobe.cq.export.json.ExporterConstants;

import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Exporter;



@Model(adaptables = Resource.class, defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL,
     resourceType = "/apps/pavan/components/header2")


@Exporter(name = ExporterConstants.SLING_MODEL_EXPORTER_NAME, extensions = ExporterConstants.SLING_MODEL_EXTENSION)

public class Model2 implements ComponentExporter{

    @ValueMapValue
    private String text;

    


    public String getText() {
        return text;
    


    }

    @Override
    public  String getExportedType() {
        
        return "/pavan/components/header2";
    }

}

