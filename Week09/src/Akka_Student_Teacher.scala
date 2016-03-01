package Akka


import akka.actor._


//import me.rerun.akkanotes.messaging.protocols.TeacherProtocol._

/*
 * Your Teacher Actor class.
 *
 * The class could use refinement by way of
 * using ActorLogging which uses the EventBus of the Actor framework
 * instead of the plain old System out
 *
 */

//object TeacherProtocol{

case class QuoteRequest()
case class QuoteResponse(quoteString:String)

//}

class TeacherLogActor extends Actor with ActorLogging {

  val quotes = List(
    "Moderation is for cowards",
    "Anything worth doing is worth overdoing",
    "The trouble is you think you have time",
    "You never gonna know if you never even try")

  def receive = {

    case QuoteRequest => {

      import util.Random

      //get a random element (for now)
      val quoteResponse=QuoteResponse(quotes(Random.nextInt(quotes.size)))
      log.info(quoteResponse.toString())
    }
  }

  //We'll cover the purpose of this method in the Testing section
  def quoteList=quotes

}

object StudentSimulatorApp extends App{

  //Initialize the ActorSystem
  val actorSystem=ActorSystem("UniversityMessageSystem")

  //construct the Teacher Actor Ref
  val teacherActorRef=actorSystem.actorOf(Props[TeacherLogActor])

  //send a message to the Teacher Actor
  teacherActorRef!QuoteRequest

  //Let's wait for a couple of seconds before we shut down the system
  Thread.sleep (2000)

  //Shut down the ActorSystem.
  actorSystem.shutdown()

}


