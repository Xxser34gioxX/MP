package jeroquest.utils;

public class DynamicVectorObjects {
  private Object[] data;
  
  public DynamicVectorObjects() {
    this.data = new Object[0];
  }
  
  public DynamicVectorObjects(DynamicVectorObjects v) {
    this.data = new Object[v.length()];
    for (int i = 0; i < this.data.length; i++)
      this.data[i] = v.get(i); 
  }
  
  public DynamicVectorObjects(int size) {
    this.data = new Object[size];
    for (int i = 0; i < this.data.length; i++)
      this.data[i] = null; 
  }
  
  public DynamicVectorObjects(Object[] v) {
    this.data = new Object[v.length];
    for (int i = 0; i < this.data.length; i++)
      this.data[i] = v[i]; 
  }
  
  public int length() {
    return this.data.length;
  }
  
  public boolean isNull() {
    return (this.data.length == 0);
  }
  
  public Object get(int i) {
    return this.data[i];
  }
  
  public void show() {
    System.out.println("\nDynamicVectorObjects");
    System.out.printf("Length: %d", new Object[] { Integer.valueOf(this.data.length) });
    System.out.print("\nData: ");
    for (int i = 0; i < this.data.length; i++) {
      System.out.printf(" %s", new Object[] { this.data[i] });
    } 
    System.out.println();
  }
  
  public int position(Object x) {
    int i = 0;
    while (i < length()) {
      if (get(i).equals(x))
        return i; 
      i++;
    } 
    return -1;
  }
  
  public boolean member(Object x) {
    return (position(x) != -1);
  }
  
  public void set(int i, Object x) {
    this.data[i] = x;
  }
  
  public void add(Object x) {
    Object[] temp = new Object[this.data.length + 1];
    for (int i = 0; i < this.data.length; i++)
      temp[i] = this.data[i]; 
    temp[temp.length - 1] = x;
    this.data = temp;
  }
  
  public void insert(int i, Object x) {
    Object[] temp = new Object[this.data.length + 1];
    int j;
    for (j = 0; j < i; j++)
      temp[j] = this.data[j]; 
    temp[i] = x;
    for (j = i + 1; j < temp.length; j++)
      temp[j] = this.data[j - 1]; 
    this.data = temp;
  }
  
  public void remove(int i) {
    Object[] temp = new Object[this.data.length - 1];
    int j;
    for (j = 0; j < i; j++)
      temp[j] = this.data[j]; 
    for (j = i; j < temp.length; j++)
      temp[j] = this.data[j + 1]; 
    this.data = temp;
  }
  
  public Object[] vectorNormal() {
    Object[] temp = new Object[length()];
    for (int i = 0; i < temp.length; i++)
      temp[i] = get(i); 
    return temp;
  }
}
