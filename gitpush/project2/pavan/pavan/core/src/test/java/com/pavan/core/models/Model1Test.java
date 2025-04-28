package com.pavan.core.models;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import org.apache.sling.api.resource.Resource;
import org.apache.sling.api.resource.ValueMap;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class Model1Test {

    @InjectMocks
    private Model1 model1;

    @Mock
    private Resource resource;

    @Mock
    private ValueMap valueMap;

    @Mock
    private Model2 header2Component;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
       Mockito.lenient().when(resource.getValueMap()).thenReturn(valueMap);
       Mockito.lenient().when(valueMap.get("text", String.class)).thenReturn("Sample Text");
      Mockito.lenient().when(valueMap.get("path", String.class)).thenReturn("/content/sample");
      Mockito.lenient().when(valueMap.get("text1", String.class)).thenReturn("Another Sample Text");
      Mockito.lenient().when(resource.getChild("header2")).thenReturn(mock(Resource.class));
    }

    @Test
    void testGetText() throws NoSuchFieldException, IllegalAccessException {
        setField(model1, "text", "Sample Text");
        assertEquals("Sample Text", model1.getText());
    }

    @Test
    void testGetPath() throws NoSuchFieldException, IllegalAccessException {
        setField(model1, "path", "/content/sample");
        assertEquals("/content/sample", model1.getPath());
    }

    @Test
    void testGetText1() throws NoSuchFieldException, IllegalAccessException {
        setField(model1, "text1", "Another Sample Text");
        assertEquals("Another Sample Text", model1.getText1());
    }

    @Test
    void testGetHeader2Component() throws NoSuchFieldException, IllegalAccessException {
        setField(model1, "header2Component", header2Component);
        assertNotNull(model1.getHeader2Component());
    }

    @Test
    void testGetExportedType() {
        assertEquals("/pavan/components/header", model1.getExportedType());
    }

    private void setField(Object object, String fieldName, Object value) throws NoSuchFieldException, IllegalAccessException {
        java.lang.reflect.Field field = object.getClass().getDeclaredField(fieldName);
        field.setAccessible(true);
        field.set(object, value);
    }
}
