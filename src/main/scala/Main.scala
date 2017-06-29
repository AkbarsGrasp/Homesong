// -*- mode: Scala;-*- 
// Filename:    Main.scala 
// Authors:     luciusmeredith                                                    
// Creation:    Wed Jun  7 19:20:29 2017 
// Copyright:   Not supplied 
// Description: 
// ------------------------------------------------------------------------

package com.akbarsgrasp.homesong

object Main extends App {
  case class UserExit( msg : String ) extends Exception( msg )
  println("Hello, World!")
  @inline def defined(line: String) = {
     line != null && line.nonEmpty
  }
  def processQuery( q : NamedSongT with QuestionT ) : Unit = {
    println( s"""should process ${q} for ${q.songName}""" )
  }
  def processUpdate( q : NamedSongT with AnswerT ) : Unit = {
    println( s"""should process ${q} for ${q.songName}""" )
  }
  def readUserQuery() : Unit = {
    var l = List[Char]()
    println( "What do you want to get?" )
    try {
      Iterator.continually(scala.io.StdIn.readLine).takeWhile(defined(_)).foreach(
        {
          ( l ) => {
            println( s"""Ok, you want to get: ${l.toString}""" )
            l.split( " " ).toList match {
              case "info" :: name :: Nil => processQuery( GetSongInfo( name ) )
              case "motifs" :: name :: Nil => processQuery( GetMotifs( name ) )
              case "composers" :: name :: Nil => processQuery( GetComposers( name ) )
              case "quit" :: Nil => throw new UserExit("user requested exit")
              case _ => throw new Exception( "" )
            }
            println( "What do you want to get?" )
          }
        }
      )
    }
    catch {
      case UserExit( m ) => println( "exiting homesong." )
      case e : Throwable => println( "ill-formated request" )
    }
  }

  def evaluateUserRequest() : Unit = {
    var l = List[Char]()
    println( "What do you want to get?" )
    try {
      Iterator.continually(scala.io.StdIn.readLine).takeWhile(defined(_)).foreach(
        {
          ( l ) => {
            println( s"""Ok, you want to get: ${l.toString}""" )
            l.split( " " ).toList match {
              case "get" :: what => {
                what match {
                  case "info" :: name :: Nil => processQuery( GetSongInfo( name ) )
                  case "motifs" :: name :: Nil => processQuery( GetMotifs( name ) )
                  case "composers" :: name :: Nil => processQuery( GetComposers( name ) )
                  case _ => throw new Exception( "" )
                }
              }
              case "put" :: what => {
                what match {
                  case "info" :: name :: Nil => processUpdate( PutSongInfo( name ) )
                  case "motifs" :: name :: Nil => processUpdate( PutMotifs( name ) )
                  case "composers" :: name :: Nil => processUpdate( PutComposers( name ) )
                  case _ => throw new Exception( "" )
                }
              }
              case "quit" :: Nil => throw new UserExit("user requested exit")
              case _ => throw new Exception( "" )
            }
            println( "What do you want to get?" )
          }
        }
      )
    }
    catch {
      case UserExit( m ) => println( "exiting homesong." )
      case e : Throwable => println( "ill-formated request" )
    }
  }
}
