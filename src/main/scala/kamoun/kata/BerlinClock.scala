package kamoun.kata

/**
  * @author KAMOUN Ahmed
  */
object BerlinClock {

  def convertToBerlinTime(times: String): Array[String] = {
    val parts = times.split(':') map (_.toInt)

    Array(
      seconds(parts(2)),
      topHours(parts(0)),
      bottomHours(parts(0)),
      topMinutes(parts(1)),
      bottomMinutes(parts(1))
    )
  }


  def bottomMinutes(minutes: Int): String = display(4, minutes % 5, "Y")

  def topMinutes(minutes: Int): String = display(11, minutes / 5, "Y").replaceAll("YYY", "YYR")

  def topHours(hours: Int): String = display(4, hours / 5, "R")

  def bottomHours(hours: Int): String = display(4, hours % 5, "R")

  def seconds(seconds: Int): String = {
    if (seconds % 2 == 0) "Y" else "O"
  }

  private def display(totalLamps: Int, lightedLamps: Int, charColor: String): String = {
    charColor * lightedLamps + "O" * (totalLamps - lightedLamps)
  }
}
