package com.byreytiz.game.gui;

import android.app.Activity;
import android.view.View;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.widget.NestedScrollView;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.byreytiz.game.R;
import com.byreytiz.game.gui.famsetting.Famsetting;
import com.byreytiz.game.gui.famsetting.FamsettingAdapter;
import com.byreytiz.game.gui.famsetting.FamsettingModels;
import com.byreytiz.game.gui.famshop.FamShopAdapter;
import com.byreytiz.game.gui.famshop.FamShopModel;
import com.byreytiz.game.gui.util.Utils;
import com.nvidia.devtech.NvEventQueueActivity;

import java.util.ArrayList;
import java.util.List;

public class FamilyMenu extends AppCompatActivity {
    public NestedScrollView fam_layout;
    public ConstraintLayout fam_items;
    public ImageView quest, autopark, shop, uluch, reiting, setting, exit, plus, back;
    public TextView name_fam, exp, expt;
    public  Activity activity;

    static RecyclerView shopRecycler;
    static FamShopAdapter shopAdapter;

    public RecyclerView autoRecycler;
    int open;
    public FamilyMenu(Activity aactivity){
        activity = aactivity;
        fam_layout = aactivity.findViewById(R.id.fam_layout);
        shopRecycler = aactivity.findViewById(R.id.shopRecycle);
        autoRecycler = aactivity.findViewById(R.id.shopRecycle);
        quest = aactivity.findViewById(R.id.item_1_icon);
        fam_items = aactivity.findViewById(R.id.fam_items);
        autopark = aactivity.findViewById(R.id.item_2_icon);
        back = aactivity.findViewById(R.id.backfam2);
        shop = aactivity.findViewById(R.id.item_3_icon);
        uluch = aactivity.findViewById(R.id.item_4_icon);
        reiting = aactivity.findViewById(R.id.item_5_icon);
        setting = aactivity.findViewById(R.id.famsetting_1);
        exit = aactivity.findViewById(R.id.fam_close);
        plus = aactivity.findViewById(R.id.plus);
        name_fam = aactivity.findViewById(R.id.textnamefam);
        exp = aactivity.findViewById(R.id.textnamefam3);
        expt = aactivity.findViewById(R.id.textnamefam2);
        Utils.HideLayout(fam_layout, false);
        back.setVisibility(View.GONE);
        shopRecycler.setVisibility(View.GONE);
        autopark.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                v.startAnimation(AnimationUtils.loadAnimation(aactivity, R.anim.button_click));
                NvEventQueueActivity.getInstance().FamClickSetting(5);
            }
        });
        uluch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                v.startAnimation(AnimationUtils.loadAnimation(aactivity, R.anim.button_click));
                Famsetting.open = 2;
                NvEventQueueActivity.getInstance().FamClickSetting(4); // улучшения
            }
        });
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Utils.HideLayout(shopRecycler, true);
                Utils.ShowLayout(fam_items, true);
                back.setVisibility(View.GONE);
                open = 0;
            }
        });
        exit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Utils.HideLayout(fam_layout, true);
                NvEventQueueActivity.getInstance().HideSettingf();
            }
        });
        setting.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                v.startAnimation(AnimationUtils.loadAnimation(aactivity, R.anim.button_click));
                NvEventQueueActivity.getInstance().FamClickSetting(13); // инфа о семье
            }
        });
        quest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                v.startAnimation(AnimationUtils.loadAnimation(aactivity, R.anim.button_click));
                NvEventQueueActivity.getInstance().showquets();
            }
        });
        shop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                v.startAnimation(AnimationUtils.loadAnimation(aactivity, R.anim.button_click));
                show_shop();
            }
        });
    }
    public void showf(String name, int num, int num2){
        Utils.ShowLayout(fam_layout, true);
        name_fam.setText(name);
        exp.setText(String.format("%d", num));
        expt.setText(String.format("%d", num2));
    }
    private void setShopRecycler(List<FamShopModel> shopList) {
        RecyclerView.LayoutManager layoutManager = new GridLayoutManager(this, 3, RecyclerView.VERTICAL, false);
        shopRecycler.setLayoutManager(layoutManager);

        shopAdapter = new FamShopAdapter(activity, shopList);
        shopRecycler.setAdapter(shopAdapter);
    }
    public void show_shop() {
        Utils.HideLayout(fam_items, true);
        back.setVisibility(View.VISIBLE);
        List<FamShopModel> shopList = new ArrayList<>();
        shopList.add(new FamShopModel(1, "КЕЙС", "tuning_icon_box", 80));
        shopList.add(new FamShopModel(2, "МАСКА АНОНИМУСА", "aks_dias", 120));
        shopList.add(new FamShopModel(3, "ШЛЯПА ВЕДЬМЫ", "aks_kranin", 100));
        shopList.add(new FamShopModel(4, "КРЫЛЬЯ АНГЕЛА", "aks_krilyaangela", 90));
        shopList.add(new FamShopModel(5, "МАСКА ГРИНЧ", "aks_grinch", 140));
        shopList.add(new FamShopModel(6, "МЕТЛА ВЕДЬМЫ", "aks_kasha", 200));
        shopList.add(new FamShopModel(7, "ПАНАМА", "aks_visokaya", 100));
        shopList.add(new FamShopModel(8, "ПОСОХ", "aks_siniyaposoxa", 150));
        setShopRecycler(shopList);
        Utils.ShowLayout(autoRecycler, true);
        open = 1;
    }
}
