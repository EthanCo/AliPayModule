package com.ethanco.myalipaytest.test3;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Toast;

import com.ethanco.alipay.AliPayDirector;
import com.ethanco.alipay.bean.PayResult;
import com.ethanco.myalipaytest.R;

/**
 * Created by EthanCo on 2016/3/24.
 */
public class MyPayDemoActivity2 extends AppCompatActivity implements View.OnClickListener {
    private AliPayDirector alipay;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pay);
        findViewById(R.id.btnPay).setOnClickListener(this);
        alipay = new AliPayDirector(this, new AliPayDirector.onPayListener() {
            @Override
            public void payFailed(PayResult payResult) {
                Toast.makeText(MyPayDemoActivity2.this, "支付失败", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void payUnknown(PayResult payResult) {
                Toast.makeText(MyPayDemoActivity2.this, "支付结果确认中", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void paySuccess(PayResult payResult) {
                Toast.makeText(MyPayDemoActivity2.this, "支付成功", Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btnPay:
                alipay.pay("特仑苏", "不是所有的牛奶都叫特仑苏", "0.01");
                //alipay.pay("特仑苏", "不是所有的牛奶都叫特仑苏", "0.01","123456790");
                break;
            default:
        }
    }
}
