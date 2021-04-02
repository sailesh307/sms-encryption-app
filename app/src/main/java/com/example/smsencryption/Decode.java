package com.example.smsencryption;

import static java.lang.Math.pow;

public class Decode {

    public static String dec(String s){

        String inv="This code was not encrypted by SMS Encrypter";
        String initializer="11111111";

        for(int i=0;i<8;i++){
            if(initializer.charAt(i)!=s.charAt(i)){
                return inv; //if starting 8 char are not 1 then string is invalid as per the algo
            }
        }
        /*separating prefix*/
        String data="";
        for (int i=8;i<s.length();i++){
            char temp=s.charAt(i);
            data=data.concat(String.valueOf(temp));
        }

        if(data.length()%7!=0)
            return inv; // if data length is not in multiple of 7 string is invalid as per the algo






        /*changing string binary to integer binary of 7 bit */
        int asc[][]=new int[1101][8];
        int idx=1;
        int idx2=0;

        for (int i=0;i<data.length();i++){
            if(i%7==0) {
                idx++;
                idx2 = 0;
            }
            char temp=data.charAt(i);
            asc[idx][idx2]=temp-'0';
            idx2++;
        }

        int num[]=new int[11111];
        int nidx=0;
        int temp=0;
        int ct=0;
        for (int i=0;i<=idx;i++){
            ct=0;
            temp=0;
            for (int j=6;j>=0;j--){
                int temp1=(int)pow(2,ct);
                temp+=asc[i][j]*temp1;
                ct++;
            }
            num[nidx++]=temp;
        }
        String rv="";
        char ch;
        for (int i=0;i<nidx;i++){
            ch=(char)num[i];
            rv=rv.concat(String.valueOf(ch));
        }

        return rv;
    }
}
