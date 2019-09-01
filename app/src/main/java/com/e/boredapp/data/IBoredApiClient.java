package com.e.boredapp.data;

import com.e.boredapp.model.BoredAction;

public interface IBoredApiClient {

    void getBoredAction(BoredActionCallback callback);

    interface BoredActionCallback{

        void onSuccess(BoredAction action);

        void  onFailure(Exception e);

    }
}
