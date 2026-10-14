package com.byreytiz.game.gui.famshop;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.byreytiz.game.R;
import com.nvidia.devtech.NvEventQueueActivity;

import java.util.Formatter;
import java.util.List;

public class FamShopAdapter extends RecyclerView.Adapter<FamShopAdapter.CarViewHolder> {

    Context context;
    List<FamShopModel> FamShopModels;


    public FamShopAdapter(Context context, List<FamShopModel> famShopModels) {
        this.context = context;
        this.FamShopModels = famShopModels;
    }

    @NonNull
    @Override
    public CarViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View test_items = LayoutInflater.from(context).inflate(R.layout.fam_shop_item, parent, false);
        return new CarViewHolder(test_items);
    }

    @Override
    public void onBindViewHolder(@NonNull CarViewHolder holder, int position) {

        int imgid = context.getResources().getIdentifier(FamShopModels.get(position).getImg(), "drawable", context.getPackageName());
        holder.item_img.setImageResource(imgid);

        holder.item_name.setText(FamShopModels.get(position).getName());
        holder.item_cost.setText(new Formatter().format("%d", Integer.valueOf(FamShopModels.get(position).getCost())).toString());
        holder.item_img_bg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //v.startAnimation(AnimationUtils.loadAnimation(context, R.anim.button_click));
                NvEventQueueActivity.getInstance().FamClickShop(FamShopModels.get(position).getId(), FamShopModels.get(position).getCost());
                /*switch (FamShopModels.get(position).getId()) {

                    case 1: NvEventQueueActivity.getInstance().FamClickShop(FamShopModels.get(position).getId(), FamShopModels.get(position).getCost()); break;
                    case 2: NvEventQueueActivity.getInstance().FamClickShop(FamShopModels.get(position).getId(), FamShopModels.get(position).getCost()); break;
                    case 3: NvEventQueueActivity.getInstance().FamClickShop(FamShopModels.get(position).getId(), FamShopModels.get(position).getCost()); break;
                    case 4: NvEventQueueActivity.getInstance().FamClickShop(FamShopModels.get(position).getId(), FamShopModels.get(position).getCost()); break;
                    case 5: NvEventQueueActivity.getInstance().FamClickShop(FamShopModels.get(position).getId(), FamShopModels.get(position).getCost()); break;
                    case 6: NvEventQueueActivity.getInstance().FamClickShop(FamShopModels.get(position).getId(), FamShopModels.get(position).getCost()); break;
                    case 7: NvEventQueueActivity.getInstance().FamClickShop(FamShopModels.get(position).getId(), FamShopModels.get(position).getCost()); break;
                    case 8: NvEventQueueActivity.getInstance().FamClickShop(FamShopModels.get(position).getId(), FamShopModels.get(position).getCost()); break;

                }*/
            }
        });
    }
    @Override
    public int getItemCount() {
        return FamShopModels.size();
    }
    public List getItems() {
        return FamShopModels;
    }
    public static final class CarViewHolder extends RecyclerView.ViewHolder {
        ImageView item_img, item_img_bg;
        TextView item_cost, item_name;

        public CarViewHolder(@NonNull View itemView) {
            super(itemView);

            item_img = itemView.findViewById(R.id.imagefamshopitem);
            item_img_bg = itemView.findViewById(R.id.imagefamshopitem_bg);
            item_cost = itemView.findViewById(R.id.textfamshopitem2);
            item_name = itemView.findViewById(R.id.textfamshopitem);
        }
    }
}
