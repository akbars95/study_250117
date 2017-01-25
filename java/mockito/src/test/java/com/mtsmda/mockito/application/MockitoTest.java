package com.mtsmda.mockito.application;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Matchers;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.stream.Stream;

import static org.mockito.Mockito.*;
import static org.junit.Assert.*;

/**
 * Created by dminzat on 12/28/2016.
 */
@RunWith(MockitoJUnitRunner.class)
public class MockitoTest {

    @Test
    public void testMoreThanOneReturnValue() {
        Iterator<String> stringIterator = mock(Iterator.class);

        when(stringIterator.next()).thenReturn("Mockito").thenReturn("framework");
        assertEquals("Mockito framework", stringIterator.next() + " " + stringIterator.next());
    }

    @Test
    public void testReturnValueDependentOnMethodParameter() {
        Comparable<String> stringComparable = mock(Comparable.class);
        when(stringComparable.compareTo("Mockito")).thenReturn(1);
        when(stringComparable.compareTo("Idea")).thenReturn(2);

        assertEquals(1, stringComparable.compareTo("Mockito"));
    }


    @Test
    public void testReturnValueInDependentOnMethodParameter() {
        Comparable<String> stringComparable = mock(Comparable.class);
        when(stringComparable.compareTo(anyString())).thenReturn(-1);

        assertEquals(-1, stringComparable.compareTo("Mockito"));
        assertEquals(-1, stringComparable.compareTo(""));
        assertEquals(-1, stringComparable.compareTo(new String("Mockito framework")));

        verify(stringComparable, times(3)).compareTo(anyString());
        verify(stringComparable, times(1)).compareTo("Mockito");
    }

    @Test
    @Ignore
    public void testType() {
        Comparable mockComparable = mock(Comparable.class);
        when(mockComparable.compareTo(isA(ToDo.class))).thenReturn(0);

        ToDo toDo = new ToDo(5);
        assertEquals(toDo, mockComparable.compareTo(new ToDo(1)));
    }

    @Test(expected = IOException.class)
    public void test() throws IOException {
        OutputStream mockOutputStream = mock(OutputStream.class);
        doThrow(new IOException()).when(mockOutputStream).close();

        OutputStreamWriter outputStreamWriter = new OutputStreamWriter(mockOutputStream);
        outputStreamWriter.close();
    }

    @Test
    public void testVerify() {
        ToDo toDo = mock(ToDo.class);
        when(toDo.multiply10()).thenReturn(99);

        toDo.testing(15);
        toDo.multiply10();
        toDo.multiply10();

        verify(toDo).testing(Matchers.eq(15));
        verify(toDo, times(2)).multiply10();
        verify(toDo, times(1)).testing(anyInt());

        verify(toDo, never()).setNumber(anyInt());
        verify(toDo, atLeastOnce()).testing(anyInt());
        verify(toDo, atLeast(2)).multiply10();

        Stream.iterate(1, integer -> integer).limit(5).forEach(integer -> {
            toDo.getNumber();
        });

        verify(toDo, times(5)).getNumber();
        verify(toDo, atMost(5)).getNumber();
    }

    @Test
    public void testSpy(){
        LinkedList<String> spy = spy(LinkedList.class);
        assertTrue(spy.isEmpty());

        doReturn("first").when(spy).get(0);

        assertEquals(spy.get(0), "first");
        assertTrue(spy.isEmpty());

        /*DOMINO*/
        int count = 0;
        for(int i = 0; i <= 6; i++){
            for(int j = i; j <= 6; j++){
                System.out.print(i + "|" + j + "\t");
                ++count;
            }
            System.out.println();
        }
        System.out.println("count - " + count);
    }

}

class ToDo {
    private int number;

    public ToDo(int number) {
        this.number = number;
    }

    public int multiply10() {
        return this.getNumber() * 10;
    }

    public String testing(int number) {
        return "testing - " + (multiply10() * number);
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }
}