package com.blueradix.android.jetpacklivedata.ui.main;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class MainViewModel extends ViewModel {
    // TODO: Implement the ViewModel

    private MutableLiveData<String> message = new MutableLiveData<>();

    //this setter will be used to set a value to our total property.
    public void setMessage(String amount){
        //Here we use setValue method that exist in every MutableLiveData Object
        message.setValue(amount);
    }

    //This getter needed so we can attach an observer to this MutableLiveData Class.
    public MutableLiveData<String> getMessage(){
        return message;
    }

    /* commented out, this was the original ViewModel before the changes
    private String total = "0";

    public String getTotal() {
        return total;
    }

    public void setTotal(String total) {
        this.total = total;
    }
    */
}