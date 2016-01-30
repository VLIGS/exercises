
object Animals {

  def main(args: Array[String]): Unit = {
    val hip: Hippo = new Hippo
    println(hip.toString())
    val leo: Lion = new Lion
    println(leo.toString())
    val tigr: Tiger = new Tiger
    println(tigr.toString())
    val samuel: Monkey = new Monkey
    println(samuel.toString())
    val nick: Giraffe = new Giraffe
    println(nick.toString())
    val leopold:Lion = new Lion
    println(leopold.toString())
    val nicky:Giraffe = new Giraffe
    println(nicky.toString())
    val nicolas:Giraffe = new Giraffe
    println(nicolas.toString())
  }

  class Hippo() {
    private val look = "big and grey"
    override def toString(): String = {
      return "I am " + this.getClass.getSimpleName + ", I am " + look
    }
  }

  class Lion() {
    private val look = "scary and proud"
    override def toString(): String = {
      return "I am " + this.getClass.getSimpleName + ", I am " + look
    }
  }
  class Tiger() {
    private val look = "stripy and fast"
    override def toString(): String = {
      return "I am " + this.getClass.getSimpleName + ", I am " + look
    }
  }
  class Monkey() {
    private val look = "cheeky and silly"
    override def toString(): String = {
      return "I am " + this.getClass.getSimpleName + ", I am " + look
    }
  }

  class Giraffe() {
    private val look = "necky and kind"
    override def toString(): String = {
      return "I am " + this.getClass.getSimpleName + ", I am " + look
    }
  }

}
