import java.util.Scanner;

public class Main{
  public static void main(String[] args){
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    long n = Math.abs((long) n);

    int even = 0;
    int odd = 0;
    
    if(n == 0){
      even = 0;
    }

    do{
      int digit = (int) n % 10;
      if(digit % 2 == 0){
        even++;
      }else{
        odd++;
      }
    }while(n > 0);

    System.out.println("Number" + n + "evenC" + even + "oddC" + odd);
  }
}
      
      

    
