package sk.srecyclerview;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.Collection;

import sk.srecyclerview_library.SRecyclerViewAdapter;

/**
 * Created by SK on 2017-06-12.
 */

public class TestAdapter extends RecyclerView.Adapter<TestAdapter.TestViewHolder> {

    private ArrayList<String> mDataList = new ArrayList<>();

    @Override
    public TestAdapter.TestViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new TestViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_test, parent, false));
    }

    @Override
    public void onBindViewHolder(TestViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return mDataList.size();
    }

    public void setDataList(Collection<String> list) {
        this.mDataList.clear();
        this.mDataList.addAll(list);
        notifyDataSetChanged();
    }

    public void addAll(Collection<String> list) {
        int lastIndex = this.mDataList.size();
        if (this.mDataList.addAll(list)) {
            notifyItemRangeInserted(lastIndex, list.size());
        }
    }

    public void remove(int position) {
        this.mDataList.remove(position);
        notifyItemRemoved(position);

        if (position != (mDataList.size())) { // 如果移除的是最后一个，忽略
            notifyItemRangeChanged(position, this.mDataList.size()-position);
        }
    }

    public void clear() {
        mDataList.clear();
        notifyDataSetChanged();
    }

    class TestViewHolder extends RecyclerView.ViewHolder {

        public TestViewHolder(View itemView) {
            super(itemView);
        }
    }
}
