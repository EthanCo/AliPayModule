package com.ethanco.myalipaytest.test2;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.ethanco.alipay.BasePayActivity;
import com.ethanco.alipay.bean.PayResult;
import com.ethanco.myalipaytest.R;

/**
 * Created by EthanCo on 2016/3/24.
 */
public class MyPayDemoActivity extends BasePayActivity implements View.OnClickListener {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pay);
        findViewById(R.id.btnPay).setOnClickListener(this);
    }

    @Override
    protected void payFailed(PayResult payResult) {
        Toast.makeText(this, "支付失败", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void payUnknown(PayResult payResult) {
        Toast.makeText(this, "支付结果确认中", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void paySuccess(PayResult payResult) {
        Toast.makeText(this, "支付成功", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btnPay:
                pay("特仑苏", "不是所有的牛奶都叫特仑苏", "0.01");
                //alipay.pay("特仑苏", "不是所有的牛奶都叫特仑苏", "0.01","123456790");
                break;
            default:
        }
    }
}
