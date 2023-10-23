import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.time.LocalDate;
import java.util.ArrayList;

public class InvoiceGUI extends JFrame
{
    Color backgroundColor = new Color(247, 246, 242);
    Color textColor = new Color(31, 30, 30);
    Color buttonBackgroundColor = new Color(236,116,108);
    Color buttonTextColor = new Color(240, 240, 240);
    Font labelFont = new Font("Roboto", Font.BOLD, 12);
    Font headerFont = new Font("Comfortaa", Font.BOLD, 48);
    Font smallHeaderFont = new Font("Comfortaa", Font.BOLD, 24);

    JPanel mainPanel;

    // North Panel
    JPanel headerPanel;
    JLabel header;



    // Center Panel
    JPanel centerPanel;

    // Panel for customer info input

    JPanel customerInputPanel;

    JPanel customerHeaderPanel;
    JLabel customerInputHeader;

    JPanel customerFormPanel;
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
    JButton clearButton;

    JOptionPane dialogBox;

    // South Panel
    JPanel buttonPanel;

    JButton submitButton;
    JButton quitButton;
    JOptionPane quitDialogBox;
    int quitConfirm;



    // Program logic
    ArrayList<LineItem> lineItems = new ArrayList<>();

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

        createButtonPanel();
        mainPanel.add(buttonPanel, BorderLayout.SOUTH);

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

