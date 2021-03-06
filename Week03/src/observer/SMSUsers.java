package observer;

public class SMSUsers implements Observer {
    private Subject mySubject;
    private String myMsg;
    public SMSUsers(Subject s, String msg){
        mySubject = s;
        myMsg = msg;
    }

    //update with most recent message
    @Override
    public void update(String desc) {
        System.out.println(myMsg + " received " + desc);
    }
    //this is to subscribe to the SMS service
    @Override
    public void subscribe() {
        mySubject.subscribeObserver(this);
    }

    //terminate subscription to SMS service
    @Override
    public void unSubscribe() {
        mySubject.unSubscribeObserver(this);
    }
}
