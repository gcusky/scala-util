package com.gcusky.util.eval

/**
  * Created by lizhy on 2018/4/17.
  */
trait BinaryOp {
  val op: String
  def apply(p1: String, p2: String): String = p1 + op + p2

  def unapply(str: String): Option[(String, String)] = {
    val index = str indexOf op
    if(index > 0)
      Some(str substring(0, index), str substring(index + 1))
    else None
  }
}

object Add extends {val op = "+"} with BinaryOp
object Subtract extends {val op = "-"} with BinaryOp
object Multiply extends {val op = "*"} with BinaryOp
object Divide extends {val op = "/"} with BinaryOp