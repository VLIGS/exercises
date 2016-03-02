package RequestAndResponse
import akka.actor._

case class InitSignal()
case class QuoteRequest()
case class QuoteResponse(quoteString:String)

class TeacherActor extends Actor with ActorLogging {

  val quotes = List(
    "Moderation is for cowards",
    "Anything worth doing is worth overdoing",
    "The trouble is you think you have time",
    "You never gonna know if you never even try")

  def receive = {

    case QuoteRequest => {

      import util.Random

      //Get a random Quote from the list and construct a response
      val quoteResponse = QuoteResponse(quotes(Random.nextInt(quotes.size)))

      //respond back to the Student who is the original sender of QuoteRequest
      sender ! quoteResponse

    }
  }
}


class StudentActor (teacherActorRef:ActorRef) extends Actor with ActorLogging {

  def receive = {
    case InitSignal=> {
      teacherActorRef!QuoteRequest
    }

    case QuoteResponse(quoteString) => {
      log.info ("Received QuoteResponse from Teacher")
      log.info(s"Printing from Student Actor $quoteString")
    }
  }
}

object DriverApp extends App {

  //Initialize the ActorSystem
  val system = ActorSystem("UniversityMessageSystem")

  //construct the teacher actor
  val teacherRef = system.actorOf(Props[TeacherActor], "teacherActor")

  //construct the Student Actor - pass the teacher actorref as a constructor parameter to StudentActor
  val studentRef = system.actorOf(Props(new StudentActor(teacherRef)), "studentActor")

  //send a message to the Student Actor
  studentRef ! InitSignal

  //Let's wait for a couple of seconds before we shut down the system
  Thread.sleep(2000)

  //Shut down the ActorSystem.
  system.shutdown()

}