package com.pavan.core.servlets;


import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.SlingHttpServletResponse;
import org.apache.sling.api.servlets.SlingAllMethodsServlet;
import org.apache.sling.api.servlets.HttpConstants;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;
import org.apache.sling.event.jobs.JobManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.Servlet;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@Component(
        service = Servlet.class,
        property = {
                "sling.servlet.methods=" + HttpConstants.METHOD_GET,
                "sling.servlet.paths=" + "/bin/practice",
                "service.description=Custom Servlet"
        }
)
public class SlingServletByPath extends SlingAllMethodsServlet {

    @Reference
    private JobManager jobManager;

    private final Logger logger = LoggerFactory.getLogger(getClass());

    @Override
    protected void doGet(final SlingHttpServletRequest req, final SlingHttpServletResponse resp) throws IOException {
        try {
        
            final Map<String, Object> props = new HashMap<>();
            props.put("data", "test");


            jobManager.addJob("practice/job", props);

           
            logger.info("Practice Servlet called. Job added to JobManager.");

            
            resp.setStatus(SlingHttpServletResponse.SC_OK);
            resp.setContentType("application/json;charset=UTF-8");
            resp.getWriter().print("{\"response message\" : \"Servlet Called\"}");
        } catch (Exception e) {
        
            logger.error("Error occurred while processing the request: ", e);

            resp.setStatus(SlingHttpServletResponse.SC_INTERNAL_SERVER_ERROR);
            resp.getWriter().print("{\"response message\" : \"Error occurred\"}");
        }
    }
}