import java.util.*;
public class Monitor{
  Random randomGenerator = new Random();
  private int score;
  private int penalties;
  private boolean flag = true;
  private String homeKeys = "asdfjkl;";
  private ArrayList<Character> stringBuffer = new ArrayList<Character>();

  private int time = 1000;

  public int getTime(){
    return time;
  }

  synchronized public void tick() throws InterruptedException{
    int randomInt = randomGenerator.nextInt(7)+1;
    char result = homeKeys.charAt(randomInt);
    stringBuffer.add(result);
    System.out.print(result);

  }

  synchronized public void filter(char c) throws InterruptedException{
   Iterator<Character> iterator = stringBuffer.iterator();
   while(iterator.hasNext()) {
    char value = iterator.next();
    if (c == value){
      iterator.remove();
      score++;
      clear((stringBuffer.size()+1));
      if (time != 20){
        time = time - 20;
      }
    } else {
      penalties++;
    }
   }
  }

  synchronized public boolean gameOn() throws InterruptedException{
    if (stringBuffer.size() >= 10){
      flag = false;
      return flag;
    }
    return flag;
  }

  public int getScore(){
    return score;
  }
  public int getPenalty(){
    return penalties;
  }

  synchronized public void clear(int n) throws InterruptedException{
    int i;
    for (i = 0; i < n; i++) {System.out.print("\b");}
    for (i = 0; i < n; i++) {System.out.print(" ");}
    for (i = 0; i < n; i++) {System.out.print("\b");}
    for (char x : stringBuffer){
      System.out.print(x);
    }
  }

}