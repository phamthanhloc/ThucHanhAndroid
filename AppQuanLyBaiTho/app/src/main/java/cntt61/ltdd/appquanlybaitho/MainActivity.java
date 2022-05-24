package cntt61.ltdd.appquanlybaitho;


import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    SQLiteDatabase databaseTho;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        databaseTho = SQLiteDatabase.openOrCreateDatabase("/data/data/cntt61.ltdd.appquanlybaitho/MyBook.db", null);
        TaoBangVaThemDuLieu();
        NapSACHvaoListview();
        Button nutXoa = (Button) findViewById(R.id.btnXoa);
        EditText edChon = (EditText) findViewById(R.id.edtMaCHON);
        nutXoa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String maTho = edChon.getText().toString();
                int ma = Integer.parseInt(maTho);
                XoaTho(ma);
            }
        });
    }
    void TaoBangVaThemDuLieu() {
        String sqlXoaBang = "DROP TABLE IF EXISTS THO";
        databaseTho.execSQL(sqlXoaBang);
        String sqlTaoBang = "CREATE TABLE THO(     ThoID integer PRIMARY KEY, " +
                "   Ten, " +
                "   TacGia)";
        databaseTho.execSQL(sqlTaoBang);
        String sqlThem1 = "INSERT INTO THO VALUES(1, 'Mẹ và Quả', 'Nguyễn Khoa Điềm')";
        databaseTho.execSQL(sqlThem1);
        String sqlThem2 = "INSERT INTO THO VALUES(2, 'Việt Nam Quê Hương Ta', 'Nguyễn Đình Thi')";
        databaseTho.execSQL(sqlThem2);
        String sqlThem3 = "INSERT INTO THO VALUES(3, 'Sang Thu', 'Hữu Thỉnh') ";
        databaseTho.execSQL(sqlThem3);
        String sqlThem4 = "INSERT INTO THO VALUES(4, 'Tràng Giang', 'Huy Cận')";
        databaseTho.execSQL(sqlThem4);
        String sqlThem5 = "INSERT INTO THO VALUES(5, 'Miền Trung', 'Hoàng Trần Cương')";
        databaseTho.execSQL(sqlThem5);
    }
    void NapSACHvaoListview() {
        ListView listView = (ListView) findViewById(R.id.lvTho);
        ArrayList<String> dsTho = new ArrayList<String>();
        Cursor cs = databaseTho.rawQuery("SELECT * FROM THO", null);
        cs.moveToFirst();
        while (true) {
            if (cs.isAfterLast() == true) break;
            int ms = cs.getInt(0);
            String tenTho = cs.getString(1);
            String tacgia = cs.getString(2);
            String dong = String.valueOf(ms) + " --- " +
                    tenTho + "----" + String.valueOf(tacgia);
            dsTho.add(dong);
            cs.moveToNext();

        }

        ArrayAdapter adapter = new ArrayAdapter(this,
                android.R.layout.simple_list_item_1,
                dsTho);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                String dongChon = dsTho.get(i);
                int k = dongChon.indexOf(" ");
                String ma = dongChon.substring(0, k);
                EditText edChon = (EditText) findViewById(R.id.edtMaCHON);
                edChon.setText(ma);
            }
        });
    }
    void XoaTho(int ma) {
        String[] thamSoTruyen = {String.valueOf(ma)};
        int kq = databaseTho.delete("BOOKS", "BookID=?", thamSoTruyen);
        if (kq == 0)
            Toast.makeText(this, "Không xóa  được", Toast.LENGTH_LONG).show();
        else {
            Toast.makeText(this, "Xóa thành công", Toast.LENGTH_LONG).show();
        }
    }

}