package phone.method;

public class SupplementCheck {

private static final Integer NUMBERS_OF_NUMBERS_IN_ACCOUNT=26;
    private Boolean isNumber(String singleNumber) {
        boolean isANumber = false;
        if (singleNumber.trim().matches("\\d{0,9}")) {
            isANumber = true;
        }
        return isANumber;
    }

    public Boolean isAllNumbers(String accountNumber) {
        boolean isANumber = false;
        for (int i = 0; i < accountNumber.trim().length(); i++) {
            isANumber = isNumber(accountNumber.trim().substring(i, i + 1));
            if (isANumber == false) {
                break;
            }
        }
        return isANumber;
    }

    public Boolean isAccountNumberCorrect(String accountNumber){
        Boolean isCorrect=false;
        if(isAllNumbers(accountNumber.trim()) && accountNumber.trim().length()>=NUMBERS_OF_NUMBERS_IN_ACCOUNT){
            isCorrect=true;
        }
        return isCorrect;
    }

}