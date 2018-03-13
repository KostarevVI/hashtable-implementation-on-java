package HashTable;

public class Cell {
    private int key;
    private int hash;

    public Cell(int key, int hash) {
        this.key = key;
        this.hash = hash;
    }

    public int getKey() {
        return key;
    }

    public int getHash() {
        return hash;
    }

    public boolean hashEquals(Cell otherCell) {
        return this.getHash() == otherCell.getHash() && this.getKey() == otherCell.getKey();
    }
}