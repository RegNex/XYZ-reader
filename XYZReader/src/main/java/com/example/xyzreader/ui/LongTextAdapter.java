package com.example.xyzreader.ui;

import android.database.Cursor;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.xyzreader.R;
import com.example.xyzreader.data.ArticleLoader;

import butterknife.BindView;
import butterknife.ButterKnife;

public class LongTextAdapter extends RecyclerView.Adapter<LongTextAdapter.LongTextViewHolder> {

    private Cursor cursor;

    public LongTextAdapter(Cursor cursor) {
        this.cursor = cursor;
    }

    @NonNull
    @Override
    public LongTextViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler_text_view, parent, false);
        return new LongTextViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull LongTextViewHolder holder, int position) {
        holder.bindViews(cursor.getString(ArticleLoader.Query.BODY));
    }

    @Override
    public int getItemCount() {
        return cursor.getCount();
    }

    class LongTextViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.article_body)
        TextView mTextView;

        public LongTextViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }

        public void bindViews(String text) {
            mTextView.setText(Html.fromHtml(text.replaceAll("(\r\n|\n)", "<br />")));

        }
    }
}
