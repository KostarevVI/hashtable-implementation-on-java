package HashTable;

import org.junit.Test;

import static org.junit.Assert.*;

public class HashTableTest1 {

    HashTable firstTable = new HashTable(10);
    HashTable secondTable = new HashTable(9);
    HashTable thirdTable = new HashTable(10);

    @Test
    public void push() throws Exception {
        firstTable.push(1);
        firstTable.print();
        //assertEquals(1, firstTable.getTable()[49].getKey());
    }

    @Test
    public void delete() throws Exception {
        firstTable.delete(1);
        assertEquals(null, firstTable.getTable()[49]);
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
    public void hashEquals() throws Exception {
        firstTable.push(256);
        thirdTable.push(256);
        firstTable.push(5);
        thirdTable.push(5);
        firstTable.push(1);
        thirdTable.push(2);
        firstTable.push(526);
        firstTable.print();
        thirdTable.print();
        assertFalse(firstTable.hashEquals(thirdTable));
        firstTable.delete(526);
        assertFalse(firstTable.hashEquals(thirdTable));
        firstTable.delete(1);
        thirdTable.delete(2);
        firstTable.print();
        thirdTable.print();
        System.out.println(firstTable.getSize());
        System.out.println(thirdTable.getSize());
        assertTrue(firstTable.hashEquals(thirdTable));
    }
}