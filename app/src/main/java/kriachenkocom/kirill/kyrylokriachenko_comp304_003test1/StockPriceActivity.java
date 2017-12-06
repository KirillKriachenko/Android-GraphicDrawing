package kriachenkocom.kirill.kyrylokriachenko_comp304_003test1;

import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.Map;

public class StockPriceActivity extends AppCompatActivity {

    private static final String APP_PREFERENCES = "myPreference";
    public static final String APP_PREFERENCES_NAME = "FirmName";
    SharedPreferences mySharedPreferences;

    TextView textView;
    String name;
    Map<String, String> allPreferences;

    TextView colorText;

    int getDrawColor;
    ImageView imageView ;//=(ImageView) findViewById(R.id.imageView);
    Bitmap bitmap;
    Canvas canvas;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stock_price);

        textView = (TextView)findViewById(R.id.textView2);
        colorText = (TextView)findViewById(R.id.colorText);

        imageView =(ImageView) findViewById(R.id.imageView);
        bitmap = Bitmap.createBitmap(368, 300, Bitmap.Config.ARGB_8888);

        canvas = new Canvas(bitmap);

        mySharedPreferences = getSharedPreferences(APP_PREFERENCES, Context.MODE_PRIVATE);
        try {
            allPreferences = (Map<String, String>) mySharedPreferences.getAll();

            for (Map.Entry<String, ?> entry : allPreferences.entrySet()) {
                //name += entry.getKey()+": " + entry.getValue().toString();
                String value = (String) entry.getValue();
                if(value.equals("IBM"))
                {
                    int sX = 0;
                    int sY = 0;
                    int eX = 0;
                    int eY = 0;
                    String[] values = getResources().getStringArray(R.array.ibmStockValues);
                    for (int i = 0; i < values.length - 1; i++)
                    {
                        sY = Integer.parseInt(values[i]);
                        eX = sX+100;
                        eY = Integer.parseInt(values[i+1]);
                        onDraw(imageView,sX,sY,eX,eY,Color.RED,3);
                        sX = sX+100;
                    }
                    colorText.append("IBM - Red line \n");

                }
                if(value.equals("AAPL"))
                {
                    int sX = 0;
                    int sY = 0;
                    int eX = 0;
                    int eY = 0;
                    String[] values = getResources().getStringArray(R.array.aaplStockValues);
                    for (int i = 0; i < values.length - 1; i++)
                    {
                        sY = Integer.parseInt(values[i]);
                        eX = sX+100;
                        eY = Integer.parseInt(values[i+1]);
                        onDraw(imageView,sX,sY,eX,eY,Color.GREEN,3);
                        sX = sX+100;
                    }
                    colorText.append("AAPL - Green line \n");

                }
                if(value.equals("ORCL"))
                {
                    int sX = 0;
                    int sY = 0;
                    int eX = 0;
                    int eY = 0;
                    String[] values = getResources().getStringArray(R.array.orclStockValues);
                    for (int i = 0; i < values.length - 1; i++)
                    {
                        sY = Integer.parseInt(values[i]);
                        eX = sX+100;
                        eY = Integer.parseInt(values[i+1]);
                        onDraw(imageView,sX,sY,eX,eY,Color.BLUE,3);
                        sX = sX+100;
                    }
                    colorText.append("ORCL - Blue line \n");

                }
                if(value.equals("MSFT"))
                {
                    int sX = 0;
                    int sY = 0;
                    int eX = 0;
                    int eY = 0;
                    String[] values = getResources().getStringArray(R.array.msftStockValues);
                    for (int i = 0; i < values.length - 1; i++)
                    {
                        sY = Integer.parseInt(values[i]);
                        eX = sX+100;
                        eY = Integer.parseInt(values[i+1]);
                        onDraw(imageView,sX,sY,eX,eY,Color.DKGRAY,3);
                        sX = sX+100;
                    }

                    colorText.append("MSFT - Gray line \n");

                }

                if(value.equals("GOOG"))
                {
                    int sX = 0;
                    int sY = 0;
                    int eX = 0;
                    int eY = 0;
                    String[] values = getResources().getStringArray(R.array.googStockValues);
                    for (int i = 0; i < values.length - 1; i++)
                    {
                        sY = Integer.parseInt(values[i]);
                        eX = sX+100;
                        eY = Integer.parseInt(values[i+1]);
                        onDraw(imageView,sX,sY,eX,eY,Color.YELLOW,3);
                        sX = sX+100;
                    }
                    colorText.append("GOOG - Red line \n");

                }

                name += entry.getValue().toString() + " ";
            }

            textView.setText(name);
        }
        catch (Throwable e)
        {Log.d("EXCEPTION:" , e.toString());}

    }


    public void onDraw(View view,int startX,int startY,int endX,int endY, int color, int thikness)
    {
        Paint paint = new Paint(Paint.ANTI_ALIAS_FLAG);
        paint.setColor(color);
        paint.setStrokeWidth(thikness);
        canvas.drawLine(startX,startY,endX,endY,paint);
        imageView.setImageBitmap(bitmap);
    }

}
