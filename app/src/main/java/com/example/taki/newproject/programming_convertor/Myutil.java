package com.example.taki.newproject.programming_convertor;

import android.app.Activity;
import android.content.Intent;
import android.view.View;
import android.view.inputmethod.InputMethodManager;

import java.util.ArrayList;
import java.util.Arrays;

public class Myutil {

    final public static ArrayList<Character> symbols = new ArrayList<>(Arrays.asList(new Character[]{
            '-', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9',
            'A', 'B', 'C', 'D', 'E', 'F'
    }));

    public static void hideSoftKeyBoard(View view, InputMethodManager imm){
        if ( view != null ) {
            imm.hideSoftInputFromWindow(view.getWindowToken(), 0);
        }
    }

    //we modified this class to store activity histories to stack in order to make back button behavior correct
    public static void startNoHistoryAcitivity(Activity acc, Intent intent){
        //intent.setFlags(intent.getFlags()| Intent.FLAG_ACTIVITY_NO_HISTORY);
        intent.setFlags(intent.getFlags());
        acc.startActivity( intent );
    }

    public static boolean sanity_check( String sAnswer, int radix ) throws IntOverFlow, SanityCheckException {
        if (sAnswer.length() == 0 || sAnswer.length() > 15){
            throw new IntOverFlow();
        }
        char[] answerChars = sAnswer.toCharArray();
        boolean isValid = false;

        // if 0111 in decimal
        if(radix==10 && answerChars[0]=='0' && answerChars.length!=1){
            throw new SanityCheckException();
        }

        // if only -
        else if(answerChars[0]=='-' && answerChars.length==1){
            throw new SanityCheckException();
        }

        //if -0
        else if(answerChars[0]=='-' && answerChars[1]=='0' && answerChars.length==2){
            throw new SanityCheckException();
        }

        // if - appears in any base except decimal base
        else if(radix!=10 && answerChars[0]=='-'){
            throw new SanityCheckException();
        }

        //check every char in answerChars is valid
        else {
            for (char c : answerChars) {
                isValid = false;
                for (int i = 0; i < radix+1; ++i) {
                    Character target = symbols.get(i);
                    if ((target.equals(c)) | (target.isLetter(target) && Character.toLowerCase(target) == c)) {
                        isValid = true;
                        break;
                    }
                }
                if (!isValid)
                    throw new SanityCheckException();
            }
        }
        return isValid;

    }
}
