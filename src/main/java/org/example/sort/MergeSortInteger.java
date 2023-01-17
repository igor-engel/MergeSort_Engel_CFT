package org.example.sort;

import java.util.ArrayList;
import java.util.List;

public class MergeSortInteger {
    public List<Integer> mergeSort(List<Integer> firstIntegerArray, List<Integer> secondIntegerArray) {
        ArrayList<Integer> out = new ArrayList<>();

        int fiaIndex = 0;
        int siaIndex = 0;
        int errorCount = 0;
        int capacity = firstIntegerArray.size() + secondIntegerArray.size();

        for (int i = 0; i < capacity; i++) {
            if (fiaIndex == firstIntegerArray.size()) {
                out.add(i, secondIntegerArray.get(siaIndex));
                siaIndex++;
            } else if (siaIndex == secondIntegerArray.size()) {
                out.add(i, firstIntegerArray.get(fiaIndex));
                fiaIndex++;
            } else if (firstIntegerArray.get(fiaIndex) < secondIntegerArray.get(siaIndex)) {
                out.add(i, firstIntegerArray.get(fiaIndex));
                fiaIndex++;
            } else {
                out.add(i, secondIntegerArray.get(siaIndex));
                siaIndex++;
            }

            if (i > 0 && out.get(i) < out.get(i - 1)) {
                out.add(0, out.get(i));
                out.remove(i + 1);
                errorCount++;
            }
        }

        out.removeAll(out.subList(0, errorCount));
        return out;
    }

    public void reverse(List<Integer> array) {
        for (int i = 0, j = array.size() - 1; j >= array.size() / 2; i++, j--) {
            Integer temp = array.get(i);
            array.set(i, array.get(j));
            array.set(j, temp);
        }
    }
}
