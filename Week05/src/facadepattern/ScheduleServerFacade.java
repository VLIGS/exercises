package facadepattern;

public class ScheduleServerFacade {
    private ScheduleServer scheduleServer;
    public ScheduleServerFacade(){
        scheduleServer = new ScheduleServerImpl();
    }
    public void startServer(){

    }
    public void stopServer(){

    }
}
