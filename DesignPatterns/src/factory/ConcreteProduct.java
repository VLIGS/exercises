package factory;

class  ConcreteProduct implements Product{

    private String productName;

    public ConcreteProduct(){
        setProductName("generic");
    }
    public ConcreteProduct(String name){
        productName = name;
    }

    @Override
    public String getProductName (){
        return productName;
    }


    @Override
    public void setProductName(String name){
        productName = name;
    }
}
