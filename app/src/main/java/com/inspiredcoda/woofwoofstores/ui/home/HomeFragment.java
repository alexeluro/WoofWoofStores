package com.inspiredcoda.woofwoofstores.ui.home;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.widget.RelativeLayout;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.inspiredcoda.woofwoofstores.model.Dog;
import com.inspiredcoda.woofwoofstores.R;
import com.inspiredcoda.woofwoofstores.adapter.CustomAdapter;

import java.util.List;

public class HomeFragment extends Fragment {

    private HomeViewModel homeViewModel;
    private RecyclerView recyclerView1, recyclerView2;
    private CustomAdapter adapter;
    private RelativeLayout dogBreedTextLayout;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_home, container, false);

        recyclerView1 = root.findViewById(R.id.german_shepherd_recyclerview);
        recyclerView2 = root.findViewById(R.id.bulldog_shepherd_recyclerview);
        dogBreedTextLayout = root.findViewById(R.id.dog_breed);

        dogBreedTextLayout.setAnimation(AnimationUtils.loadAnimation(container.getContext(), R.anim.dog_breed_anim));

        homeViewModel = ViewModelProviders.of(this).get(HomeViewModel.class);
//        homeViewModel.init();
        homeViewModel.getData().observe(getViewLifecycleOwner(), new Observer<List<Dog>>() {
            @Override
            public void onChanged(List<Dog> dogs) {
                if (adapter != null){
                    adapter.notifyDataSetChanged();
                }else{
                    adapter = new CustomAdapter(dogs);
                    initRecyclerView1();
                    initRecyclerView2();
                }
            }
        });

        return root;
    }

    private void initRecyclerView1(){
        recyclerView1.setAdapter(adapter);
        recyclerView1.setLayoutManager(new LinearLayoutManager(this.getContext(), LinearLayoutManager.HORIZONTAL, false));
    }

    private void initRecyclerView2(){
        recyclerView2.setAdapter(adapter);
        recyclerView2.setLayoutManager(new LinearLayoutManager(this.getContext(), LinearLayoutManager.HORIZONTAL, false));
    }


    @Override
    public void onResume() {
        super.onResume();
        initRecyclerView1();
        initRecyclerView2();
    }
}