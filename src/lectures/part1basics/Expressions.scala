package lectures.part1basics

object Expressions extends App{

  // **********************************************************
  // Examples of expressions
  // **********************************************************
  val x = 1 + 2 // right-hand-side is called an "expression"
  println(x)

  // operators
  // + - * / & | ^ << >> >>>(right shift with zero extension)

  // relational operators
  // == != > >= < <=

  // logical
  // !(not) && ||

  var aVariable = 2
  aVariable += 3 // also works with -= *= /= (only work with mutable (variables)) ... these are all side effects
  println(aVariable)

  // **********************************************************
  // Instructions vs expressions
  // **********************************************************
  // Instruction = do something
  // Expression = give me the value of something


  // Example: IF expression in scala:
  val aCondition = true
  val aConditionedValue = if(aCondition) 5 else 2 // if expression!
  println(aConditionedValue)

  // Loops are discouraged as they are imperative, but they do exist:
  // Please NEVER WRITE THIS AGAIN! This is very specific to imperative
  // programming, e.g. Java, Python, C and friends
  var i = 0
  while (i < 10 ){
    println(i)
    i += 1
  }

  // **********************************************************
  // EVERYTHING in scala is an expression!
  // Side effects in scala are expressions returning Unit.
  // **********************************************************

  // Examples of side effects: println(), whiles, reassigning variables...
  val aWeirdVal = (aVariable = 3) // Unit == void
  println(aWeirdVal)

  // **********************************************************
  // Code blocks
  // Rules:
  // Things inside code blocks are expressions!
  // The value of the block is the value of its last expression
  // Everything declared inside code block stays visible only within the block
  // **********************************************************

  // Example: value of this block is "hello"
  val aCodeBlock = {
    val y = 2
    val z = y + 1
    if (z > 2) "hello" else "goodbye"
  }

  // **********************************************************
  // Exercises
  // **********************************************************
  /*
  1. What is the difference between "hello world" vs println("hello world")?
  ANS: "hello world" is a string of type string while println() is an expression
  with a side effect. So "hello world" is a String, and the println is an unit, with
  the side effect of printing the string "hello world" to the console


  2. What is the value of the following:
    val someValue = {
      2 < 3
    }
  ANS:

  3. What is the value of the following:
    val someOtherValue = {
      if(someValue) 239 else 986
      42
    }
  ANS:

   */





}
