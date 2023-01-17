package org.example.script;

import org.example.service.Creator;
import org.example.service.Writer;
import org.example.sort.MergeSortInteger;
import org.example.sort.MergeSortString;

import java.util.List;

public class Script {
    String dataType;
    String sortingMode;
    List<String> files;

    public Script(String dataType, String sortingMode, List<String> files) {
        this.dataType = dataType;
        this.sortingMode = sortingMode;
        this.files = files;
    }

    public String getDataType() {
        return dataType;
    }

    public void setDataType(String dataType) {
        this.dataType = dataType;
    }

    public String getSortingMode() {
        return sortingMode;
    }

    public void setSortingMode(String sortingMode) {
        this.sortingMode = sortingMode;
    }

    public List<String> getFiles() {
        return files;
    }

    public void setFiles(List<String> files) {
        this.files = files;
    }

    MergeSortString sortString = new MergeSortString();
    MergeSortInteger sortInteger = new MergeSortInteger();
    Creator creator = new Creator();
    Writer writer = new Writer();

    public void sortingScript() {
        if (files.size() < 2) {
            System.out.println("Число файлов для сортировки дожно быть не менее двух.");
            return;
        }

        if (getDataType().equals("-i") && getSortingMode().equals("-a")) {
            List<Integer> out = creator.createIntegerArrays(getFiles());

            writer.wrightIntegerArrayToFile(out);
        } else if (getDataType().equals("-i") && getSortingMode().equals("-d")) {
            List<Integer> out = creator.createIntegerArrays(getFiles());

            sortInteger.reverse(out);
            writer.wrightIntegerArrayToFile(out);
        } else if (getDataType().equals("-s") && getSortingMode().equals("-a")) {
            List<String> out = creator.createStringArrays(getFiles());

            writer.wrightStringArrayToFile(out);
        } else {
            List<String> out = creator.createStringArrays(getFiles());

            sortString.reverse(out);
            writer.wrightStringArrayToFile(out);
        }
    }
}
