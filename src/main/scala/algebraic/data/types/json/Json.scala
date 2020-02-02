package algebraic.data.types.json
trait Json
{
  def print: String = {
    this match {
      case JsNumber(value) => value.toString
      case JsString(value) => quote(value)
      case JsBoolean(value) => value.toString
      case JsNull => "null"
      case ObjectEnd => "{}"
      case objectCell @ ObjectCell(_, _, _) => s"{${objectToJson(objectCell)}}"
      case SeqEnd => "[]"
      case seqCell @ SeqCell(_, _) => s"[${seqToJson(seqCell)}]"
    }
  }

  def quote(s: String): String =
    '"'.toString ++ s ++ '"'.toString

  def seqToJson(seq: SeqCell): String =
    seq match {
      case SeqCell(h, t @ SeqCell(_, _)) =>
        s"${h.print}, ${seqToJson(t)}"
      case SeqCell(h, SeqEnd) => h.print
    }

  def objectToJson(obj: ObjectCell): String =
    obj match {
      case ObjectCell(k, v, t @ ObjectCell(_, _, _)) =>
        s"${quote(k)}: ${v.print}, ${objectToJson(t)}"
      case ObjectCell(k, v, ObjectEnd) =>
        s"${quote(k)}: ${v.print}"
    }
}

case class JsNumber(value: Double) extends Json
case class JsString(value: String) extends Json
case class JsBoolean(value: Boolean) extends Json
case object JsNull extends Json

trait JsSequence extends Json
case class SeqCell(head: Json, tail: JsSequence) extends JsSequence
case object SeqEnd extends JsSequence

trait JsObject extends Json
case class ObjectCell(key: String, value: Json, tail: JsObject) extends JsObject
case object ObjectEnd extends JsObject

case object main {
  def main(args: Array[String]): Unit = {
    val json = SeqCell(JsNumber( 1 ), SeqCell( JsNumber( 2 ), SeqCell( JsNumber( 3 ), SeqCell( JsNumber( 4 ), SeqEnd ) ) ) )
    println(json.print)

    val json2 = ObjectCell(
      "a", SeqCell(JsNumber(1.0), SeqCell(JsNumber(2.0), SeqCell(JsNumber(3.0), SeqEnd))),
      ObjectCell(
        "b", SeqCell(JsString("a"), SeqCell(JsString("b"), SeqCell(JsString("c"), SeqEnd))),
        ObjectCell(
          "c", ObjectCell("doh", JsBoolean(true),
            ObjectCell("ray", JsBoolean(false),
              ObjectCell("me", JsNumber(1.0), ObjectEnd))),
          ObjectEnd
        )
      )
    )
    println(json2.print)
  }
}

