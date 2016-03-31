package gyndroids.com.studyjam.fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;

import java.text.NumberFormat;

import gyndroids.com.studyjam.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class JustJava extends Fragment {

    private View mView;

    //views
    private Button btnOrder;
    private Button btnLessCoffe;
    private Button btnMoreCoffe;
    private CheckBox chkChocolate;
    private CheckBox chkCream;
    private EditText edtName;
    private TextView txtQuantity;
    private TextView txtOrderSummary;

    private int quantityCoffe;

    public JustJava() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        mView = inflater.inflate(R.layout.fragment_just_java, container, false);

        quantityCoffe = 0;

        setupViews();
        setupListeners();

        return mView;
    }

    private void setupViews() {
        edtName = (EditText) mView.findViewById(R.id.edt_input_name);

        btnLessCoffe = (Button) mView.findViewById(R.id.btn_less_coffe);
        btnMoreCoffe = (Button) mView.findViewById(R.id.btn_more_coffe);
        btnOrder = (Button) mView.findViewById(R.id.btn_submit_order);

        chkChocolate = (CheckBox) mView.findViewById(R.id.chk_topping_chocolate);
        chkCream = (CheckBox) mView.findViewById(R.id.chk_topping_cream);

        txtQuantity = (TextView) mView.findViewById(R.id.txt_qtd_coffe);
        txtOrderSummary = (TextView) mView.findViewById(R.id.txt_order_sumarry);
    }

    private void setupListeners() {
        btnLessCoffe.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (quantityCoffe > 0)
                    quantityCoffe--;
                updateQtdCoffe();
            }
        });

        btnMoreCoffe.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                quantityCoffe++;
                updateQtdCoffe();
            }
        });

        btnOrder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculateOrder();
            }
        });
    }

    public void calculateOrder() {
        String name = edtName.getText().toString();
        boolean hasChocolate = chkChocolate.isChecked();
        boolean hasCream = chkCream.isChecked();

        int priceCoffe = 5;
        int price = quantityCoffe * priceCoffe;

        if (hasChocolate) price += 3 * quantityCoffe;
        if (hasCream) price += 3 * quantityCoffe;

        String summary = "";
        summary += "Nome: " + name + "\n";
        summary += "Chocolate: " + hasChocolate + "\n";
        summary += "Cream: " + hasCream + "\n";
        summary += "Total Order Price: " + NumberFormat.getCurrencyInstance().format(price);

        updateOrderSummary(summary);
    }

    private void updateOrderSummary(String summary) {
        txtOrderSummary.setText(summary);
    }

    private void updateQtdCoffe() {

        txtQuantity.setText(String.valueOf(quantityCoffe));
    }

    public void finishOrder() {

    }

}
