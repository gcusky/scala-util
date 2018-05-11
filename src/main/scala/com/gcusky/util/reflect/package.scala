package com.gcusky.util

import org.reflections.Reflections

/**
  * Created by lizhy on 2018/4/18.
  */
package object reflect {
  val reflection = new Reflections("com.gcusky.util.reflect")

  implicit def toClassOps[T1](clazz: Class[T1]): ClassOps[T1] = ClassOps(clazz) // clazz 类类型
  implicit def toModifierOps(mod: Int): ModifierOps = ModifierOps(mod)
}
