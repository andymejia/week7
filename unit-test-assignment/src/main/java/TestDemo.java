import java.util.Random;

public class TestDemo {

  public int addPositive(int a, int b) {
  if (a <= 0 & b <= 0) {
  throw new IllegalArgumentException("Both parameters must be positive!");
}else {
  int sum = a + b;
  return sum;
}
}
  
  
  int getRandomInt(){
    Random random = new Random();
    return random.nextInt(10) +1;
  }
  
  public int randomNumberSquared() {
   int num = getRandomInt();
   num *= num;
   return num;
  }
  

  
  
}