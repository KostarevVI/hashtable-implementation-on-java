package HashTable;

import java.util.Objects;

public class Cell {

    private Integer key;

    public Cell(Integer key) {
        this.key = key;
    }

    public Integer getKey() {
        return key;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null)
            return false;
        if (this.getClass() != obj.getClass())
            return false;
        if (obj == this)
            return true;
        Cell otherCell = (Cell) obj;
        return Objects.equals(this.getKey(), otherCell.getKey());
    }

    //не хочу писать тесты для этого :/

    @Override
    public int hashCode() {
        return key != null ? key.hashCode() : 0;
    }

    @Override
    public String toString() {
        return "Cell{" +
                "key=" + key +
                '}';
    }
}