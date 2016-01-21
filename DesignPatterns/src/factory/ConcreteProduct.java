package factory;

class  ConcreteProduct implements Product{

    private String productName;

    public ConcreteProduct(){
        productName = "generic";
    }
    public ConcreteProduct(String name){
        productName = name;
    }

    @Override
    public String getProductName (){
        return productName;
    }
}
