
object Boats {
  def main(args: Array[String]): Unit = {

    val sailboat = new Sailboat
    val r1 = sailboat.raise()
    assert(r1 == "Sails raised", "Expected Sails raised, Got " + r1)

    val r2 = sailboat.lower()
    assert(r2 == "Sails lowered", "Expected Sails lowered, Got " + r2)

    val motorboat = new Motorboat
    val s1 = motorboat.on()
    assert(s1 == "Motor on", "Expected Motor on, Got " + s1)
    val s2 = motorboat.off()
    assert(s2 == "Motor off", "Expected Motor off, Got " + s2)

    val flare = new Flare
    val f1 = flare.light
    assert(f1 == "Flare used!", "Expected Flare used!, Got " + f1)

    val sailboat2 = new Sailboat
    val signal = sailboat2.signal()
    assert(signal == "Flare used!", "Expected Flare used! Got " + signal)

    val motorboat2 = new Motorboat
    val flare2 = motorboat2.signal()
    assert(flare2 == "Flare used!", "Expected Flare used!, Got " + flare2)

  }
  class Sailboat() {
    def raise(): String = {
      "Sails raised"
    }
    def lower(): String = {
      "Sails lowered"
    }
    def signal(): String = {
      val flare:Flare = new Flare
      flare.light();
    }
  }

  class Motorboat() {
    def on(): String = {
      "Motor on"
    }
    def off(): String = {
      "Motor off"
    }
    def signal(): String = {
      val flare:Flare = new Flare
      flare.light();
    }
  }

  class Flare() {
    def light(): String = {
      "Flare used!"
    }
  }


}
