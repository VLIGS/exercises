package observer;

import java.util.List;

public class CommentaryObject implements Subject {
    private List<Observer> mySubscribers;
    private String myTitle;
    private Commentary myCommentary;

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
            myObserver.update(subjectDetails());
        }
    }

    @Override
    public String subjectDetails() {
        return null;
    }
}
