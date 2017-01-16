package com.example.android.justjava;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.TextView;
import java.text.NumberFormat;
import static android.R.attr.checkBoxPreferenceStyle;
import static android.R.attr.checked;
import static android.R.attr.order;
import static android.icu.lang.UCharacter.GraphemeClusterBreak.T;
import static com.example.android.justjava.R.id.check_box;

/**
 * This app displays an order form to order coffee.
 */
public class MainActivity extends AppCompatActivity {
    int quantity = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    /**
     * This method is called when the + button is clicked.
     */
    public void increment(View view) {
        quantity += 1;
        displayQuantity(quantity);
        //2 dollars per cup of coffee
    }
    /**
     * This method is called when the - button is clicked.
     */
    public void decrement(View view) {
        quantity -= 1;
        displayQuantity(quantity);
        //2 dollars per cup of coffee
    }
    /**
     * This method is called when the order button is clicked.
     */
    public void submitOrder(View view) {
        CheckBox whippedCreamCheckBox = (CheckBox) findViewById(R.id.check_box);
        boolean hasWhippedCream = whippedCreamCheckBox.isChecked();
        int price = calculatePrice(hasWhippedCream);
        String message = createOrderSummary(price, hasWhippedCream);
        displayMessage(message);
    }
    /**
     * This method is run when the order button is pushed
     * @param price
     * @param addWhippedCream
     * @return
     */
    private String createOrderSummary(int price, boolean addWhippedCream) {
        String priceMessage = "Name: Robin";
        priceMessage += "\nAdd whipped cream?" + addWhippedCream;
        priceMessage += "\nQuantity: " + quantity;
        priceMessage += "\nTotal: $ " + price;
        priceMessage += "\nThank you!";
        return priceMessage;
    }
    /**
     * This method displays the given quantity value on the screen.
     */
    private void displayQuantity(int number) {
        TextView quantityTextView = (TextView) findViewById(R.id.quantityNumber);
        quantityTextView.setText("" + number);
    }
    /**
     * This method displays the given text on the screen.
     */
    private void displayMessage(String message) {
        TextView priceTextView = (TextView) findViewById(R.id.dollarsPerCup);
        priceTextView.setText(message);
    }
    /**
     * This method calculates the price based on the quantity.
     */
    private int calculatePrice(boolean hasWhippedCream){
        int basePrice = 2;
        return quantity * basePrice;
    }
}