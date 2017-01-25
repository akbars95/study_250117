package com.mtsmda.mockito.application;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.Mock;
import org.mockito.Spy;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.mockito.Mockito.*;
import static org.junit.Assert.*;

/**
 * Created by dminzat on 12/27/2016.
 */
@RunWith(MockitoJUnitRunner.class)
public class MockitoAnnotationTest {

    @Mock
    private Set<String> mockStringSet;

    @Spy
    private Set<Integer> spyIntegerSet = new HashSet<>();

    @Mock
    List mockListAnnotation;

    @Captor
    ArgumentCaptor argumentCaptor;

    //captor
    @Test
    public void testCreateAnnotationCaptor(){
        mockListAnnotation.add("1");
        verify(mockListAnnotation).add(argumentCaptor.capture());
        assertEquals("1", argumentCaptor.getValue());
        assertEquals(0, mockListAnnotation.size());
    }

    @Test
    public void testCreateCaptor(){
        List mockList = mock(List.class);
        ArgumentCaptor<String> stringArgumentCaptor = ArgumentCaptor.forClass(String.class);
        mockList.add("1");
        verify(mockList).add(stringArgumentCaptor.capture());
        assertEquals("1", stringArgumentCaptor.getValue());
        assertEquals(0, mockList.size());
    }

    //spy
    @Test
    public void testCreateAnnotationSpy(){
        assertNotNull(spyIntegerSet);

        spyIntegerSet.add(1);
        spyIntegerSet.add(2);

        verify(spyIntegerSet).add(1);
        verify(spyIntegerSet).add(2);

        assertEquals(2, spyIntegerSet.size());

        doReturn(100).when(spyIntegerSet).size();
        assertEquals(100, spyIntegerSet.size());
    }

    @Test
    public void testCreateSpy(){
        ArrayList<String> spyStringArrayList = spy(new ArrayList<String>());
        assertNotNull(spyStringArrayList);

        spyStringArrayList.add("1");
        spyStringArrayList.add("2");

        verify(spyStringArrayList).add("1");
        verify(spyStringArrayList).add("2");

        assertEquals(2, spyStringArrayList.size());

        doReturn(100).when(spyStringArrayList).size();
        assertEquals(100, spyStringArrayList.size());
    }

    //mock
    @Test
    public void testCreateMock() {
        ArrayList mockArrayList = mock(ArrayList.class);
        mockArrayList.add("one");
        verify(mockArrayList).add("one");
        assertEquals(0, mockArrayList.size());

        when(mockArrayList.size()).thenReturn(100);
        assertEquals(100, mockArrayList.size());

        doReturn(150).when(mockArrayList).size();
        assertTrue(150 == mockArrayList.size());
    }

    @Test
    public void testCreateAnnotationMock() {
        this.mockStringSet.add("barca");
        verify(this.mockStringSet).add("barca");
        assertEquals(0, this.mockStringSet.size());

        when(mockStringSet.size()).thenReturn(100);
        assertEquals(100, mockStringSet.size());
    }

}