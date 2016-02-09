package facadepattern;

public interface ScheduleServer {
    void startBooting();

    void readSystemConfigFile();

    void init();

    void initializeContext();

    void initializeListeners();

    void createSystemObjects();

    void releaseProcesses();

    void destroy();

    void destroySystemObjects();

    void destroyListeners();

    void destroyContext();

    void shutdown();
}
