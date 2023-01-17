package org.example.sort;

import java.util.ArrayList;
import java.util.List;

public class MergeSortString {
    public List<String> mergeSort(List<String> firstStringArray, List<String> secondStringArray) {
        ArrayList<String> out = new ArrayList<>();

        int fsaIndex = 0;
        int ssaIndex = 0;
        int errorCount = 0;
        int capacity = firstStringArray.size() + secondStringArray.size();

        for (int i = 0; i < capacity; i++) {
            if (fsaIndex == firstStringArray.size()) {
                out.add(i, secondStringArray.get(ssaIndex));
                ssaIndex++;
            } else if (ssaIndex == secondStringArray.size()) {
                out.add(i, firstStringArray.get(fsaIndex));
                fsaIndex++;
            } else if (firstStringArray.get(fsaIndex).compareTo(secondStringArray.get(ssaIndex)) < 0) {
                out.add(i, firstStringArray.get(fsaIndex));
                fsaIndex++;
            } else {
                out.add(i, secondStringArray.get(ssaIndex));
                ssaIndex++;
            }

            if ((i > 0 && out.get(i).compareTo(out.get(i - 1)) < 0) || out.get(i).contains(" ")) {
                out.add(0, out.get(i));
                out.remove(i + 1);
                errorCount++;
            }
        }

        out.removeAll(out.subList(0, errorCount));
        return out;
    }

    public void reverse(List<String> array) {
        for (int i = 0, j = array.size() - 1; j >= array.size() / 2; i++, j--) {
            String temp = array.get(i);
            array.set(i, array.get(j));
            array.set(j, temp);
        }
    }
}
