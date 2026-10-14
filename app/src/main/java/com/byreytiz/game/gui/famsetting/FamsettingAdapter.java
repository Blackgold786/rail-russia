package com.byreytiz.game.gui.famsetting;

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

public class FamsettingAdapter extends RecyclerView.Adapter<FamsettingAdapter.FamViewHolder> {

    Context context;
    List<FamsettingModels> famList;

    static int slvl1,  slvl2,  slvl3, scash,  smaxcash,  smats,  smask,  sfuels,  sammos,  spuples;
    public FamsettingAdapter(Context context, List<FamsettingModels> list) {
        this.context = context;
        this.famList = list;
    }

    @NonNull
    @Override
    public FamViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View test_items = LayoutInflater.from(context).inflate(R.layout.fam_setting_item, parent, false);
        return new FamViewHolder(test_items);
    }

    @Override
    public void onBindViewHolder(@NonNull FamViewHolder holder, int position) {

        holder.item_name.setText(famList.get(position).getName());
        holder.item_name.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                v.startAnimation(AnimationUtils.loadAnimation(context, R.anim.button_click));
                switch (famList.get(position).getId()) {

                    case 1: NvEventQueueActivity.getInstance().showsetting(); break; // настройка семьи
                    case 2: NvEventQueueActivity.getInstance().FamClickSetting(2); break; // управление сеиьей
                    case 3: NvEventQueueActivity.getInstance().showsclad(); break; // склад
                    case 4: NvEventQueueActivity.getInstance().FamClickSetting(4); Famsetting.open = 3; break; // улчшения
                    case 5: NvEventQueueActivity.getInstance().FamClickSetting(5); break; // автопарк
                    case 6: NvEventQueueActivity.getInstance().FamClickSetting(6); break; // семейные логи
                    case 7: NvEventQueueActivity.getInstance().FamClickSetting(7); break; // черный список
                    case 8: NvEventQueueActivity.getInstance().FamClickSetting(8); break; // покинуть семью
                    case 9: NvEventQueueActivity.getInstance().FamClickSetting(9); break; // сейф
                    case 10: NvEventQueueActivity.getInstance().FamClickSetting(10); break; // склад
                    case 11: NvEventQueueActivity.getInstance().FamClickSetting(11); break; // настройка рангов
                    case 12: NvEventQueueActivity.getInstance().FamClickSetting(12); break; // цвет чата семьи
                    case 13: NvEventQueueActivity.getInstance().showvquets(1); break;
                    case 14: NvEventQueueActivity.getInstance().showvquets(2); break;
                    case 15: NvEventQueueActivity.getInstance().showvquets(3); break;
                    case 16: NvEventQueueActivity.getInstance().showvquets(4); break;
                    case 17: NvEventQueueActivity.getInstance().showvquets(5); break;
                    case 18: NvEventQueueActivity.getInstance().showvquets(6); break;
                    case 19: NvEventQueueActivity.getInstance().textulych(1, slvl1,  slvl2,  slvl3, scash,  smaxcash,  smats,  smask,  sfuels,  sammos,  spuples); break;
                    case 20: NvEventQueueActivity.getInstance().textulych(2, slvl1,  slvl2,  slvl3, scash,  smaxcash,  smats,  smask,  sfuels,  sammos,  spuples); break;
                    case 21: NvEventQueueActivity.getInstance().textulych(3, slvl1,  slvl2,  slvl3, scash,  smaxcash,  smats,  smask,  sfuels,  sammos,  spuples); break;

                }
            }
        });
    }
    @Override
    public int getItemCount() {
        return famList.size();
    }
    public static final class FamViewHolder extends RecyclerView.ViewHolder {
        TextView item_name;
        public FamViewHolder(@NonNull View itemView) {
            super(itemView);

            item_name = itemView.findViewById(R.id.button_fam);
        }
    }
}
