package ds.hashing.practise;

import java.util.LinkedList;

public class DirectHashing {

    LinkedList<String> hashTable[];

    DirectHashing(int size) {
        hashTable = new LinkedList[size];
    }


    int getIndex(String data, int size) {
        char[] dataArray = data.toCharArray();
        int sum = 0;
        for (int j = 0; j < data.length(); j++) {
            sum += dataArray[j];
        }
        return sum % size;
    }

    void insertElements(String data) {
        int index = getIndex(data, 14);
        if (hashTable[index] == null) {
            hashTable[index] = new LinkedList<>();
            hashTable[index].add(data);
        } else {
            hashTable[index].add(data);
        }
    }

    void searchData(String data){
        int index = getIndex(data, 14);
        if(hashTable[index] != null && hashTable[index].contains(data)){
            System.out.println("Data found . index "+ index + " data "+data);
        }else{
            System.out.println("not found");
        }
    }

    void deleateData(String data){
        int index = getIndex(data, 14);
        if(hashTable[index] != null && hashTable[index].contains(data)){
            System.out.println("Data found . index "+ index + " data "+data);
            hashTable[index].remove(data);
        }else{
            System.out.println("not found");
        }
    }

    void displayData() {
        for (int i = 0; i < hashTable.length; i++) {
            if (hashTable[i] != null) {
                LinkedList<String> strings = hashTable[i];
                System.out.println("index " + i + " value " + strings);
            }
        }
    }

    public static void main(String[] args) {
        DirectHashing dh = new DirectHashing(14);
        dh.insertElements("abc");
        dh.insertElements("abc");
        dh.insertElements("abc2");
        dh.insertElements("abc5");
        dh.displayData();
        dh.searchData("abc");
        dh.searchData("abc2");
        dh.displayData();
        dh.deleateData("abc");
        dh.displayData();
    }
}
