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
        secondTable.push(1);
        firstTable.push(2);
        firstTable.print();
        secondTable.print();
        assertFalse(firstTable.equals(thirdTable));
        assertFalse(firstTable.equals(secondTable)); //первая таблица содержит все элементы второй и что-то ещё
        secondTable.delete(1);
        assertFalse(firstTable.equals(secondTable));
        firstTable.delete(1);
        firstTable.delete(2);
        firstTable.print();
        secondTable.print();
        assertTrue(firstTable.equals(secondTable));
        assertFalse(firstTable.equals(null));
        assertFalse(firstTable.equals(notHashtable));
    }

    @Test
    public void rehash() throws Exception {
        for (int i = 0; i < 50; i++)
            firstTable.push(i);
        firstTable.print();
        assertTrue(firstTable.find(1));
        assertEquals(8, firstTable.getTableSize());
    }
}