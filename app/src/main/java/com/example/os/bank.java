package com.example.os;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class bank extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bank);
        Intent in=getIntent();
        String a=in.getStringExtra(gv.e1),m=in.getStringExtra(gv.e2),av=in.getStringExtra(gv.e3);
        TextView h=findViewById(R.id.textView);
        String[] avr= a.split("\r\n|\r|\n");
        String[] mv= m.split("\r\n|\r|\n");
        String f="",lp="";
        for(int i=0;i<mv.length;i++)
        {
            String[] p= mv[i].split(" "),d=avr[i].split(" ");
            f= f+Integer.toString(Integer.parseInt(p[0])-Integer.parseInt(d[0]));
            for(int j=1;j<p.length;j++)
                f=f+" "+Integer.toString(Integer.parseInt(p[j])-Integer.parseInt(d[j]));
              f+="\n";
        }
        int n=mv.length;
        int[] p=new int[n];
        for(int i=0;i<n;i++)
            p[i]=1;
        while(true)
        {
            int fl = 0;
            for (int i = 0; i < n; i++)
            {
                if (p[i] == 0)
                    continue;
                else
                {
                    int fe = 0;
                    for (int j = 0; j <mv[i].split(" ").length ; j++)
                        if (Integer.parseInt(f.split("\r\n|\r|\n")[i].split(" ")[j]) > Integer.parseInt(av.split(" ")[j]))
                        {
                            fe = 1;
                            break;
                        }
                    String temp="";
                    if (fe == 0)
                    {
                       lp=lp+"P"+(i + 1)+"(";
                        for (int j = 0; j < mv[i].split(" ").length - 1; j++)
                        {
                            temp=temp+Integer.toString(Integer.parseInt(av.split(" ")[j]) +Integer.parseInt(a.split("\r\n|\r|\n")[i].split(" ")[j]))+" ";
                            lp=lp+Integer.toString(Integer.parseInt(av.split(" ")[j]) +Integer.parseInt(a.split("\r\n|\r|\n")[i].split(" ")[j]))+", ";;
                        }
                        temp=temp+Integer.toString(Integer.parseInt(av.split(" ")[mv[i].split(" ").length-1]) +Integer.parseInt(a.split("\r\n|\r|\n")[i].split(" ")[mv[i].split(" ").length-1]));
                        lp=lp+Integer.toString(Integer.parseInt(av.split(" ")[mv[i].split(" ").length-1]) +Integer.parseInt(a.split("\r\n|\r|\n")[i].split(" ")[mv[i].split(" ").length-1]))+")\n";
                        p[i] = 0;
                        fl = 1;
                        av=temp;
                        continue;
                    }
                }
            }
            if (fl == 0)
                break;
        }
        h.setText(lp);
    }

}