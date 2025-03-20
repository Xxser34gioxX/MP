package jeroquest.utils;

import jeroquest.units.Character;

public class DynamicVectorCharacters extends DynamicVectorObjects {
  public DynamicVectorCharacters() {}
  
  public DynamicVectorCharacters(DynamicVectorCharacters vDE) {
    super(vDE);
  }
  
  public DynamicVectorCharacters(int size) {
    super(size);
  }
  
  public DynamicVectorCharacters(Character[] v) {
    super((Object[])v);
  }
  
  public Character get(int i) {
    return (Character)super.get(i);
  }
  
  public Character[] vectorNormal() {
    Character[] temp = new Character[length()];
    for (int i = 0; i < temp.length; i++)
      temp[i] = get(i); 
    return temp;
  }
}