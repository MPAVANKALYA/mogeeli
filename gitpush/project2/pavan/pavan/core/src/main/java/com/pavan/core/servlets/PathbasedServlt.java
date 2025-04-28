package com.pavan.core.servlets;


import org.apache.commons.lang3.ArrayUtils;
import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.SlingHttpServletResponse;
import org.apache.sling.api.servlets.SlingSafeMethodsServlet;
import org.osgi.service.component.annotations.Component;

import javax.servlet.Servlet;
import java.io.IOException;

@Component(service = { Servlet.class }, 
    property = {
        "sling.servlet.paths=/bin/practie1",
        "sling.servlet.methods=GET",
        "sling.servlet.selectors=one,two",
        "sling.servlet.extensions=txt"
    })
public class PathbasedServlt extends SlingSafeMethodsServlet {

    private static final long serialVersionUID = 1L;

    @Override
    protected void doGet(final SlingHttpServletRequest req, final SlingHttpServletResponse resp) throws IOException {
        resp.setContentType("text/plain");

        String[] selectors = req.getRequestPathInfo().getSelectors();
        
        if (ArrayUtils.isNotEmpty(selectors) && selectors.length > 0) {
            resp.getWriter().write("Selector Size = " + selectors.length + 
                                   ", Selector value = " + selectors[0]);
        } else {
            resp.getWriter().write("Hello World !!!!!");
        }
    }
}