package com.agile.ondemand.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.agile.ondemand.R;
import com.agile.ondemand.model.feedback;

import java.util.List;

public class FeedbackAdapter extends RecyclerView.Adapter<FeedbackAdapter.FeedbackViewHolder> {

    Context context;
    List<feedback> feedbackList;

    public FeedbackAdapter(Context context, List<feedback> feedbackList) {
        this.context = context;
        this.feedbackList = feedbackList;
    }

    @NonNull
    @Override
    public FeedbackViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.feedback_recycler, parent, false);
        return new FeedbackViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull FeedbackViewHolder holder, int position) {
        final feedback feedback = feedbackList.get(position);
        holder.rate.setText(feedback.getRating());
        holder.comment.setText(feedback.getComment());
        holder.commentBy.setText(feedback.getCommentBy().getUsername());

    }

    @Override
    public int getItemCount() {
        return feedbackList.size();
    }

    public class FeedbackViewHolder extends RecyclerView.ViewHolder {

        TextView rate, comment, commentBy;

        public FeedbackViewHolder(@NonNull View itemView) {
            super(itemView);

            rate = itemView.findViewById(R.id.tvRate);
            comment = itemView.findViewById(R.id.tvComment);
            commentBy = itemView.findViewById(R.id.tvCommentBy);
        }
    }

}
