package jeroquest.utils;

import jeroquest.boardgame.Position;

public class DynamicVectorPosition extends DynamicVectorObjects {
  public DynamicVectorPosition() {}
  
  public DynamicVectorPosition(DynamicVectorPosition vDE) {
    super(vDE);
  }
  
  public DynamicVectorPosition(int size) {
    super(size);
  }
  
  public DynamicVectorPosition(Integer[] v) {
    super((Object[])v);
  }
  
  public Position get(int i) {
    return (Position)super.get(i);
  }
  
  public Position[] vectorNormal() {
    Position[] temp = new Position[length()];
    for (int i = 0; i < temp.length; i++)
      temp[i] = get(i); 
    return temp;
  }
}
