package com.example.uulbarcode;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.app.Application;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    public static TextView result;
    Button scan;
    MyDBHelper myDBHelper;
    boolean scanned = false;
    public static String GET_UIUID;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setTypes();
        scan.setOnClickListener(this);
    }

    @Override
    protected void onResume() {
        super.onResume();
        if (scanned) {

            myDBHelper = new MyDBHelper(this);
            Cursor getMember = myDBHelper.displayAllMemberData();
            Cursor getExCom = myDBHelper.displayAllEcomData();
            StringBuffer stringBuffer = new StringBuffer();

            while (getMember.moveToNext()) {
                if (GET_UIUID.equals(getMember.getString(2))) {
                    //   Toast.makeText(MainActivity.this, "Scaned", Toast.LENGTH_SHORT).show();

                    stringBuffer.append("Serial No. :   " + getMember.getString(0) + "\n");
                    stringBuffer.append("Name :   " + getMember.getString(1) + "\n");
                    stringBuffer.append("UIU ID :   " + getMember.getString(2) + "\n");
                    stringBuffer.append("Department :   " + getMember.getString(3) + "\n");
                    stringBuffer.append("T-Shirt Size:   " + getMember.getString(10) + "\n");
                    stringBuffer.append("Contact No. :   " + getMember.getString(5) + "\n");
                    stringBuffer.append("Email :   " + getMember.getString(4) + "\n\n\n");

                }
            }
            if (stringBuffer.toString().equals("")) {
                while (getExCom.moveToNext()) {
                    if (GET_UIUID.equals(getExCom.getString(2))) {
                        //   Toast.makeText(MainActivity.this, "Scaned", Toast.LENGTH_SHORT).show();

                        stringBuffer.append("Name :   " + getExCom.getString(0) + " ,  ");
                        stringBuffer.append(getExCom.getString(1) + "\n");
                        stringBuffer.append("UIU ID :   " + getExCom.getString(2) + "\n");
                        stringBuffer.append("Department :   " + getExCom.getString(3) + "\n");
                        stringBuffer.append("T-Shirt Size:   " + getExCom.getString(11) + "\n");
                        stringBuffer.append("Contact No. :   " + getExCom.getString(5) + "\n");
                        stringBuffer.append("Email :   " + getExCom.getString(4) + "\n\n\n");
                    }
                }
            }
            if (!stringBuffer.toString().equals("")) {
                if (GET_UIUID.length() == 9) {
                    showdata(stringBuffer);
                } else {
                    Toast.makeText(MainActivity.this, "Invalid ID", Toast.LENGTH_SHORT).show();
                }
            } else {
                Toast.makeText(MainActivity.this, "Not A Member", Toast.LENGTH_SHORT).show();
            }
        }
    }

    private void showdata(StringBuffer stringBuffer) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Member");
        builder.setMessage(stringBuffer.toString());
        builder.setCancelable(true);
        AlertDialog alertDialog = builder.create();
        alertDialog.show();
    }


    private void setTypes() {
        result = findViewById(R.id.res);
        scan = findViewById(R.id.btnScanBarcode);
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        finish();
        System.exit(0);
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.btnScanBarcode) {
            scanned = true;
            startActivity(new Intent(getApplicationContext(), ScanCodeActivity.class));
        }
    }
}
