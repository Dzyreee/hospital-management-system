package HMS;

/**
 * Interface representing a Payable entity in the hospital system.
 * Any class that implements this interface is expected to provide a method
 * for calculating the payment based on the given bill ID.
 * 
 * @author Omair Nawaz
 * @author Yacine Marabet
 * @author Mir Abbasi
 * @author Abdulrahman Al-Sulaiti
 */
public interface Payable {

    /**
     * Calculates the payment for a specific bill based on the bill ID.
     *
     * @param billId the unique identifier for the bill.
     * @return the calculated payment amount for the bill.
     */
    public double calculatePayment(int billId);

}
