package observer;

import java.util.List;

public class CommentaryObject implements Subject {
    private List<Observer> mySubscribers;
    private String myState;
    private String myTitle;

    public CommentaryObject(List<Observer> subscribers, String title) {
        mySubscribers = subscribers;
        myTitle = title;
    }

    @Override
    public void subscribeObserver(Observer observer) {
        mySubscribers.add(observer);
    }

    @Override
    public void unSubscribeObserver(Observer observer) {
        mySubscribers.remove(observer);
    }

    @Override
    public void notifyObservers() {
        for (Observer myObserver: mySubscribers){
            myObserver.update(myState);
        }
    }

    @Override
    public String subjectDetails() {
        return myTitle;
    }
}
