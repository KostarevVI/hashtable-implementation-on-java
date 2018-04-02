package HashTable;

import java.util.Objects;

public class Cell {

    private Integer key;
    private Integer amount; //да, я хочу хранить кол-во значений, ведь это моя таблица и я её сделал

    /**
     * Constructor of Cell
     *
     * @param key Received value
     */

    public Cell(Integer key) {
        this.key = key;
        this.amount = 1;
    }

    /**
     * Getter of key in Cell
     *
     * @return Key in Cell
     */

    public Integer getKey() {
        return key;
    }

    /**
     * Increase amount of this value in Cell
     */

    public void incAmount() {
        this.amount++;
    }

    /**
     * Decrease amount of this value in Cell
     */

    public void decAmount() {
        if (amount > 0)
            this.amount--;
    }

    /**
     * Getter of key in Cell
     *
     * @return Amount of values in Cell
     */

    public Integer getAmount() {
        return amount;
    }

    /**
     * Override of equals for Cell
     *
     * @param obj Other Cell
     * @return If Cells equals returns True, else False
     */

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

    /**
     * Override of hashCode for Cell
     *
     * @return Generated hashCode
     */

    @Override
    public int hashCode() {
        return key != null ? key.hashCode() : 0;
    }

    /**
     * Override of toString for Cell
     *
     * @return String with key value
     */

    @Override
    public String toString() {
        return "Cell{" +
                "key=" + key +
                '}';
    }
}