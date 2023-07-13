/**
 * 
 */
   import java.util.NoSuchElementException;
/**
 * @author Emmanuel Makoye
 * A NumArrayList class that implements a NumList interface
 *
 */
public class NumArrayList implements NumList {


    //a field to store an array of doubles in the NumArrayList 
    private double list[];
    // a field to store the size of the NumArrayList 
    private int size;
    // a field to store the capacity of the NumArrayList
    private int arrayCapacity;
    
    // A constructor that creates a list with capacity of 15
    public NumArrayList() {
     arrayCapacity = 15;
     size = 0;
     list = new double[arrayCapacity];
    }
    
    // a constructor that allows the user to specify the capacity
    public NumArrayList(int n) {
     arrayCapacity = n;
     size = 0;
     list = new double[arrayCapacity];
    }
    
    /**
     * adds a value to the NumArrayList while increasing the size
     */
    @Override    
    public void add(double d) {
     if(capacity() == size())
     //the list is expanded to accommodate one more element
      expand();
     list[size++] = d;
    }
    
    /**
     * returns the number of elements present in NumArrayList
     * @return an int that is the size
     */
    @Override
    public int size() {
     return size;
    }
    
    /**
     * returns the number of elements the list can hold
     * @return an int that is the capacity 
     */
    @Override
    public int capacity() {
     return arrayCapacity;
    }
    
    /**
     * inserts a value at a specified index in the NumArrayList
     */
    @Override
    public void insert(int i, double value) {
     if(i >= size()) {
      if(capacity() == size())
      //the list is expanded to accommodate one more element
       expand();
      size++;
      list[size() - 1] = value;
     }
     
     else {
      if(capacity() == size())
       //the list is expanded to accommodate one more element
       expand();
      //a new array containing all elements plus the inserted one
      double[] list2 = new double[capacity()];
      // an index for the elements in the new array (list2)
      int index = 0;
      for(int j = 0; j < size(); j++) {
       //copies all elements from old array to new array
       if(j != i) {
        list2[index++] = list[j];
       }
       //at index i, the value is inserted
       if(j == i) {
        list2[index++] = value;
        list2[index++] = list[j];
       }
       }
      //the old array is resized
      size++;
      //the old array is assigned to the new array
      list = list2;
      }
     }
    
    /**
     * removes an a double value at the specified index
     */
    @Override
    public void remove(int i) {
  //if elements in not in list, an exception is thrown     
     if(i + 1 > size())
      throw new NoSuchElementException();
     else {
      //a new array of all elements but the one to be removed
      double[] list2 = new double[capacity()];
      // an index for the elements in the new array (list2)
      int index = 0;
      for(int j = 0; j < size(); j++) {
       //copies elements from old array to new array except at i
       if( i != j) {
        list2[index] = list[j];
        index++;
       }    
      }
      // the original array is resized 
      size--;
      // the old array is assigned to the new array
      list = list2;
     }
    }
    
    /**
     * checks if the list contains the parameter value 
     */
    @Override
    public boolean contains(double value) {
     for(int i = 0; i < size(); i++) {
      if(list[i] == value)
       return true;
     }
     return false;
    }
    
    /**
     * checks what double value is at a specific index
     * @return a double value at that index
     */
    @Override
    public double lookup(int i) {
     if(i + 1 <= size())
      return list[i];
     else
      throw new NoSuchElementException();
    }
    
    /**
     * checks whether a specific NumList is equal to this list
     * @return true only if the list is exactly equal
     */
    @Override
    public boolean equals(NumList otherList) {
     if(this.size() != otherList.size())
      return false;
     else {
      //the NumLists are changed to a String for easy comparisons
      String str1 = this.toString();
      String str2 = otherList.toString();
      for(int i = 0; i < str1.length(); i++) {
       if(str1.charAt(i) != str2.charAt(i))
        return false;
      }
     }
     return true;
    }
    
    /**
     * removes any duplicates in the list
     */
    @Override
    public void removeDuplicates() {
     for(int i = 0; i < size(); i++) {
     // compareVal holds an element that is checked against others 
      double compareVal = list[i];
      for(int j = i+1; j < size(); j++) {
      //when an element is equal to the compareVal, it is removed
       if(compareVal == list[j])
        remove(j);
      }
     }
     
   //calls duplicates() to check if all duplicates are removed
     if(duplicates() == true)
      removeDuplicates();
     
     
    }
    
    /**
     * returns a String representation of the NumArrayList
     * @return String representation of the list
     */
    @Override
    public String toString() {
     //for an empty list
     if(size() == 0)
      return "";
     //for non empty lists
     StringBuilder builder = new StringBuilder();
     for(int i = 0; i < size(); i++) {
      if(i < size() - 1) {
      //appends the element and a space for the first elements
      builder.append(list[i]);
      builder.append(' ');
      }
      //for the last element, only the element is appended 
      if(i == size() -1) {
       builder.append(list[i]);
      }
     }
     return builder.toString();
    }
    
    /**
     * A helper method for expanding the capacity of the list
     */
    private void expand() {
     if(capacity() == size()) {
      arrayCapacity++; 
      double[] list2 = new double[arrayCapacity];
      for(int i = 0; i < size(); i++) {
       list2[i] = list[i];
      }
      
      list = list2;
       
      }
     }
    
    /**
     * checks whether the list has duplicates or not 
     * @return true only when there are duplicates
     */
    private boolean duplicates() {
     for(int i = 0; i < size(); i++) {
      double temp = list[i];
      for(int j = i + 1; j < size(); j++) {
       if( temp == list[j])
        return true;
      }
      }
     return false;
     }
    
    
    public static void main(String[] args) {
     NumArrayList list = new NumArrayList(5);
     NumArrayList list2 = new NumArrayList();
       
       for(int i = 0; i < 5; i++){
         list.add(2.0);
         list.add(4.0);
         list.add(8.0);
         list.add(16.0);
         list.add(32.0);
       }
       list2.add(30.0);
       list2.add(90.0);
       System.out.println("List size: " + list.size());
       System.out.println("List capacity: " + list.capacity());
      System.out.println("String Representation of the list: " + list.toString());
      list.removeDuplicates();
      System.out.println("Duplicates removed: " + list.toString());
      list.add(777.7);
      System.out.println("777.7 is added to the list: " + list.toString());
      list.insert(0, 100.0);
      System.out.println("100.0 is inserted at index 0: " + list.toString());
      list.insert(4, 300.0);
      System.out.println("300.0 is inserted at index 4: " + list.toString());
      System.out.println("the two lists are not equal: " + list.equals(list2));
      list2 = list;
      System.out.println("the two lists are now equal: " + list.equals(list2));
   }     
    }
    
     



