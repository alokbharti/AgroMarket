package garg.hackfest;

import android.app.ProgressDialog;
import android.os.Handler;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class NewsActivity extends AppCompatActivity {

    private RecyclerView mRecyclerView;
    private List<News> mNewsList;
    private NewsAdapter mNewsAdapter;
    private String Url="https://newsapi.org/v2/everything?sources=the-times-of-india&q=Farmer&apiKey=2012066be1c944409c701878d544b5fc";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_news);
        setTitle("News");
        mRecyclerView = (RecyclerView) findViewById(R.id.recylerView);
        mRecyclerView.setHasFixedSize(false);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));

        mNewsList = new ArrayList<News>();
        mNewsAdapter = new NewsAdapter(this,mNewsList);
        mRecyclerView.setAdapter(mNewsAdapter);

        getNewsData(Url);
        mNewsAdapter.notifyDataSetChanged();

        final SwipeRefreshLayout swipeRefreshLayout = (SwipeRefreshLayout)(findViewById(R.id.swipe_refresh_layout));
        swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                mNewsList.clear();
                getNewsData(Url);
                mNewsAdapter.notifyDataSetChanged();

                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        swipeRefreshLayout.setRefreshing(false);
                    }
                },4000);
            }
        });

    }

    private void getNewsData(String url) {

        //Initialising dialog box
        final ProgressDialog progressDialog = new ProgressDialog(this);
        progressDialog.setMessage("Loading Data....");
        progressDialog.show();

        StringRequest stringRequest = new StringRequest(Request.Method.GET, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        progressDialog.dismiss();

                        Log.e("inside onResponse","reached");

                        try{
                            JSONObject jsonObject = new JSONObject(response);
                            JSONArray jsonArray = jsonObject.getJSONArray("articles");

                            Log.e("inside try block","reached");

                            for(int i=0; i<jsonArray.length();i++){
                                JSONObject object = jsonArray.getJSONObject(i);
                                News item = new News(object.getString("title"),object.getString("description")
                                        ,object.getString("urlToImage"),object.getString("url"));
                                mNewsList.add(item);
                                mNewsAdapter.notifyDataSetChanged();
                            }

                            if(mNewsList.size()==0){
                                Toast.makeText(getApplicationContext(),"That was Last Page",Toast.LENGTH_SHORT).show();
                            }

                        }catch(JSONException e){
                            //progressDialog.dismiss();
                            e.printStackTrace();
                            Toast.makeText(getApplicationContext(), "try again", Toast.LENGTH_SHORT).show();

                        }


                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                progressDialog.dismiss();

                Toast.makeText(getApplicationContext(), "Check your Internet", Toast.LENGTH_SHORT).show();

            }
        });

        //Requesting using volley
        RequestQueue requestQueue = Volley.newRequestQueue(this);
        requestQueue.add(stringRequest);

    }
}
