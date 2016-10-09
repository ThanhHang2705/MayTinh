package com.example.thanhhang.maytinh;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private Button btx1, btx2, btx3, btx4, btx5, btx6, btx7, btx8, btx9, btx0;
    private Button btx_cong, btx_tru, btx_nhan, btx_chia, btx_cham, btx_bang;
    private Button btx_xetdau, btx_binhphuong, btxDel, btxC;
    private TextView edt_kqua;
    String a="", b="", dau;
    Double kqua=0d;

    boolean chuyenve = false;
    boolean click = false;
    String tam_kq ="";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // khong cân -.-
        setContentView(R.layout.activity_main);
        btx1 = (Button) findViewById(R.id.btx1);
        btx2 = (Button) findViewById(R.id.btx2);
        btx3 = (Button) findViewById(R.id.btx3);
        btx4 = (Button) findViewById(R.id.btx4);
        btx5 = (Button) findViewById(R.id.btx5);
        btx6 = (Button) findViewById(R.id.btx6);
        btx7 = (Button) findViewById(R.id.btx7);
        btx8 = (Button) findViewById(R.id.btx8);
        btx9 = (Button) findViewById(R.id.btx9);
        btx0 = (Button) findViewById(R.id.btx0);
        btx_cham = (Button) findViewById(R.id.btx_cham);

        btx_binhphuong = (Button) findViewById(R.id.btx_binhphuong);
        btx_binhphuong.setOnClickListener(this);

        btx_xetdau = (Button)findViewById(R.id.btx_xetdau);
        btx_xetdau.setOnClickListener(this);

        btxDel = (Button) findViewById(R.id.btx_Del);
        btxDel.setOnClickListener(this);

        btxC = (Button) findViewById(R.id.btx_C);
        btxC.setOnClickListener(this);
       edt_kqua = (TextView) findViewById(R.id.edt_kqua);
        // dat su kien
        btx_cong = (Button) findViewById(R.id.btx_cong);
        btx_cong.setOnClickListener(this);

        btx_tru = (Button) findViewById(R.id.btx_tru);
        btx_tru.setOnClickListener(this);

        btx_nhan = (Button) findViewById(R.id.btx_nhan);
        btx_nhan.setOnClickListener(this);

        btx_chia = (Button) findViewById(R.id.btx_chia);
        btx_chia.setOnClickListener(this);



        btx_bang = (Button) findViewById(R.id.btx_bang);
        btx_bang.setOnClickListener(this);

    }

    //bấm cộng trừ nhân chia sẽ chạy vào đây

    @Override
    public void onClick(View v) {

        switch (v.getId()) {
            case R.id.btx_cong:
            case R.id.btx_tru:
            case R.id.btx_nhan:
            case R.id.btx_chia:
                congTruNhanChia(v);
                break;
            case R.id.btx_bang:
                bang();
                break;
            case R.id.btx_Del:
              delChar();
                break;
            case  R.id.btx_C:
               delAll();
            default:
                break;

        }


    }


   // bấm vào số sẽ chạy vào đây
    public void so_click(View so) {
       if (!chuyenve) {
           tam_kq = tam_kq.concat(((Button) so).getText().toString());
           edt_kqua.setText(tam_kq);
        } else {
           b = b.concat(((Button) so).getText().toString());
           tam_kq = tam_kq.concat(((Button) so).getText().toString());

           edt_kqua.setText(tam_kq);
        }

    }

// tinh toan
    private void bang() {
        /*
        String so[] = tam_kq.split("[+-x/]");
        a = so[0];
        b = so[1];
        */
        if (a.length() > 0 && b.length() > 0) {
            switch (dau) {
                case "+":
                    kqua = Double.valueOf(a) + Double.valueOf(b);
                    break;
                case "-":
                    kqua = Double.valueOf(a) - Double.valueOf(b);
                    break;

                case "x":
                    kqua = Double.valueOf(a) * Double.valueOf(b);
                    break;
                default:
                    kqua = Double.valueOf(a) / Double.valueOf(b);

            }
        } else {
            Toast.makeText(this, "ERROR!", Toast.LENGTH_LONG).show();
        }
        edt_kqua.setText(Double.toString(kqua));
    }

    // xu li cong tru nhan chia
    private void congTruNhanChia(View v){
        chuyenve = true;

        if(click){//neu da click dau 1 lan roi
            bang();
            a = kqua.toString();
            dau = ((Button) v).getText().toString();
            tam_kq =kqua.toString() + dau;
        }else{ // neu chua
            dau = ((Button) v).getText().toString();
            a=tam_kq;
            tam_kq +=dau;
            click = true;
        }
        b="";

        edt_kqua.setText(tam_kq);
    }

    private void delAll(){
        edt_kqua.setText("0");
        kqua=0d;
        a="";
        b="";
        tam_kq ="";
        chuyenve = false;
        click = false;

    }

    private void delChar(){
        tam_kq = tam_kq.substring(1,tam_kq.length()-1);
    }
}
