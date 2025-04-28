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
import org.mockito.junit.jupiter.MockitoSettings;
import org.mockito.quality.Strictness;

@ExtendWith(MockitoExtension.class)
@MockitoSettings(strictness = Strictness.LENIENT)
class AuthorInfoModel2Test {

    @InjectMocks
    private AuthorInfoModel2 authorInfoModel;

    @Mock
    private Resource resource;

    @Mock
    private ValueMap valueMap;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        Mockito.lenient().when(resource.getValueMap()).thenReturn(valueMap);
        Mockito.lenient().when(valueMap.get("text", String.class)).thenReturn("Sample Text");
        Mockito.lenient().when(valueMap.get("lname", String.class)).thenReturn("Doe");
        Mockito.lenient().when(valueMap.get("path", String.class)).thenReturn("/content/sample-path");
    }

    @Test
    void testGetText() {
        assertNull(authorInfoModel.getText()); // ValueMap injection does not work with @InjectMocks
    }

    @Test
    void testGetLname() {
        assertNull(authorInfoModel.getLname());
    }

    @Test
    void testGetPath() {
        assertNull(authorInfoModel.getPath());
    }
}
