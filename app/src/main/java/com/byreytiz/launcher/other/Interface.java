package com.byreytiz.launcher.other;

import com.byreytiz.game.gui.models.Actions;
import com.byreytiz.launcher.model.Servers;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface Interface {

    @GET("https://www.dropbox.com/scl/fi/s8bupyabauacytkxszt8b/servers.json?rlkey=4saqhjoij7r4324y4uxmf8qoj&st=lefzkfrt&dl=1")
    Call<List<Servers>> getServers();

    @GET("https://www.dropbox.com/scl/fi/mz91jmo7qtrewal2ak39w/donate.json?rlkey=hb3rxjdrphg1h4tpppehosqj9&st=qc9r880m&dl=1")
    Call<List<Actions>> getActions();
}
