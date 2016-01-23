package xpay;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class AdapterTests {
    @Test
    public void testFlow(){
        Xpay myXPay = new XpayImpl();
        myXPay.setCustomerName("John Smith");
        myXPay.setCreditCardNo("123456789");
        myXPay.setCardCVVNo((short)123);
        PayD myPayD = new XpayToPayDAdapter(myXPay);

        assertEquals(myPayD.getCardOwnerName(),myXPay.getCustomerName());
        assertEquals(myPayD.getCustCardNo(),myXPay.getCreditCardNo());
        //assertEquals(myPayD.getCVVNo(),myXPay.getCardCVVNo().intValue());
    }
}
