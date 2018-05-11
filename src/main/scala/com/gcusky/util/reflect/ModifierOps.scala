package com.gcusky.util.reflect

import java.lang.reflect.Modifier

/**
  * Created by lizhy on 2018/4/18.
  */
case class ModifierOps(mod: Int) extends AnyVal {
  def isAbstract: Boolean = Modifier.isAbstract(mod)
}