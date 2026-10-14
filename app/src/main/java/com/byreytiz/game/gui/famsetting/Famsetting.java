package com.byreytiz.game.gui.famsetting;

import android.app.Activity;
import android.view.View;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.byreytiz.game.R;
import com.byreytiz.game.gui.util.Utils;
import com.nvidia.devtech.NvEventQueueActivity;

import java.util.ArrayList;
import java.util.List;

public class Famsetting extends AppCompatActivity {

    static RecyclerView testRecycler;
    static FamsettingAdapter testAdapter;

    public RecyclerView autoRecycler;
    public ConstraintLayout famskladinfo, test_main, faminfor, famtext;
    public  Activity activity;
    public ImageView btnstart, btnstart2, back, pers;
    public TextView textfamquest11, textfamquest8, textfamquest9, textfamquest6, textfamquest5, textfamquest7 ,textfamquest, famtextmain, main_text2, main_text, namep, status, rep, colichestvo, lvl_sclad, lvl_gun, lvl_sostav, money, mats, mask, fuel, ammo, armor;

    public static int open = 0;
    int id, qid;
    public Famsetting(Activity aactivity){
        activity = aactivity;
        autoRecycler = activity.findViewById(R.id.famsettinglist);
        test_main = activity.findViewById(R.id.famsettingmain);
        famtext = activity.findViewById(R.id.famtext);
        testRecycler = activity.findViewById(R.id.famsettinglist);
        famskladinfo = activity.findViewById(R.id.famskladinfo);
        famtextmain = activity.findViewById(R.id.textfamquest2);
        textfamquest = activity.findViewById(R.id.textfamquest);
        textfamquest9 = activity.findViewById(R.id.textfamquest9);
        textfamquest8 = activity.findViewById(R.id.textfamquest8);
        textfamquest11 = activity.findViewById(R.id.textfamquest11);
        textfamquest6 = activity.findViewById(R.id.textfamquest6);
        textfamquest5 = activity.findViewById(R.id.textfamquest5);
        textfamquest7 = activity.findViewById(R.id.textfamquest7);
        namep = activity.findViewById(R.id.famsettinginfo13);
        faminfor = activity.findViewById(R.id.faminfo);
        pers = activity.findViewById(R.id.person);
        btnstart2 = activity.findViewById(R.id.btnstart2);
        btnstart = activity.findViewById(R.id.btnstart);
        main_text = activity.findViewById(R.id.famsettingtext);
        main_text2 = activity.findViewById(R.id.famsettinginfo14);
        status = activity.findViewById(R.id.famsettinginfo12);
        rep = activity.findViewById(R.id.famsettinginfo11);
        colichestvo = activity.findViewById(R.id.famsettinginfo10);
        lvl_sclad = activity.findViewById(R.id.famsettinginfo7);
        lvl_gun = activity.findViewById(R.id.famsettinginfo8);
        lvl_sostav = activity.findViewById(R.id.famsettinginfo6);
        money = activity.findViewById(R.id.famsettinginfo5);
        mats = activity.findViewById(R.id.famsettinginfo4);
        mask = activity.findViewById(R.id.famsettinginfo3);
        fuel = activity.findViewById(R.id.famsettinginfo2);
        ammo = activity.findViewById(R.id.famsettinginfo);
        armor = activity.findViewById(R.id.famsettinginfo9);
        back = activity.findViewById(R.id.backfam);
        Utils.HideLayout(test_main, false);

        btnstart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                v.startAnimation(AnimationUtils.loadAnimation(activity, R.anim.button_click));
                NvEventQueueActivity.getInstance().FamClickQuest(qid);
            }
        });

        btnstart2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                v.startAnimation(AnimationUtils.loadAnimation(activity, R.anim.button_click));
                NvEventQueueActivity.getInstance().FamClickUluch(id);
            }
        });

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                v.startAnimation(AnimationUtils.loadAnimation(activity, R.anim.button_click));
                if(open == 1 || open == 3){
                    close_sklad();
                    show_test();
                    faminfor.setVisibility(View.VISIBLE);
                    famtext.setVisibility(View.GONE);
                    famskladinfo.setVisibility(View.GONE);
                    main_text.setText("Меню взаимодействия");
                    main_text2.setText("Информация о семье");
                    pers.setVisibility(View.VISIBLE);
                    namep.setVisibility(View.VISIBLE);
                    main_text2.setVisibility(View.VISIBLE);
                }else if(open == 2){
                    hideset();
                    open = 0;
                }else{
                    hideset();
                }
            }
        });
    }
    private void setTestRecycler(List<FamsettingModels> famList) {
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager (this, RecyclerView.VERTICAL, false);
        testRecycler.setLayoutManager(layoutManager);

        testAdapter = new FamsettingAdapter(activity, famList);
        testRecycler.setAdapter(testAdapter);
    }
    public void show_test() { //СДЕЛАТЬ НА КОМАНДЕ БЛЯДЬ

        List<FamsettingModels> famList = new ArrayList<>();
        famList.add(new FamsettingModels(1, "  Настройка семьи"));
        famList.add(new FamsettingModels(2, "  Управление семьей"));
        famList.add(new FamsettingModels(3, "  Склад"));
        famList.add(new FamsettingModels(4, "  Улучшения"));
        famList.add(new FamsettingModels(5, "  Автопарк"));
        famList.add(new FamsettingModels(6, "  Семейные логи"));
        famList.add(new FamsettingModels(7, "  Черный список"));
        famList.add(new FamsettingModels(8, "  Покинуть семью"));

        setTestRecycler(famList);
        autoRecycler.setVisibility(View.VISIBLE);
    }

    public void show_sclad() {

        List<FamsettingModels> famList = new ArrayList<>();
        famList.add(new FamsettingModels(9, "  Сейф"));
        famList.add(new FamsettingModels(10, "  Склад"));

        setTestRecycler(famList);
        autoRecycler.setVisibility(View.VISIBLE);
        open = 1;
    }

    public void show_setting() {

        List<FamsettingModels> famList = new ArrayList<>();
        famList.add(new FamsettingModels(11, "  Настройка рангов"));
        famList.add(new FamsettingModels(12, "  Цвет чата семьи"));

        setTestRecycler(famList);
        autoRecycler.setVisibility(View.VISIBLE);
        open = 1;
    }
    public void showtest(String name, String statys, int repa, int colivo, int lvl1, int lvl2, int lvl3, int cash, int mater, int masks, int fuels, int ammos, int armors){
        Utils.ShowLayout(test_main, true); //СДЕЛАТЬ НА КОМАНДЕ БЛЯДЬ
        show_test();
        faminfor.setVisibility(View.VISIBLE);
        famtext.setVisibility(View.GONE);
        famskladinfo.setVisibility(View.GONE);
        main_text.setText("Меню взаимодействия");
        main_text2.setText("Информация о семье");
        pers.setVisibility(View.VISIBLE);
        namep.setVisibility(View.VISIBLE);
        main_text2.setVisibility(View.VISIBLE);
        namep.setText(name);
        status.setText("Статус семьи: "+statys);
        rep.setText(String.format("Репутация: "+"%d", repa));
        colichestvo.setText(String.format("Количество людей: "+"%d", colivo));
        lvl_sclad.setText(String.format("Улучшение склада: "+"%d"+" из 7 ур.", lvl1));
        lvl_gun.setText(String.format("Улучшение оружия: "+"%d"+" из 7 ур.", lvl2));
        lvl_sostav.setText(String.format("Улучшение состава: "+"%d"+" из 7 ур.", lvl3));
        money.setText(String.format("Денег: "+"%d", cash));
        mats.setText(String.format("Матерьялов: "+"%d", mater));
        mask.setText(String.format("Масок: "+"%d", masks));
        fuel.setText(String.format("Канистр бензина: "+"%d", fuels));
        ammo.setText(String.format("Патронов: "+"%d"+" из 300000 шт.", ammos));
        armor.setText(String.format("Бронижелетов: "+"%d"+" из 100 шт.", armors));
    }
    public void hideset()
    {
        Utils.HideLayout(test_main, true);
    }
    public void show_quest(){
        Utils.ShowLayout(test_main, true);
        faminfor.setVisibility(View.GONE);
        famtext.setVisibility(View.VISIBLE);
        famskladinfo.setVisibility(View.GONE);
        pers.setVisibility(View.GONE);
        namep.setVisibility(View.GONE);
        main_text2.setVisibility(View.GONE);
        main_text.setText("Задания семьи");
        show_qoesti();
        open = 2;
    }

    public void show_qoesti(){
        List<FamsettingModels> famList = new ArrayList<>();
        famList.add(new FamsettingModels(13, "  Коллекционер"));
        famList.add(new FamsettingModels(14, "  Сыщик"));
        famList.add(new FamsettingModels(15, "  Охотник"));
        famList.add(new FamsettingModels(16, "  Солдат"));
        famList.add(new FamsettingModels(17, "  Помощь поднебесной"));
        famList.add(new FamsettingModels(18, "  Легкие деньги"));

        setTestRecycler(famList);
        autoRecycler.setVisibility(View.VISIBLE);
    }
    public void quest(int type)
    {
        if(type == 1){
            famtextmain.setText("Коллекционировать машины это ли не счастие?\nСемье необходимо помочь с финансами, для этого Вам украсть 3 машины на работе Автоугонщика. Отправляйтесь на работу и украдите 3 автомобиля.");
            textfamquest.setText("ЗАДАНИЕ «КОЛЛЕКЦИОНЕР»\n\nДетали задания");
            textfamquest6.setText("10\n репутации");
            textfamquest7.setText("2\nжетона");
            textfamquest5.setText("2000\n рублей");
            qid = type;
        }
        if(type == 2){
            famtextmain.setText("Семья развивается и ей требуется больше ресурсов!\nГоворят, на окрайне городов работают кладоискатели, попробуй в этом деле себя: найдите 5 кладов. Для начала выполнения задания отправляйся к Пантелеевичу, но не забудьте купить металлоискатель!");
            textfamquest.setText("ЗАДАНИЕ «СЫЩИК»\n\nДетали задания");
            textfamquest6.setText("10\n репутации");
            textfamquest7.setText("2\nжетона");
            textfamquest5.setText("2000\n рублей");
            qid = type;
        }
        if(type == 3){
            famtextmain.setText("Охота - отличный способ добыть пищу или заработать\nНаша семья нуждаеться в трех тушах зайцев. Ваша задача: доставить свежую тушу трех зайцев.");
            textfamquest.setText("ЗАДАНИЕ «ОХОТНИК»\n\nДетали задания");
            textfamquest6.setText("10\n репутации");
            textfamquest7.setText("4\nжетона");
            textfamquest5.setText("4000\n рублей");
            qid = type;
        }
        if(type == 4){
            famtextmain.setText("Наша семья часто сражается в Битве семей и ей требуется помощь\nВаша задача: принять участие в Битве семей. Для участия обратитесь к владельцу вашей семьи ил заместителю. Место проведение: \n GPS - 1 -Война семей");
            textfamquest.setText("ЗАДАНИЕ «СОЛДАТ»\n\nДетали задания");
            textfamquest6.setText("10\n репутации");
            textfamquest7.setText("2\nжетона");
            textfamquest5.setText("2000\n рублей");
            qid = type;
        }
        if(type == 5){
            famtextmain.setText("Зарабатывать семейную репутацию - очень важное и отвественное делою\nОтличный способ для демонстрации своей силы: битва за контейнер! Она проходит каждый час в Роговичах и по дороге к тюрьмею Ваша задача: доставить два ящика из контейнера в автомобиль семьи.");
            textfamquest.setText("ЗАДАНИЕ «ПОМОЩЬ ПОДНЕБЕСНОЙ»\n\nДетали задания");
            textfamquest6.setText("10\n репутации");
            textfamquest7.setText("2\nжетона");
            textfamquest5.setText("3000\n рублей");
            qid = type;
        }
        if(type == 6){
            famtextmain.setText("Легко зарабатывать - мечта каждого.\nНо мы можем это сделать совершенно легко, надо только постараться. В общем, возьмите задание у Ростислава, нападие на инкоссаторскую машину и ограбьте её! Как только возьмёте мешок - выполните мое поручение.");
            textfamquest.setText("ЗАДАНИЕ «ЛЕГКИЕ ДЕНЬГИ»\n\nДетали задания");
            textfamquest6.setText("10\n репутации");
            textfamquest7.setText("2\nжетона");
            textfamquest5.setText("3000\n рублей");
            qid = type;
        }
    }
    public void close_sklad() {

        autoRecycler.setVisibility(View.GONE);
        open = 0;
    }
    public void show_uluch(){
        List<FamsettingModels> famList = new ArrayList<>();
        famList.add(new FamsettingModels(19, "  Улучшить склад"));
        famList.add(new FamsettingModels(20, "  Улучшить оружейный\n  cклад"));
        famList.add(new FamsettingModels(21, "  Улучшить кол-во\n  членов семьи"));

        setTestRecycler(famList);
        autoRecycler.setVisibility(View.VISIBLE);
    }
    public void showuluch(int lvl1, int lvl2, int lvl3, int cash, int maxcash, int mats, int mask, int fuels, int ammos, int puples){
        Utils.ShowLayout(test_main, true);
        faminfor.setVisibility(View.GONE);
        famtext.setVisibility(View.GONE);
        pers.setVisibility(View.GONE);
        namep.setVisibility(View.GONE);
        btnstart2.setVisibility(View.GONE);
        famskladinfo.setVisibility(View.VISIBLE);
        main_text2.setText("Улучшения");
        main_text.setText("Улучшение семьи");
        textfamquest9.setText("");
        textfamquest8.setText("");
        show_uluch();
        textfamquest11.setText(String.format("%d"+" из "+"%d", cash, maxcash));
        FamsettingAdapter.slvl1 = lvl1;
        FamsettingAdapter.slvl2 = lvl2;
        FamsettingAdapter.slvl3 = lvl3;
        FamsettingAdapter.scash = cash;
        FamsettingAdapter.smats = mats;
        FamsettingAdapter.smask = mask;
        FamsettingAdapter.smaxcash = maxcash;
        FamsettingAdapter.sfuels = fuels;
        FamsettingAdapter.sammos = ammos;
        FamsettingAdapter.spuples = puples;
    }
    public void ulych(int type, int lvl1, int lvl2, int lvl3, int cash, int maxcash, int mats, int mask, int fuels, int ammos, int puples)
    {
        if(type == 1){
            textfamquest9.setText(String.format("%d"+" уровня\n\n\n"+"%d"+"Р\n\n"+"%d"+" матерьялов\n\n"+"%d"+" масок\n\n"+"%d"+" канистр с бензином", lvl1, maxcash, mats, mask, fuels));
            textfamquest8.setText("СКЛАД");
            id = type;
            btnstart2.setVisibility(View.VISIBLE);
        }
        if(type == 2){
            textfamquest9.setText(String.format("%d"+" уровня\n\n\n"+"%d"+" боеприпасов", lvl2, ammos));
            textfamquest8.setText("ОРУЖЕЙНЫЙ СКЛАД");
            id = type;
            btnstart2.setVisibility(View.VISIBLE);
        }
        if(type == 3){
            textfamquest9.setText(String.format("%d"+" уровня\n\n\n"+"%d"+" человек", lvl3, puples));
            textfamquest8.setText("ЧИСЛО УЧАСТНИКОВ");
            id = type;
            btnstart2.setVisibility(View.VISIBLE);
        }
    }
}
