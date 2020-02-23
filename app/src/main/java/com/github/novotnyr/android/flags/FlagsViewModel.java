package com.github.novotnyr.android.flags;

import java.util.ArrayList;
import java.util.List;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class FlagsViewModel extends ViewModel {
    private MutableLiveData<List<Flag>> flagsLiveData = new MutableLiveData<>();

    public FlagsViewModel() {
        List<Flag> flags = new ArrayList<>();

        flags.add(new Flag("Austria", R.drawable.austria));
        flags.add(new Flag("Croatia", R.drawable.croatia));
        flags.add(new Flag("Czech Republic", R.drawable.czech));
        flags.add(new Flag("Germany", R.drawable.germany));
        flags.add(new Flag("Hungary", R.drawable.hungary));
        flags.add(new Flag("Poland", R.drawable.poland));
        flags.add(new Flag("Romania", R.drawable.romania));
        flags.add(new Flag("Serbia", R.drawable.serbia));
        flags.add(new Flag("Slovakia", R.drawable.slovakia));
        flags.add(new Flag("Slovenia", R.drawable.slovenia));
        flags.add(new Flag("Ukraine", R.drawable.ukraine));

        flagsLiveData.postValue(flags);
    }

    public MutableLiveData<List<Flag>> getFlags() {
        return flagsLiveData;
    }

    public void remove(Flag flag) {
        List<Flag> newFlags = new ArrayList<>(flagsLiveData.getValue());
        newFlags.remove(flag);
        flagsLiveData.postValue(newFlags);
    }
}
