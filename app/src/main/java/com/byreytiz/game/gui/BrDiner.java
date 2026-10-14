package com.byreytiz.game.gui;

import android.app.Activity;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.nvidia.devtech.NvEventQueueActivity;
import com.byreytiz.game.gui.util.Utils;

import com.byreytiz.game.R;

public class BrDiner {
    public Activity activity;
    public LinearLayout br_diner, br_diner_hotdog, br_diner_cheburek, br_diner_pie, br_diner_sausage, br_diner_coffee, br_diner_tea;
    public TextView br_diner_price_0, br_diner_price_1, br_diner_price_2, br_diner_price_3, br_diner_price_4, br_diner_price_5;
    public TextView br_diner_satiety_0, br_diner_satiety_1, br_diner_satiety_2, br_diner_satiety_3, br_diner_satiety_4, br_diner_satiety_5;
    public TextView br_diner_price_sum;
    public RelativeLayout br_diner_purchase_button;
    public Button close_button;
    public boolean[] buttons = new boolean[6];
    public int[] prices = new int[] {120, 230, 320, 580, 80, 30}; //прайсы
    public int[] satiety = new int[]{5, 10, 15, 20, 3, 2}; //кол во сытости
    public int sum = 0;
    public int satietys = 0;
    public BrDiner(Activity aactivity) {
        activity = aactivity;
        br_diner = aactivity.findViewById(R.id.br_diner);
        br_diner.setVisibility(View.GONE);

        br_diner_price_0 = aactivity.findViewById(R.id.br_diner_price_0);
        br_diner_price_1 = aactivity.findViewById(R.id.br_diner_price_1);
        br_diner_price_2 = aactivity.findViewById(R.id.br_diner_price_2);
        br_diner_price_3 = aactivity.findViewById(R.id.br_diner_price_3);
        br_diner_price_4 = aactivity.findViewById(R.id.br_diner_price_4);
        br_diner_price_5 = aactivity.findViewById(R.id.br_diner_price_5);

        br_diner_satiety_0 = aactivity.findViewById(R.id.br_diner_satiety_0);
        br_diner_satiety_1 = aactivity.findViewById(R.id.br_diner_satiety_1);
        br_diner_satiety_2 = aactivity.findViewById(R.id.br_diner_satiety_2);
        br_diner_satiety_3 = aactivity.findViewById(R.id.br_diner_satiety_3);
        br_diner_satiety_4 = aactivity.findViewById(R.id.br_diner_satiety_4);
        br_diner_satiety_5 = aactivity.findViewById(R.id.br_diner_satiety_5);

        br_diner_hotdog = aactivity.findViewById(R.id.br_diner_hotdog);
        br_diner_cheburek = aactivity.findViewById(R.id.br_diner_cheburek);
        br_diner_pie = aactivity.findViewById(R.id.br_diner_pie);
        br_diner_sausage = aactivity.findViewById(R.id.br_diner_sausage);
        br_diner_coffee = aactivity.findViewById(R.id.br_diner_coffee);
        br_diner_tea = aactivity.findViewById(R.id.br_diner_tea);

        br_diner_hotdog.setOnClickListener(view -> click(view, 0));
        br_diner_cheburek.setOnClickListener(view -> click(view, 1));
        br_diner_pie.setOnClickListener(view -> click(view, 2));
        br_diner_sausage.setOnClickListener(view -> click(view, 3));
        br_diner_coffee.setOnClickListener(view -> click(view, 4));
        br_diner_tea.setOnClickListener(view -> click(view, 5));

        br_diner_price_sum = aactivity.findViewById(R.id.br_diner_price_sum);
        br_diner_purchase_button = aactivity.findViewById(R.id.br_diner_purchace_button);
        br_diner_purchase_button.setOnClickListener(view -> {
            if(sum > 0) {
                NvEventQueueActivity.getInstance().sendDiner(sum, satietys);
                Hide();
                resetbacks();
                updateTotalPrice();
            }
        });

        close_button = aactivity.findViewById(R.id.close_button);
        close_button.setOnClickListener( view -> {
            Hide();
        });

        setPrice();
        setSatiety();
    }

    public void click(View view, int i) {
        buttons[i] = !buttons[i];
        if (buttons[i]) {
            view.setBackgroundResource(R.drawable.bg_button_red_unfilled_ss);
        } else {
            view.setBackgroundResource(R.drawable.bg_button_gray);
        }
        updateTotalPrice();
    }

    public void updateTotalPrice() {
        int totalPrice = 0;
        int totalSatiety = 0;
        for (int i = 0; i < buttons.length; i++) {
            if (buttons[i]) {
                totalPrice += prices[i];
                totalSatiety += satiety[i];
            }
        }
        sum = totalPrice;
        satietys = totalSatiety;
        br_diner_price_sum.setText("Общая стоимость: " + totalPrice + " рублей");
        if (totalPrice > 0) {
            br_diner_purchase_button.setAlpha(1.0f);
            br_diner_purchase_button.setEnabled(true);
        } else {
            br_diner_purchase_button.setAlpha(0.5f);
            br_diner_purchase_button.setEnabled(false);
        }
    }

    public void resetbacks() {
        for (int i = 0; i < buttons.length; i++) {
            buttons[i] = false;
            resetback(i);
        }
    }
    public void resetback(int i) {
        View view = null;
        switch (i) {
            case 0: view = br_diner_hotdog; break;
            case 1: view = br_diner_cheburek; break;
            case 2: view = br_diner_pie; break;
            case 3: view = br_diner_sausage; break;
            case 4: view = br_diner_coffee; break;
            case 5: view = br_diner_tea; break;
        }
        if (view != null) {
            view.setBackgroundResource(R.drawable.bg_button_gray);
        }
    }
    public void setPrice() {
        TextView[] br_diner_prices = new TextView[] {
                br_diner_price_0,
                br_diner_price_1,
                br_diner_price_2,
                br_diner_price_3,
                br_diner_price_4,
                br_diner_price_5
        };
        for (int i = 0; i < br_diner_prices.length; i++) {
            br_diner_prices[i].setText("Стоимость: " + prices[i] + " ₽");
        }
    }
    public void setSatiety() {
        TextView[] br_diner_satiety = new TextView[] {
                br_diner_satiety_0,
                br_diner_satiety_1,
                br_diner_satiety_2,
                br_diner_satiety_3,
                br_diner_satiety_4,
                br_diner_satiety_5
        };
        for (int i = 0; i < br_diner_satiety.length; i++) {
            br_diner_satiety[i].setText("Сытость: " + satiety[i] + " ед.");
        }
    }

    public void Show() {
        Utils.ShowLayout(br_diner, true);
        NvEventQueueActivity.getInstance().togglePlayer(1);
    }

    public void Hide() {
        Utils.HideLayout(br_diner, true);
        NvEventQueueActivity.getInstance().togglePlayer(0);
    }
}
