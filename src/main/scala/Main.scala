package com.akbarsgrasp.homesong
object Main extends App {
  println("Hello, World!")
  @inline def defined(line: String) = {
     line != null && line.nonEmpty
  }
  def processCmd( q : QuestionT ) : Unit = {
    println( s"""should process q for ${q.songName}""" )
  }
  def readUserQuery() : Unit = {
    var l = List[Char]()
    var ok = true        
    // while(ok) {
    //   val c = readChar()
    //   ok = (c != -1)
    //   if (ok) {
    //     l = l ++ List[Char]( c )
    //     print(c)
    //   }
    // }
    println( "What do you want to get?" )
    Iterator.continually(scala.io.StdIn.readLine).takeWhile(defined(_)).foreach(
      {
        ( l ) => {
          println( s"""Ok, you want to get: ${l.toString}""" )
          try { 
            val cmd :: name :: Nil = l.split( " " ).toList
            cmd match {
              case "info" => processCmd( GetSongInfo( name ) )
              case "motifs" => processCmd( GetMotifs( name ) )
              case "composers" => processCmd( GetComposers( name ) )
              case _ => throw new Exception( "" )
            }
          }
          catch {
            case e : Throwable => println( "ill-formated request" )
          }
          println( "What do you want to get?" )
        }
      }
    )    
  }
}
