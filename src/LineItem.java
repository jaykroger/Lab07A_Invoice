public class LineItem extends Product
{
    int quantity;

    public LineItem(String name, double price, int quantity)
    {
        super(name, price);
        this.quantity = quantity;
    }

    public int getQuantity()
    {
        return quantity;
    }

    public void setQuantity(int quantity)
    {
        this.quantity = quantity;
    }

    public double calculateLineTotal()
    {
        return this.quantity * this.getPrice();
    }
}
