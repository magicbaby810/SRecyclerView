package sk.srecyclerview;

import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;

import java.util.ArrayList;

import sk.srecyclerview_library.SRecyclerView;
import sk.srecyclerview_library.SRecyclerViewAdapter;

public class MainActivity extends AppCompatActivity implements SwipeRefreshLayout.OnRefreshListener {

    private SwipeRefreshLayout swipeRefreshLayout;
    private SRecyclerView sRecyclerView;
    private SRecyclerViewAdapter sRecyclerViewAdapter;
    private TestAdapter adapter;
    private ArrayList<String> mDataList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        swipeRefreshLayout = (SwipeRefreshLayout) findViewById(R.id.swipe_refresh_layout);
        swipeRefreshLayout.setColorSchemeResources(android.R.color.holo_blue_light, android.R.color.holo_orange_light, android.R.color.holo_red_light, android.R.color.holo_green_light);
        swipeRefreshLayout.setProgressViewOffset(true, 0, AppUtils.dip2px(this, 24));
        swipeRefreshLayout.setOnRefreshListener(this);
        swipeRefreshLayout.setRefreshing(true);


        sRecyclerView = (SRecyclerView) findViewById(R.id.recycler_view);

        mDataList.add("nihao");
        mDataList.add("nihao");
        mDataList.add("nihao");
        mDataList.add("nihao");
        mDataList.add("nihao");
        mDataList.add("nihao");

        adapter = new TestAdapter();
        adapter.setDataList(mDataList);
        swipeRefreshLayout.setRefreshing(false);

        sRecyclerViewAdapter = new SRecyclerViewAdapter(adapter);
        sRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        sRecyclerView.setHasFixedSize(true);
        sRecyclerView.setLoadMoreEnabled(true);
        sRecyclerView.setAdapter(sRecyclerViewAdapter);
    }

    @Override
    public void onRefresh() {
        adapter.setDataList(mDataList);
        swipeRefreshLayout.setRefreshing(false);
    }
}
