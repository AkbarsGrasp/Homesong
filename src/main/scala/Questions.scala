// -*- mode: Scala;-*- 
// Filename:    Questions.scala 
// Authors:     luciusmeredith                                                  
// Creation:    Wed Jun  7 18:44:54 2017 
// Copyright:   Not supplied 
// Description: 
// ------------------------------------------------------------------------

package com.akbarsgrasp.homesong

trait QuestionT

case class GetSongInfo( override val songName : String ) extends NamedSongT with QuestionT
case class GetMotifs( override val songName : String ) extends NamedSongT with QuestionT
case class GetComposers( override val songName : String ) extends NamedSongT with QuestionT
case class GetBPM( override val songName : String ) extends NamedSongT with QuestionT
case class GetLink( override val songName : String ) extends NamedSongT with QuestionT
case class GetTimesignature( override val songName : String ) extends NamedSongT with QuestionT

