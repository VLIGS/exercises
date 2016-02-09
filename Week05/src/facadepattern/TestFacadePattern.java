package facadepattern;

public class TestFacadePattern {
    public static void main(String[] args) {
        ScheduleServerFacade scheduleServerFacade = new ScheduleServerFacade();
        scheduleServerFacade.startServer();
        scheduleServerFacade.stopServer();
    }

}
