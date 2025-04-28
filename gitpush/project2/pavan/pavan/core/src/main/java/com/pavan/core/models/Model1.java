package com.pavan.core.models;

import com.adobe.cq.export.json.ComponentExporter;
import com.adobe.cq.export.json.ExporterConstants;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.models.annotations.*;
import org.apache.sling.models.annotations.injectorspecific.*;

@Model(
    adaptables = Resource.class,
    defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL,
    resourceType = "/apps/pavan/components/header"
)

@Exporter(name = ExporterConstants.SLING_MODEL_EXPORTER_NAME, extensions = ExporterConstants.SLING_MODEL_EXTENSION)
public class Model1 implements ComponentExporter {

    @ValueMapValue
    private String text;

    @ValueMapValue
    private String path;

    @ValueMapValue
    private String text1;

    @ChildResource(name = "header2")  // Inject Model2 as a child resource
    private Model2 header2Component;

    public String getText() {
        return text;
    }

    public String getPath() {
        return path;
    }

    public String getText1() {
        return text1;
    }

    public Model2 getHeader2Component() {
        return header2Component;
    }

    @Override
    public String getExportedType() {
        return "/pavan/components/header";
    }
}
