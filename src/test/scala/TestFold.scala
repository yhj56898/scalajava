import scala.collection.mutable.ListBuffer

/**
  * @author hejin-Yu
  *
  * fold函数，将一种格式的数据，转为另外一种格式的数据
  **/
object TestFold {

  def main(args: Array[String]) {

    val numbers = List(5, 4, 8, 6, 2)

/*
    val rs =numbers.fold(0)({
      (o,i) =>{
        o + i
      }
    })

    println(rs)
*/

    val fooList = Foo("Hugh Jass", 25, 'male) ::
      Foo("Biggus Dickus", 43, 'male) ::
      Foo("Incontinentia Buttocks", 37, 'female) ::
      Nil

    /*------想将上面的list转换成一个存储[title] [name], [age]格式的String链表-------*/


    val stringList =fooList.foldLeft(List[String]())({
      (z,i)=>{
        val title = i.sex match {
          case 'male => "Mr."
          case 'female => "Ms."
        }

        z :+ s"${title} ${i.name} ${i.age}"
      }
    })


    stringList.foreach(println(_))

  }




}
class Foo(val name: String, val age: Int, val sex: Symbol)

object Foo {
  def apply(name: String, age: Int, sex: Symbol) = new Foo(name, age, sex)
}
