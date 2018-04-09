package HashTable;

import org.junit.Test;

import static org.junit.Assert.*;

public class CellTest {

    @Test
    public void getKey() {
        Cell cell = new Cell(1);
        assertEquals("1", cell.getKey().toString());
    }

    @Test
    public void incAmount() throws Exception {
        Cell cell = new Cell(1);
        cell.incAmount();
        assertEquals("2", cell.getAmount().toString());
    }

    @Test
    public void decAmount() throws Exception {
        Cell cell = new Cell(2);
        cell.decAmount();
        assertEquals("0", cell.getAmount().toString());
        cell.decAmount();
        assertEquals("0", cell.getAmount().toString());
    }

    @Test
    public void getAmount() {
    }

    @Test
    public void equals() throws Exception {
        Cell cell = new Cell(13);
        Cell secondCell = new Cell(0);
        Cell thirdCell = new Cell(13);
        int notCell = 13;
        Cell voidCell = null;
        assertFalse(cell.equals(notCell));
        assertFalse(cell.equals(voidCell));
        assertTrue(cell.equals(cell));
        assertFalse(cell.equals(secondCell));
        assertTrue(cell.equals(thirdCell));
        assertFalse(cell.equals(null));
    }

    @Test
    public void toStringTest() {
        Cell cell = new Cell(13);
        assertEquals("Cell{key=13 amount=1}", cell.toString());
        cell.incAmount();
        assertEquals("Cell{key=13 amount=2}", cell.toString());
        cell.decAmount();
        cell.decAmount();
        assertEquals("Cell{key=13 amount=0}", cell.toString());
        cell.decAmount();
        assertEquals("Cell{key=13 amount=0}", cell.toString());
    }
}