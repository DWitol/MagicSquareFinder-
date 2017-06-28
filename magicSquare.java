import java.util.*;

public class magicSquare{
  public static ArrayList<Integer> list = new ArrayList<Integer>();
  public static boolean testDone = false;
  public static int squareChecks = 0;

  public static void main(String[]args){
    for(int i = 0; i < 9; i++){list.add(i,0); }

    Integer magicNumber = 45;
    Integer numberToAdd = 750;
    populateList();
    permute(list,0);
    while(!testDone){
      numberToAdd++;
      float start = System.nanoTime();
      addNumbers(8,numberToAdd);
      float time = System.nanoTime() - start;
      System.out.print(numberToAdd + "and took " + time +" nanoSeconds" );
      System.out.println();

      populateList();
      squareChecks = 0;
    }

  }
  public static boolean checkNotSquare(java.util.List<Integer> list){

    Integer testNumber =  list.get(0) +  list.get(1)  +  list.get(2) ;
    if( list.get(3) +  list.get(4) +  list.get(5) != testNumber ) return false; //middle row
    if( list.get(6)  +  list.get(7)  +  list.get(8)  != testNumber ) return false; //bottom row
    if( list.get(0)  +  list.get(3)  +  list.get(6)  != testNumber ) return false; //first collumn
    if( list.get(1)  +  list.get(4)  +  list.get(7)  != testNumber ) return false; //second collumn
    if( list.get(2) +  list.get(5)  +  list.get(8)  != testNumber ) return false; //third collumn
    if( list.get(0)  +  list.get(4)  +  list.get(8)  != testNumber ) return false; //diagle, top left bottom right
    if( list.get(6)  +  list.get(4)  +  list.get(2)  != testNumber ) return false; //diagnal, bottom left top right
    return true;
  }

  public static boolean checkSquare(java.util.List<Integer> list){

    Integer testNumber =  list.get(0)*list.get(0)  +  list.get(1)*list.get(1)  +  list.get(2)*list.get(2) ;
    if( list.get(3)*list.get(3)  +  list.get(4)*list.get(4)  +  list.get(5)*list.get(5)  != testNumber ) return false; //middle row
    if( list.get(6)*list.get(6)  +  list.get(7)*list.get(7)  +  list.get(8)*list.get(8)  != testNumber ) return false; //bottom row
    if( list.get(0)*list.get(0)  +  list.get(3)*list.get(3)  +  list.get(6)*list.get(6)  != testNumber ) return false; //first collumn
    if( list.get(1)*list.get(1)  +  list.get(4)*list.get(4)  +  list.get(7)*list.get(7)  != testNumber ) return false; //second collumn
    if( list.get(2)*list.get(2)  +  list.get(5)*list.get(5)  +  list.get(8)*list.get(8)  != testNumber ) return false; //third collumn
    if( list.get(0)*list.get(0)  +  list.get(4)*list.get(4)  +  list.get(8)*list.get(8)  != testNumber ) return false; //diagle, top left bottom right
    if( list.get(6)*list.get(6)  +  list.get(4)*list.get(4)  +  list.get(2)*list.get(2)  != testNumber ) return false; //diagnal, bottom left top right
    return true;
  }

  public static void populateList(){
    list.set(0,1);
    list.set(1,2);
    list.set(2,3);
    list.set(3,4);
    list.set(4,5);
    list.set(5,6);
    list.set(6,7);
    list.set(7,8);
    list.set(8,9);
  }

  static void permute(java.util.List<Integer> arr, int k){
        for(int i = k; i < arr.size(); i++){
            java.util.Collections.swap(arr, i, k);
            permute(arr, k+1);
            java.util.Collections.swap(arr, k, i);
        }
        if (k == arr.size() -1){
          boolean answer = checkSquare(arr);
          if(answer){
            System.out.println(answer);
            System.out.println(java.util.Arrays.toString(arr.toArray()));
            testDone = true;
            return;
          }
        }

  }

  private static void addNumbers(int subject, int ammountToAdd){
    list.set(subject,list.get(subject)+ammountToAdd);


    permute(list,0);


    if(subject == 0) return;
    int ammountToSendDown = 0;
    while(list.get(subject)-1 > list.get(subject-1)+1){
      list.set(subject,list.get(subject)-1);
      ammountToSendDown++;
      addNumbers(subject-1, ammountToSendDown);
    }
    return;


  }

}
