package singleton;

public class SingletonDoubleLocking {
    //the volatile keyword ensures that multiple threads handle the instance variable
    //correctly when it is being initialised to the Singleton instance
    private volatile static SingletonDoubleLocking instance;
    private SingletonDoubleLocking(){}

    public static SingletonDoubleLocking getInstance(){
        if(instance==null){
            synchronized (SingletonDoubleLocking.class) {
                if (instance == null) {
                    instance = new SingletonDoubleLocking();
                }
            }
        }
        return instance;
    }
}

