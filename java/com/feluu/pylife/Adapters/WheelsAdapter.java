package com.feluu.pylife.Adapters;

import android.content.Context;
import androidx.recyclerview.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.feluu.pylife.R;

import java.util.List;

public class WheelsAdapter extends RecyclerView.Adapter<WheelsAdapter.WheelsViewHolder> {

    private Context mCtx;
    private List<Adapter> wheelsList;

    public WheelsAdapter(Context mCtx, List<Adapter> wheelsList) {
        this.mCtx = mCtx;
        this.wheelsList = wheelsList;
    }

    @Override
    public WheelsViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(mCtx);
        View view = inflater.inflate(R.layout.wheels_layout, null);
        return new WheelsViewHolder(view);
    }

    @Override
    public void onBindViewHolder(WheelsViewHolder holder, int position) {
        Adapter wheels = wheelsList.get(position);

        holder.textViewName.setText(wheels.getName());
        holder.textViewPrice.setText(wheels.getFirst());
        holder.textViewDemont.setText(wheels.getSecond());
        Glide
                .with(mCtx)
                .load(mCtx.getResources().getDrawable(wheels.getImage()))
                .placeholder(R.drawable.ic_loading)
                .error(R.drawable.ic_error)
                .apply(RequestOptions.circleCropTransform())
                .into(holder.imageView2);
    }

    @Override
    public int getItemCount() {
        return wheelsList.size();
    }

    class WheelsViewHolder extends RecyclerView.ViewHolder {

        private TextView textViewName, textViewPrice, textViewDemont;
        private ImageView imageView2;

        public WheelsViewHolder(View itemView) {
            super(itemView);

            textViewName = itemView.findViewById(R.id.wheelsName);
            textViewPrice = itemView.findViewById(R.id.price);
            textViewDemont = itemView.findViewById(R.id.demont);
            imageView2 = itemView.findViewById(R.id.imageView2);
        }
    }
}