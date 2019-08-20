package kr.eungikim.snscommerce.friend;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import butterknife.ButterKnife;
import butterknife.Unbinder;
import kr.eungikim.snscommerce.R;

public class FriendListFragment extends Fragment {
    private static final String TAG = FriendListFragment.class.getSimpleName();

    private Unbinder mUiBinder;


    public static FriendListFragment newInstance() {
        return new FriendListFragment();
    }


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d(TAG, "onCreate: ");
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_friend_list, container, false);
        mUiBinder = ButterKnife.bind(this, view);

        return view;
    }

}
