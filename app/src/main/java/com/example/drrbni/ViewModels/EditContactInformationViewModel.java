package com.example.drrbni.ViewModels;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;

import com.example.drrbni.Models.Student;


public class EditContactInformationViewModel extends AndroidViewModel {

    private Repository repository;
    private MutableLiveData<Student> profileInfo;

    public EditContactInformationViewModel(@NonNull Application application) {
        super(application);
        repository = new Repository(application);
        profileInfo = repository.getProfileInfo();
    }

    public void requestProfileInfo(String uid){
        repository.requestProfileInfo(uid);
    }

    public MutableLiveData<Student> getProfileInfo() {
        return profileInfo;
    }


    public void editProfileContactInformation(String whatsapp, MyListener<Boolean> isSuccessful){
        repository.editProfileContactInformation(whatsapp, isSuccessful);
    }


}
