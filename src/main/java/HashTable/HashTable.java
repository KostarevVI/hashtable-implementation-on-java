package HashTable;

//import javax.annotation.Nullable;

import com.sun.istack.internal.Nullable;

public class HashTable {
    @Nullable
    private Cell[] table;
    private int size;


    /*public static void main(String[] args){
        for (int i = 0;i<;i++){
            table[i] = null;
        }
    }

    public Cell[] init(){
        for (int i = 0;i<size;i++){

        }
        return table;
    }*/

    public HashTable(int size) {
        this.size = size;
        table = new Cell[size];
        for (int i = 0; i < this.size; i++) {
            table[i] = null;
            //table[i] = new Cell(null, null);
        }
    }

    private int hash(int key) {
        int hash = 0;
        for (int i = 0; i < String.valueOf(key).length(); i++)
            hash = (31 * hash + String.valueOf(key).charAt(i)) % size; //алгоритм Горнера
        return hash;
    }

    public Cell[] getTable() {
        return table;
    }

    public int getSize() {
        return size;
    }

    public void push(int key) {
        int hash = hash(key);
        Cell cell = new Cell(key, hash);
        while (table[hash].getKey() != null)  //решение коллизий методом линейного пробирования
        {
            hash++;
            hash %= size;
        }
        table[hash] = cell;
    }

    public void delete(int key) {
        int hash = hash(key);
        if (find(key)) {
            int counter = hash;
            while (counter < size) {
                if (table[counter].getKey() == key) {
                    table[counter] = null;
                    System.out.println("Удалил");
                    break;
                }
                counter++;
            }
        } else {
            System.out.println("Удалять нечего");
        }
    }

    public Boolean find(int key) {
        int hash = hash(key);
        try {
            if (table[hash].getKey() != null && table[hash].getKey() == key) {
                return true;
            } else {
                for (int i = 0; i < size; i++) {
                    try {
                        if (table[i].getKey() == key)
                            return true;
                    } catch (NullPointerException e) {

                    }
                }
            }
        } catch (NullPointerException e) {

        }
        return false;
    }

    public void print() {
        for (int i = 0; i < size; i++)
            if (table[i] != null)
                System.out.println(i + " " + table[i].getKey());
    }

    public void clear() {
        for (int i = 0; i < size; i++) {
            this.table[i] = null;
        }
        System.out.println("Таблица очищена");
    }

    public Boolean isThisEmpty() {
        int counter = 0;
        boolean flag = true;
        while (flag && this.getSize() > counter) {
            if (table[counter].getKey() != null)
                flag = false;
            counter++;
        }
        return flag;
    }

    public Boolean hashEquals(HashTable otherTable) {
        if (this.size != otherTable.size) {
            System.out.println("Таблицы не равны");
            return false;
        }
        for (int i = 0; i < this.size; i++)
            if (!this.table[i].cellEquals(otherTable.table[i])) {
                System.out.println("Таблицы не равны");
                return false;
            }
        System.out.println("Таблицы равны");
        return true;
    }

/*
    public Integer getHash(int key) {
        int hash = hash(key);
        while (table[hash] != null) {
            if (table[hash].getKey() == key) {
                System.out.println("Нашёл");
                return hash;
                //return table[hash];
            }
            hash++;
            hash = hash % size;
        }
        System.out.println("Не нашёл по ходу");
        return null;
        //return null;
    }
*/
}


