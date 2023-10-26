package iset.dsi.news;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;


public class MyAdapter extends RecyclerView.Adapter<MyViewHolder> {

    ArrayList<News> newsList;
    Context context;
    private final InterfaceItem interfaceItem;

    public MyAdapter(ArrayList<News> newsList, Context context, InterfaceItem interfaceItem) {
        this.newsList = newsList;
        this.context = context;
        this.interfaceItem = interfaceItem;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.news_item, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        News news = newsList.get(position);
        holder.bind(news);
        holder.itemView.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if (interfaceItem != null){
                            int pos = holder.getAdapterPosition();
                            if ( pos != RecyclerView.NO_POSITION){
                                interfaceItem.onItemClick(pos);
                            }
                        }
                    }
                }
        );

    }

    @Override
    public int getItemCount() {
        return newsList.size();
    }
}