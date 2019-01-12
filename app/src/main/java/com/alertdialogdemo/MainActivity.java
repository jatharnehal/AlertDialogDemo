package com.alertdialogdemo;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private Context context=this;
    Button btn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn=findViewById(R.id.exit);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                final Dialog dialog=new Dialog(context);
                dialog.setContentView(R.layout.customalert);

                //Alert Dialog Cancle Button method
                Button canclebtn=dialog.findViewById(R.id.cancle);
                canclebtn.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {

                        Toast.makeText(getApplicationContext(),"You clicked on Cancel",Toast.LENGTH_LONG).show();
                    }
                });

//Alert Dialog No Button method
                Button nobtn=dialog.findViewById(R.id.no);

                nobtn.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {

                        Toast.makeText(getApplicationContext(),"You clicked on No",Toast.LENGTH_LONG).show();
                    }
                });


//Alert Dialog Ok Button method
                Button okbtn=dialog.findViewById(R.id.ok);

                okbtn.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        dialog.dismiss();
                        Toast.makeText(getApplicationContext(),"Dismiss",Toast.LENGTH_LONG).show();
                    }
                });
                dialog.show();

            }
        });
    }

    @Override
    public void onBackPressed() {

        AlertDialog.Builder alterDialogBuilder=new AlertDialog.Builder(this);
        alterDialogBuilder.setTitle("Are you sure,You want to exit");

        alterDialogBuilder.setCancelable(false);

        alterDialogBuilder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {

                finish();
            }
        });

        alterDialogBuilder.setNegativeButton("No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {

                Toast.makeText(MainActivity.this,"You clicked over No",Toast.LENGTH_SHORT).show();
            }
        });

        alterDialogBuilder.setNeutralButton("cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {

                Toast.makeText(getApplicationContext(),"You clicked on Cancel",Toast.LENGTH_SHORT).show();
            }
        });


        AlertDialog alertDialog = alterDialogBuilder.create();
        alertDialog.show();
    }
}
