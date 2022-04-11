package phamthanhloc.baikt2.baikt2;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText edtuser, edtpass;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button btnlog = (Button) findViewById(R.id.btnlogin);
        btnlog.setOnClickListener(XulyLogin);
    }

    View.OnClickListener XulyLogin = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            edtuser = (EditText) findViewById(R.id.eduser);
            edtpass = (EditText) findViewById(R.id.edpass);
            String tk = "locpham";
            String mk = "123";
            String a = edtuser.getText().toString();
            String b = edtpass.getText().toString();
            if((a.equals(tk)) && (b.equals(mk))) {
                Toast.makeText(MainActivity.this, "User and Password is correct", Toast.LENGTH_SHORT).show();
                Intent Itip = new Intent(MainActivity.this, CalculatorActivity.class);
                startActivity(Itip);
            }
            else
                Toast.makeText(MainActivity.this, "User and Password is wrong", Toast.LENGTH_SHORT).show();
        }
    };
}