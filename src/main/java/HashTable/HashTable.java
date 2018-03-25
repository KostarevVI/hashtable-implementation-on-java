package HashTable;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;

public class HashTable {

    private List<HashSet<Cell>> buckets;
    private int size;


    public HashTable(int size) {
        this.size = size;
        this.buckets = insertSets(size);
    }

    private List<HashSet<Cell>> insertSets(int size) {
        List<HashSet<Cell>> newBucket = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            newBucket.add(new HashSet<>());
        }
        return newBucket;
    }

    private int bucketNum(Integer a) {
        return a.hashCode() % size;
    }

    public List<HashSet<Cell>> getBuckets() {
        return buckets;
    }

    public int getTableSize() {
        return this.size;
    }

    public int getBucketsSize() {
        int tSize = 0;
        for (HashSet<Cell> bucket : buckets)
            for (Cell cell : bucket)
                tSize++;
        return tSize;
    }

    private void expandSets() {
        for (int i = 0; i < size; i++) {
            buckets.add(new HashSet<>());
        }
        this.size = this.size * 2;
    }

    public boolean push(int key) {
        int bucketNum = bucketNum(key);
        Cell cell = new Cell(key);
        if (!buckets.get(bucketNum).contains(cell)) {
            buckets.get(bucketNum).add(cell);
            return true;
        } else {
            int counter = 0;
            while (counter < size) {
                if (counter != bucketNum && !buckets.get(counter).contains(cell)) {
                    buckets.get(counter).add(cell);
                    return true;
                }
                counter++;
            }
            this.expandSets();
            buckets.get(bucketNum + 1).add(cell);
            return true;
        }
    }

    public boolean delete(int key) {
        if (this.find(key)) {
            int bucketNum = bucketNum(key);
            int counter = 0;
            while (counter < size) {
                if (buckets.get(bucketNum).contains(new Cell(key)))
                    for (Cell cell : buckets.get(bucketNum))
                        if (cell != null && cell.getKey() == key) {
                            buckets.get(bucketNum).remove(cell);
                            System.out.println("Удалил");
                            return true;
                        }
                bucketNum = (bucketNum + 1) % size;
                counter++;
            }
        }
        System.out.println("Удалять нечего");
        return false;
    }

    /**
     * ABC
     *
     * @param key TEST
     * @return Буль
     */
    public Boolean find(int key) {
        int hash = bucketNum(key);
        if (buckets.get(hash).contains(new Cell(key))) {
            return true;
        } else {
            int counter = 0;
            while (counter < size)
                for (HashSet<Cell> bucket : buckets) {
                    if (bucket.contains(new Cell(key)))
                        return true;
                    counter++;
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
        for (HashSet<Cell> bucks : buckets) {
            bucks.clear();
        }
        System.out.println("Таблица очищена");
    }

    public Boolean isThisEmpty() {
        for (HashSet<Cell> bucks : buckets) {
            if (!bucks.isEmpty()) {
                return false;
            }
        }
        return true;
    }

    @Override
    public int hashCode() {
        return Objects.hash(buckets, size);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null || this.getClass() != obj.getClass())
            return false;
        HashTable otherBucks = (HashTable) obj;
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


