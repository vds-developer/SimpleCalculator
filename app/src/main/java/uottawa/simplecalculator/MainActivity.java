package uottawa.simplecalculator;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

//import android.support.v7.app.AppCompatActivity;

public class MainActivity extends Activity {


    Boolean reset = false;
    Boolean error = false;
    Operator operator = Operator.none;
    TextView result;
    Button btn00;
    Button btn01;
    Button btn02;
    Button btn03;
    Button btn04;
    Button btn05;
    Button btn06;
    Button btn07;
    Button btn08;
    Button btn09;
    Button btnAdd;
    Button btnMinus;
    Button btnDivide;
    Button btnMultiply;
    Button btnClear;
    Button btnResult;
    private double data1 = 0, data2 = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        result = (TextView) findViewById(R.id.resultEdit);
        btn00 = (Button) findViewById(R.id.btn00);
        btn01 = (Button) findViewById(R.id.btn01);
        btn02 = (Button) findViewById(R.id.btn02);
        btn03 = (Button) findViewById(R.id.btn03);
        btn04 = (Button) findViewById(R.id.btn04);
        btn05 = (Button) findViewById(R.id.btn05);
        btn06 = (Button) findViewById(R.id.btn06);
        btn07 = (Button) findViewById(R.id.btn07);
        btn08 = (Button) findViewById(R.id.btn08);
        btn09 = (Button) findViewById(R.id.btn09);
        btnAdd = (Button) findViewById(R.id.btnAdd);
        btnMinus = (Button) findViewById(R.id.btn08);
        btnDivide = (Button) findViewById(R.id.btn09);
        btnMultiply = (Button) findViewById(R.id.btnAdd);
        btnClear = (Button) findViewById(R.id.btn09);
        btnResult = (Button) findViewById(R.id.btnAdd);
    }

    public void btn00CLick(View view) {
        if (!error && !reset) {
            if (result.getText().toString().equals("0")) result.setText("");
            result.setText(result.getText() + "0");
        }

    }

    public void btn01CLick(View view) {
        if (!error && !reset) {
            if (result.getText().toString().equals("0")) result.setText("");
            result.setText(result.getText() + "1");
        }

    }

    public void btn02CLick(View view) {
        if (!error && !reset) {
            if (result.getText().toString().equals("0")) result.setText("");
            result.setText(result.getText() + "2");
        }
    }

    public void btn03CLick(View view) {
        if (!error && !reset) {
            if (result.getText().toString().equals("0")) result.setText("");
            result.setText(result.getText() + "3");
        }
    }

    public void btn04CLick(View view) {
        if (!error && !reset) {
            if (result.getText().toString().equals("0")) result.setText("");
            result.setText(result.getText() + "4");
        }
    }

    public void btn05CLick(View view) {
        if (!error && !reset) {
            if (result.getText().toString().equals("0")) result.setText("");
            result.setText(result.getText() + "5");
        }
    }

    public void btn06CLick(View view) {
        if (!error && !reset) {
            if (result.getText().toString().equals("0")) result.setText("");
            result.setText(result.getText() + "6");
        }
    }

    public void btn07CLick(View view) {
        if (!error && !reset) {
            if (result.getText().toString().equals("0")) result.setText("");
            result.setText(result.getText() + "7");
        }
    }

    public void btn08CLick(View view) {
        if (!error && !reset) {
            if (result.getText().toString().equals("0")) result.setText("");
            result.setText(result.getText() + "8");
        }
    }

    public void btn09CLick(View view) {
        if (!error && !reset) {
            if (result.getText().toString().equals("0")) result.setText("");
            result.setText(result.getText() + "9");
        }
    }

    public void btnAddCLick(View view) {
        if (!error && Character.isDigit(result.getText().toString().charAt(result.length() - 1))) {
            if (operator != Operator.none) {
                this.btnResultCLick(view);
            }
            operator = Operator.add;
            data1 = Double.parseDouble(result.getText().toString());
            result.setText(result.getText() + "+");
            reset = false;
        }

    }

    public void btnMinusCLick(View view) {
        if (!error && Character.isDigit(result.getText().toString().charAt(result.length() - 1))) {
            if (operator != Operator.none) {
                this.btnResultCLick(view);
            }
            operator = Operator.minus;
            data1 = Double.parseDouble(result.getText().toString());
            result.setText(result.getText() + "-");
            reset = false;

        }
    }

    public void btnMultiplyCLick(View view) {
        if (!error && Character.isDigit(result.getText().toString().charAt(result.length() - 1))) {
            if (operator != Operator.none) {
                this.btnResultCLick(view);
            }
            data1 = Double.parseDouble(result.getText().toString());
            result.setText(result.getText() + "*");
            operator = Operator.multiply;
            reset = false;

        }
    }

    public void btnDivideCLick(View view) {
        if (!error && !result.getText().toString().equals("0") && Character.isDigit(result.getText().toString().charAt(result.length() - 1))) {
            if (operator != Operator.none) {
                this.btnResultCLick(view);
            }
            data1 = Double.parseDouble(result.getText().toString());
            result.setText(result.getText() + "/");
            operator = Operator.divide;
            reset = false;

        }
    }

    public void btnClearCLick(View view) {
        result.setText("0");
        operator = Operator.none;
        data1 = Double.parseDouble(result.getText().toString());
        error = false;
        reset = false;

    }

    public void btnDotCLick(View view) {
        if (!error) {
            String parseString = result.getText().toString();
            if (operator != Operator.none) {
                if (operator == Operator.add) {
                    parseString = parseString.substring(parseString.indexOf("+") + 1);
                } else if (operator == Operator.minus) {
                    parseString = parseString.substring(parseString.indexOf("-") + 1);
                } else if (operator == Operator.multiply) {
                    parseString = parseString.substring(parseString.indexOf("*") + 1);
                } else { // divide
                    parseString = parseString.substring(parseString.indexOf("/") + 1);
                }
            }
            if (!parseString.contains(".")) {
                if (result.getText().length() == 0) {
                    result.setText(result.getText() + "0");
                }
                result.setText(result.getText() + ".");
            }
        }

    }

    public void btnResultCLick(View view) {
        if (operator != Operator.none) {
            double endResult = 0;
            String text = result.getText().toString();
            if (operator == Operator.add) {
                data2 = Double.parseDouble(text.substring(text.indexOf("+") + 1));
                endResult = data1 + data2;
            } else if (operator == Operator.minus) {
                data2 = Double.parseDouble(text.substring(text.indexOf("-") + 1));
                endResult = data1 - data2;
            } else if (operator == Operator.multiply) {
                data2 = Double.parseDouble(text.substring(text.indexOf("*") + 1));
                endResult = data1 * data2;
            } else { // divide
                data2 = Double.parseDouble(text.substring(text.indexOf("/") + 1));
                if (data2 != 0) {
                    endResult = data1 / data2;
                } else {
                    result.setText("Error");
                    error = true;
                }

            }
            operator = Operator.none;
            data1 = endResult;
            result.setText(Double.toString(endResult));
            reset = true;
        }

    }

    private enum Operator {none, add, minus, multiply, divide}

}
