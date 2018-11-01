package com.example.taki.newproject.programming_convertor;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.PopupMenu;
import android.widget.TextView;

import com.example.taki.newproject.R;

import java.util.HashMap;
import java.util.Map;

public class programming_converter extends Fragment {

    Integer fromBase = 10, toBase = 2;
    private Button mFromButton, mToButton, mConvertButton;
    private EditText mFromText;
    private TextView mToText;
    private InputMethodManager inputMethodManager;
    private Context context;
    private static Map<Integer, String> base2Str = new HashMap<Integer, String>() {
        {
            put(2, "Bin");
            put(8, "Oct");
            put(10, "Dec");
            put(16, "Hex");
        }
    };

    //View view;



    private void update_base(int base, boolean isFrom) {
        if (isFrom) {
            fromBase = base;
            mFromButton.setText(base2Str.get(fromBase));
        } else {
            toBase = base;
            mToButton.setText(base2Str.get(toBase));
        }
    }

    public void showPopup(View v, final boolean isFrom) {
        PopupMenu popup = new PopupMenu(getActivity(), v);
        popup.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                                             @Override
                                             public boolean onMenuItemClick(MenuItem item) {
                                                 int id = item.getItemId();
                                                 switch (id) {
                                                     case R.id.Hex:
                                                         update_base(16, isFrom);
                                                         break;
                                                     case R.id.Dec:
                                                         update_base(10, isFrom);
                                                         break;
                                                     case R.id.Oct:
                                                         update_base(8, isFrom);
                                                         break;
                                                     case R.id.Bin:
                                                         update_base(2, isFrom);
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

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        //view = inflater.inflate(R.layout.programming_convert,null);

        View view = inflater.inflate( R.layout.programming_convert, container, false);
        mFromButton = (Button) view.findViewById(R.id.fromButton);
        mToButton = (Button) view.findViewById(R.id.toButton);
        mFromText = (EditText) view.findViewById(R.id.fromText);
        mToText = (TextView) view.findViewById(R.id.toText);
        mConvertButton = (Button) view.findViewById(R.id.convertButton);
        inputMethodManager = (InputMethodManager) getActivity().getSystemService( Context.INPUT_METHOD_SERVICE );


        mConvertButton.setOnClickListener(new convertButtonOnClickListener());
        mFromButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showPopup(v, true);
            }
        });
        mToButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showPopup(v, false);
            }
        });

        return view;
    }

    class convertButtonOnClickListener implements View.OnClickListener {
        @Override
        public void onClick(View v) {
            String input = mFromText.getText().toString();
            try {
                Converter converter = new Converter(input, fromBase);
                mToText.setText(converter.toBase(toBase));
                Myutil.hideSoftKeyBoard(v, inputMethodManager);

            } catch (IntOverFlow e) {
                mFromText.setError("Input Number Too Large");
            } catch (SanityCheckException e){
                mFromText.setError("Input Format Wrong");
            }

        }
    }


}
