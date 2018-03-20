package HashTable;

import java.util.ArrayList;
import java.util.List;

public class HashTable {

    private List<List<Cell>> buckets;
    private int size;

    public HashTable(int size) {
        this.size = size;
        List<List<Cell>> buckets = new ArrayList<>();
        this.buckets = insertLists(buckets, size);
    }

    private List<List<Cell>> insertLists(List<List<Cell>> newBucket, int size) {
        for (int i = 0; i < size; i++) {
            newBucket.add(new ArrayList<>());
        }
        return newBucket;
    }

    private int hash(Integer a) {
        int key = a.hashCode();
        int hash = 0;
        for (int i = 0; i < String.valueOf(key).length(); i++)
            hash = (31 * hash + String.valueOf(key).charAt(i)) % size; //алгоритм Горнера
        return hash;
    }

    public List<List<Cell>> getBuckets() {
        return buckets;
    }

    public int getTableSize() {
        int tSize = 0;
        for (List<Cell> bucket : buckets)
            for (Cell cell : bucket)
                tSize++;
        return tSize;
    }

    public void push(int key) {
        int hash = hash(key);
        Cell cell = new Cell(key);
        buckets.get(hash).add(cell);
    }

    public void delete(int key) {
        int hash = hash(key);
        if (buckets.get(hash).contains(new Cell(key))) {
            for (int i = 0; i < buckets.get(hash).size(); i++) {
                Cell cell = buckets.get(hash).get(i);
                if (cell != null && cell.getKey() == key) {
                    buckets.get(hash).remove(i);
                    System.out.println("Удалил");
                    break;
                }
            }
        } else {
            System.out.println("Удалять нечего");
        }
    }

    /**
     * ABC
     *
     * @param key TEST
     * @return Буль
     */
    public Boolean find(int key) {
        int hash = hash(key);
        if (buckets.get(hash).contains(new Cell(key))) {
            return true;
        } else {
            for (Cell cell : buckets.get(hash)) {
                if (cell != null && cell.getKey() == key)
                    return true;
            }
        }
        return false;
    }

    public void print() {
        for (int i = 0; i < buckets.size(); i++)
            for (Cell cell : buckets.get(i))
                System.out.println(i + " " + cell.getKey());
        System.out.println();
    }

    public void clear() {
        for (List<Cell> bucks : buckets) {
            bucks.clear();
        }
        System.out.println("Таблица очищена");
    }

    public Boolean isThisEmpty() {
        for (List<Cell> bucks : buckets) {
            if (!bucks.isEmpty()) {
                return false;
            }
        }
        return true;
    }

    public Boolean hashEquals(HashTable otherBucks) {
        if (this.size != otherBucks.size) {
            System.out.println("Таблицы не равны");
            return false;
        }
        for (int i = 0; i < this.size; i++)
            if (!this.getBuckets().get(i).containsAll(otherBucks.getBuckets().get(i))) {
                System.out.println("Таблицы не равны");
                return false;
            }
        System.out.println("Таблицы равны");
        return true;
    }
}


