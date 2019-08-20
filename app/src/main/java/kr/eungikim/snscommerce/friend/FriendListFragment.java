package kr.eungikim.snscommerce.friend;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import kr.eungikim.snscommerce.R;
import kr.eungikim.snscommerce.db.domain.Friend;

public class FriendListFragment extends Fragment {
    private static final String TAG = FriendListFragment.class.getSimpleName();

    private Unbinder mUiBinder;

    @BindView(R.id.fragment_friend_list_recycler_view) RecyclerView mRecyclerView;
    private FriendAdapter mFriendAdapter;
    private FriendItem mFriendItem;

    public static FriendListFragment newInstance() {
        return new FriendListFragment();
    }


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d(TAG, "FriendListFragment onCreate");

        insertTestFriendData();
    }


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_friend_list, container, false);
        mUiBinder = ButterKnife.bind(this, view);


        mFriendAdapter = new FriendAdapter();
        mFriendAdapter.setFriendItemList(mFriendItem.getFriendList());
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        mRecyclerView.setAdapter(mFriendAdapter);
        return view;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        mUiBinder.unbind();
    }

    private void insertTestFriendData() {
        mFriendItem = new FriendItem();
        for (int i = 0; i < 25; i++) {
            mFriendItem.addFriendToList(new Friend("이름" + i));
        }
    }
}
