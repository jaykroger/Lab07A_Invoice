import javax.swing.*;
import java.awt.*;
import java.time.LocalDate;
import java.util.ArrayList;

public class InvoiceGUI extends JFrame
{
    Color backgroundColor = new Color(247, 246, 242);
    Color textColor = new Color(31, 30, 30);
    Font labelFont = new Font("Roboto", Font.BOLD, 12);
    Font headerFont = new Font("Comfortaa", Font.BOLD, 48);

    JPanel mainPanel;

    // North Panel
    JPanel headerPanel;
    JLabel header;



    // Center Panel
    JPanel centerPanel;

    // Panel for customer info input
    JPanel customerInputPanel;
    JLabel customerInputHeader;

    JLabel customerNameLabel;
    JLabel customerStreetAddressLabel;
    JLabel customerCityLabel;
    JLabel customerStateLabel;
    JLabel customerZIPCodeLabel;

    JTextField customerName;
    JTextField customerStreetAddress;
    JTextField customerCity;
    JComboBox customerState;
    JTextField customerZIPCode;

    String[] states = {
            "Alabama", "Alaska", "Arizona", "Arkansas", "California",
            "Colorado", "Connecticut", "Delaware", "Florida", "Georgia",
            "Hawaii", "Idaho", "Illinois", "Indiana", "Iowa", "Kansas",
            "Kentucky", "Louisiana", "Maine", "Maryland", "Massachusetts",
            "Michigan", "Minnesota", "Mississippi", "Missouri", "Montana",
            "Nebraska", "Nevada", "New Hampshire", "New Jersey", "New Mexico",
            "New York", "North Carolina", "North Dakota", "Ohio", "Oklahoma",
            "Oregon", "Pennsylvania", "Rhode Island", "South Carolina",
            "South Dakota", "Tennessee", "Texas", "Utah", "Vermont",
            "Virginia", "Washington", "West Virginia", "Wisconsin", "Wyoming"
    };


    // Panel for product info input
    JPanel productInputPanel;
    JLabel productInputHeader;

    JLabel productNameLabel;
    JLabel productPriceLabel;
    JLabel productQuantityLabel;

    JTextField productName;
    JTextField productPrice;
    JTextField productQuantity;

    JButton addButton;


    // South Panel

    JPanel buttonPanel;

    JButton submitButton;
    JButton quitButton;

    public InvoiceGUI()
    {
        mainPanel = new JPanel();
        mainPanel.setLayout(new BorderLayout());
        mainPanel.setBackground(backgroundColor);
        mainPanel.setForeground(textColor);

        createHeaderPanel();
        mainPanel.add(headerPanel, BorderLayout.NORTH);

        createCenterPanel();
        mainPanel.add(centerPanel, BorderLayout.CENTER);
        add(mainPanel);
    }

    private void createHeaderPanel()
    {
        headerPanel = new JPanel();
        headerPanel.setBackground(backgroundColor);
        headerPanel.setForeground(textColor);

        header = new JLabel("Invoice Generator");
        header.setFont(headerFont);

        headerPanel.add(header);
    }

    private void createCenterPanel()
    {
        centerPanel = new JPanel();
        centerPanel.setBackground(backgroundColor);
        centerPanel.setForeground(textColor);
        centerPanel.setLayout(new GridLayout(2,1));

        createCustomerInputPanel();
        centerPanel.add(customerInputPanel);
    }

    private void createCustomerInputPanel()
    {
        customerInputPanel = new JPanel();
        customerInputPanel.setBackground(backgroundColor);
        customerInputPanel.setForeground(textColor);
        customerInputPanel.setLayout(new GridLayout(6, 2));

        customerInputHeader = new JLabel("Customer Information");
        customerInputHeader.setFont(headerFont);

        customerNameLabel = new JLabel("Name");
        customerNameLabel.setFont(labelFont);
        customerName = new JTextField(25);

        customerStreetAddressLabel = new JLabel("Street Address");
        customerStreetAddressLabel.setFont(labelFont);
        customerStreetAddress = new JTextField(30);

        customerCityLabel = new JLabel("City");
        customerCityLabel.setFont(labelFont);
        customerCity = new JTextField(20);

        customerStateLabel = new JLabel("State");
        customerStateLabel.setFont(labelFont);
        customerState = new JComboBox(states);

        customerZIPCodeLabel = new JLabel("Zip Code");
        customerZIPCodeLabel.setFont(labelFont);
        customerZIPCode = new JTextField(5);

        customerInputPanel.add(customerInputHeader);
        customerInputPanel.add(customerNameLabel);
        customerInputPanel.add(customerName);
        customerInputPanel.add(customerStreetAddressLabel);
        customerInputPanel.add(customerStreetAddress);
        customerInputPanel.add(customerCityLabel);
        customerInputPanel.add(customerCity);
        customerInputPanel.add(customerZIPCodeLabel);
        customerInputPanel.add(customerZIPCode);

    }

}
