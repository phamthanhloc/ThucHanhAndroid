package cntt61.ltdd.apptinhhbh;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    EditText edtcA;
    EditText edtcB;
    EditText edtcH;
    TextView txtKQ;
    Button btTinh;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        edtcA = (EditText)findViewById(R.id.edcA);
        edtcB = (EditText)findViewById(R.id.edcB);
        edtcH = (EditText)findViewById(R.id.edcH);
        txtKQ = (TextView)findViewById(R.id.tvKQ);

    }
    public void TinhCV(View v){
        String cA = edtcA.getText().toString();
        String cB = edtcB.getText().toString();
        double a = Double.parseDouble(cA);
        double b = Double.parseDouble(cB);
        Double chuvi = 2*(a+b);
        String chuoiChuvi = String.valueOf(chuvi);
        txtKQ.setText("Chu vi là:" + chuoiChuvi);
    }

    public void TinhDT(View v){
        String cA = edtcA.getText().toString();
        String cH = edtcH.getText().toString();
        double a = Double.parseDouble(cA);
        double h = Double.parseDouble(cH);
        Double dientich = a*h;
        String chuoiDienTich = String.valueOf(dientich);
        txtKQ.setText("Diện Tích là:" + chuoiDienTich);
    }
}