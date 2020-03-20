package com.inspiredcoda.woofwoofstores.ui.home;

import com.inspiredcoda.woofwoofstores.R;
import com.inspiredcoda.woofwoofstores.model.Dog;

import java.util.ArrayList;
import java.util.List;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class HomeViewModel extends ViewModel {

    private MutableLiveData<List<Dog>> mDog = new MutableLiveData<>();

    public void init() {
        setValue();
    }

    private void setValue(){
        mDog.setValue(getDogs());
    }

    public LiveData<List<Dog>> getData() {
        return mDog;
    }


    private List<Dog> getDogs(){
        List<Dog> dogs = new ArrayList<>();
        dogs.add(new Dog("Krypto", "M", 8, R.drawable.dog_1, "A friend to Superman", "SmallVille"));
        dogs.add(new Dog("Havok", "M", 4, R.drawable.dog_2, "A dangerous dog", "Arkham"));
        dogs.add(new Dog("Quake", "M", 13, R.drawable.dog_3, "A big and rich dog", "Lekki Phase 1"));
        dogs.add(new Dog("Batman", "M", 8, R.drawable.dog_1, "A friend to Superman", "SmallVille"));
        dogs.add(new Dog("Superdog", "M", 4, R.drawable.dog_2, "A dangerous dog", "Arkham"));
        dogs.add(new Dog("Captain", "M", 13, R.drawable.dog_3, "A big and rich dog", "Lekki Phase 1"));
        dogs.add(new Dog("Bryce", "M", 8, R.drawable.dog_1, "A friend to Superman", "SmallVille"));
        dogs.add(new Dog("Warrior", "M", 4, R.drawable.dog_2, "A dangerous dog", "Arkham"));
        dogs.add(new Dog("Spartacus", "M", 13, R.drawable.dog_3, "A big and rich dog", "Lekki Phase 1"));
        dogs.add(new Dog("Cryxus", "M", 8, R.drawable.dog_1, "A friend to Superman", "SmallVille"));
        dogs.add(new Dog("Havok", "M", 4, R.drawable.dog_2, "A dangerous dog", "Arkham"));
        dogs.add(new Dog("Quake", "M", 13, R.drawable.dog_3, "A big and rich dog", "Lekki Phase 1"));
        dogs.add(new Dog("Krypto", "M", 8, R.drawable.dog_1, "A friend to Superman", "SmallVille"));
        dogs.add(new Dog("Havok", "M", 4, R.drawable.dog_2, "A dangerous dog", "Arkham"));
        dogs.add(new Dog("Quake", "M", 13, R.drawable.dog_3, "A big and rich dog", "Lekki Phase 1"));
        dogs.add(new Dog("Krypto", "M", 8, R.drawable.dog_1, "A friend to Superman", "SmallVille"));
        dogs.add(new Dog("Havok", "M", 4, R.drawable.dog_2, "A dangerous dog", "Arkham"));
        dogs.add(new Dog("Quake", "M", 13, R.drawable.dog_3, "A big and rich dog", "Lekki Phase 1"));
        dogs.add(new Dog("Krypto", "M", 8, R.drawable.dog_1, "A friend to Superman", "SmallVille"));
        dogs.add(new Dog("Havok", "M", 4, R.drawable.dog_2, "A dangerous dog", "Arkham"));
        dogs.add(new Dog("Quake", "M", 13, R.drawable.dog_3, "A big and rich dog", "Lekki Phase 1"));
        dogs.add(new Dog("Krypto", "M", 8, R.drawable.dog_1, "A friend to Superman", "SmallVille"));
        dogs.add(new Dog("Havok", "M", 4, R.drawable.dog_2, "A dangerous dog", "Arkham"));
        dogs.add(new Dog("Quake", "M", 13, R.drawable.dog_3, "A big and rich dog", "Lekki Phase 1"));
        dogs.add(new Dog("Krypto", "M", 8, R.drawable.dog_1, "A friend to Superman", "SmallVille"));
        dogs.add(new Dog("Havok", "M", 4, R.drawable.dog_2, "A dangerous dog", "Arkham"));
        dogs.add(new Dog("Quake", "M", 13, R.drawable.dog_3, "A big and rich dog", "Lekki Phase 1"));

        return dogs;
    }

}