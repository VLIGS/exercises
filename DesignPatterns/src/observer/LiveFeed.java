package observer;

public class LiveFeed implements Commentary{
    private String currentFeed;
    
    public void setDesc(String desc){
        currentFeed = desc;
    }
}
