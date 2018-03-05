package HashTable;

public class HashTable {
    private Cell[] table;
    private int size;

    public HashTable(int size) {
        this.size = size;
        table = new Cell[size];
    }

    private int hash(int key) {
        int hash = 0;
        for (int i = 0; i < String.valueOf(key).length(); i++)
            hash = (31 * hash + String.valueOf(key).charAt(i)) % size; //алгоритм Горнера
        return hash;
    }

    public void push(int key) {
        Cell cell = new Cell(key);
        int hash = hash(key);
        while (table[hash] != null)  //решение коллизий методом линейного пробирования
        {
            hash++;
            hash %= size;
        }
        table[hash] = cell;
    }

    public void delete(int key) {
        int hash = hash(key);
        if (find(key) != null) {
            table[hash] = null;
            System.out.println("Удалил");
        } else {
            System.out.println("Удалять нечего");
        }
    }

    public void print() {
        for (int i = 0; i < size; i++)
            if (table[i] != null)
                System.out.println(i + " " + table[i].getKey());
    }

    public Integer find(int key) {
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

    public boolean hashEquals(Cell otherCell) {
        int hash = hash(otherCell.getKey());
        return this.find(otherCell.getKey()) == otherCell.getKey() && this.table[hash].getKey() == otherCell.getKey();
    }
}


