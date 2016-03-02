package ActorLifeCycle

import akka.actor._
import akka.event.LoggingReceive

class BasicLifecycleLoggingActor extends Actor with ActorLogging{

  log.info ("Inside BasicLifecycleLoggingActor Constructor")
  log.info (context.self.toString())
  override def preStart() ={
    log.info("Inside the preStart method of BasicLifecycleLoggingActor")
  }

  def receive = LoggingReceive{
    case "hello" => log.info ("hello")
    case "stop" => context.stop(self)
  }

  override def postStop()={
    log.info ("Inside postStop method of BasicLifecycleLoggingActor")
  }

}

object LifecycleApp extends App{

  val actorSystem=ActorSystem("LifecycleActorSystem")
  val lifecycleActor=actorSystem.actorOf(Props[BasicLifecycleLoggingActor],"lifecycleActor")

  //lifecycleActor!"hello"
  //actorSystem.stop(lifecycleActor);
  //lifecycleActor!"stop"
  //lifecycleActor!PoisonPill
  lifecycleActor ! Kill

  //wait for a couple of seconds before shutdown
  Thread.sleep(2000)
  actorSystem.shutdown()

}