package com.gcusky.util.tets

import org.reflections.Reflections
import scala.collection.JavaConverters._

/**
  * Created by lizhy on 2018/5/2.
  */
object Demo extends App {
  val ru = scala.reflect.runtime.universe
  val mo = ru.typeOf[Demo].typeSymbol.asClass.knownDirectSubclasses
//
//  val mirror = ru.runtimeMirror(getClass.getClassLoader)
//  // mo.foreach(f => mirror.reflectModule(f.asModule).instance.asInstanceOf[f.NameType])
//  val yu = mo.map(_.fullName).map(mirror.classLoader.loadClass).map(sub => sub.getField("MODULE$").get(null).asInstanceOf[])

//  println(mo)

  def subObject1[T](underlying: Class[T]): Seq[T] = {
    val ru        = scala.reflect.runtime.universe
    val mirror    = ru.runtimeMirror(getClass.getClassLoader)
    val subSymbol = ru.typeOf[Demo].typeSymbol.asClass.knownDirectSubclasses
    val subClass  = subSymbol.map(f => mirror.classLoader.loadClass(f.fullName + "$"))
    subClass.map(sub => sub.getField("MODULE$").get(null).asInstanceOf[T]).toSeq
  }
//  def subObject[T](underlying: Class[T]): Seq[T] = {
//    val reflects = new Reflections("com.gcusky.util.tets")
//    reflects.getSubTypesOf(underlying).asScala.map { sub =>
//      sub.getField("MODULE$").get(null).asInstanceOf[T]
//    }.toSeq
//  }
  val heirenwenhao = scala.reflect.runtime.universe.typeOf[Demo].typeSymbol.asClass.knownDirectSubclasses

  val test1 = subObject1(classOf[Demo]).map(_.x)
//  val test2 = subObject1(classOf[Demo]).map(_.x)

  print(test1)
}

sealed trait Demo {
  val x: Int
}

object A extends Demo {
  override val x: Int = 1

}

object B extends Demo {
  override val x: Int = 2
}

object C extends Demo {
  override val x: Int = 3
}
