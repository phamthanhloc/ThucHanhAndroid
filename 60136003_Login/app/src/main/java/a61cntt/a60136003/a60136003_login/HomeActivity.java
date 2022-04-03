package a61cntt.a60136003.a60136003_login;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class HomeActivity extends AppCompatActivity{
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        Intent Ihome = getIntent();
        TextView tv= (TextView) findViewById(R.id.tvusername);
        tv.setText(String.valueOf(Ihome.getStringExtra("username")));
    }
}
