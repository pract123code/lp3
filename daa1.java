import java.util.*;

import java.util.Scanner;

public class fibo{
  public static void main(String[] args){
    Scanner sc=new Scanner(System.in);
    int steps=0;
    System.out.println("enter the number of ste
                       ps:");
    int n=sc.nextInt();
    int a=0;
    int  b=1;
    System.out.println("fibo series:");
    for(int i=0;i<n; i++){
      System.out.print(a+" ");
      int c=a+b;
      a=b;
      b=c;
      steps++;

    }
    System.out.print("steps count:"+steps);
    
      }
}
