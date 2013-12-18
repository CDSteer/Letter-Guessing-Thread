import java.util.Random;

public class Main {
  static Monitor monitor = new Monitor();
  static Random randomGenerator = new Random();
  static String letters = "asdfjkl;";
  static int time = 1000;

  public static void main(String args[]) throws InterruptedException{


    Thread generator = new Thread(new Runnable() {
    public void run() {
      try{
        while (monitor.gameOn()) {
          Thread.sleep(monitor.getTime());
          monitor.tick();
        }
      } catch (InterruptedException e){}
    }});

    Thread guesser = new Thread(new Runnable() {
    public void run() {
      try{
        while (monitor.gameOn()) {
          Thread.sleep(100);
          int randomInt = randomGenerator.nextInt(7)+1;
          char result = letters.charAt(randomInt);
          monitor.filter(result);
        }
      } catch (InterruptedException e){}
    }});

    System.out.println("Start Game: \n");

    generator.start();
    guesser.start();

    guesser.join();
    generator.join();

    System.out.println("\n");
    System.out.println("Game Over");
    System.out.println("Successes: " + monitor.getScore());
    System.out.println("Failures: " + monitor.getPenalty());
    System.out.println("Score: " + ((monitor.getScore()*10) - monitor.getPenalty()));


      }
}