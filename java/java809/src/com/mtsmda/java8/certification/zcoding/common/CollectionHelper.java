package com.mtsmda.java8.certification.zcoding.common;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by dminzat on 8/5/2016.
 */
public class CollectionHelper {

    public static final <T> List<T> getList(T ... ts){
        List<T> resultList = new ArrayList<>();
        if(ts.length > 0){
            for (T t : ts){
                resultList.add(t);
            }
        }
        return resultList;
    }

    public static final <T> List<T> joinLists(List<T> ... lists){
        List<T> resultList = new ArrayList<>();
        if(lists.length > 0){
            for(int i = 0; i < lists.length; i++){
                resultList.addAll(lists[i]);
            }
        }
        return resultList;
    }

}