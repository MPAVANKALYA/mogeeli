package com.pavan.core.servlets;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;

import javax.servlet.ServletException;

import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.SlingHttpServletResponse;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;

import com.pavan.core.services.PracticeService;

@ExtendWith(MockitoExtension.class)
class ResourceTypeServletTest {

    @Mock
    private SlingHttpServletRequest request;

    @Mock
    private SlingHttpServletResponse response;

    @Mock
    private PracticeService practiceService;

    @InjectMocks
    private ResourceTypeServlet resourceTypeServlet;

    private StringWriter stringWriter;
    private PrintWriter printWriter;

    @BeforeEach
    void setUp() throws IOException {
        MockitoAnnotations.openMocks(this);
        stringWriter = new StringWriter();
        printWriter = new PrintWriter(stringWriter);
        when(response.getWriter()).thenReturn(printWriter);
        when(practiceService.getName()).thenReturn("Test Name");
    }

    @Test
    void testDoGet() throws IOException, ServletException {
        resourceTypeServlet.doGet(request, response);
        printWriter.flush();
        assertTrue(stringWriter.toString().contains("pavan kalyan mogeeli Test Name"));
    }
}
