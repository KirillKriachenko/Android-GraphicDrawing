package kriachenkocom.kirill.kyrylokriachenko_comp304_003test1;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.SparseBooleanArray;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private static final String APP_PREFERENCES = "myPreference";
    public static final String APP_PREFERENCES_NAME = "FirmName";
    SharedPreferences mySharedPreferences;
    TextView selection;

    String chosenFirm;
    ListView listView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mySharedPreferences = getSharedPreferences(APP_PREFERENCES, Context.MODE_PRIVATE);




        listView = (ListView)findViewById(R.id.listView);

        final String[] stocks_firm_names = getResources().getStringArray(R.array.stocks);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_multiple_choice, stocks_firm_names);
        listView.setAdapter(adapter);

    }

    public void showChart(View view)
    {
        SharedPreferences.Editor editor = mySharedPreferences.edit();
        editor.clear();
        editor.apply();

        int count = 1;
        int len = listView.getCount();
        SparseBooleanArray checked = listView.getCheckedItemPositions();
        for (int i = 0; i < len; i++)
        {
            if(checked.get(i))
            {
                String item = listView.getItemAtPosition(i).toString();
                 editor = mySharedPreferences.edit();
                        editor.putString(APP_PREFERENCES_NAME+count, item);
                        editor.apply();

                count+=1;
//                Context context = getApplicationContext();
//                int duration = Toast.LENGTH_SHORT;
//                Toast toast = Toast.makeText(context, item, duration);
//                toast.show();
            }
        }
        Intent intent  = new Intent(this, StockPriceActivity.class);
        startActivity(intent);
    }
}
