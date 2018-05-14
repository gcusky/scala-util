package com.gcusky.util.reflect

/**
  * Created by lizhy on 2018/5/11.
  */
object runtimeReflect extends App {
  val ru = scala.reflect.runtime.universe // 运行时 universe
  val m  = ru.runtimeMirror(getClass.getClassLoader) // 运行时 mirror，调用者镜像入口

  val im      = m.reflect(new Ta) // 创建调用者实例镜像
  val methodX = ru.typeOf[Ta].decl(ru.TermName("x")).asMethod // 创建方法符号
  val mm      = im.reflectMethod(methodX) // 创建方法镜像
  println("调用者实例镜像调用方法镜像：" + mm()) // 调用者实例镜像调用方法镜像
  val filedY = ru.typeOf[Ta].decl(ru.TermName("y")).asTerm.accessed.asTerm // 创建字段符号
  val fmY    = im.reflectField(filedY) // 创建字段镜像
  println("调用者实例镜像调用字段镜像：" + fmY.get) // 调用者实例镜像调用字段镜像
  fmY.set(5)
  println("字段镜像修改字段：" + fmY.get)

  val classTb = ru.typeOf[Tb].typeSymbol.asClass // 创建调用者类符号
  val cm      = m.reflectClass(classTb) // 创建调用者类镜像
  val ctorTb  = ru.typeOf[Tb].decl(ru.termNames.CONSTRUCTOR).asMethod // 创建构造函数方法符号
  val ctorTbC = cm.reflectConstructor(ctorTb) // 创建构造函数方法镜像
  println("调用者类镜像调用构造函数方法镜像：" + ctorTbC(2)) // 调用者类镜像调用构造函数方法镜像

  val objectTc = ru.typeOf[Tc.type].termSymbol.asModule // 创建调用者对象符号
  val mm1      = m.reflectModule(objectTc) // 创建调用者对象镜像
  val obj      = mm1.instance.asInstanceOf[Tc.type] // 获得对象实例
  println("对象镜像获得对象实例并输出内部字段：" + obj.x)
}
class Ta { def x = 2; val y = 2 }
case class Tb(x: Int)
object Tc { def x = 2 }
