package com.pavan.core.servlets;


import java.io.BufferedReader;
import java.io.IOException;

import javax.servlet.Servlet;
import javax.servlet.ServletException;

import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.SlingHttpServletResponse;
import org.apache.sling.api.servlets.HttpConstants;
import org.apache.sling.api.servlets.SlingAllMethodsServlet;
import org.osgi.framework.Constants;
import org.osgi.service.component.annotations.Component;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


@Component(service = Servlet.class,
            property = {
                Constants.SERVICE_DESCRIPTION+"=Custom Servlet",
                "sling.servlet.methods="+HttpConstants.METHOD_POST,
                "sling.servlet.paths="+"/bin/user/save"
            }

)
public class Postservletbypath extends SlingAllMethodsServlet{
    private static final long serialVersionUID=1L;
    private final Logger logger= LoggerFactory.getLogger(getClass());
    @Override
    protected void doPost(SlingHttpServletRequest request, SlingHttpServletResponse response)throws ServletException, IOException {
          logger.error("user details >>>>>>> {}", request.getParameter("dataXml"));  
          
          StringBuilder sb=new StringBuilder();
          BufferedReader reader=request.getReader();
          
          try{
            String line;
            while((line =reader.readLine())!=null){
                sb.append(line).append('\n');

            }
          }finally{
            reader.close();
          }


          logger.error("practicePostServletByPath >>>>>>>>  {}", sb.toString());

          response.setStatus(SlingHttpServletResponse.SC_OK);
          response.setContentType("application/json;charset=UTF-8");
          response.getWriter().print("{\"respone message\" : \" Service called\"}");
          
        }


    

}