public class SuperArray{
  private String[] data;
  //new edit
  private int size;

  public SuperArray(){
    data = new String[10];
    size = 10;
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
    return size;
  }

  private boolean isFull(){
    for(int i = 0; i < data.length; i++){
      if (data[i] == null)
        return false;
    } return true;
  }

  private void resize(){
    if (size == 0){
      size += 1;
      data = new String[1];
    }
    size = 2 * size + 1;
    String[] ans  = new String[size];

    for(int i = 0; i < data.length; i++){
      ans[i] = data[i];
    }
    data = ans;
  }

  public boolean add(String s){
    this.resize();

    if (this.isFull())
      return false;

    for(int i = 0; i < size; i++){
      if (data[i] == null){
        data[i] = s;
        return true;
      }
    } return false;

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

  public void add(int index, String s){
    if(index >= size || index < 0){
      throw new IndexOutOfBoundsException("index too large for array");
    }
    size += 1;
    String[] ans = new String[size];
    for(int i = 0; i < size; i++){
      if(i < index)
        ans[i] = data[i];
      if(i == index)
        ans[i] = s;
      if (i > index)
        ans[i] = data[i - 1];
      if (i == size - 1)
        data = ans;

    }
}

  public String remove(int index){
    if (index >= size || index < 0){
      throw new IndexOutOfBoundsException("Argument out of bounds");
    }
    size += -1;
    String a = "";
    String ans[] = new String[size];
    for(int i = 0; i < size; i++){
      if(i < index)
        ans[i] = data[i];
      if(i == index)
        a = data[i];
        ans[i] = data[i + 1];
      if(i > index)
          ans[i] = data[i + 1];
    } data = ans;
    return a;
  }



  public boolean remove(String element){
    if (this.contains(element)){
    String a = remove(this.indexOf(element));
    return true;
  }
  return false;
  }
}
