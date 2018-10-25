public class SuperArray{
  private String[] data;
  private int size;

  public SuperArray(){
    data = null;
    size = 0;
  }

  public SuperArray(String[] data, int size){
    this.data = data;
    this.size = size;
  }

  public String get(int index){
    return data[index];
  }

  public boolean contains(String s){
    for(int i = 0;i < data.length; i++){
      if (data[i].equals(s));
        return true;
    }
    return false;
  }

  public int indexOf(String s){
    for(int i = 0;i < data.length; i++){
      if (data[i].equals(s))
        return i;
    } return -1;
 }

 public int lastIndexOf(String s){
   for(int i = data.length - 1; i > -1; i ++){
     if (data[i].equals(s)){
       return i;
     }
   } return -1;
 }

  public void clear(){
    data = new String[0];
  }

  public int size(){
    return size;
  }

  public boolean add(String s){
    String[] ans = new String[size + 1];
    for (int i = 0; i <= data.length; i++){
      if (i == data.length){
        ans[i] = s;
        size += 1;
        return true;
      }
      ans[i] = data[i];
    } return false;

  }

  public String set(int index, String element){
    String a = data[index];
    data[index] = element;
    return a;
  }

public String toStringDebug(){
    if (data == null)
      return "null";
    String ans = "[";
    for(int i = 0; i <= data.length; i++){
      if (i == data.length)
        return ans + data[i] + "]";
      ans += data[i];
    } return "Failed";
  }

  public String toString(){
    if (size == 0 || data[0] == null)
      return "[]";
    String ans = "[";
    for(int i = 0; i <= data.length; i++){
      if (i == data.length)
        return ans + data[i] + "]";
      if (data[i] == null)
        return ans;
      ans += data[i];
    } return "Failed";
  }

  public void add(int index, String s){
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
