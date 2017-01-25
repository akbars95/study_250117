package com.mtsmda.mockito.service;

/**
 * Created by dminzat on 12/27/2016.
 */
public interface DictionaryService {

    void add(String word, String meaning);
    String getMeaning(String word);

}