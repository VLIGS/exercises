package Lab1;

public class Driver {
    public static void main(String[] args) {
        Storage<BankAccount> aStorage = new Storage<BankAccount>();
        Storage<String> sStorage = new Storage<String>();

        //Class baCls = Lab1.BankAccount.class;  //used in questions 3, 4, 5
        Class<BankAccount> baCls = BankAccount.class; //used in questions 6,7

        try {

            /** Question 3
            Object myAccount =  baCls.newInstance();
            aStorage.setValue(myAccount); //error message setValue(Lab1.BankAccount) in Storage can't be applied to java.lang.Object
             **/

            /** Question 4
            Lab1.BankAccount myAccount =  baCls.newInstance(); //error message incompatable type, required Lab1.BankAccount found java.lang.Object
            aStorage.setValue(myAccount);
             **/

            /** Question 5
            Lab1.BankAccount myAccount =  (Lab1.BankAccount) baCls.newInstance(); //this works with Class baCls = Lab1.BankAccount.class;
            aStorage.setValue(myAccount);
             **/

            BankAccount myAccount =  (BankAccount) baCls.newInstance();
            aStorage.setValue(myAccount);

            // Deposit
            myAccount.deposit(15);
        }
        catch ( InstantiationException e ) {
            // ...
        }
        catch ( IllegalAccessException e ) {

        }

        System.out.println( aStorage.getValue().showBalance() );
        if( aStorage.getClass() == sStorage.getClass() ) {
            System.out.println( "EQUAL" );
        } else {
            System.out.println( "NOT EQUAL" );
        }
    }
}
