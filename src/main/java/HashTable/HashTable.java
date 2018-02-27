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
        if (table[hash] == null) {
            table[hash] = cell;
        } else {
            System.out.println("Такой элемент уже есть");
        }
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

    public Cell find(int key) {
        int hash = hash(key);
        while (table[hash] != null) {
            if (table[hash].getKey() == key) {
                System.out.println("Нашёл");
                return table[hash];
            }
            hash++;
            hash = hash % size;
        }
        System.out.println("Не нашёл по ходу");
        return null;
    }

    public boolean hashEquals(HashTable otherTable) {
        if (this.size != otherTable.size) {
            System.out.println("Таблицы не равны");
            return false;
        }
        for (int i = 0; i < this.size; i++)
            if (!this.table[i].equals(otherTable.table[i])) {
                System.out.println("Таблицы не равны");
                return false;
            }
        System.out.println("Таблицы равны");
        return true;
    }
}


