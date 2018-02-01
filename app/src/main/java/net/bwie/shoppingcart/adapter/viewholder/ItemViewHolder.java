package net.bwie.shoppingcart.adapter.viewholder;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import net.bwie.shoppingcart.R;

public class ItemViewHolder extends RecyclerView.ViewHolder {

    public CheckBox mPurchaseBox;
    public ImageView mPicImageView;
    public TextView mTitleTextView;
    public TextView mPriceTextView;
    public Button mMinusBtn;
    public Button mPlusBtn;
    public EditText mCountEditText;

    public ItemViewHolder(View itemView) {
        super(itemView);

        mPurchaseBox = itemView.findViewById(R.id.purchase_box);
        mPicImageView = itemView.findViewById(R.id.pic_iv);
        mTitleTextView = itemView.findViewById(R.id.item_title_tv);
        mPriceTextView = itemView.findViewById(R.id.price_tv);
        mMinusBtn = itemView.findViewById(R.id.minus_btn);
        mPlusBtn = itemView.findViewById(R.id.plus_btn);
        mCountEditText = itemView.findViewById(R.id.count_et);
    }
}
