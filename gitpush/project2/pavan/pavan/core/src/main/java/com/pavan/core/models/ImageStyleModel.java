package com.pavan.core.models;


import org.apache.sling.api.resource.Resource;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.injectorspecific.ValueMapValue;

@Model(adaptables = Resource.class, defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL)
public class ImageStyleModel {

    @ValueMapValue
    private String imagePath; // Pathfield image selection

    @ValueMapValue
    private boolean roundAllEdges;

    @ValueMapValue
    private boolean roundLeftEdges;

    @ValueMapValue
    private boolean roundBottomLeftEdge;

    @ValueMapValue
    private boolean roundTopRightEdge;

    @ValueMapValue
    private String borderRadius; // Dynamic border-radius

    @ValueMapValue
    private String borderWidth; // Dynamic border width

    public String getImagePath() {
        return imagePath;
    }

    public boolean isRoundAllEdges() {
        return roundAllEdges;
    }

    public boolean isRoundLeftEdges() {
        return roundLeftEdges;
    }

    public boolean isRoundBottomLeftEdge() {
        return roundBottomLeftEdge;
    }

    public boolean isRoundTopRightEdge() {
        return roundTopRightEdge;
    }

    public String getBorderRadius() {
        return borderRadius;
    }

    public String getBorderWidth() {
        return borderWidth;
    }

    public String getCssClasses() {
        StringBuilder classes = new StringBuilder();
        if (roundAllEdges) classes.append(" round-all");
        if (roundLeftEdges) classes.append(" round-left");
        if (roundBottomLeftEdge) classes.append(" round-bottom-left");
        if (roundTopRightEdge) classes.append(" round-top-right");
        return classes.toString().trim();
    }
}
