package chap03;

import java.time.LocalDate;

public class ExpiryDateCalculator {

    /**
     * 만료일 계산
     * @param payData
     * @return
     */
    public LocalDate calculateExpiryDate(PayData payData) {
        int addedMonths = 1;

        if (payData.getFirstBillingDate() != null) {
            LocalDate candidateExp = payData.getBillingDate().plusMonths(addedMonths);

            //첫 납부일과 납부일의 일자가 다르면 첫 납부일의 일자를 만료일의 일자로 사용
            if (payData.getFirstBillingDate().getDayOfMonth()
                    != candidateExp.getDayOfMonth()) {
                return candidateExp.withDayOfMonth(
                        payData.getFirstBillingDate().getDayOfMonth());
            }
        }

        return payData.getBillingDate().plusMonths(addedMonths);
    }
}


