import org.junit.*;
import static org.junit.Assert.*;
import java.util.NoSuchElementException;

public class P1_Test {
  @Test
  public void sizeTest(){
    NumArrayList list = new NumArrayList(5);
    NumArrayList list2 = new NumArrayList();
    
    assertEquals(0, list.size());
    assertEquals(0, list2.size());
    
    list.add(1.3);
    
    for(int i = 0; i < 5; i++)
      list.add(2.3);
    assertEquals(6, list.size());
  }
  
  @Test
  public void capacityTest(){
    NumArrayList list = new NumArrayList(5);
    NumArrayList list2 = new NumArrayList();
    
    assertEquals(5, list.capacity());
    assertEquals(15, list2.capacity());
  }
  
  @Test 
  public void addTester(){
    NumArrayList list = new NumArrayList(5);
    assertEquals("", list.toString());
    list.add(1.3);
    assertEquals("1.3", list.toString());
    list.add(2.5);
    assertEquals("1.3 2.5", list.toString());
    for(int i = 0; i < 5; i++){
      list.add(12.3);
      list.add(4.5);
    }
    assertEquals("1.3 2.5 12.3 4.5 12.3 4.5 12.3 4.5 12.3 4.5 12.3 4.5", list.toString());
    
  }
  
  @Test
  public void insertTester(){
    NumArrayList list = new NumArrayList(5);
    list.insert(0, 5.7);
    assertEquals("5.7", list.toString());
    list.insert(4, 15.5);
    assertEquals("5.7 15.5", list.toString());
    for(int i = 0; i < 5; i++){
      list.add(12.3);
      list.add(4.5);
    }
    list.insert(5, 1000.1);
    list.insert(17, 2000.0);
    list.insert(0, 9999.0);
    assertEquals("9999.0 5.7 15.5 12.3 4.5 12.3 1000.1 4.5 12.3 4.5 12.3 4.5 12.3 4.5 2000.0", list.toString());
    
  }
  
  @Test
  public void toStringTest(){
    NumArrayList list = new NumArrayList(5);
    assertEquals("", list.toString());
    list.add(1.3);
    assertEquals("1.3", list.toString());
    list.add(2.5);
    assertEquals("1.3 2.5", list.toString());
    for(int i = 0; i < 5; i++){
      list.add(12.3);
      list.add(4.5);
    }
    assertEquals("1.3 2.5 12.3 4.5 12.3 4.5 12.3 4.5 12.3 4.5 12.3 4.5", list.toString());
  }
  
  @Test
  public void removeTest(){
    NumArrayList list = new NumArrayList(5);
    try{
      list.remove(1);
    }
    catch(Exception e){
    }
    list.add(1.3);
    list.remove(0);
    assertEquals("", list.toString());
    list.add(1.3);
    list.add(2.5);
    assertEquals("1.3 2.5", list.toString());
    for(int i = 0; i < 5; i++){
      list.add(12.3);
      list.add(4.5);
    }
    list.insert(5, 1000.1);
    list.insert(13, 2000.0);
    list.insert(0, 9999.0);
    assertEquals("9999.0 1.3 2.5 12.3 4.5 12.3 1000.1 4.5 12.3 4.5 12.3 4.5 12.3 4.5 2000.0", list.toString());
    list.remove(0);
    assertEquals("1.3 2.5 12.3 4.5 12.3 1000.1 4.5 12.3 4.5 12.3 4.5 12.3 4.5 2000.0", list.toString());
    list.remove(7);
    assertEquals("1.3 2.5 12.3 4.5 12.3 1000.1 4.5 4.5 12.3 4.5 12.3 4.5 2000.0", list.toString());
    list.remove(12);
    assertEquals("1.3 2.5 12.3 4.5 12.3 1000.1 4.5 4.5 12.3 4.5 12.3 4.5", list.toString());
  }
  
  @Test
  public void containsTester(){
    NumArrayList list = new NumArrayList(5);
    assertEquals(false, list.contains(23.0));
    list.add(23.0);
    assertEquals(true, list.contains(23.0));
    list.add(30.0);
    list.add(100);
    list.add(300.5);
    assertEquals(false, list.contains(3.0));
    assertEquals(true, list.contains(100.0));
    assertEquals(true, list.contains(300.5));
    
  }
  
  @Test
  public void lookupTest(){
    NumArrayList list = new NumArrayList(5);
    list.add(1.3);
    list.add(2.5);
    for(int i = 0; i < 5; i++){
      list.add(12.3);
      list.add(4.5);
    }
    
    assertEquals(1.3, 0.000001, list.lookup(0));
    assertEquals(12.3, 0.000001, list.lookup(2));
    assertEquals(4.5, 0.000001, list.lookup(11));
  }
  
  @Test
  public void equalsTest(){
    NumArrayList list = new NumArrayList(5);
    NumArrayList list2 = new NumArrayList();
    
    assertEquals(true, list.equals(list2));
    
    list.add(5.0);
    assertEquals(false, list.equals(list2));
    
    list.add(10.0);
    list.add(15.00); 
    
    list2.add(4.0);
    list2.add(8.0);
    list2.add(12.0);
    
    assertEquals(false, list.equals(list2));
  }
  
  @Test
  public void removeDuplicatesTest(){
    NumArrayList list = new NumArrayList(5);
    
    for(int i = 0; i < 5; i++){
      list.add(2.0);
      list.add(4.0);
      list.add(8.0);
      list.add(16.0);
      list.add(32.0);
    }
    //before duplicates are removed
    assertEquals("2.0 4.0 8.0 16.0 32.0 2.0 4.0 8.0 16.0 32.0 2.0 4.0 8.0 16.0 32.0 2.0 4.0 8.0 16.0 32.0 2.0 4.0 8.0 16.0 32.0", list.toString());
    
    list.removeDuplicates();
    //after duplicates are removed
    assertEquals("2.0 4.0 8.0 16.0 32.0", list.toString());
  }
}