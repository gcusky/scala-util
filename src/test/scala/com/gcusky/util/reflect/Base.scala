package com.gcusky.util.reflect

import org.reflections.Reflections

import scala.collection.JavaConverters._
/**
  * Created by lizhy on 2018/4/16.
  */
trait Base {
  val x: Int
}

object A extends Base {
  override val x: Int = 1
}
object B extends Base {
  override val x: Int = 2
}
object C extends Base {
  override val x: Int = 3
}

//class D extends Base {
//  override val x: Int = 0
//}

object Base extends App {
  val sub2 = subObject(classOf[Base]).map(_.x)
  println(sub2)


  def subObject[T](underlying: Class[T]): Seq[T] = {
    val reflects = new Reflections("com.gcusky.util.reflect")
    val subType  = reflects.getSubTypesOf(underlying).asScala // 获取所有继承Base的子类类型
    subType.map { sub =>
      sub.getField("MODULE$").get(null).asInstanceOf[T] // 获取单例对象实例
    }.toSeq
  }
}