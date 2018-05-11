object C {
  object A
  object X
}
class D

C.getClass.getDeclaredFields

C.getClass.getSimpleName

val d = new D

d.getClass.getSimpleName

// C.A.getClass.getField("MODULE$")

////////////////////////////

trait G

object G1 extends G

G1.getClass.getField("MODULE$").get(null).asInstanceOf[G1.type]