        createProductInputPanel();
        centerPanel.add(productInputPanel);
    }

    private void createCustomerInputPanel()
    {
        customerInputPanel = new JPanel();
        customerInputPanel.setBackground(backgroundColor);
        customerInputPanel.setForeground(textColor);
        customerInputPanel.setLayout(new GridBagLayout());

        GridBagConstraints panelConstraints = new GridBagConstraints();
        panelConstraints.anchor = GridBagConstraints.WEST;
        panelConstraints.insets = new Insets(2, 2, 0, 2);

        customerHeaderPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        customerHeaderPanel.setBackground(backgroundColor);
        customerHeaderPanel.setForeground(textColor);


        customerInputHeader = new JLabel("Customer Information");
        customerInputHeader.setBackground(backgroundColor);
        customerInputHeader.setForeground(textColor);
        customerInputHeader.setFont(smallHeaderFont);
        customerHeaderPanel.add(customerInputHeader);


        customerFormPanel = new JPanel();
        customerFormPanel.setBackground(backgroundColor);
        customerFormPanel.setForeground(textColor);
        customerFormPanel.setBorder(new LineBorder(textColor, 2));
        customerFormPanel.setLayout(new GridBagLayout());


        GridBagConstraints formConstraints = new GridBagConstraints();
        formConstraints.anchor = GridBagConstraints.WEST;
        formConstraints.insets = new Insets(5, 5, 5, 5);

        customerNameLabel = new JLabel("Name:");
        customerNameLabel.setFont(labelFont);
        customerName = new JTextField(20);

        customerStreetAddressLabel = new JLabel("Street Address:");
        customerStreetAddressLabel.setFont(labelFont);
        customerStreetAddress = new JTextField(20);


        customerCityLabel = new JLabel("City:");
        customerCityLabel.setFont(labelFont);
        customerCity = new JTextField(20);


        customerStateLabel = new JLabel("State:");
        customerStateLabel.setFont(labelFont);
        customerState = new JComboBox(states);


        customerZIPCodeLabel = new JLabel("Zip Code:");
        customerZIPCodeLabel.setFont(labelFont);
        customerZIPCode = new JTextField(10);



        formConstraints.gridx = 1;
        formConstraints.gridy = 0;
        customerFormPanel.add(customerNameLabel, formConstraints);
        formConstraints.gridx = 2;
        customerFormPanel.add(customerName, formConstraints);
        formConstraints.gridx = 1;
        formConstraints.gridy = 2;
        customerFormPanel.add(customerStreetAddressLabel, formConstraints);
        formConstraints.gridx = 2;
        customerFormPanel.add(customerStreetAddress, formConstraints);
        formConstraints.gridx = 1;
        formConstraints.gridy = 3;
        customerFormPanel.add(customerCityLabel, formConstraints);
        formConstraints.gridx = 2;
        customerFormPanel.add(customerCity, formConstraints);
        formConstraints.gridx = 1;
        formConstraints.gridy = 4;
        customerFormPanel.add(customerStateLabel, formConstraints);
        formConstraints.gridx = 2;
        customerFormPanel.add(customerState, formConstraints);
        formConstraints.gridx = 1;
        formConstraints.gridy = 5;
        customerFormPanel.add(customerZIPCodeLabel, formConstraints);
        formConstraints.gridx = 2;
        customerFormPanel.add(customerZIPCode, formConstraints);


        panelConstraints.gridx = 1;
        panelConstraints.gridy = 1;
        customerInputPanel.add(customerHeaderPanel, panelConstraints);
        panelConstraints.gridy = 2;
        customerInputPanel.add(customerFormPanel, panelConstraints);
    }

    private void createProductInputPanel()
    {
        productInputPanel = new JPanel();
        productInputPanel.setBackground(backgroundColor);
        productInputPanel.setForeground(textColor);
        productInputPanel.setLayout(new GridBagLayout());

        GridBagConstraints constraints = new GridBagConstraints();
        constraints.anchor = GridBagConstraints.WEST;
        constraints.insets = new Insets(5, 5, 5, 5);

        GridBagConstraints headerConstraints = new GridBagConstraints();
        headerConstraints.anchor = GridBagConstraints.CENTER;
        headerConstraints.insets = new Insets(2,2,2,2);

        productInputHeader = new JLabel("Product Billing");
        productInputHeader.setFont(smallHeaderFont);

        productNameLabel = new JLabel("Product Name:");
        productNameLabel.setFont(labelFont);
        productName = new JTextField(10);

        productPriceLabel = new JLabel("Price:");
        productPriceLabel.setFont(labelFont);
        productPrice = new JTextField(8);

        productQuantityLabel = new JLabel("Quantity:");
        productQuantityLabel.setFont(labelFont);
        productQuantity = new JTextField(3);

        addButton = new JButton("Add");
        addButton.setFont(labelFont);
        addButton.setBackground(buttonBackgroundColor);
        addButton.setForeground(buttonTextColor);
        addButton.addActionListener((ActionEvent ae) ->
        {
            addLineItem();
            clearLineItemFields();
        });

        clearButton = new JButton("Clear");
        clearButton.setFont(labelFont);
        clearButton.setBackground(buttonBackgroundColor);
        clearButton.setForeground(buttonTextColor);
        clearButton.addActionListener((ActionEvent ae) ->
        {
            clearLineItemFields();
        });

        constraints.gridx = 1;
        constraints.gridy = 3;
        productInputPanel.add(productNameLabel, constraints);
        constraints.gridx = 2;
        productInputPanel.add(productName, constraints);
        constraints.gridx = 3;
        productInputPanel.add(productPriceLabel, constraints);
        constraints.gridx = 4;
        productInputPanel.add(productPrice, constraints);
        constraints.gridx = 5;
        productInputPanel.add(productQuantityLabel, constraints);
        constraints.gridx = 6;
        productInputPanel.add(productQuantity, constraints);
        constraints.gridx = 7;
        productInputPanel.add(addButton, constraints);
        constraints.gridx = 8;
        productInputPanel.add(clearButton, constraints);
    }

    private void createButtonPanel()
    {
        buttonPanel = new JPanel(new GridLayout(1,2));
        buttonPanel.setBackground(backgroundColor);

        submitButton = new JButton("Submit");
        submitButton.setFont(labelFont);
        submitButton.setBackground(buttonBackgroundColor);
        submitButton.setForeground(buttonTextColor);
        submitButton.addActionListener((ActionEvent ae) ->
            {
                printInvoice();
            });

        quitButton = new JButton("Quit");
        quitButton.setFont(labelFont);
        quitButton.setBackground(buttonBackgroundColor);
        quitButton.setForeground(buttonTextColor);
        quitButton.addActionListener((ActionEvent ae) ->
        {
            getQuitConfirm();
        });

        buttonPanel.add(submitButton);
        buttonPanel.add(quitButton);
    }


    private void addLineItem()
    {
        String lineItemName = productName.getText();
        double lineItemPrice = Double.parseDouble(productPrice.getText());
        int lineItemQuantity = Integer.parseInt(productQuantity.getText());

        LineItem l = new LineItem(lineItemName, lineItemPrice, lineItemQuantity);

        lineItems.add(l);

        dialogBox = new JOptionPane();
        dialogBox.showMessageDialog(null, "Product added successfully.");
    }

    private void clearLineItemFields()
    {
        productName.setText("");
        productPrice.setText("");
        productQuantity.setText("");
    }

    private void printInvoice()
    {
        String[] stateAbbreviations = {
                "AL", "AK", "AZ", "AR", "CA",
                "CO", "CT", "DE", "FL", "GA",
                "HI", "ID", "IL", "IN", "IA", "KS",
                "KY", "LA", "ME", "MD", "MA",
                "MI", "MN", "MS", "MO", "MT",
                "NE", "NV", "NH", "NJ", "NM",
                "NY", "NC", "ND", "OH", "OK",
                "OR", "PA", "RI", "SC", "SD",
                "TN", "TX", "UT", "VT", "VA",
                "WA", "WV", "WI", "WY"
        };

        String name = customerName.getText();
        String streetAddress = customerStreetAddress.getText();
        String city = customerCity.getText();
        String state = stateAbbreviations[customerState.getSelectedIndex()];
        int zipCode = Integer.parseInt(customerZIPCode.getText());

        LocalDate d;
        d = java.time.LocalDate.now();

        Customer c = new Customer(name, streetAddress, city, state, zipCode);
        Invoice i = new Invoice(c, lineItems, d);
        i.printInvoice();

        dialogBox.showMessageDialog(null, "Invoice printed successfully.");
    }
    private void getQuitConfirm()
    {
        quitConfirm = quitDialogBox.showConfirmDialog(null, "Are you sure you want to quit?", "Quit", JOptionPane.YES_NO_OPTION);

        if (quitConfirm == quitDialogBox.YES_OPTION)
        {
            System.exit(0);
        }
    }
}
