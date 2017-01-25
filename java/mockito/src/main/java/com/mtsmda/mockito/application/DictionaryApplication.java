package com.mtsmda.mockito.application;

import com.mtsmda.mockito.service.DictionaryService;

/**
 * Created by dminzat on 12/27/2016.
 */
public class DictionaryApplication {

    private DictionaryService dictionaryService;

    public void addWord(String word, String meaning){
        this.dictionaryService.add(word, meaning);
    }

    public String getMeaning(String word){
        return this.dictionaryService.getMeaning(word);
    }

}