package HashTable;

import com.sun.istack.internal.Nullable;

public class Cell {
    @Nullable
    private Integer key;
    @Nullable
    private Integer hash;

    public Cell(Integer key, Integer hash) {
        this.key = key;
        this.hash = hash;
    }

    public Integer getKey() {
        return key;
    }

    public Integer getHash() {
        return hash;
    }

    public boolean cellEquals(Cell otherCell) {
        //if(this.getKey() != null && this.getHash() != null && otherCell.getHash() != null && otherCell.getKey() != null){
        if (this.getHash().equals(otherCell.getHash()) && this.getKey().equals(otherCell.getKey())) {
            return true;
        }
        //}
        return false;
    }
}