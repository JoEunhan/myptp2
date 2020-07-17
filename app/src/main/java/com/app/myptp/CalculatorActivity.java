package com.app.myptp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;



import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Stack;

import static android.app.ProgressDialog.show;

public class CalculatorActivity extends AppCompatActivity {
    Button btn0;
    Button btn1;
    Button btn2;
    Button btn3;
    Button btn4;
    Button btn5;
    Button btn6;
    Button btn7;
    Button btn8;
    Button btn9;

    Button btnc;
    Button btnp;
    Button btnm;
    Button btnpm;
    Button btnx;
    Button btnd;
    Button btnr;

    TextView txt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculator);

        txt = (TextView) findViewById(R.id.board_tv);
        btn0 = (Button) findViewById(R.id.button0);
        btn1 = (Button) findViewById(R.id.button1);
        btn2 = (Button) findViewById(R.id.button2);
        btn3 = (Button) findViewById(R.id.button3);
        btn4 = (Button) findViewById(R.id.button4);
        btn5 = (Button) findViewById(R.id.button5);
        btn6 = (Button) findViewById(R.id.button6);
        btn7 = (Button) findViewById(R.id.button7);
        btn8 = (Button) findViewById(R.id.button8);
        btn9 = (Button) findViewById(R.id.button9);

        btnc = (Button) findViewById(R.id.buttonC);
        btnp = (Button) findViewById(R.id.buttonplus);
        btnm = (Button) findViewById(R.id.buttonminus);
        btnpm = (Button) findViewById(R.id.buttonpm);
        btnx = (Button) findViewById(R.id.buttonX);
        btnd = (Button) findViewById(R.id.buttondivide);
        btnr = (Button) findViewById(R.id.buttonr);

        btnr.setOnClickListener(new Button.OnClickListener() {

            @Override
            public void onClick(View v) {
                if (txt.length() > 0) {
                    txt.setText(String.valueOf(result(txt)));
                }

            }
        });
        btnc.setOnClickListener(new Button.OnClickListener() {

            @Override
            public void onClick(View v) {
                txt.setText("");

            }
        });
        btnp.setOnClickListener(new Button.OnClickListener() {

            @Override
            public void onClick(View v) {
                if (txt.length() > 0) txt.append("+");

            }
        });
        btnm.setOnClickListener(new Button.OnClickListener() {

            @Override
            public void onClick(View v) {
                if (txt.length() > 0) txt.append("-");

            }
        });
        btnx.setOnClickListener(new Button.OnClickListener() {

            @Override
            public void onClick(View v) {
                if (txt.length() > 0) txt.append("x");

            }
        });

        btnd.setOnClickListener(new Button.OnClickListener() {

            @Override
            public void onClick(View v) {
                if (txt.length() > 0) txt.append("/");

            }
        });


        btn0.setOnClickListener(new Button.OnClickListener() {

            @Override
            public void onClick(View v) {
                if (txt.length() > 0) txt.append("0");
                else txt.setText("0");

            }

        });
        btn1.setOnClickListener(new Button.OnClickListener() {

            @Override
            public void onClick(View v) {
                if (txt.length() > 0) txt.append("1");
                else txt.setText("1");

            }

        });
        btn2.setOnClickListener(new Button.OnClickListener() {

            @Override
            public void onClick(View v) {
                if (txt.length() > 0) txt.append("2");
                else txt.setText("2");

            }


        });
        btn3.setOnClickListener(new Button.OnClickListener() {

            @Override
            public void onClick(View v) {
                if (txt.length() > 0) txt.append("3");
                else txt.setText("3");

            }

        });
        btn4.setOnClickListener(new Button.OnClickListener() {

            @Override
            public void onClick(View v) {

                if (txt.length() > 0) txt.append("4");
                else txt.setText("4");

            }

        });
        btn5.setOnClickListener(new Button.OnClickListener() {

            @Override
            public void onClick(View v) {
                if (txt.length() > 0) txt.append("5");
                else txt.setText("5");

            }

        });
        btn6.setOnClickListener(new Button.OnClickListener() {

            @Override
            public void onClick(View v) {
                if (txt.length() > 0) txt.append("6");
                else txt.setText("6");

            }

        });
        btn7.setOnClickListener(new Button.OnClickListener() {

            @Override
            public void onClick(View v) {
                if (txt.length() > 0) txt.append("7");
                else txt.setText("7");

            }

        });
        btn8.setOnClickListener(new Button.OnClickListener() {

            @Override
            public void onClick(View v) {
                if (txt.length() > 0) txt.append("8");
                else txt.setText("8");

            }

        });

        btn9.setOnClickListener(new Button.OnClickListener() {

            @Override
            public void onClick(View v) {
                if (txt.length() > 0) txt.append("9");
                else txt.setText("9");

            }

        });
        btnpm.setOnClickListener(new Button.OnClickListener(){

            @Override
            public void onClick(View v){
                if(txt.length()==0){
                    switch(String.valueOf(txt.getText())){
                        case("+"):
                            txt.setText("+");
                            break;
                        case("-"):
                            txt.setText("-");
                            break;
                    }

                }
                if(txt.length()>0){
                    String s = String.valueOf(txt.getText()) ;
                    int i =Integer.parseInt(s);
                    i=i*(-1);
                    s = String.valueOf(i);
                    txt.setText(s);

                }

            }




        });


    }


    public static int result(TextView txt) {

        String exp = String.valueOf(txt.getText());
        if(exp.charAt(exp.length()-1)=='+'||exp.charAt(exp.length()-1)=='-'||exp.charAt(exp.length()-1)=='x'||exp.charAt(exp.length()-1)=='/')
            exp=exp.substring(0,exp.length()-1);
        ArrayList<String> arr = new ArrayList<>();
        String ns = "";
        for (int i = 0; i < exp.length(); i++) {

            if (ns.equals("") || (exp.charAt(i) != '+' && exp.charAt(i) != '-' && exp.charAt(i) != 'x' && exp.charAt(i) != '/')) {
                ns += String.valueOf(exp.charAt(i));
            } else if (String.valueOf(exp.charAt(i)).equals("+") || String.valueOf(exp.charAt(i)).equals("-") || String.valueOf(exp.charAt(i)).equals("x") || String.valueOf(exp.charAt(i)).equals("/")) {
                if (!ns.equals("")) arr.add(ns);
                arr.add(String.valueOf(exp.charAt(i)));
                ns = "";
            }


        }
        arr.add(ns);
        System.out.println(arr);

        Stack<String> stack = new Stack<>();
        int len = arr.size();
        String postFix = "";

        for (int i = 0; i < len; i++) {

            String ch = arr.get(i);

            if (ch.equals("+") || ch.equals("-") || ch.equals("x") || ch.equals("/")) {

                switch (ch) {
                    case "+":
                    case "-":
                    case "x":
                    case "/":
                        while (!stack.isEmpty() && isProceed(stack.peek(), ch))
                            postFix += stack.pop() + " ";
                        stack.push(ch);
                        break;
                }

            } else {
                postFix += ch + " ";

            }
        }
        //System.out.println(postFix);
        //System.out.println(stack);

        while (!stack.isEmpty())
            postFix = postFix + " " + stack.pop();
        System.out.println(postFix);
        String[] pp = postFix.split(" ");

        //System.out.println("this is pp");
        for (int i = 0; i < pp.length; i++) {
            System.out.println(pp[i]);
        }
        //System.out.println("end");
        return calPostfix(pp);

    }

    public static boolean isProceed(String op1, String op2) {

        int op1Prec = getOpPrec(op1);
        int op2Prec = getOpPrec(op2);

        if (op1Prec >= op2Prec)
            return true;
        else
            return false;

    }

    public static int getOpPrec(String op) {

        switch (op) {
            case "x":
            case "/":
                return 5;

            case "+":
            case "-":
                return 3;

        }
        return -1;
    }

    public static int calPostfix(String[] input) {

        Stack<Integer> stack = new Stack<>();
        int len = input.length;

        for (int i = 0; i < len; i++) {
            String ns = "";
            //char op = input.charAt(i);
            String op = input[i];
            if (op.equals(" ") || op.equals("")) continue;
            if (op.equals("+") || op.equals("-") || op.equals("x") || op.equals("/")) {

                int op2 = stack.pop();
                int op1 = stack.pop();

                switch (op) {

                    case "+":
                        stack.push(op1 + op2);
                        break;
                    case "-":
                        stack.push(op1 - op2);
                        break;
                    case "x":
                        stack.push(op1 * op2);
                        break;
                    case "/":
                        stack.push(op1 / op2);
                        break;
                }
            } else {

                stack.push(Integer.parseInt(op));

            }
        }


        return (int) stack.pop();
    }
}

