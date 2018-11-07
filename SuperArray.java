public class SuperArray{
  private String[] data;
  //new edit
  private int size;

  public SuperArray(){
    data = new String[10];
    size = 0;
  }

  public SuperArray(int startingCapacity){
    if(startingCapacity < 0){
      throw new IllegalArgumentException("must be greater than 0");
    }
      size = startingCapacity;
    data = new String[startingCapacity];


  }

  public boolean isEmpty(){
    if (size == 0)
      return true;
    for(int i = 0; i < data.length; i++){
      if(data[i] != null)
        return false;
    }    return true;
  }
  public SuperArray(String[] data, int size){
    this.data = data;
    this.size = size;
  }

  public String get(int index){
    if(index > size || index < 0){
      throw new IndexOutOfBoundsException("IndexOutOfBoundsException");
    }
    if (size == 0)
      return null;
    return data[index];

}

  public boolean contains(String s){
    for(int i = 0;i < data.length; i++){
      if (data[i] == null)
        return false;
      if (data[i].equals(s))
        return true;
    }
    return false;
  }

  public int indexOf(String s){
    for(int i = 0;i < data.length; i++){
      if(data[i] != null){
      if (data[i].equals(s))
        return i;
      }
    } return -1;
 }

 public int lastIndexOf(String s){
   for(int i = data.length - 1; i > -1; i -= 1){
     if(data[i] != null){
     if (data[i].equals(s)){
       return i;
     }
   }
   } return -1;
 }

  public void clear(){
    data = new String[0];
    size = 0;

  }

  public int size(){
    int ans=0;
    for(int i=0;i<data.length;i++)
    {
      if (data[i]!=null)
        ans++;

    }
    return ans;
  }


  private boolean isFull(){
    for(int i = 0; i < data.length; i++){
      if (data[i] == null)
        return false;
    } return true;
  }

  public boolean add(String s){
     if (size == data.length)resize();
     data[size] = s;
     size++;
     return true;
   }
   private void resize(){
     String[] newAr = new String[size * 2 + 1];
     for (int i = 0; i < size; i++){
       newAr[i] = data[i];
     }
     data = newAr;
   }


  public String set(int index, String element){
    if(index >= size || index < 0){
      throw new IndexOutOfBoundsException("index out of bounds");
    }
    String a = data[index];
    data[index] = element;
    return a;
  }

  public String toStringDebug(){
    if (data == null)
      return null;
    if (size == 0){
      return "[]";
    }
    String ans = "[";
    for(int i = 0; i < data.length; i++){
      if (data[i] == null && i < size - 1)
        ans += "null, ";
      if (i == size - 1)
        return ans + data[i] + "]";
      ans += (data[i] + ", ");
    } return "Failed";
  }

  public String toString(){
    if (size == 0 || data[0] == null)
      return "[]";
    String ans = "[";
    for(int i = 0; i < size; i++){
      if(data[i] == null && i < size - 1){

      } else {
        if(i == size - 1 && data[i] == null)
          return ans + "]";
        if (i == size - 1 && data[i] != null)
        return ans + data[i] + "]";
      ans += (data[i] + ", ");
    }
    } return "Failed";
  }

  public void add(int index, String element){
    String[] listafter=new String[size];

    if (index < 0 || index > size)
    {
      throw new IndexOutOfBoundsException();
    }  else {
      if(size==data.length)
      { resize();
      }
      for(int i=size;i>index;i-=1)
      {
        data[i]=data[i-1];
      }
      data[index]=element;
      size++;
    }

  }
public String remove( int index){
    if (index < 0 || index > size())
    throw new IndexOutOfBoundsException( index + "not in range");
    String output = "";
    if ( !(index < 0 || index > size())) {
      String[] ans = new String[data.length];
      for( int x = 0; x < index; x++) {
        ans[x] = data[x];
      }
      output = data[index];
      size--;
      for ( int x = index; x < size; x++){
        ans[x] = data[x+1];
      }
      data = ans;
    }
    return output;
  }




  public boolean remove(String element){
    if (this.contains(element)){
    String a = remove(this.indexOf(element));
    return true;
  }
  return false;
  }
}
