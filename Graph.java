import java.util.Scanner;
import java.util.ArrayList;
class Graph {
  public static void main(String args[])
  {
    Scanner sc = new Scanner(System.in);
    int a = sc.nextInt();
    ArrayList<ArrayList<Integer>> a1 = new ArrayList<>();
    for(int i=0;i<a;i++){
        a1.add(new ArrayList<Integer>());
    }
    int e = sc.nextInt();
    for(int i=0;i<e;i++){
        int x = sc.nextInt();
        int y = sc.nextInt();
        a1.get(x).add(y);
        a1.get(y).add(x);
        }
    for(int i=0; i<a; i++){
        System.out.println(i + "->");
        for(int j=0; j<a1.get(i).size(); j++){
            System.out.print(a1.get(i).get(j) + " ");
            if(j<a1.get(i).size()){
          	    System.out.print("-> ");
          }
        }
        System.out.println();
    }
    sc.close();
  }
}