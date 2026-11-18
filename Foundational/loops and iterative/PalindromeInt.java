import java.util.Scanner;

public class PalindromeInt{
  public static void main(String[] args){
    int n = sc.nextInt();

    boolean isPali;
    if(n < 0 || (n % 10 == 0 && n!=0)){
      return false;
    }else{
      int x = n;
      int reversed = 0;
      while( x > reversed){
        reversed = reversed * 10 + ( x % 10);
        x /= 10;
      }
      isPali = (x == reversed) || (x == reversed /10);
    }
    System.out.println(n + (isPali ? " is a Palindrome" : " is NOT a Palindrome"));
    }
}
