package HashTable;

import org.junit.After;
import org.junit.Test;

import static org.junit.Assert.*;

public class HashTableTest1 {

    HashTable firstTable = new HashTable(4);
    HashTable secondTable = new HashTable(4);
    HashTable thirdTable = new HashTable(10);

    @After
    public void after() {
        firstTable.clear();
        secondTable.clear();
        System.out.println("---------------------");
    }

    @Test
    public void push() throws Exception {
        firstTable.push(990);
        firstTable.print();
        assertTrue(firstTable.find(990));
        firstTable.push(990);
        firstTable.delete(990);
        firstTable.print();
        assertTrue(firstTable.find(990));
        assertFalse(firstTable.find(0));
    }

    @Test
    public void delete() throws Exception {
        firstTable.push(1);
        firstTable.delete(1);
        firstTable.push(13);
        assertFalse(firstTable.find(1));
        assertTrue(firstTable.delete(13));
    }

    @Test
    public void getTableSize() throws Exception {
        for (int i = 0; i < 100; i++) {
            firstTable.push(i);
        }
        assertEquals(16, firstTable.getTableSize());
    }

    @Test
    public void find() throws Exception {
        firstTable.push(6);
        firstTable.push(256);
        firstTable.push(256);
        firstTable.print();
        firstTable.delete(256);
        firstTable.print();
        assertTrue(firstTable.find(6));
        assertTrue(firstTable.find(256));
        assertFalse(firstTable.find(999));
    }

    @Test
    public void clear() throws Exception {
        firstTable.push(1);
        firstTable.push(9998);
        firstTable.print();
        firstTable.clear();
        firstTable.print();
        assertFalse(firstTable.find(1));
        assertFalse(firstTable.find(9999));
    }

    @Test
    public void getBucketsSize() throws Exception {
        for (int i = 0; i < 13; i++) {
            firstTable.push(i);
        }
        firstTable.print();
        assertEquals(13, firstTable.getBucketsSize());
    }

    @Test
    public void isThisEmpty() throws Exception {
        firstTable.push(2);
        assertFalse(firstTable.isThisEmpty());
        firstTable.delete(2);
        firstTable.print();
        assertTrue(firstTable.isThisEmpty());
        assertTrue(secondTable.isThisEmpty());
    }

    @Test
    public void equals() throws Exception {
        int notHashtable = 13;
        firstTable.push(256);
        secondTable.push(256);
        firstTable.push(5);
        secondTable.push(5);
        firstTable.push(1);
        secondTable.push(2);
        firstTable.push(526);
        firstTable.print();
        secondTable.print();
        assertFalse(firstTable.equals(thirdTable));
        assertFalse(firstTable.equals(secondTable));
        firstTable.delete(526);
        assertFalse(firstTable.equals(secondTable));
        firstTable.delete(1);
        secondTable.delete(2);
        firstTable.print();
        secondTable.print();
        assertTrue(firstTable.equals(secondTable));
        assertFalse(firstTable.equals(null));
        assertFalse(firstTable.equals(notHashtable));
    }

    @Test
    public void rehash() throws Exception {
        for (int i = 0; i < 17; i++)
            firstTable.push(i);
        firstTable.print();
        assertTrue(firstTable.find(1));
        assertEquals(8, firstTable.getTableSize());
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

    //Как сделать два equals теста в одном тестовом классе? К какой магии прибегать?

    class CellTest extends HashTableTest1 {
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
    }
}