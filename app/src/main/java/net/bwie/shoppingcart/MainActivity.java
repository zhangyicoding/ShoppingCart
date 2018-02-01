package net.bwie.shoppingcart;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.RelativeLayout;
import android.widget.TextView;

import net.bwie.shoppingcart.adapter.ShoppingCartAdapter;
import net.bwie.shoppingcart.bean.ItemBean;
import net.bwie.shoppingcart.bean.StoreBean;

import java.util.ArrayList;
import java.util.List;

/**
 * 初始化UI界面
 * 模拟初始化数据
 * 实现逻辑
 */
public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    protected CheckBox mCheckAllBoxl;
    protected TextView mTotalMoneyTv;
    protected Button mPayBtn;
    protected RelativeLayout mBottomContainer;
    protected RecyclerView mRecyclerView;

    // 商店集合
    private List<StoreBean> mStoreList;
    private ShoppingCartAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        super.setContentView(R.layout.activity_main);
        initView();
        initData();

        mAdapter.addDatas(mStoreList);
    }

    private void initData() {
        mStoreList = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            StoreBean store = new StoreBean();
            store.setTitle("第" + i + "家专卖店");
            for (int j = 0; j < 1; j++) {
                ItemBean item = new ItemBean();
                item.setPrice(1);
                item.setTitle("第" + i + "家的第" + j + "个商品");
                store.getItemList().add(item);
            }

            mStoreList.add(store);
        }
    }

    private void initView() {
        mCheckAllBoxl = (CheckBox) findViewById(R.id.check_all_boxl);
        mTotalMoneyTv = (TextView) findViewById(R.id.total_money_tv);
        mPayBtn = (Button) findViewById(R.id.pay_btn);
        mPayBtn.setOnClickListener(MainActivity.this);
        mBottomContainer = (RelativeLayout) findViewById(R.id.bottom_container);
        mRecyclerView = (RecyclerView) findViewById(R.id.recycler_view);

        mAdapter = new ShoppingCartAdapter(this);
        mRecyclerView.setAdapter(mAdapter);
    }

    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.pay_btn) {

        }
    }

}
