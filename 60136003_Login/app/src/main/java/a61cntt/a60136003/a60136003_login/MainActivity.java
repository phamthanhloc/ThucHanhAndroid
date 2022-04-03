package a61cntt.a60136003.a60136003_login;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button btnlog = (Button)findViewById(R.id.btnLogin);
        btnlog.setOnClickListener(XulytruocLogin);
    }

    View.OnClickListener XulytruocLogin = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent Ilogin = new Intent(MainActivity.this, LoginActivity.class);
            startActivity(Ilogin);
        }
    };
}