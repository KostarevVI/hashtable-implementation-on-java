package HashTable;

import javafx.util.Pair;
import org.junit.Test;

import static org.junit.Assert.*;

public class HashTableTest {


    //public HashTable firstTable = new HashTable(10);
    //public HashTable secondTable = new HashTable(10);
    @Test
    public Pair<HashTable,HashTable> fun() {

        HashTable firstTable = new HashTable(10);
        HashTable secondTable = new HashTable(20);

        firstTable.push(7);
        firstTable.push(7);
        firstTable.push(9);
        firstTable.push(981);
        firstTable.push(20943212);

        secondTable.push(1);
        secondTable.push(7);
        secondTable.push(8);
        secondTable.push(981);
        secondTable.push(999999999);

        firstTable.print();
        secondTable.print();

        Pair<HashTable,HashTable> result = new Pair<HashTable, HashTable>(firstTable,secondTable);
        return result;
        //assertEquals(null,firstTable;
    }

    @Test
    public void push() throws Exception {
        Pair<HashTable, HashTable> tables = fun();
        tables.getKey().push(7);
    }

    @Test
    public void delete() throws Exception {

    }

    @Test
    public void find() throws Exception {
        assertEquals(true, fun().getValue().find(981));
        assertEquals(false, fun().getValue().find(1321123));
        assertEquals(false, fun().getValue().find(0));
        assertEquals(true, fun().getValue().find(7));
    }

    @Test
    public void hashEquals() throws Exception {
        //fun();
        //assertEquals(true, firstTable.hashEquals(secondTable));

    }

}