package kr.eungikim.snscommerce.friend;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import kr.eungikim.snscommerce.R;
import kr.eungikim.snscommerce.db.domain.Friend;

/**
 * Created by Eungi on 2019-08-20.
 */
public class FriendAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private static final String TAG = "FriendAdapter";

    private ItemClickListener mClickListener;
    private List<Friend> mFriendItemList = new ArrayList<>();

    public class ItemViewHolder extends RecyclerView.ViewHolder implements View.OnLongClickListener {
        private TextView mTextView;

        public ItemViewHolder(View itemView) {
            super(itemView);
            mTextView = itemView.findViewById(R.id.item_friend_name_text_view);
            itemView.setOnLongClickListener(this);
        }

        @Override
        public boolean onLongClick(View v) {
            if (mClickListener != null) {
                mClickListener.onItemClick(v, getAdapterPosition());
                return true;
            }
            return false;
        }
    }

    public void setFriendItemList(List<Friend> friendItemList) {
        mFriendItemList = friendItemList;
        notifyDataSetChanged();
    }

    // allows clicks events to be caught
    public void setClickListener(ItemClickListener itemClickListener) {
        this.mClickListener = itemClickListener;
    }


    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView;
        itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_friend, parent, false);
        return new ItemViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        String name = mFriendItemList.get(position).getName();
        ((ItemViewHolder) holder).mTextView.setText(name);
    }

    @Override
    public int getItemCount() {
        return mFriendItemList.size();
    }


    // parent activity will implement this method to respond to click events
    public interface ItemClickListener {
        void onItemClick(View view, int position);
    }


}
