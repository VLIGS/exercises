package xpay;

//Adapter needs to implement the interface of the type need to adapt to, interface that clients expects to see
public class XpayToPayDAdapter implements PayD {
    //talks to Xpay
    Xpay myXPay;

    public XpayToPayDAdapter (Xpay xpay){
        myXPay = xpay;
    }

    public String getCustCardNo(){ return myXPay.getCreditCardNo();}

    public void setCustCardNo(String custCardNo){myXPay.setCreditCardNo(custCardNo);}

    public String getCardOwnerName(){return myXPay.getCustomerName();}

    public void setCardOwnerName(String cardOwnerName) {myXPay.setCustomerName(cardOwnerName);}

    public String getCardExpMonthDate(){return myXPay.getCardExpMonth();}

    public void setCardExpMonthDate(String cardExpMonthDate){myXPay.setCardExpMonth(cardExpMonthDate);}

    public Integer getCVVNo(){return myXPay.getCardCVVNo().intValue();}

    public void setCVVNo(Integer cVVNo){myXPay.setCardCVVNo(cVVNo.shortValue());}

    public Double getTotalAmount(){return myXPay.getAmount();}

    public void setTotalAmount(Double totalAmount){myXPay.setAmount(totalAmount);};
}
