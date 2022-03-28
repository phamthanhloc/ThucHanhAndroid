package a61cntt.a60136003.a60136003bai16;

import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.app.Activity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;


public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //1. Lấy dữ liệu từ strings.xml
        String[] source = getResources().getStringArray(R.array.data);
        //2. Lấy đối tượng Listview dựa vào id
        ListView lv=(ListView) findViewById(R.id.lvhienthi);
        //3. Gán Data source vào ArrayAdapter
        ArrayAdapter<String> adapter = new ArrayAdapter<String>
                (this, android.R.layout.simple_list_item_1, source);
        //4. Đưa Data source vào ListView
        lv.setAdapter(adapter);
        final TextView txt=(TextView) findViewById(R.id.tvhienthi);
        //5. Thiết lập sự kiện cho Listview, khi chọn phần tử nào thì hiển thị lên TextView
        lv.setOnItemClickListener(
                new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> arg0,
                                            View arg1,
                                            int arg2,
                                            long arg3) {
                        String selectedItem = (String) arg0.getItemAtPosition(arg2);
                        //đối số arg2 là vị trí phần tử trong Data Source (source)
                        txt.setText("position :"+arg2+" ; value ="+source[arg2]);
                    }
                });
    }

}
