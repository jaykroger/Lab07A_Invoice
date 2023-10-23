import java.text.Format;
import java.time.LocalDate;
import java.util.ArrayList;

public class Invoice
{

    private Customer customer;
    private ArrayList<LineItem> lineItems = new ArrayList<>();
    private LocalDate date;

    public Invoice(Customer customer, ArrayList<LineItem> lineItems, LocalDate date)
    {
        this.customer = customer;
        this.lineItems = lineItems;
        this.date = date;

    }

    public LocalDate getDate()
    {
        return date;
    }

    public void setDate(LocalDate date)
    {
        this.date = date;
    }

    public double calculateTotal()
    {
        double total = 0.0;
        double lineItemTotal;

        for (LineItem l : this.lineItems)
        {
            lineItemTotal = l.calculateLineTotal();
            total = total + lineItemTotal;
        }
        return total;
    }

    public void printInvoice()
    {
        String name = this.customer.getName();
        String streetAddress = this.customer.getStreetAddress();
        String city = this.customer.getCity();
        String state = this.customer.getState();
        int zipCode = this.customer.getZipCode();
        LocalDate date = this.date;

        double amountDue = this.calculateTotal();


        // Prints header with address
        System.out.print("\n\n");
        System.out.printf("%44s", "Invoice");
        System.out.print("\n\n\n");
        System.out.println(name);
        System.out.println(streetAddress);
        System.out.print(city + ", " + state + " " + zipCode);
        System.out.printf("%53s", date);
        System.out.print("\n");
        System.out.println("=============================================================================");

        // Prints line items with quantity, price, and calculated line total
        System.out.print("Item");
        System.out.printf("%40s %14s %16s", "Price", "Quantity", "Total Price");
        System.out.print("\n");

        for (LineItem l : this.lineItems)
        {
            String itemName = l.getName();
            double itemPrice = l.getPrice();
            int itemQuantity = l.getQuantity();
            double itemTotalPrice = l.calculateLineTotal();





            System.out.print("\n");
            System.out.printf("%-38s $%-14.2f %-10d $%-15.2f\n", itemName, itemPrice, itemQuantity, itemTotalPrice);
        }

        // Prints footer with total amount due for all items
        System.out.print("\n");
        System.out.println("=============================================================================");
        System.out.print("\n");
        System.out.print("Amount Due: $");
        System.out.printf("%.2f", amountDue);
        System.out.print("\n\n");

    }
}
