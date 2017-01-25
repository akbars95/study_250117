package com.mtsmda.mockito.application;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Spy;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.*;
/**
 * Created by dminzat on 12/27/2016.
 */
@RunWith(MockitoJUnitRunner.class)
public class SpyTest {

    private List<String> strings = new ArrayList<>();

    @Spy
    private List<String> stringsSpy = new ArrayList<>();

    @Test
    public void testSpyAnnotation(){
        stringsSpy.add("one");
        stringsSpy.add("two");
        assertTrue(stringsSpy.size() == 2);
        assertTrue(stringsSpy.stream().mapToInt(current -> current.length()).sum() == 6);
        doReturn(100).when(stringsSpy).size();
        assertEquals(stringsSpy.size(), 100);
        when(stringsSpy.size()).thenReturn(50);
        assertEquals(50, stringsSpy.size());
    }

    @Test
    public void testSpy(){
        Map<String, String> stringMap = new LinkedHashMap<>();
        Map<String, String> stringMapSpy = spy(stringMap);

        System.out.println(stringMap.get("key"));
        System.out.println(stringMapSpy.get("key"));

        stringMapSpy.put("key", "value");

        System.out.println(stringMap.get("key"));
        System.out.println(stringMapSpy.get("key"));

        when(stringMapSpy.get("key")).thenReturn("Another value");
        System.out.println(stringMap.get("key"));
        System.out.println(stringMapSpy.get("key"));
    }

}