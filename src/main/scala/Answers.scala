// -*- mode: Scala;-*- 
// Filename:    Answers.scala 
// Authors:     luciusmeredith                                                  
// Creation:    Wed Jun  7 18:44:54 2017 
// Copyright:   Not supplied 
// Description: 
// ------------------------------------------------------------------------

package com.akbarsgrasp.homesong

trait AnswerT {
  def songName : String = ""
}

case class PutSongInfo( override val songName : String ) extends AnswerT
case class PutMotifs( override val songName : String ) extends AnswerT
case class PutComposers( override val songName : String ) extends AnswerT
case class PutBPM( override val songName : String ) extends AnswerT
case class PutLink( override val songName : String ) extends AnswerT
case class PutTimesignature( override val songName : String ) extends AnswerT

