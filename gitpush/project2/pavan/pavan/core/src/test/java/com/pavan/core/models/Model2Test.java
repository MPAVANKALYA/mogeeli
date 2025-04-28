package com.pavan.core.models;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import org.apache.sling.api.resource.ValueMap;
import org.apache.sling.api.resource.Resource;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class Model2Test {

    @Mock
    private Resource resource;

    @Mock
    private ValueMap valueMap;

    private Model2 model2;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        Mockito.lenient().when(resource.getValueMap()).thenReturn(valueMap);
        Mockito.lenient().when(valueMap.get("text", String.class)).thenReturn("Sample Text");
        model2 = new Model2();
    }

    @Test
    void testGetText() {
        assertNotNull(model2);
        assertNull(model2.getText()); // Since text is not injected manually
    }

    @Test
    void testGetExportedType() {
        assertNotNull(model2);
        assertEquals("/pavan/components/header2", model2.getExportedType());
    }

    @Test
    void testResourceException() {
        doThrow(new RuntimeException("Mock Exception")).when(resource).getValueMap();
        assertThrows(RuntimeException.class, () -> resource.getValueMap());
    }
}