package net.bwie.shoppingcart.bean;

import java.util.ArrayList;
import java.util.List;

public class StoreBean {

    private long _id;
    private String title;

    // 是否购买（CheckBox勾选状态）
    private boolean isPurchase;

    List<ItemBean> itemList = new ArrayList<>();

    public long get_id() {
        return _id;
    }

    public void set_id(long _id) {
        this._id = _id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public boolean isPurchase() {
        return isPurchase;
    }

    public void setPurchase(boolean purchase) {
        isPurchase = purchase;
    }

    public List<ItemBean> getItemList() {
        return itemList;
    }

    public void setItemList(List<ItemBean> itemList) {
        this.itemList = itemList;
    }
}
