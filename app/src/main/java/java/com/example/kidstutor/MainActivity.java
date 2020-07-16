package java.com.example.kidstutor;



import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        java.com.example.kidstutor.NumberClickListener numberClickListener=new java.com.example.kidstutor.NumberClickListener();
           // linking with xml layouts and call listeners
        TextView textView=(TextView)findViewById(R.id.textView1);
        textView.setOnClickListener(new java.com.example.kidstutor.NumberClickListener(){
            @Override
            public void onClick(View v) {
                super.onClick(v);
                Intent intent=new Intent(MainActivity.this,NumbersActivity.class);
                startActivity(intent);
                Toast.makeText(MainActivity.this,"you visited numbers",Toast.LENGTH_LONG).show();
            }
        });
        TextView textViewa=(TextView)findViewById(R.id.textView3);
        textViewa.setOnClickListener(new java.com.example.kidstutor.NumberClickListener(){
            @Override
            public void onClick(View v) {
                super.onClick(v);
                Intent intent=new Intent(MainActivity.this,FamilyActivity.class);
                startActivity(intent);
                Toast.makeText(MainActivity.this,"you visited family",Toast.LENGTH_LONG).show();

            }
        });
        TextView textViewb=(TextView)findViewById(R.id.textView4);
        textViewb.setOnClickListener(new java.com.example.kidstutor.NumberClickListener(){
            @Override
            public void onClick(View v) {
                super.onClick(v);
                Intent intent=new Intent(MainActivity.this,ColorsActivity.class);
                startActivity(intent);
                Toast.makeText(MainActivity.this,"you visited colors",Toast.LENGTH_LONG).show();

            }
        });
        TextView textViewc=(TextView)findViewById(R.id.textView5);
        textViewc.setOnClickListener(new java.com.example.kidstutor.NumberClickListener(){
            @Override
            public void onClick(View v) {
                super.onClick(v);
                Intent intent=new Intent(MainActivity.this,PhraseActivity.class);
                startActivity(intent);
                Toast.makeText(MainActivity.this,"you visited phrases",Toast.LENGTH_LONG).show();

            }
        });

    }
// all done till now

}

