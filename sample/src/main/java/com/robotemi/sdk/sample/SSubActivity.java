package com.robotemi.sdk.sample;

import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.EventListener;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.FirebaseFirestoreException;

//카드정보 받아오기
//데이터 받아오기
//결제시 토스트
public class SSubActivity extends AppCompatActivity {
    private Button btn_back;
    private TextView tv_price, tv_introduce, tv_title;
    String data;
    FirebaseFirestore db = FirebaseFirestore.getInstance();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ssub);
        Intent intent = getIntent();
        BookInfo BI = (BookInfo) intent.getSerializableExtra("BI");

        btn_back = (Button) findViewById(R.id.btn_back);
        btn_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(getApplicationContext(), MainActivity.class);

                startActivity(intent);
            }
        });

        tv_price = (TextView)findViewById(R.id.tv_price);
        tv_title = (TextView)findViewById(R.id.tv_title);

        tv_price.setText(BI.getPrice());
        tv_title.setText(BI.getTitle());

        listenToDocument();
    }
    private void listenToDocument(){
        db.collection("Raspberry").document("rfid").addSnapshotListener(new EventListener<DocumentSnapshot>() {
            @Override
            public void onEvent(@Nullable DocumentSnapshot documentSnapshot, @Nullable FirebaseFirestoreException e) {
                if(e != null){
                    Toast.makeText(getApplicationContext(), e.toString(), Toast.LENGTH_LONG).show();
                    return;
                }
                if(documentSnapshot != null && documentSnapshot.exists()){
                    LayoutInflater inflater = getLayoutInflater();
                    View layout = inflater.inflate(R.layout.toast_border, (ViewGroup)findViewById(R.id.toast_layout_root));
                    TextView text = (TextView) layout.findViewById(R.id.toast_text);



                    // Success
                    data = documentSnapshot.get("rfid_0").toString() + " - " + documentSnapshot.get("rfid_1").toString() + " - " + documentSnapshot.get("rfid_2").toString() + " - " + documentSnapshot.get("rfid_3").toString();
                    if(!data.equals("0 - 0 - 0 - 0")) {
                        Toast toast0 = new Toast(getApplicationContext());
                        toast0.setGravity(Gravity.TOP|Gravity.CENTER, 0, 160);
                        toast0.setView(layout);
                        //toast0.makeText(getApplicationContext(), "결제가 완료되었습니다.\nCard Number : " + data, Toast.LENGTH_LONG);
                        text.setText("결제가 완료되었습니다.\nCard Number : " + data);
                        toast0.setDuration(Toast.LENGTH_LONG);
                        toast0.show();
                    }

                }else{
                    Toast.makeText(getApplicationContext(), "NULL Data", Toast.LENGTH_LONG).show();
                }
            }
        });
    }
}
