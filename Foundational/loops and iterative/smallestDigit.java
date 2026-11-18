public class MinMax{
  public static void main(String[] args){
    Scanner sc = new Scanner(System.in);

    int n = sc.nextInt();
    long num = Math.abs((long) n);

    int minDigit = 9;
    int maxDigit = 0;

    do{
      int digit = (int) (num % 10);
      if(digit > maxDigit) maxDigit = digit;
      if(digit < maxDigit) minDigit = digit;
      num /= 10;
    }while(n > 0);

    System.out.println("Number" + n + "max" + maxDigit + "min" + minDigit);
  }
}
      
