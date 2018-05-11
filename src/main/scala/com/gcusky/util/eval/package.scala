package com.gcusky.util

/**
  * Created by lizhy on 2018/4/17.
  */
package object eval {
  def eval(str: String): Int = str match {
    case Add(p1, p2) => eval(p1) + eval(p2)
    case Subtract(p1, p2) => eval(p1) - eval(p2)
    case Multiply(p1, p2) => eval(p1) * eval(p2)
    case Divide(p1, p2) => eval(p1) / eval(p2)
    case _ => str toInt
  }

}
