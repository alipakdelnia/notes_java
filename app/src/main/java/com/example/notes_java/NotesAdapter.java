package com.example.notes_java;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;

public class NotesAdapter extends RecyclerView.Adapter<NotesAdapter.ViewHolder> {

    private ArrayList<String> notes;

    public NotesAdapter(ArrayList<String> notes) {
        this.notes = notes;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.note_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        // اطلاعات مورد نظر را از لیست دریافت کرده و در ViewHolder قرار می‌دهیم
        String note = notes.get(position);
        holder.titleTextView.setText("عنوان " + position);  // موضوع
        holder.contentTextView.setText(note.substring(0, Math.min(note.length(), 20)) + "...");  // متن (20 کاراکتر اول)
        holder.iconImageView.setImageResource(R.drawable.ic_launcher_foreground);  // آیکون
    }

    @Override
    public int getItemCount() {
        return notes.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        TextView titleTextView;
        TextView contentTextView;
        ImageView iconImageView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            titleTextView = itemView.findViewById(R.id.tv_title_note);
            contentTextView = itemView.findViewById(R.id.tv_note);
            iconImageView = itemView.findViewById(R.id.iv_ic_notes);
        }
    }
}
