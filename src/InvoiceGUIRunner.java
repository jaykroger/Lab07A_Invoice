import javax.swing.*;

public class InvoiceGUIRunner
{
    public static void main(String[] args)
    {
        InvoiceGUI invoiceGUI = new InvoiceGUI();

        invoiceGUI.setTitle("Invoice Generator");
        invoiceGUI.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        invoiceGUI.setSize(1080, 560);
        invoiceGUI.setLocation(100, 80);
        invoiceGUI.setVisible(true);
    }
}