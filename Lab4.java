public class Lab4
{
  public static void turnRight()
  {
    Robot.turnLeft();
    Robot.turnLeft();
    Robot.turnLeft();
  }
  
  public static void turnAround()
  {
    Robot.turnLeft();
    Robot.turnLeft();
  }

  public static void backUp()
  {
    turnAround();
    Robot.move();
    turnAround();
  }
  
  public static void completeBars()
  {
    while(Robot.frontIsClear())
    {
    completeBar();
    }
    fillBar();
  }
  
  public static void testCompleteBars1()
  {
    Robot.load("bars1.txt");
    Robot.setDelay(0.025);
    completeBars();
  }
  
  public static void testCompleteBars2()
  {
    Robot.load("bars2.txt");
    Robot.setDelay(0.025);
    completeBars();
  }
  
  public static void combinePiles()
  {
    while(Robot.onDark())
    {
    Robot.makeLight();
    turnRight();
    Robot.move();
    Robot.turnLeft();
    darkenFirstSquare();
    backToStart();
    while(!Robot.onDark() && Robot.frontIsClear())
    {
    Robot.move();
    }
  }
  }

  public static void testCombinePiles1()
  {
    Robot.load("piles1.txt");
    Robot.setDelay(0.025);
    combinePiles();
  }
  
  public static void testCombinePiles2()
  {
    Robot.load("piles2.txt");
    Robot.setDelay(0.025);
    combinePiles();
  }
  
  public static void connectDots()
  {
    checkCardinals();
    while (checkCardinals())
    {
    checkCardinals();
    }
  }
  
  public static void testConnectDots1()
  {
    Robot.load("connect1.txt");
    Robot.setDelay(0.025);
    connectDots();
  }
  
  public static void testConnectDots2()
  {
    Robot.load("connect2.txt");
    Robot.setDelay(0.025);
    connectDots();
  }
  //pre: a bar hasn't been filled
  //post: the bar has been filled and the robot is prepped for the next one
  public static void completeBar()
  {
    fillBar();
    Robot.turnLeft();
    Robot.move();
    }
  //pre: the bar hasn't been filled
  //post: the bar has been filled
  public static void fillBar()
  {
    Robot.turnLeft();
    while (!Robot.onDark())
    {
    Robot.makeDark();
    Robot.move();
    }
    turnAround();
    while(Robot.frontIsClear())
    {
    Robot.move();
    }
    }
  //pre: the first potential square hasn't been darkened
  //post: the first potential square has been darkened
  public static void darkenFirstSquare()
  {
    while (Robot.onDark())
    {
    Robot.move();
    }
    Robot.makeDark();
    }
  //pre: robot is not back to starting position
  //post: robot is back to starting position
  public static void backToStart()
  {
    turnAround();
    while(Robot.frontIsClear())
    {
    Robot.move();
    }
    turnRight();
    Robot.move();
    turnRight();
    }
  public static boolean checkCardinals()
  {
    Robot.turnLeft();
    checkRow();
    if (checkRow())
    {
    darkenAndMove();
    return true;
    }
    else
    {
    turnRight();
    checkRow();
    if (checkRow())
    {
    darkenAndMove();
    return true;
    }
    else
    {
    turnRight();
    checkRow();
    if(checkRow())
    {
    darkenAndMove();
    return true;
    }
    else
    {
    return false;
    }
    }
    }
    }
  //pre: robot has finished the second stage of checking a certain direction.
  //post: the robot is on the first stage of checking another direction.
  public static void turnAndGo()
  {
    Robot.move();
    Robot.turnLeft();
    Robot.move();
    Robot.move();
    }
  //pre: the robot has finished the first stage of checking a direction
  //post: the robot is on the second stage of checking that direction
  public static void goBackOne()
  {
    turnAround();
    Robot.move();
}

  public static boolean checkRow()
  {
    Robot.move();
    Robot.move();
    if (Robot.onDark())
    {
    goBackOne();
    if(Robot.onDark())
    {
    return false;
    }
    else
    {
    Robot.move();
    turnAround();
    return true;
    }
    }
    else
    {
    turnAround();
    Robot.move();
    Robot.move();
    return false;
    }
    }
  //pre: the square in front of the robot is light
  //post: the square now behind the robot is dark
  public static void darkenAndMove()
  {
    Robot.move();
    Robot.makeDark();
    Robot.move();
    }
}
