package composite;

public class HtmlElement extends HtmlTag{
    private String name;
    private String startTag;
    private String endTag;
    private String tagBody;

    public HtmlElement(String name){
        this.name = name;
    }
    @Override
    public String getTagName(){
        return name;
    }
    @Override
    public void setStartTag(String tag){
        startTag = tag;
    }
    @Override
    public void setEndTag(String tag){
        endTag = tag;
    }
    @Override
    public void setTagBody(String body){
        tagBody = body;
    }

    public void generateHtml(){
        System.out.println(startTag + tagBody+endTag);
    }
}
