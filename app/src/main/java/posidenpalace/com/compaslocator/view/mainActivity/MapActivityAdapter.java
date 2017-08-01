package posidenpalace.com.compaslocator.view.mainActivity;


import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.List;

import posidenpalace.com.compaslocator.R;
import posidenpalace.com.compaslocator.model.Banks;

public class MapActivityAdapter extends RecyclerView.Adapter<MapActivityAdapter.ViewHolder> {
   List<Banks> banksList = new ArrayList<>();

    public MapActivityAdapter(List<Banks> banksList) {
        this.banksList = banksList;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.items_list,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        final Banks bank = banksList.get(position);
        holder.name.setText("Name: "+bank.getResult().getName());
        holder.location.setText("Location: " + bank.getResult().getFormattedAddress());
       // holder.openTimes.setText("Open: " + bank.getResult().getOpeningHours().getOpenNow());
        Glide.with(holder.itemView.getContext()).load(bank.getResult().getIcon()).into(holder.icon);
        holder.container.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }

    @Override
    public int getItemCount() {
        return banksList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView name;
        TextView location;
        TextView openTimes;
        ImageView icon;
        LinearLayout container;
        public ViewHolder(View itemView) {
            super(itemView);
            name = (TextView) itemView.findViewById(R.id.tvName);
            location= (TextView) itemView.findViewById(R.id.tvLocation);
            openTimes= (TextView) itemView.findViewById(R.id.tvOpen);
            icon = (ImageView) itemView.findViewById(R.id.ivIcon);
            container = (LinearLayout) itemView.findViewById(R.id.llItemsList);
        }
    }
}
