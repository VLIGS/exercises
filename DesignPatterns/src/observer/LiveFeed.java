package observer;

public class LiveFeed implements Commentary{
    private Subject mySubject;
    private String feed;

    public LiveFeed(Subject subject){
        mySubject=subject;
    }
    public void setDesc(String desc){
        feed = desc;
        mySubject.notifyObservers();
    }
}
