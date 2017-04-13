package betheracer.devincontactstest;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity {

    private RequestQueue requestQueue;
    private RequestQueue requestQueue1;
    private StringRequest request;
    private StringRequest request1;
    private static final String URL = "http://iblind7.godo.co.kr/shop/proc/test.php";
    private static final String URL1 = "http://iblind7.godo.co.kr/shop/proc/test1.php";

    TextView textView;




    Response.Listener<String> listener =  new Response.Listener<String>() {
        @Override
        public void onResponse(String response) {

            textView.setText(response);

        }
    };


    Response.ErrorListener errorListener = new Response.ErrorListener() {
        @Override
        public void onErrorResponse(VolleyError error) {

            textView.setText("Error");

        }
    };




    Response.Listener<String> listener1 = new Response.Listener<String>() {
        @Override
        public void onResponse(String response) {

            textView.setText(response);
        }
    };


    Response.ErrorListener errorListener1 = new Response.ErrorListener() {
        @Override
        public void onErrorResponse(VolleyError error) {

            textView.setText("Error test1.php");
        }
    };






    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = (TextView) findViewById(R.id.textView);

        requestQueue = Volley.newRequestQueue(this);
        requestQueue1 = Volley.newRequestQueue(this);

        request = new StringRequest(Request.Method.POST, URL, listener, errorListener) {

            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                return super.getParams();
            }
        };
        requestQueue.add(request);

        Button button1 = (Button) findViewById(R.id.button1);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textView.setText("Button Clicked");

                request1 = new StringRequest(Request.Method.POST, URL1, listener1, errorListener1) {
                    @Override
                    protected Map<String, String> getParams() throws AuthFailureError {
                        Map<String, String> hashMap = new HashMap<String, String>();
                        hashMap.put("aaa", "bbb");
                        hashMap.put("ccc", "ddd");
                        //return super.getParams();
                        return hashMap;
                    }
                };
                requestQueue1.add(request1);


            }
        });

    }
}
