package com.example.kiki.fragments;

import android.os.Build;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.kiki.adapter.CategoryAdapter;
import com.example.kiki.data.SubCategoryModel;
import com.example.kiki.databinding.FragmentCategoryBinding;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link CategoryFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class CategoryFragment extends Fragment {
    FragmentCategoryBinding binding;
    List<SubCategoryModel>list = new ArrayList<>();
    FirebaseAuth firebaseAuth = FirebaseAuth.getInstance();
    FirebaseDatabase firebaseDatabase = FirebaseDatabase.getInstance();
    DatabaseReference dbRef = firebaseDatabase.getReference();



    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public CategoryFragment() {

    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment CategoryAdapter.
     */
    // TODO: Rename and change types and number of parameters
    public static CategoryFragment newInstance(String param1, String param2) {
        CategoryFragment fragment = new CategoryFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        binding = FragmentCategoryBinding.inflate(inflater, container, false);

        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        category();




    }

    public void category() {

        dbRef.child("Category").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                if (snapshot.hasChild("women")) {
                    for(DataSnapshot s: snapshot.getChildren()){
                        Log.e("TAG", "onDataChange: "+s.getKey());
                    }
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });


        CategoryAdapter categoryAdapter = new CategoryAdapter(requireContext(),list);
        binding.categories.setLayoutManager(new GridLayoutManager(requireContext(), 2));
        binding.categories.setAdapter(categoryAdapter);
        binding.categories.hasFixedSize();

        list.add(new SubCategoryModel("Men","data:image/jpeg;base64,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"));
        list.add(new SubCategoryModel("Women","https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSAEkkPYsSR757egGNeBFotyjAL0UnIcVtgTw&usqp=CAU"));
        list.add(new SubCategoryModel("Kids","https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQUqfCT6LnUaXQ38Ld3aryYCF0-Xy7WEObhTg&usqp=CAU"));
        list.add(new SubCategoryModel("Electronics","https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTJdZXMyMmn1his8fnLv_Ua1hthHqiZJtNTbA&usqp=CAU"));
        list.add(new SubCategoryModel("Mobiles","data:image/jpeg;base64,/9j/4AAQSkZJRgABAQAAAQABAAD/2wCEAAoHCBEUFBcSERQSFxISFBQUERIRERESERISFxcYGBcXFxcbICwkGx0pHhcXJTYlKS49MzMzGiI5PjkyPSwyMzABCwsLEA4QHhISHjIiIiAyMjIzMjIyMjIyMjIyMjIyMjAyMjIyMjMyMjIyMjIyMjIyMjIyMjIyMjIyMjIyMjAyMv/AABEIAKgBLAMBIgACEQEDEQH/xAAbAAEAAgMBAQAAAAAAAAAAAAAABAUDBgcCAf/EAEcQAAIBAgIECQYLCAEFAQAAAAECAAMRBCEFBhIxEyIkQVFxc5GxIzJhgaGyFDRSYnKCkrPBw9EVM1ODk8LE0kJjoqPw8UP/xAAaAQEAAgMBAAAAAAAAAAAAAAAAAQIDBAUG/8QANBEAAgECBAMGBAQHAAAAAAAAAAECETEDBCFBEmGxBRMyUXGhIoHB8RRC0fAGIyRDcpHh/9oADAMBAAIRAxEAPwDQoiIAiIgCIiAIiIAiIgCIiAIiIAiIgCIiAIiIAiIgCIiAIiIAiZFpMdyt3G0Gk4zsbd/hBFTHERBIiIgCIiAIiIAiIgCIiAIiIAiIgCIiAJtGrehKdTZqVRtIFqPsHczJwYAPzQKqm3OZq83fV59mgh+Zif8AEl4KrKysZ8ThcE11ejTFt5RGp7PWyW9sq8Xq/hSu1SquvoJSov4H2yNiNKlVqKxyFRtnPcNlT4kzTv2i/CqykjjAMBuZSbEHp3w2vIKPM3vQugqZ49SzgbRAzCsV2Rn6OOJY1MLg24r0qQtvKIaZXrZbe2NAnyCH5lbxoymx2kygqoTkKrWz3DZU+JM3JtYeGqJanFw4SzGZmnNrhrb1JuI1Ywzrt0arr1lKqeyx9sn6tasURZ6oWrZajWIOwxVlUZHmG1u6ROb4XSbjEIyMReoqsAcmVjYg9O+di0G/kaZ/6Vb72nMFYyVUqHSwIYkJOM58SpppRkfG4LRrEpUp0VItcopplb7rslh3ypxup+EZduhWdRvzKVU7xY+2VWl9KFTVVjuqVAM+bIjxM1DA6TdcRTZGI2nCuAcnVjY36d/smJvU2jp2ruq1BUFSqFqtxitxxDYgXsebO1vRJmNwWjXJSpToqRa7IrUivWyWF+uT9AHktL6DH/yTRdNaUKmojHzatUDP52UPRGBLilcva2ouFqDaw9d1vu2tisneLHxmv6T1OxVHMNSqL8xyrfZcD2Eyk1T0rUXH0ODYgPUFOooPFdXyzHP0+qdI1oqkKYSTLNyi6VqcsxWISk2xU2gw3qBxv0kdtL0h5tNz9I28DIWnGvXc/R90SBK0MtC2/bLbgiL6SNrxmE6Zr8zW+iLSviCaEx9JV231G9Vl8BLDVnFMMQrsSwWxYOSwZNpQ6m/MVLeyUgEtdBIRUv8AMb8IDWhfaYwwp16tNfNSo6r1A5SFLXWX43X7V/GVUhlY2QiIgkREQBERAEREAREQBERAEREAREQBNx0U1sMn0MT/AIk06bbo48mT6GJ/xZfDuUnY0/TdYqTa/HJJ9Dbu61pQ4exZenbXuuJvJp4Q0q/Dh+F4MHCFQxXhLm4a2XRv5rzUVReFXYN+MMtmxtzyu5dWOn6BPJ6fZ1fGhNI1nqlajgX47En0NYDwtNz0CeT0+yr+OHlZpHC4bYxDV1qGoUVsIyBynCf8g1sujfzTdzCfdJnGyMl+KnXn1NBwFjUp9PC0+bm2hnO3aHbk9Psav3lOcfwFNfhFPYN7OCRs2Nhckzruijyan2NX7ynNaHh+Z1f7ny+pzPWqsVq1AL2ZmJPzv/lpQ6OsatPp4VL9Vxzzf9L4TD8HiWrLU4YhGwjKrlL344a2Q9fqmmaPVfhFPgztWYk8WxAANyZjdzKjt2gPilLs2+8nJNb6pWtVUXs1Rz9ba/Sda0AeSUuzb7yaVrHo+gq4l6yVOGZkfCOquyEE8cMRkOff6Lem0jBhv4maXqgAcbhbb+Hp3y5r33/+7p1bWzzTOdalU1OkaGwdqzsTZbEKKb3J9H6zoOtbixHP1G3qPPJgTPxI4/pn98/1fdEgydpr98/1PcWQZUzCInuml4JM2HpXM3b9gHD4elWqK4qVidm+SrT2CQLb7nI3kXUjQ4rVwXXap0VNWovylTcn1mKjqJmya1Yx6io1TIs7OBc2ChSBYcwzkSajRbv9/VGxh5Zzw54u0Or/AEv/AKKHWb45X7V/GVctNZvjlftX8ZVyDTjZCIiCwiIgCIiAIiIAiIgCIiAIiIAiIgCbTo9+TgfJSuftHDj+wzVpsejj5A9nU9+lLwuVlYgI8xY5Ra4Ava17C/fPKNnPOKbIzIVVzZdX25NTHOtKrf1mj+hkmg0i6APkF7J/eSZcO2c6OF4Uebx4/wAyZmx9JNksFUMRbaCja75P0M/JaY50ouD17dMyBjTxDJWhz5D+W/vpNfMbHR7LekhQeRdNUk2SwVQxUgsFAY9ZmTDvnPGljxD1TCzrovdXm5HTHyaZHeyt+MkUjI2gDyVez/1magc5iRpTuTEw9MXZUQOwsXCKGI6CQLzXtaHXgypI2hzXFxNlpmazrWeKZJMLnH9Nfvn+p7iyDJ2mf3z/AFPcWQZjN0+gSfg6Wci0kvNl1Z0LVxVUUqQ9L1GvsU052Y9+XPMkI1LWVWdA1CwDJhKlQAbWKZqascrUqeRI63c/YlHrLW2nUDcrOB1DIeE3XTAGGo0qFA3p0KeyrC22zkkHLn2ib9bCaTphFSki2vULl6r899ggIvotfPnMtjRbhFR/yfJc+iXqdrCh3eRnJrVrq9Wyv1pW2Mr9ox78/wAZUS31s+N1vp/gJUTXZwI2QiIgsIiIAiIgCIiAIiIAiIgCIiAIiIAmw4K4oH00qlvt0pr0vMK/kSOilUt9ul+kvC5WViqR58xDcWYUfOK78WXIRteg/wBwvYv4pMuHaR9CN5Bewbxp/pPeGbOdLD8KPOYleOfqTMaeIZM0YhXD3NuNSYi3RtpIGMPEkzAVScPY/wDGiwHVtpMGYujodmWZHw7ZxpQ8SYMM+c96TPk5gZ1kbFoLLCr2Y/smSg0w6Dbkq9mP7J9wzTEjSlctqZmta1+aZsVE5TXNazxZJMLnIdLjyzdSe4sjJTvLPHUdqqx+j7qz6mGtEYNm+kR6NI7gLk5ADnPMJ2bULApQHBAA1GpsajEHZeoRmOoC3tnLcAgFWmTuDg7r+bmPCdj1YYCzn/8AMG56WI3Riwm1SLoo0b566R+b6I38DLReHLFkq00S5vfol6t3oYsU6LXqOfKEPahS/wCIJteo999rCw/SUGvFNAlJl89mbbuQT5p6AMvVNrxyrTUX89ztMx849A9A57TSdaaqFEsBtbbEne1tjdfomSOWxe7ljTe1va9f+epu5j4svKSroqdPv7lJrUb4yt2hHcBKiXGtY5ZW7QnvAlPNZnno2QiIkFhERAEREAREQBERAEREAREQBERAEuqC2obXyqdUfZaif7/ZKWXKtyYfRr+OGl4FZGvq09VmymBWn2o2Uknc3HQwth0PTRqDuNH9Yw7T5ok8np9lV8aEx4Zp1YeFHmnrOfq+rLHFHieqTMGlsMG+VSf2PTlfiTxD1SxoHkidlU+8pzXzF0dHsy0irwzzNpI8T1SHhWzmfHtxDMDOqjZ9DC2EQ/Kp91mVfwM84dueetEnkdPsn+8Ew4Vub0zEjRlcuqJmt61nimbDQM13Wo8UySYXOeugLk9XuiGWY8RVs5H0fdE+CpebOC6qh08MlYdbEMN+dusgj8Z0vU7FbVIOTxbu5B53B2Rf0DZac0ovNqw+lBToBFyJXMjv8SZt5bAliNwXL2qvavQ7WUwuKEo7aF1p3TCkkg3OYGc1/S+CIoU69Rl26rnYp3BfgtgnbI3gEgAdciYahVxFTg6Sszncq7/SSeYemWmsmq1TB0aVWtUBepUKbC5hAULXLHeeKBum72h3WDl3hqVG9rt8uS59CM/jQhgvDi6dX+nqUes7XxlbtWHdlKmWms3xuv2r+Mq55lnnoeFCIiQWEREAREQBERAEREAREQBERAEREAS1ZuTj6Nb/ABpVSxqNycdVb/Hl4FZGuBp9dspiDT6zZSCxu+ijyan2VX8iYcO3jPejDyan2VX8iYMM2frnWjZHm0qufq+rLPEHiHqlih5InZVPfpyqrHiSxB5HT7Kp79OYMxdHQ7NtL5FLhmz9cl408QyvwzZ+uS8UfJzAdRG2aLPI6fYt94JHwrbuuZtHHkVLsW+8EiYRsx1zEjQkX2HM1/Wo8WXmGOUodaTxTJLQucv0g3lG+r7onqgZ8x6+Ub6vuiZcOk2cutzqYZJpmXuFwbtS2lKkKSM/OHPa30SJTKku9G4kLSqKd5FwPnKbX7nUfVmXMY2YwYqeWpx1So9U1KSVPdOq10OpkZrvVGVn9/oYcDjalGoKtNijoTZgBlkQTY5HfJGlNKtiApqtVeptPd3e6hdkAKF5jc3v6N0r1ioM1628BOp2nk4Tw5Y8224rRbLn5v5t02Muaf8ATzola+9K2r5clfcy6y/G6/aP4yrlprL8br9q/jKueXZ52HhQiIgsIiIAiIgCIiAIiIAiIgCIiAIiIAk3ENycdVb/AB5CknFHyC/zfyJeG5WRQLTcgsFYqvnMBcL1nmmMmT8K9sPVyfjMgJVdpTbMbeWQHN6ZXEyCyN50aeS0uyqfkTDhabkFlViqkbTAZL1nmnvRx5JS7Kp+RM2jXtQqZNxmRTsjaW4zBfLIDm9M6taKJ5/CVXP1fVnuqeJLFzyOn2VT36cqnPEllUPI6fZVPfpzDmLo3Oz/AMxS4ZHILhSVU8ZgOKpy3nm3iScS3EnzAPbD1Mn41RQSoulxYguebfYdZ6ZjrtxO+a9TqI3HR55FS7F/fEh4RGPGAOyDmbZDdv7xJWC+JUuxf3xMWBe1MjjcZxuF1uLZsebI2Hr6ZiNB7lthTlKHWnzTLvCHKUmtB4ssTC5zfFL5Rvq+6JJoJI+J88/V90STRqTcwX8J14LQkNJGA4+0g3kgjrzX2llkN3mbQ7HhQALs4YIDkOEHGpj1uqj1y85tRfDfb129zNhz4Zp+TXUzg2y3W3+ieXOa9beAmxVcPRq2qBbFxc3GYYZMpHMQbiVuk8KqBSPlMP8Atmti/wASxzOH3HdOM5aOr0XnTd25HazeXX4Wc1KqpVaEXWT43X7R/EyrlnrL8brdo/jKyajPKQ8KEREgsIiIAiIgCIiAIiIAiIgCIiAIiIAmbGnyK/zfyZhmTSH7lPTwv5I/CXhuVlsVlGqvwdxubbAve+2CL2tsG1rHO43yvJntMS6o1MW2XN2yzNt2cxmVLG8YE8lo9lU/InvB1V4FhubbAvfz752tsm1s87iY8F8Vo+mlU/IkfD4hgCgtssRtZZnoznVaqonBwbz9ZdWTnPE9UsMQeR0uzqe9TlY54vfLHFfE6XppVPepzHmLo28h+YrcNVXgCNzcJbfk+47tg2tf5Q9cVjxPVIWGxDBTTFtliCcsycrZyTVPE9RmqdNG6YM8ipdi/viRcM44MDcdo/W3Hoy39Mk4Qcho9i3viVuHqHzeYm8xmjW5f4U5eqUutB4plvhDl6pTazniywhc51jW45+r7onmjUnjHnjt1L7qxQEyQ2OqnoiepmWkxUhlNmUhlPQQbiYFEcJNihmR07RWATFrw2FZRUaxrUC1ruFzZD8rKxHzQ3PKLWXRmIpBDWRlBdgt9x4t9458jNe0Rpath3D0mIswcjm2lvY9xI6iZs2setHwyjSRiwdKhcqbfIZbg84znPzPZyeKszB2uvr9q/UzYmenDBeClWMtLN8O+2zum1RWratDrL8brdo/jKuWmsvxut2j+Mq5U5UPChERBYREQBERAEREAREQBERAEREAREQBPukaytSp0xfbUVNoWNrMVIN/q29U+T0rEbiRfI2NriSnQhqprlj0HuM+lT0Hul7wS9HtM+Gip3j2mQSWeicWj4amgPlEFWmwscr7JU39IWYkU33HukTDjgySl1JFjski49PTMnCt8pu8ibkc0lFJqxz3kmpScXpJ11rvqWzA7O47pMbErUw1Kmty9NKqOLHinbDLn6QJrrVXO9m+009Yau9Mk03dSws2yzDaHp6ZGJmIz2MmWy8sJurTqekQ33HuMmVFOzuPdIfwyp/Ef1G0+PiqjZM7keljMPGjcN40PpGnUwtKkpPCJTqK62ORD3XP0i5kWmhB3Hf0TUcNialMk03dC2TbLEbXWOee/h1b+I/qciV4jXlgurodIwgNtx7pT6yqdkzUP2jX/i1P6jfrMVTE1G8+o5+k7GTxkRwZJ1qVGkKbmoSqFgQu4E5gAc3VPFNq67qTetGltSOwbrkTv5wesHIzN8KfpX+nT/1leJ7GzxNFR8JxH8E/YaeDWxH8I/YaXXwt+lf6dP8A1j4W/Sv9On/rLd7PzJ45FOuKxA3Uu9H/AFk7QnDVcTTWouypKhhskBU2lLm2+5VSB6SJK+Fv0r/Tp/6w+JcixY26Fso7haQ8ST0bIlKTVDNpjECpXquNzuT+vtvIURKEJUVBERBIiIgCIiAIiIAiIgCIiAIiIAiIgCIiAIiIAiIgCIiAIiIAiIgCIiAIiIAiIgCIiAIiIAiIgCIiAIiIAiIgH//Z"));
        list.add(new SubCategoryModel("Footwear","https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSOr2fBwnNYRXhRABg0yjQ5Ram37DqBiReBXQ&usqp=CAU"));
        list.add(new SubCategoryModel("Grocery","https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTZzks8b3_14k60GgUQvDKpjYAVxM2SLFWs0A&usqp=CAU"));
        list.add(new SubCategoryModel("Household","https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSWwjQnJIRo4fdwj-5DXPjH8-KeO49FyKCazg&usqp=CAU"));

        categoryAdapter.notifyDataSetChanged();

    }


}