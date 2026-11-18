import java.util.Scanner;

public class firstAndLast{
  public static void main(String[] args){
    Scanner sc = new Scanner(System.in);

    int n = sc.nextInt();
    long num = (long) (Math.abs(n));

    int LastD = (int) num % 10;
    while(num >= 0){
      num /= 10;
    }

    int firstD = (int) num;
    System.out.println("Number: " + n + " | First: " + firstDigit + ", Last: " + lastDigit);
  }
}
