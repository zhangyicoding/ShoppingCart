package net.bwie.shoppingcart.adapter.viewholder;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.CheckBox;
import android.widget.TextView;

import net.bwie.shoppingcart.R;

public class HeaderViewHolder extends RecyclerView.ViewHolder {

    public CheckBox mCheckAllItemBox;
    public TextView mTitleTextVew;

    public HeaderViewHolder(View itemView) {
        super(itemView);

        mCheckAllItemBox = itemView.findViewById(R.id.check_all_item_box);
        mTitleTextVew = itemView.findViewById(R.id.store_title_tv);
    }
}
