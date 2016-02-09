package composite;

import java.util.ArrayList;
import java.util.List;

public class HtmlParentElement extends HtmlTag{
    private String name;
    private String startTag;
    private String endTag;
    private List<HtmlTag> children;

    public HtmlParentElement(String name){
        this.name = name;
        children = new ArrayList<>();
    }
    public String getTagName(){
        return name;
    }

    public void setStartTag(String tag){
        startTag = tag;
    }

    public void setEndTag(String tag){
        endTag = tag;
    }
    @Override
    public void addChildTag(HtmlTag htmlTag) {
        children.add(htmlTag);
    }
    public void removeChildTag(HtmlTag htmlTag) {
        children.remove(htmlTag);
    }
    public List<HtmlTag> getChildren() {
        return children;
    }

    public void generateHtml(){
        System.out.println(startTag);
        for(HtmlTag child: children){
            child.generateHtml();
        }
        System.out.println(endTag);
    }
}
