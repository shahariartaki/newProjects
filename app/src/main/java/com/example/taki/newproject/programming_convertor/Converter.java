package com.example.taki.newproject.programming_convertor;

public class Converter {

    Integer num = -1 ;
    boolean isValid = true;

    public Converter(String s , int base) throws IntOverFlow, SanityCheckException {
        if (!Myutil.sanity_check(s, base)) {
            isValid = false;
            return;
        }
        this.num = Integer.parseInt(s , base);
    }

    public String toHex(){
        return Integer.toHexString(this.num);
    }

    public String toOct(){
        return Integer.toOctalString(this.num);
    }

    public String toDec(){
        return Integer.toString(this.num);
    }

    public String toBin(){
        return Integer.toBinaryString(this.num);
    }

    public String toBase(int base){
        switch(base){
            case(2):
                return toBin();
            case(8):
                return toOct();
            case(10):
                return toDec();
            case(16):
                return toHex();
        }
        return null;
    }
}
