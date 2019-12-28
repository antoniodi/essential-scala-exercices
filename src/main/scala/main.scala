import counter.exercise.Counter

object main {

  def main(args: Array[String]): Unit = {
    counterExercise()
  }

  def counterExercise(): Unit = {
    println(new Counter(10).inc().dec().inc().inc().count)
    println(new Counter(10).inc.inc(10).count)
  }

}
