package chained_list2;


import org.junit.Test;

import static org.junit.Assert.*;

public class ChainedTest {

	@Test
    public void testAdd() throws Exception {

		ChainedList<String> chain = new ChainedList<>();
		assertTrue(chain.isEmpty());
		
		chain.add("A");
		chain.add("B");
		chain.add("C");
		chain.add("D");
		chain.add("E");
		
		assertFalse(chain.isEmpty());
		
		assertEquals(5, chain.getSize());
	
		StringBuilder sb = new StringBuilder();
		ChainedItem<String> ptr = chain.getHead();
		
		while (ptr != null) {
			//System.out.println(ptr.getData());
			sb.append(ptr.getData());
			ptr = ptr.getNext();
		}
		assertEquals("ABCDE", sb.toString());
	
    }
	/**
	
	@Test
	public void testEmpty() throws Exception {
		ChainedList<String> c = new ChainedList<>();
		assertTrue(c.isEmpty());
		
		c.add("A");
		c.add("B");
		c.add("C");
		c.add("D");
		c.add("E");
		
		c.empty();
		assertTrue(c.isEmpty());		
	}
	*/
	@Test
	public void testEmpty() throws Exception {
		ChainedList<String> chain = new ChainedList<>();
		assertTrue(chain.isEmpty());
		
		chain.add("A");
		chain.add("B");
		chain.add("C");
		chain.add("D");
		chain.add("E");
		
		chain.empty();	
		assertTrue(chain.isEmpty());
	}
	
	
	@Test
    public void testRemove() throws Exception {

		ChainedList<String> chain = new ChainedList<>();
		chain.add("A");
		chain.add("B");
		chain.add("C");
		chain.add("D");
		chain.add("E");

		chain.remove(2);
		chain.remove("E");
		
		StringBuilder sb = new StringBuilder();
		ChainedItem<String> ptr = chain.getHead();
		
		while (ptr != null) {
			sb.append(ptr.getData());
			ptr = ptr.getNext();
		}
		assertEquals("ABD", sb.toString());
    }

	@Test
    public void testInsert() throws Exception {

		ChainedList<String> chain = new ChainedList<>();
		chain.add("A");
		chain.add("B", 0);
		chain.add("C");
		chain.add("D");
		
		StringBuilder sb = new StringBuilder();
		ChainedItem<String> ptr = chain.getHead();
		
		while (ptr != null) {
			sb.append(ptr.getData());
			ptr = ptr.getNext();
		}
		assertEquals("BACD", sb.toString());
    }
	
	@Test
	public void testIterator() throws Exception{
		ChainedList<String> chain = new ChainedList<>();
		assertTrue(chain.isEmpty());
		
		chain.add("A");
		chain.add("B");
		chain.add("C");
		chain.add("D");
		chain.add("E");
		
		for(String s : chain){
			System.out.println(s);
		}
		
	}
    /*	
	@Test(expected=IndexOutOfBoundsException.class)
    public void testRemoveOutOfBound() throws Exception {

		ChainedList<String> chain = new ChainedList<>();
		chain.add("A");
		chain.add("B");
		chain.add("C");
		chain.add("D");
		chain.add("E");

		chain.remove(7);
    }
	
	@Test(expected=IndexOutOfBoundsException.class)
    public void testAddOutOfBound() throws Exception {

		ChainedList<String> chain = new ChainedList<>();
		chain.add("A");
		chain.add("B");
		chain.add("C");
		chain.add("D");
		chain.add("E", 7);
    }
    */
	
	@Test()
    public void testRemoveUntilEmpty() throws Exception {

		ChainedList<String> chain = new ChainedList<>();
		chain.add("A");
		chain.add("B");
		chain.add("C");
		chain.add("D");
		chain.add("E");

		while (!chain.isEmpty()) {
			chain.remove(0);
		}
		assertNull(chain.getHead());
    }

	@Test()
	public void testSortAscending() throws Exception {
	
		ChainedList<String> chain = new ChainedList<>();
		chain.add("A");
		chain.add("D");
		chain.add("E");
		chain.add("B");
		chain.add("C");
		
		chain.sortAscending();
	
		StringBuilder sb = new StringBuilder();
		ChainedItem<String> ptr = chain.getHead();
		
		while (ptr != null) {
			sb.append(ptr.getData());
			ptr = ptr.getNext();
		}
		assertEquals("ABCDE", sb.toString());
	}
	/*
	@Test()
	public void testGetMax() throws Exception{
		Chain<String> chain = new Chain<>();
		chain.add("E");
		chain.add("D");
		chain.add("A");
		chain.add("B");
		chain.add("C");
		
		assertEquals("E", chain.getMax());
	}
	
	@Test()
	public void testSortDescending() throws Exception {
		Chain<String> chain = new Chain<>();
		chain.add("E");
		chain.add("D");
		chain.add("A");
		chain.add("B");
		chain.add("C");
		
		chain.sortDescending();
	
		StringBuilder sb = new StringBuilder();
		Chain<String>.ChainItem<String> ptr = chain.getHead();
		
		while (ptr != null) {
			sb.append(ptr.getData());
			ptr = ptr.getNext();
		}
		assertEquals("EDCBA", sb.toString());
	}
	*/
}


