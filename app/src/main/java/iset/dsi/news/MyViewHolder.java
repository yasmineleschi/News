package iset.dsi.news;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class MyViewHolder extends RecyclerView.ViewHolder {
    ImageView img;
    TextView t1,t2;
    public MyViewHolder(@NonNull View itemView) {
        super(itemView);
        img = itemView.findViewById(R.id.img);
        t1 = itemView.findViewById(R.id.news);
        t2 = itemView.findViewById(R.id.date);


    }

    public void bind(News news) {
        img.setImageResource(news.getImage());
        t2.setText(news.getDate());
        t1.setText(news.getTitle());
        
        
    }
}
