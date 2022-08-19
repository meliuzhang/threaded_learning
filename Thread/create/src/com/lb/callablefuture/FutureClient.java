package com.lb.callablefuture;

public class FutureClient {
    public Data request(String queryStr) {
        FurureData furureData = new FurureData();
        new Thread(new Runnable() {
            @Override
            public void run() {
                RealData realData = new RealData(queryStr);
                furureData.setRealData(realData);
            }
        }).start();
        return furureData;
    }
}
