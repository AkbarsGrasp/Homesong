object Main extends App {
  println("Hello, World!")
  @inline def defined(line: String) = {
     line != null && line.nonEmpty
  }
  def readUserQuery() : Unit = {
   //Iterator.continually(scala.io.StdIn.readLine).takeWhile(defined(_)).foreach(c => println(c))
   while(ok) {
     val c = readChar()
      ok = c != -1
      if (ok) print(c)
   }
 }
}