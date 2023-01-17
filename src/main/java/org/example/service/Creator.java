package org.example.service;

import org.example.sort.MergeSortInteger;
import org.example.sort.MergeSortString;

import java.util.ArrayList;
import java.util.List;

public class Creator {
    Reader reader = new Reader();
    MergeSortString sortString = new MergeSortString();
    MergeSortInteger sortInteger = new MergeSortInteger();

    public List<Integer> createIntegerArrays(List<String> files) {
        List<Integer> cacheIntegerArray = new ArrayList<>();
        reader.addFileToIntegerArray(files.get(0), cacheIntegerArray);

        for (int i = 1; i < files.size(); i++) {
            List<Integer> nextFile = new ArrayList<>();
            reader.addFileToIntegerArray(files.get(i), nextFile);
            cacheIntegerArray = sortInteger.mergeSort(cacheIntegerArray, nextFile);
        }

        return cacheIntegerArray;
    }

    public List<String> createStringArrays(List<String> files) {
        List<String> cacheIntegerArray = new ArrayList<>();
        reader.addFileToStringArray(files.get(0), cacheIntegerArray);

        for (int i = 1; i < files.size(); i++) {
            List<String> nextFile = new ArrayList<>();
            reader.addFileToStringArray(files.get(i), nextFile);
            cacheIntegerArray = sortString.mergeSort(cacheIntegerArray, nextFile);
        }

        return cacheIntegerArray;
    }
}
