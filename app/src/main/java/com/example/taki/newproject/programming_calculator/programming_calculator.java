package com.example.taki.newproject.programming_calculator;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.PopupMenu;
import android.widget.TextView;

import com.example.taki.newproject.R;
import com.example.taki.newproject.programming_convertor.Converter;
import com.example.taki.newproject.programming_convertor.IntOverFlow;
import com.example.taki.newproject.programming_convertor.SanityCheckException;

import java.util.HashMap;
import java.util.Map;

public class programming_calculator extends Fragment {
    Integer inputOneBase = 10;
    Integer inputTwoBase = 10;
    Integer resultBase = 10;
    Integer operation = 0;
    private Button inputOneBaseButton;
    private Button inputTwoBaseButton;
    private Button resultBaseButton;
    private EditText firstInput;
    private EditText secondInput;
    private TextView baseCalcResult;
    private Button addButton;
    private Button subtractButton;
    private Button multiplyButton;
    private static Map<Integer, String> base2Str = new HashMap<Integer, String>() {
        {
            put(2, "Bin");
            put(8, "Oct");
            put(10, "Dec");
            put(16, "Hex");
        }
    };

    private void update_base(int base, int whichBase) {
        if (whichBase == 0) {
            inputOneBase = base;
            inputOneBaseButton.setText(base2Str.get(inputOneBase));
        } else if (whichBase == 1){
            inputTwoBase = base;
            inputTwoBaseButton.setText(base2Str.get(inputTwoBase));
        }else
            resultBase = base;
        resultBaseButton.setText(base2Str.get(resultBase));
    }

    public void showPopup(View v, final int whichBase) {
        PopupMenu popup = new PopupMenu(getActivity(), v);
        popup.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                                             @Override
                                             public boolean onMenuItemClick(MenuItem item) {
                                                 int id = item.getItemId();
                                                 switch (id) {
                                                     case R.id.Hex:
                                                         update_base(16, whichBase);
                                                         break;
                                                     case R.id.Dec:
                                                         update_base(10, whichBase);
                                                         break;
                                                     case R.id.Oct:
                                                         update_base(8, whichBase);
                                                         break;
                                                     case R.id.Bin:
                                                         update_base(2, whichBase);
                                                         break;
                                                     default:
                                                         return false;

                                                 }
                                                 return true;
                                             }
                                         }
        );
        MenuInflater inflater = popup.getMenuInflater();
        inflater.inflate(R.menu.menu, popup.getMenu());
        popup.show();

    }


    //View view;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.programming_calculator,null);

        inputOneBaseButton = (Button) view.findViewById(R.id.inputOneBaseButton);
        inputTwoBaseButton = (Button) view.findViewById(R.id.inputTwoBaseButton);
        firstInput = (EditText) view.findViewById(R.id.firstInput);
        secondInput = (EditText) view.findViewById(R.id.secondInput);
        baseCalcResult = (TextView) view.findViewById(R.id.baseCalcResult);
        resultBaseButton = (Button) view.findViewById(R.id.resultBaseButton);
        addButton = (Button) view.findViewById(R.id.addButton);
        subtractButton = (Button) view.findViewById(R.id.subtractButton);
        multiplyButton = (Button) view.findViewById(R.id.multiplyButton);

        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                operation = 0;
                calculate();
            }
        });
        subtractButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                operation = 1;
                calculate();
            }
        });
        multiplyButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                operation = 2;
                calculate();
            }
        });
        inputOneBaseButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showPopup(v, 0);
            }
        });
        inputTwoBaseButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showPopup(v, 1);
            }
        });
        resultBaseButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showPopup(v, 2);
            }
        });
        return view;
    }

    public void calculate(){
        firstInput.setError(null);
        secondInput.setError(null);
        String input1 = firstInput.getText().toString();
        String input2 = secondInput.getText().toString();
        String result = "";
        boolean negative = false;
        try {
            Converter converter1 = new Converter(input1, inputOneBase);
            Converter converter2 = new Converter(input2, inputTwoBase);

            int input1_decimal = Integer.parseInt(converter1.toBase(10));
            int input2_decimal = Integer.parseInt(converter2.toBase(10));
            int value = 0;
            if (operation == 0) {
                value = input1_decimal + input2_decimal;
            } else if (operation == 1) {
                value = input1_decimal - input2_decimal;
            } else if (operation == 2) {
                value = input1_decimal * input2_decimal;
            }
            if (value < 0) {
                negative = true;
            } else {
                negative = false;
            }
            result = Integer.toString(value);
            Converter converter3 = new Converter(result, 10);
            if (!negative) {
                baseCalcResult.setText(converter3.toBase(resultBase));
            } else {
                if(resultBase==10){
                    baseCalcResult.setText(converter3.toBase(resultBase));
                } else if(resultBase==2){
                    baseCalcResult.setText(converter3.toBase(resultBase));
                } else{
                    baseCalcResult.setText(converter3.toBase(resultBase));
                }
            }
        } catch (IntOverFlow e) {
            firstInput.setError("At least one of the input numbers is too large");
            secondInput.setError("At least one of the input numbers is too large");
        } catch (SanityCheckException e){
            firstInput.setError("At least one of them has wrong input format");
            secondInput.setError("At least one of them has wrong input format");
        }
    }


}
