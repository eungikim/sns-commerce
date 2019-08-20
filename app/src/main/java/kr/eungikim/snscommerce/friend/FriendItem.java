package kr.eungikim.snscommerce.friend;

import java.util.ArrayList;
import java.util.List;

import kr.eungikim.snscommerce.db.domain.Friend;

public class FriendItem {

    private List<Friend> mFriendList;


    FriendItem() {
        mFriendList = new ArrayList<>();
    }

    public void addFriendToList(Friend friend) {
        mFriendList.add(friend);
    }

    public void setFriendList(List<Friend> friendList) {
        this.mFriendList = friendList;
    }

    public List<Friend> getFriendList() {
        return mFriendList;
    }

}
