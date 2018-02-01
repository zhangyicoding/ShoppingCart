package net.bwie.shoppingcart.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;

import com.truizlop.sectionedrecyclerview.SectionedRecyclerViewAdapter;

import net.bwie.shoppingcart.R;
import net.bwie.shoppingcart.adapter.viewholder.HeaderViewHolder;
import net.bwie.shoppingcart.adapter.viewholder.ItemViewHolder;
import net.bwie.shoppingcart.bean.ItemBean;
import net.bwie.shoppingcart.bean.StoreBean;

import java.util.ArrayList;
import java.util.List;

public class ShoppingCartAdapter extends SectionedRecyclerViewAdapter
        <HeaderViewHolder, ItemViewHolder, RecyclerView.ViewHolder> {

    private Context mContext;
    private List<StoreBean> mStoreList;

    public ShoppingCartAdapter(Context context) {
        mContext = context;
        mStoreList = new ArrayList<>();
    }

    // 添加数据
    public void addDatas(List<StoreBean> storeList) {
        mStoreList.addAll(storeList);
        notifyDataSetChanged();
    }

    // 商店数量
    @Override
    protected int getSectionCount() {
        return mStoreList.size();
    }

    // 每个商店中商品的数量
    @Override
    protected int getItemCountForSection(int section) {
        return mStoreList.get(section).getItemList().size();
    }

    @Override
    protected boolean hasFooterInSection(int section) {
        return false;
    }

    @Override
    protected HeaderViewHolder onCreateSectionHeaderViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(mContext)
                .inflate(R.layout.item_shoppingcart_header, parent, false);
        return new HeaderViewHolder(itemView);
    }

    @Override
    protected RecyclerView.ViewHolder onCreateSectionFooterViewHolder(ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    protected ItemViewHolder onCreateItemViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(mContext)
                .inflate(R.layout.item_shoppingcart, parent, false);
        return new ItemViewHolder(itemView);
    }

    @Override
    protected void onBindSectionHeaderViewHolder(HeaderViewHolder holder, int section) {
        StoreBean store = mStoreList.get(section);

        holder.mTitleTextVew.setText(store.getTitle());
    }

    @Override
    protected void onBindSectionFooterViewHolder(RecyclerView.ViewHolder holder, int section) {

    }

    @Override
    protected void onBindItemViewHolder(final ItemViewHolder holder, int section, int position) {
        final ItemBean item = mStoreList.get(section).getItemList().get(position);

        holder.mTitleTextView.setText(item.getTitle());
        holder.mPriceTextView.setText("￥" + item.getPrice());
        holder.mCountEditText.setText(item.getCount() + "");
        holder.mPurchaseBox.setChecked(item.isPurchase());

        // 商品数量改变监听
        holder.mPlusBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                item.setCount(item.getCount() + 1);
                holder.mCountEditText.setText(item.getCount() + "");
            }
        });
        holder.mMinusBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (item.getCount() > 1) {
                    item.setCount(item.getCount() - 1);
                    holder.mCountEditText.setText(item.getCount() + "");
                }
            }
        });

        // 是否购买监听器
        holder.mPurchaseBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                item.setPurchase(isChecked);
            }
        });
        holder.mPurchaseBox.setChecked(item.isPurchase());
    }
}
