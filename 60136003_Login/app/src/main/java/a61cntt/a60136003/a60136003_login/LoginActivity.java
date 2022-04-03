package a61cntt.a60136003.a60136003_login;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


public class LoginActivity extends AppCompatActivity{

    EditText edtuser, edtpass, edtemail;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        Button btnok = (Button)findViewById(R.id.btnOk);
        btnok.setOnClickListener(XulysauLogin);
    }

    View.OnClickListener XulysauLogin = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            edtuser = (EditText)findViewById(R.id.eduser);
            edtpass = (EditText)findViewById(R.id.edpass);
            edtemail = (EditText)findViewById(R.id.edemail);
            String tk = "Phạm Thành Lộc";
            String mk = "61cntt";
            String email = "locpt152@gmail.com";
            String x = edtuser.getText().toString();
            String y = edtpass.getText().toString();
            String z = edtemail.getText().toString();
            if ((x.equals(tk)) && (y.equals(mk)) && (z.equals(email))) {
                Toast.makeText(LoginActivity.this, "Đăng nhập thành công", Toast.LENGTH_SHORT).show();
                Intent Ihome = new Intent(LoginActivity.this, HomeActivity.class);
                Ihome.putExtra("username", x);
                startActivity(Ihome);
            } else
                Toast.makeText(LoginActivity.this, "Lỗi vui lòng đăng nhập lại !", Toast.LENGTH_SHORT).show();
        }
    };
}
