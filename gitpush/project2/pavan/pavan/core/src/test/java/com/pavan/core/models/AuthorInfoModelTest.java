package com.pavan.core.models;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

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
class AuthorInfoModelTest {

    @InjectMocks
    private AuthorInfoModel authorInfoModel;

    @Mock
    private Resource resource;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);

        Mockito.lenient().when(resource.getValueMap()).thenReturn(null);
    }

    @Test
    void testGetFname() throws NoSuchFieldException, IllegalAccessException {
        setField(authorInfoModel, "fname", "John");
        assertEquals("John", authorInfoModel.getFname());
    }

    @Test
    void testGetLname() throws NoSuchFieldException, IllegalAccessException {
        setField(authorInfoModel, "lname", "Doe");
        assertEquals("Doe", authorInfoModel.getLname());
    }

    @Test
    void testShowFieldsTrueWhenToday() throws NoSuchFieldException, IllegalAccessException {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        setField(authorInfoModel, "date", sdf.format(new Date()));
        authorInfoModel.init();
        assertTrue(authorInfoModel.isShowFields());
    }

    @Test
    void testShowFieldsFalseWhenPastDate() throws NoSuchFieldException, IllegalAccessException {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Calendar pastDate = Calendar.getInstance();
        pastDate.add(Calendar.DAY_OF_YEAR, -1);
        setField(authorInfoModel, "date", sdf.format(pastDate.getTime()));
        authorInfoModel.init();
        assertFalse(authorInfoModel.isShowFields());
        assertEquals("The selected date has expired or is in the future.", authorInfoModel.getExpiryMessage());
    }

    @Test
    void testShowFieldsFalseWhenFutureDate() throws NoSuchFieldException, IllegalAccessException {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Calendar futureDate = Calendar.getInstance();
        futureDate.add(Calendar.DAY_OF_YEAR, 1);
        setField(authorInfoModel, "date", sdf.format(futureDate.getTime()));
        authorInfoModel.init();
        assertFalse(authorInfoModel.isShowFields());
        assertEquals("The selected date has expired or is in the future.", authorInfoModel.getExpiryMessage());
    }

    @Test
    void testInvalidDateFormat() throws NoSuchFieldException, IllegalAccessException {
        setField(authorInfoModel, "date", "invalid-date");
        authorInfoModel.init();
        assertFalse(authorInfoModel.isShowFields());
        assertEquals("Invalid date format.", authorInfoModel.getExpiryMessage());
    }

    @Test
    void testNoDateSelected() throws NoSuchFieldException, IllegalAccessException {
        setField(authorInfoModel, "date", "");
        authorInfoModel.init();
        assertFalse(authorInfoModel.isShowFields());
        assertEquals("No date selected.", authorInfoModel.getExpiryMessage());
    }

    private void setField(Object object, String fieldName, Object value) throws NoSuchFieldException, IllegalAccessException {
        java.lang.reflect.Field field = object.getClass().getDeclaredField(fieldName);
        field.setAccessible(true);
        field.set(object, value);
    }
}
